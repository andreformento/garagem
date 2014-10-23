package br.com.formento.garagem.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.formento.garagem.dao.interfaces.CategoriaOrcamentoDao;
import br.com.formento.garagem.dao.interfaces.OrcamentoDao;
import br.com.formento.garagem.dao.interfaces.TipoCategoriaOrcamentoDao;
import br.com.formento.garagem.enums.StatusOrcamentoEnum;
import br.com.formento.garagem.model.CategoriaOrcamento;
import br.com.formento.garagem.model.ManagerUsuarioSessao;
import br.com.formento.garagem.model.Orcamento;
import br.com.formento.garagem.model.StatusOrcamento;
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

	@RequestMapping("telaOrcamento")
	public String telaOrcamento(final ModelMap modelMap, HttpServletRequest httpServletRequest, int codTipoCategoriaOrcamento,
			Integer codCategoriaOrcamento) {
		final String link = "orcamento/tela";

		TipoCategoriaOrcamento tipoCategoriaOrcamento = tipoCategoriaOrcamentoDao.buscaPorId(codTipoCategoriaOrcamento);
		if (tipoCategoriaOrcamento == null)
			return link;

		List<CategoriaOrcamento> categoriaOrcamentoList = categoriaOrcamentoDao.getByTipoCategoriaOrcamento(tipoCategoriaOrcamento);

		modelMap.addAttribute("tipoCategoriaOrcamento", tipoCategoriaOrcamento);
		modelMap.addAttribute("categoriaOrcamentoList", categoriaOrcamentoList);

		if (codCategoriaOrcamento != null && codCategoriaOrcamento >= 0)
			modelMap.addAttribute("codCategoriaOrcamento", codCategoriaOrcamento);

		return link;
	}

	@RequestMapping("listaOrcamento")
	public String listaOrcamento(final ModelMap modelMap, HttpServletRequest httpServletRequest, int codCategoriaOrcamento) {
		final String link = "orcamento/listaInterna";

		CategoriaOrcamento categoriaOrcamento = categoriaOrcamentoDao.buscaPorId(codCategoriaOrcamento);
		modelMap.addAttribute("categoriaOrcamento", categoriaOrcamento);

		ManagerUsuarioSessao managerUsuarioSessao = new ManagerUsuarioSessao(httpServletRequest);
		List<Orcamento> orcamentoList = dao.getByCarroECategoriaOrcamento(managerUsuarioSessao.getUsuarioSessao().getCarroSelecionado(),
				categoriaOrcamento);
		modelMap.addAttribute("orcamentoList", orcamentoList);

		return link;
	}

	@ModelAttribute("statusOrcamentos")
	public StatusOrcamento[] statusOrcamentos() {
		List<StatusOrcamento> list = new ArrayList<StatusOrcamento>();
		for (StatusOrcamentoEnum statusOrcamentoEnum : StatusOrcamentoEnum.values())
			list.add(statusOrcamentoEnum.getStatusOrcamento());

		StatusOrcamento[] array = list.toArray(new StatusOrcamento[list.size()]);
		return array;
	}

	@RequestMapping("cadastraOrcamento")
	public String form(final ModelMap modelMap, Integer codCategoriaOrcamento, Integer codOrcamento) {
		Orcamento entidade;
		if (codOrcamento == null || codOrcamento <= 0) {
			entidade = new Orcamento();

			entidade.setDataCriacao(new Date());
			entidade.setStatusOrcamento(StatusOrcamentoEnum.RECEBER_EMAIL.getStatusOrcamento());

			CategoriaOrcamento categoriaOrcamento = categoriaOrcamentoDao.buscaPorId(codCategoriaOrcamento);
			entidade.setCategoriaOrcamento(categoriaOrcamento);
		} else
			entidade = dao.buscaPorId(codOrcamento);

		modelMap.addAttribute("entidade", entidade);

		return "orcamento/formulario";
	}

	@RequestMapping("mergeOrcamento")
	public String merge(final ModelMap modelMap, HttpServletRequest httpServletRequest, @ModelAttribute @Valid Orcamento entidade,
			BindingResult result) {
		if (result.hasFieldErrors("acao") || result.hasFieldErrors("detalhe"))
			return "orcamento/formulario";

		ManagerUsuarioSessao managerUsuarioSessao = new ManagerUsuarioSessao(httpServletRequest);
		entidade.setCarro(managerUsuarioSessao.getUsuarioSessao().getCarroSelecionado());

		if (entidade.getCodigo() <= 0)
			dao.adiciona(entidade);
		else
			dao.altera(entidade);

		modelMap.addAttribute("codTipoCategoriaOrcamento", entidade.getCategoriaOrcamento().getTipoCategoriaOrcamento().getCodigo());
		modelMap.addAttribute("codCategoriaOrcamento", entidade.getCategoriaOrcamento().getCodigo());

		return "redirect:telaOrcamento";
	}

	//
	// @RequestMapping("telaOrcamentos")
	// public String lista(Model model) {
	// // model.addAttribute("entidades", dao.lista());
	// return "orcamento/lista";
	// }
	//
	// @RequestMapping("removeOrcamento")
	// public String remove(int codigo) {
	// dao.remove(codigo);
	// return "redirect:telaOrcamentos";
	// }

}
