package br.com.formento.garagem.dao.interfaces;

import java.util.List;

import br.com.formento.garagem.dao.Dao;
import br.com.formento.garagem.model.Orcamento;
import br.com.formento.garagem.model.ResultadoPesquisaPreco;

public interface ResultadoPesquisaPrecoDao extends Dao<ResultadoPesquisaPreco, Integer> {

	List<ResultadoPesquisaPreco> getByLinkOrcamento(String link, Orcamento orcamento);

}
