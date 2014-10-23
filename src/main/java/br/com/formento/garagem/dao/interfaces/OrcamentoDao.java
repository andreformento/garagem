package br.com.formento.garagem.dao.interfaces;

import java.util.List;

import br.com.formento.garagem.dao.Dao;
import br.com.formento.garagem.model.Carro;
import br.com.formento.garagem.model.CategoriaOrcamento;
import br.com.formento.garagem.model.Orcamento;

public interface OrcamentoDao extends Dao<Orcamento, Integer> {

	List<Orcamento> getByCarroECategoriaOrcamento(Carro carro, CategoriaOrcamento categoriaOrcamento);

}
