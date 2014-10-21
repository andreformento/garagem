package br.com.formento.garagem.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.formento.garagem.dao.interfaces.CarroDao;
import br.com.formento.garagem.dao.interfaces.UsuarioDao;
import br.com.formento.garagem.model.Carro;
import br.com.formento.garagem.model.ManagerUsuarioSessao;

@Transactional
@Controller
public class CarroController {

	@Autowired
	private CarroDao dao;

	@Autowired
	private UsuarioDao usuarioDao;

	@RequestMapping("cadastraCarro")
	public String form(final ModelMap modelMap, Integer codigo) {
		Carro entidade;
		if (codigo == null || codigo <= 0)
			entidade = new Carro();
		else
			entidade = dao.buscaPorId(codigo);

		modelMap.addAttribute("entidade", entidade);

		return "carro/formulario";
	}

	@RequestMapping("mergeCarro")
	public String merge(@Valid Carro entidade, BindingResult result, HttpServletRequest httpServletRequest) {
		if (result.hasFieldErrors("marca") || result.hasFieldErrors("modelo") || result.hasFieldErrors("ano") || result.hasFieldErrors("historia")
				|| result.hasFieldErrors("meta") || result.hasFieldErrors("cor"))
			return "carro/formulario";

		ManagerUsuarioSessao managerUsuarioSessao = new ManagerUsuarioSessao(httpServletRequest);
		entidade.setUsuario(managerUsuarioSessao.getUsuarioSessao().getUsuario());

		if (entidade.getCodigo() <= 0)
			dao.adiciona(entidade);
		else
			dao.altera(entidade);

		entidade.getUsuario().setCarro(entidade);
		usuarioDao.altera(entidade.getUsuario());

		return "redirect:cadastraCarro?mensagem=Gravado com sucesso";
	}

	@RequestMapping("removeCarro")
	public String remove(int codigo) {
		dao.remove(codigo);
		return "redirect:cadastraCarro?mensagem=Removido com sucesso";
	}

}
