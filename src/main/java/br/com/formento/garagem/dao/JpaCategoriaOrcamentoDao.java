package br.com.formento.garagem.dao;

import org.springframework.stereotype.Repository;

import br.com.formento.garagem.model.CategoriaOrcamento;

@Repository
public class JpaCategoriaOrcamentoDao extends JpaDao<CategoriaOrcamento, Integer> implements CategoriaOrcamentoDao {

}
