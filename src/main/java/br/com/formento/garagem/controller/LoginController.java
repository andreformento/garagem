package br.com.formento.garagem.controller;

import java.security.Principal;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.formento.garagem.dao.interfaces.CarroDao;
import br.com.formento.garagem.dao.interfaces.TipoCategoriaOrcamentoDao;
import br.com.formento.garagem.dao.interfaces.UsuarioDao;
import br.com.formento.garagem.dao.interfaces.UsuarioPermissaoDao;
import br.com.formento.garagem.model.ManagerUsuarioSessao;
import br.com.formento.garagem.model.Usuario;

@Transactional
@Controller
public class LoginController {

	@Autowired
	private UsuarioDao usuarioDao;

	@Autowired
	private TipoCategoriaOrcamentoDao tipoCategoriaOrcamentoDao;

	@Autowired
	private UsuarioPermissaoDao usuarioPermissaoDao;

	@Autowired
	private CarroDao carroDao;

	@RequestMapping(value = "/main", method = RequestMethod.POST)
	public String printWelcome(ModelMap model, Principal principal) {
		String name = principal.getName();
		model.addAttribute("username", name);
		return "main_page";
	}

	@RequestMapping(value = "/loginPage", method = RequestMethod.GET)
	public String login(ModelMap modelMap) {
		Usuario entidade = new Usuario();
		modelMap.addAttribute("entidade", entidade);
		return "login_page";
	}

	@RequestMapping(value = "/loginExec", method = RequestMethod.POST)
	public String loginExec(HttpServletRequest httpServletRequest, @Valid Usuario entidade, BindingResult result, final ModelMap modelMap) {
		final String mensagemErro = "redirect:loginPage?error=Login ou senha incorreto";

		if (result.hasFieldErrors("username"))
			return mensagemErro;
		else if (result.hasFieldErrors("password"))
			return mensagemErro;

		ManagerUsuarioSessao managerUsuarioSessao = new ManagerUsuarioSessao(httpServletRequest);

		Usuario usuarioByDao = usuarioDao.getByUsername(entidade.getUsername());

		if (managerUsuarioSessao.getUsuarioSessao().login(entidade, usuarioByDao)) {
			managerUsuarioSessao.getUsuarioSessao().setListTipoCategoriaOrcamento(tipoCategoriaOrcamentoDao.lista());

			managerUsuarioSessao.getUsuarioSessao().setListUsuarioPermissao(
					usuarioPermissaoDao.getByUsuario(managerUsuarioSessao.getUsuarioSessao().getUsuario()));

			managerUsuarioSessao.getUsuarioSessao().setListCarro(carroDao.getByUsuario(managerUsuarioSessao.getUsuarioSessao().getUsuario()));

			usuarioByDao.setDataUltimoLogin(new Date());
			usuarioDao.altera(usuarioByDao);

			if (managerUsuarioSessao.getUsuarioSessao().getListCarro().isEmpty()
					|| managerUsuarioSessao.getUsuarioSessao().getCarroSelecionado() == null)
				return "redirect:garagemLista";
			else {
				modelMap.addAttribute("codigo", managerUsuarioSessao.getUsuarioSessao().getCarroSelecionado().getCodigo());
				return "redirect:cadastraCarro";
			}
		} else
			return mensagemErro;
	}

	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public String logout(ModelMap model, HttpServletRequest httpServletRequest) {
		ManagerUsuarioSessao managerUsuarioSessao = new ManagerUsuarioSessao(httpServletRequest);
		managerUsuarioSessao.getUsuarioSessao().logout();

		return "redirect:loginPage";

	}

	@RequestMapping(value = "/loginError", method = RequestMethod.POST)
	public String loginError(ModelMap model) {
		model.addAttribute("error", "true");
		return "login_page";
	}

}
