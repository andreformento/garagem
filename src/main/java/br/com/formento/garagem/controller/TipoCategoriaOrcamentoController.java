package br.com.formento.garagem.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.formento.garagem.dao.TipoCategoriaOrcamentoDao;
import br.com.formento.garagem.dao.UsuarioDao;
import br.com.formento.garagem.model.TipoCategoriaOrcamento;

@Transactional
@Controller
public class TipoCategoriaOrcamentoController {

	@Autowired
	private TipoCategoriaOrcamentoDao dao;
	

	 @Autowired
//	 @Qualifier("jpaUsuarioDao")
	UsuarioDao usuarioDao;

	@RequestMapping("cadastraTipoCategoriaOrcamento")
	public String form(final ModelMap modelMap, Integer codigo) {
		TipoCategoriaOrcamento entidade;
		if (codigo == null || codigo <= 0) {
			entidade = new TipoCategoriaOrcamento();
			entidade.setDescricao("Novo");
		} else {
			entidade = dao.buscaPorId(codigo);
		}

		modelMap.addAttribute("entidade", entidade);
		return "tipoCategoriaOrcamento/formulario";
	}

	@RequestMapping("mergeTipoCategoriaOrcamento")
	public String merge(@Valid TipoCategoriaOrcamento entidade, BindingResult result) {
		if (result.hasFieldErrors("descricao"))
			return "tipoCategoriaOrcamento/formulario";

		if (entidade.getCodigo() <= 0)
			dao.adiciona(entidade);
		else
			dao.altera(entidade);

		return "redirect:listaTipoCategoriaOrcamentos";
	}

	@RequestMapping("listaTipoCategoriaOrcamentos")
	public String lista(Model model) {
		model.addAttribute("entidades", dao.lista());
		return "tipoCategoriaOrcamento/lista";
	}

	@RequestMapping("removeTipoCategoriaOrcamento")
	public String remove(int codigo) {
		TipoCategoriaOrcamento entidade = new TipoCategoriaOrcamento();
		entidade.setCodigo(codigo);
		dao.remove(entidade);
		return "redirect:listaTipoCategoriaOrcamentos";
	}

	@RequestMapping("mostraTipoCategoriaOrcamento")
	public String mostra(Integer codigo, Model model) {
		model.addAttribute("entidade", dao.buscaPorId(codigo));
		return "tipoCategoriaOrcamento/mostra";
	}

}
