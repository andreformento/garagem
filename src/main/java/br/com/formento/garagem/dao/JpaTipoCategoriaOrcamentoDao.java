package br.com.formento.garagem.dao;

import org.springframework.stereotype.Repository;

import br.com.formento.garagem.model.TipoCategoriaOrcamento;

@Repository
public class JpaTipoCategoriaOrcamentoDao extends JpaDao<TipoCategoriaOrcamento, Integer> implements TipoCategoriaOrcamentoDao {

}
