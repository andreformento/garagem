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
import br.com.formento.garagem.model.TipoCategoriaOrcamento;

@Transactional
@Controller
public class TipoCategoriaOrcamentoController {
	@Autowired
	private TipoCategoriaOrcamentoDao tipoCategoriaOrcamentoDao;

	@RequestMapping("novaTipoCategoriaOrcamento")
	public String form(final ModelMap modelMap) {
		TipoCategoriaOrcamento tipoCategoriaOrcamento = new TipoCategoriaOrcamento();
		tipoCategoriaOrcamento.setDescricao("Novo");

		modelMap.addAttribute("tipoCategoriaOrcamento", tipoCategoriaOrcamento);
		return "tipoCategoriaOrcamento/formulario";
	}

	@RequestMapping("adicionaTipoCategoriaOrcamento")
	public String adiciona(@Valid TipoCategoriaOrcamento tipoCategoriaOrcamento, BindingResult result) {
		if (result.hasFieldErrors("descricao"))
			return "tipoCategoriaOrcamento/formulario";

		tipoCategoriaOrcamentoDao.adiciona(tipoCategoriaOrcamento);
		return "tipoCategoriaOrcamento/adicionada";
	}

	@RequestMapping("listaTipoCategoriaOrcamentos")
	public String lista(Model model) {
		model.addAttribute("tipoCategoriaOrcamentos", tipoCategoriaOrcamentoDao.lista());
		return "tipoCategoriaOrcamento/lista";
	}

	@RequestMapping("removeTipoCategoriaOrcamento")
	public String remove(TipoCategoriaOrcamento tipoCategoriaOrcamento) {
		tipoCategoriaOrcamentoDao.remove(tipoCategoriaOrcamento);
		return "redirect:listaTipoCategoriaOrcamentos";
	}

	@RequestMapping("mostraTipoCategoriaOrcamento")
	public String mostra(Integer id, Model model) {
		model.addAttribute("tipoCategoriaOrcamento", tipoCategoriaOrcamentoDao.buscaPorId(id));
		return "tipoCategoriaOrcamento/mostra";
	}

	@RequestMapping("alteraTipoCategoriaOrcamento")
	public String altera(TipoCategoriaOrcamento tipoCategoriaOrcamento) {
		tipoCategoriaOrcamentoDao.altera(tipoCategoriaOrcamento);
		return "redirect:listaTipoCategoriaOrcamentos";
	}

}
