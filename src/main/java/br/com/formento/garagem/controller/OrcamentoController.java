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
import br.com.formento.garagem.model.CategoriaOrcamento;
import br.com.formento.garagem.model.Orcamento;

@Transactional
@Controller
public class OrcamentoController {

	@Autowired
	private OrcamentoDao dao;

	@Autowired
	private CategoriaOrcamentoDao categoriaOrcamentoDao;

	@RequestMapping("cadastraOrcamento")
	public String form(final ModelMap modelMap, Integer codigo) {
		Orcamento entidade;
		if (codigo == null || codigo <= 0)
			entidade = new Orcamento();
		else
			entidade = dao.buscaPorId(codigo);

		List<CategoriaOrcamento> categoriaOrcamentoList = categoriaOrcamentoDao.lista();

		modelMap.addAttribute("entidade", entidade);
		modelMap.addAttribute("categoriaOrcamentoList", categoriaOrcamentoList);

		return "orcamento/formulario";
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
//		model.addAttribute("entidades", dao.lista());
		return "orcamento/lista";
	}

	@RequestMapping("removeOrcamento")
	public String remove(int codigo) {
		dao.remove(codigo);
		return "redirect:listaOrcamentos";
	}

}
