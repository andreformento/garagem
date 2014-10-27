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
import br.com.formento.garagem.dao.interfaces.ResultadoPesquisaPrecoDao;
import br.com.formento.garagem.dao.interfaces.TipoCategoriaOrcamentoDao;
import br.com.formento.garagem.enums.MetodoPesquisaPrecoEnum;
import br.com.formento.garagem.enums.StatusOrcamentoEnum;
import br.com.formento.garagem.interfaces.IResultadoPesquisa;
import br.com.formento.garagem.model.CategoriaOrcamento;
import br.com.formento.garagem.model.ManagerUsuarioSessao;
import br.com.formento.garagem.model.MetodoPesprecoTpCatOrcame;
import br.com.formento.garagem.model.MetodoPesquisaPreco;
import br.com.formento.garagem.model.Orcamento;
import br.com.formento.garagem.model.ResultadoPesquisaList;
import br.com.formento.garagem.model.ResultadoPesquisaPreco;
import br.com.formento.garagem.model.StatusOrcamento;
import br.com.formento.garagem.model.TipoCategoriaOrcamento;

@Transactional
@Controller
public class OrcamentoController {

	@Autowired
	private OrcamentoDao orcamentoDao;

	@Autowired
	private TipoCategoriaOrcamentoDao tipoCategoriaOrcamentoDao;

	@Autowired
	private CategoriaOrcamentoDao categoriaOrcamentoDao;

	@Autowired
	private ResultadoPesquisaPrecoDao resultadoPesquisaPrecoDao;

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

		ManagerUsuarioSessao managerUsuarioSessao = new ManagerUsuarioSessao(httpServletRequest);
		if (managerUsuarioSessao.getUsuarioSessao().getCarroFoto() != null)
			modelMap.addAttribute("carroFotoEncode", managerUsuarioSessao.getUsuarioSessao().getCarroFoto().getEncode());

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
			entidade = orcamentoDao.buscaPorId(codOrcamento);

		modelMap.addAttribute("entidade", entidade);

		return "orcamento/formulario";
	}

	@RequestMapping("mergeOrcamento")
	public String merge(final ModelMap modelMap, HttpServletRequest httpServletRequest, @ModelAttribute @Valid Orcamento entidade,
			BindingResult result) {
		String link = "redirect:cadastraOrcamento";

		if (result.hasFieldErrors("acao") || result.hasFieldErrors("detalhe"))
			return link;

		ManagerUsuarioSessao managerUsuarioSessao = new ManagerUsuarioSessao(httpServletRequest);
		entidade.setCarro(managerUsuarioSessao.getUsuarioSessao().getUsuario().getCarro());

		if (entidade.getCodigo() <= 0)
			orcamentoDao.adiciona(entidade);
		else
			orcamentoDao.altera(entidade);

		modelMap.addAttribute("codCategoriaOrcamento", entidade.getCategoriaOrcamento().getCodigo());
		modelMap.addAttribute("codOrcamento", entidade.getCodigo());

		modelMap.addAttribute("mensagem", "Gravado com sucesso");

		return link;
	}

	@RequestMapping("mergeResultadosPesquisa")
	public String mergeResultadosPesquisa(final ModelMap modelMap, HttpServletRequest httpServletRequest,
			@ModelAttribute ResultadoPesquisaList resultadoPesquisaList) {
		String link = "redirect:cadastraOrcamento";

		Orcamento orcamento = orcamentoDao.buscaPorId(resultadoPesquisaList.getOrcamento().getCodigo());

		for (IResultadoPesquisa resultadoPesquisa : resultadoPesquisaList.getLista()) {
			List<ResultadoPesquisaPreco> byLinkOrcamento = resultadoPesquisaPrecoDao.getByLinkOrcamento(resultadoPesquisa.getLink(), orcamento);
			// deixar somente o primeiro link
			for (int i = 1; i < byLinkOrcamento.size(); i++)
				resultadoPesquisaPrecoDao.remove(byLinkOrcamento.get(i).getCodigo());

			ResultadoPesquisaPreco resultadoPesquisaPreco;
			if (byLinkOrcamento.size() > 1)
				resultadoPesquisaPreco = byLinkOrcamento.get(1);
			else
				resultadoPesquisaPreco = new ResultadoPesquisaPreco(orcamento);

			resultadoPesquisaPreco.configurarResultadoPesquisa(resultadoPesquisaPreco);

			if (resultadoPesquisaPreco.getCodigo() > 0)
				resultadoPesquisaPrecoDao.altera(resultadoPesquisaPreco);
			else
				resultadoPesquisaPrecoDao.adiciona(resultadoPesquisaPreco);
		}

		modelMap.addAttribute("codCategoriaOrcamento", orcamento.getCategoriaOrcamento().getCodigo());
		modelMap.addAttribute("codOrcamento", orcamento.getCodigo());

		modelMap.addAttribute("mensagem", "Gravado com sucesso");

		return link;
	}

	@RequestMapping("listaOrcamento")
	public String listaOrcamento(final ModelMap modelMap, HttpServletRequest httpServletRequest, int codCategoriaOrcamento) {
		final String link = "orcamento/listaInterna";

		CategoriaOrcamento categoriaOrcamento = categoriaOrcamentoDao.buscaPorId(codCategoriaOrcamento);
		modelMap.addAttribute("categoriaOrcamento", categoriaOrcamento);

		ManagerUsuarioSessao managerUsuarioSessao = new ManagerUsuarioSessao(httpServletRequest);
		List<Orcamento> orcamentoList = orcamentoDao.getByCarroECategoriaOrcamento(managerUsuarioSessao.getUsuarioSessao().getUsuario().getCarro(),
				categoriaOrcamento);
		modelMap.addAttribute("orcamentoList", orcamentoList);

		return link;
	}

	@RequestMapping("executarPesquisa")
	public String executarPesquisa(final ModelMap modelMap, HttpServletRequest httpServletRequest, int codTipoCategoriaOrcamento, int codOrcamento,
			String tagBusca) {
		final String link = "orcamento/resultadoPesquisaPrecoView";

		Orcamento orcamento = new Orcamento();
		orcamento.setCodigo(codOrcamento);
		ResultadoPesquisaList resultadoPesquisaList = new ResultadoPesquisaList(orcamento);

		TipoCategoriaOrcamento tipoCategoriaOrcamento = tipoCategoriaOrcamentoDao.buscaPorId(codTipoCategoriaOrcamento);
		for (MetodoPesprecoTpCatOrcame metodoPesprecoTpCatOrcame : tipoCategoriaOrcamento.getMetodoPesprecoTpCatOrcames()) {
			MetodoPesquisaPreco metodoPesquisaPreco = metodoPesprecoTpCatOrcame.getMetodoPesquisaPreco();
			MetodoPesquisaPrecoEnum metodoPesquisaPrecoEnum = MetodoPesquisaPrecoEnum.getByInstancia(metodoPesquisaPreco);

			List<IResultadoPesquisa> listaByFerramenta = metodoPesquisaPrecoEnum.getFerramentaPesquisa().gerarResultadoPesquisaList(tagBusca);
			resultadoPesquisaList.addAll(listaByFerramenta);
		}

		modelMap.addAttribute("resultadoPesquisaList", resultadoPesquisaList);
		modelMap.addAttribute("tagBusca", tagBusca);

		return link;
	}

}
