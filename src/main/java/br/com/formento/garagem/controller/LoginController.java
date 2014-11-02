package br.com.formento.garagem.controller;

import java.net.MalformedURLException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.formento.garagem.dao.interfaces.CarroDao;
import br.com.formento.garagem.dao.interfaces.CarroFotoDao;
import br.com.formento.garagem.dao.interfaces.TipoCategoriaOrcamentoDao;
import br.com.formento.garagem.dao.interfaces.UsuarioDao;
import br.com.formento.garagem.dao.interfaces.UsuarioPermissaoDao;
import br.com.formento.garagem.enums.ResultadoLoginEnum;
import br.com.formento.garagem.model.EmailConfirmacaoUsuario;
import br.com.formento.garagem.model.MD5Converter;
import br.com.formento.garagem.model.ManagerUsuarioSessao;
import br.com.formento.garagem.model.Usuario;
import br.com.formento.garagem.service.MailService;
import br.com.formento.garagem.util.ServletUtils;

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

	@Autowired
	private CarroFotoDao carroFotoDao;

	@Autowired
	private MailService mailService;

	@RequestMapping({ "/", "index" })
	public String index(HttpServletRequest httpServletRequest) {
		ManagerUsuarioSessao managerUsuarioSessao = new ManagerUsuarioSessao(httpServletRequest);
		if (managerUsuarioSessao.getUsuarioSessao().getUsuario().getCarroSelecionado())
			return "redirect:cadastraCarro?codigo=" + managerUsuarioSessao.getUsuarioSessao().getUsuario().getCarro().getCodigo();
		else
			return "redirect:nenhumCarro";
	}

	@RequestMapping(value = "/loginPage", method = RequestMethod.GET)
	public String login(ModelMap modelMap) {
		Usuario entidade = new Usuario();
		modelMap.addAttribute("entidade", entidade);
		return "login/page";
	}

	@RequestMapping(value = "/loginExec", method = RequestMethod.POST)
	public String loginExec(HttpServletRequest httpServletRequest, @Valid Usuario entidade, BindingResult result, final ModelMap modelMap) {
		if (result.hasErrors())
			return ResultadoLoginEnum.INVALIDO.getPagina();

		ManagerUsuarioSessao managerUsuarioSessao = new ManagerUsuarioSessao(httpServletRequest);

		Usuario usuarioByDao = usuarioDao.getByUsername(entidade.getUsername());

		ResultadoLoginEnum resultadoLoginEnum = managerUsuarioSessao.getUsuarioSessao().login(entidade, usuarioByDao);
		if (resultadoLoginEnum.equals(ResultadoLoginEnum.SUCESSO)) {
			managerUsuarioSessao.getUsuarioSessao().configurarUsuario(modelMap, carroDao, carroFotoDao, tipoCategoriaOrcamentoDao,
					usuarioPermissaoDao);

			usuarioByDao.setDataUltimoLogin(new Date());
			usuarioDao.altera(usuarioByDao);

		}
		return resultadoLoginEnum.getPagina();
	}

	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public String logout(HttpServletRequest httpServletRequest) {
		ManagerUsuarioSessao managerUsuarioSessao = new ManagerUsuarioSessao(httpServletRequest);
		managerUsuarioSessao.getUsuarioSessao().logout();

		return "redirect:loginPage";
	}

	@RequestMapping("cadastraUsuario")
	public String form(final ModelMap modelMap) {
		Usuario entidade = new Usuario();

		modelMap.addAttribute("entidade", entidade);
		return "login/formulario";
	}

	@RequestMapping(value = "/adicionaUsuario", method = RequestMethod.POST)
	public String merge(Model model, @ModelAttribute @Valid Usuario entidade, BindingResult result, HttpServletRequest httpServletRequest) {
		model.addAttribute("entidade", entidade);
		if (result.hasErrors()) {
			model.addAttribute("mensagem", result.getFieldError().getDefaultMessage());

			return "redirect:cadastraUsuario";
		}

		if (entidade.getPassword().length() > 20) {
			model.addAttribute("mensagem", "O tamanho da senha deve ser de 4 a 20 caracteres");
			return "redirect:cadastraUsuario";
		}

		Usuario byUsername = usuarioDao.getByUsername(entidade.getUsername());
		if (byUsername == null) {
			entidade.setDataCadastro(new Date());
			entidade.setPassword(MD5Converter.getMD5(entidade.getPassword()));
			usuarioDao.adiciona(entidade);

			ServletUtils servletUtils = new ServletUtils(httpServletRequest);

			EmailConfirmacaoUsuario emailConfirmacaoUsuario;
			try {
				emailConfirmacaoUsuario = new EmailConfirmacaoUsuario(entidade, mailService, servletUtils.getUrlBase());

				emailConfirmacaoUsuario.enviar();

				model.addAttribute("mensagem", "Login criado. Verifique seu email");
			} catch (MalformedURLException e) {
				e.printStackTrace();

				model.addAttribute("mensagem", "Ocorreu um erro. Tentar novamente mais tarde");
			}
			return "redirect:loginPage";
		} else {
			model.addAttribute("mensagem", "Email existente. Utilize outro");
			return "redirect:cadastraUsuario";
		}
	}

	@RequestMapping(value = "/confirmacaoRegistro")
	public String confirmacaoRegistro(ModelMap modelMap, int codigo, String username, String password) {
		Usuario usuario = usuarioDao.buscaPorId(codigo);

		if (usuario == null) {
			modelMap.addAttribute("mensagem", "Parametro (codigo) incorreto");
			return "redirect:loginPage";
		}

		if (usuario.getUsername().compareTo(username) != 0) {
			modelMap.addAttribute("mensagem", "Parametro (username) incorreto");
			return "redirect:loginPage";
		}

		if (usuario.getPassword().compareTo(password) != 0) {
			modelMap.addAttribute("mensagem", "Parametro (password) incorreto");
			return "redirect:loginPage";
		}

		usuario.setDataAtivacao(new Date());
		usuarioDao.altera(usuario);

		modelMap.addAttribute("mensagem", "Seu registro foi liberado para acesso");
		return "redirect:loginPage";
	}

}
