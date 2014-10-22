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
import br.com.formento.garagem.dao.interfaces.OrcamentoDao;
import br.com.formento.garagem.dao.interfaces.TipoCategoriaOrcamentoDao;
import br.com.formento.garagem.model.CategoriaOrcamento;
import br.com.formento.garagem.model.Orcamento;
import br.com.formento.garagem.model.TipoCategoriaOrcamento;

@Transactional
@Controller
public class OrcamentoController {

	@Autowired
	private OrcamentoDao dao;

	@Autowired
	private TipoCategoriaOrcamentoDao tipoCategoriaOrcamentoDao;

	@Autowired
	private CategoriaOrcamentoDao categoriaOrcamentoDao;

	@RequestMapping("listaOrcamento")
	public String form(final ModelMap modelMap, int codTipoCategoriaOrcamento) {
		final String link = "orcamento/lista";

		TipoCategoriaOrcamento tipoCategoriaOrcamento = tipoCategoriaOrcamentoDao.buscaPorId(codTipoCategoriaOrcamento);
		if (tipoCategoriaOrcamento == null)
			return link;

		List<CategoriaOrcamento> categoriaOrcamentoList = categoriaOrcamentoDao.getByTipoCategoriaOrcamento(tipoCategoriaOrcamento);

		modelMap.addAttribute("tipoCategoriaOrcamento", tipoCategoriaOrcamento);
		modelMap.addAttribute("categoriaOrcamentoList", categoriaOrcamentoList);

		return link;
	}

	@RequestMapping("mergeOrcamento")
	public String merge(@Valid Orcamento entidade, BindingResult result, @RequestParam String categoriaOrcamento) {
		if (result.hasFieldErrors("descricao"))
			return "orcamento/formulario";

		CategoriaOrcamento categoriaOrcamentoObject = new CategoriaOrcamento();
		categoriaOrcamentoObject.setCodigo(Integer.valueOf(categoriaOrcamento));
		entidade.setCategoriaOrcamento(categoriaOrcamentoObject);

		if (entidade.getCodigo() <= 0)
			dao.adiciona(entidade);
		else
			dao.altera(entidade);

		return "redirect:listaOrcamentos";
	}

	@RequestMapping("listaOrcamentos")
	public String lista(Model model) {
		// model.addAttribute("entidades", dao.lista());
		return "orcamento/lista";
	}

	@RequestMapping("removeOrcamento")
	public String remove(int codigo) {
		dao.remove(codigo);
		return "redirect:listaOrcamentos";
	}

}
