package br.com.formento.garagem.dao.interfaces;

import java.util.List;

import br.com.formento.garagem.dao.Dao;
import br.com.formento.garagem.model.CategoriaOrcamento;

public interface CategoriaOrcamentoDao extends Dao<CategoriaOrcamento, Integer> {

	List<CategoriaOrcamento> lista();

}
