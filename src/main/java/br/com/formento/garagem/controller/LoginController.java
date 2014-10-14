package br.com.formento.garagem.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.formento.garagem.dao.TipoCategoriaOrcamentoDao;
import br.com.formento.garagem.dao.UsuarioDao;
import br.com.formento.garagem.model.TipoCategoriaOrcamento;
import br.com.formento.garagem.model.Usuario;
import br.com.formento.garagem.model.UsuarioSessao;

@Controller
public class LoginController {

	@Autowired
	private UsuarioDao usuarioDao;

	@Autowired
	private TipoCategoriaOrcamentoDao tipoCategoriaOrcamentoDao;

	// @RequestMapping(value="/login", method = RequestMethod.POST)
	// public String login() {
	// return "login";
	// }
	//
	// @RequestMapping("fazerLogin")
	// public String fazerLogin() {
	// return "redirect:garagemLista";
	// }
	//
	// @RequestMapping("fazerLogoff")
	// public String fazerLogoff() {
	// return "login";
	// }

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
	public String loginExec(HttpServletRequest request, @Valid Usuario entidade, BindingResult result) {
		final String mensagemErro = "redirect:loginPage?error=Login ou senha incorreto";

		if (result.hasFieldErrors("username"))
			return mensagemErro;
		else if (result.hasFieldErrors("password"))
			return mensagemErro;

		UsuarioSessao usuarioSessao = (UsuarioSessao) request.getSession().getAttribute(UsuarioSessao.class.getSimpleName());

		Usuario usuarioByLogin = usuarioDao.getByLogin(entidade.getUsername());

		if (usuarioSessao.login(entidade, usuarioByLogin)) {
			List<TipoCategoriaOrcamento> listTipoCategoriaOrcamento = tipoCategoriaOrcamentoDao.lista();
			usuarioSessao.setListTipoCategoriaOrcamento(listTipoCategoriaOrcamento);
			return "redirect:garagemLista";
		} else
			return mensagemErro;
	}

	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public String logout(ModelMap model, HttpServletRequest request) {
		UsuarioSessao usuarioSessao = (UsuarioSessao) request.getSession().getAttribute(UsuarioSessao.class.getSimpleName());
		usuarioSessao.logout();

		return "redirect:loginPage";

	}

	@RequestMapping(value = "/loginError", method = RequestMethod.POST)
	public String loginError(ModelMap model) {
		model.addAttribute("error", "true");
		return "login_page";
	}

}
