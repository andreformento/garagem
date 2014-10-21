package br.com.formento.garagem.dao.interfaces;

import java.util.List;

import br.com.formento.garagem.dao.Dao;
import br.com.formento.garagem.model.TipoCategoriaOrcamento;

public interface TipoCategoriaOrcamentoDao extends Dao<TipoCategoriaOrcamento, Integer> {

	List<TipoCategoriaOrcamento> lista();

}
