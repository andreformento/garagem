package br.com.formento.garagem.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.formento.garagem.dao.interfaces.CategoriaOrcamentoDao;
import br.com.formento.garagem.dao.interfaces.TipoCategoriaOrcamentoDao;
import br.com.formento.garagem.model.CategoriaOrcamento;
import br.com.formento.garagem.model.TipoCategoriaOrcamento;

@Transactional
@Controller
public class CategoriaOrcamentoController {

	@Autowired
	private CategoriaOrcamentoDao dao;

	@Autowired
	private TipoCategoriaOrcamentoDao tipoCategoriaOrcamentoDao;

	@RequestMapping("cadastraCategoriaOrcamento")
	public String form(final ModelMap modelMap, Integer codigo) {
		CategoriaOrcamento entidade;
		if (codigo == null || codigo <= 0)
			entidade = new CategoriaOrcamento();
		else
			entidade = dao.buscaPorId(codigo);

		List<TipoCategoriaOrcamento> tipoCategoriaOrcamentoList = tipoCategoriaOrcamentoDao.lista();

		modelMap.addAttribute("entidade", entidade);
		modelMap.addAttribute("tipoCategoriaOrcamentoList", tipoCategoriaOrcamentoList);

		return "categoriaOrcamento/formulario";
	}

	@RequestMapping("mergeCategoriaOrcamento")
	public String merge(@Valid CategoriaOrcamento entidade, BindingResult result, @RequestParam String tipoCategoriaOrcamento) {
		if (result.hasFieldErrors("descricao"))
			return "categoriaOrcamento/formulario";

		TipoCategoriaOrcamento tipoCategoriaOrcamentoObject = new TipoCategoriaOrcamento();
		tipoCategoriaOrcamentoObject.setCodigo(Integer.valueOf(tipoCategoriaOrcamento));
		entidade.setTipoCategoriaOrcamento(tipoCategoriaOrcamentoObject);

		if (entidade.getCodigo() <= 0)
			dao.adiciona(entidade);
		else
			dao.altera(entidade);

		return "redirect:listaCategoriaOrcamentos";
	}

	@RequestMapping("listaCategoriaOrcamentos")
	public String lista(Model model) {
		model.addAttribute("entidades", dao.lista());
		return "categoriaOrcamento/lista";
	}

	@RequestMapping("removeCategoriaOrcamento")
	public String remove(int codigo) {
		dao.remove(codigo);
		return "redirect:listaCategoriaOrcamentos";
	}

}
