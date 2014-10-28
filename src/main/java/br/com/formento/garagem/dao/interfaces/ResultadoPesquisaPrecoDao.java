package br.com.formento.garagem.dao.interfaces;

import java.util.List;

import br.com.formento.garagem.dao.Dao;
import br.com.formento.garagem.model.MetodoPesquisaPreco;
import br.com.formento.garagem.model.Orcamento;
import br.com.formento.garagem.model.ResultadoPesquisaPreco;

public interface ResultadoPesquisaPrecoDao extends Dao<ResultadoPesquisaPreco, Integer> {

	List<ResultadoPesquisaPreco> getByMetodoOrcamentoLink(MetodoPesquisaPreco metodoPesquisaPreco, Orcamento orcamento, String link);

	List<ResultadoPesquisaPreco> getByOrcamento(Orcamento orcamento);

}
