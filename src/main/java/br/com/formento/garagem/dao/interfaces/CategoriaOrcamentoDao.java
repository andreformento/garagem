package br.com.formento.garagem.dao.interfaces;

import java.util.List;

import br.com.formento.garagem.dao.Dao;
import br.com.formento.garagem.model.CategoriaOrcamento;
import br.com.formento.garagem.model.TipoCategoriaOrcamento;

public interface CategoriaOrcamentoDao extends Dao<CategoriaOrcamento, Integer> {

	List<CategoriaOrcamento> getByTipoCategoriaOrcamento(TipoCategoriaOrcamento tipoCategoriaOrcamento);

	List<CategoriaOrcamento> lista();

}
