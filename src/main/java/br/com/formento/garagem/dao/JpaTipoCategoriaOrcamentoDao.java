package br.com.formento.garagem.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.formento.garagem.model.TipoCategoriaOrcamento;

@Repository
public class JpaTipoCategoriaOrcamentoDao implements TipoCategoriaOrcamentoDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void adiciona(TipoCategoriaOrcamento tipoCategoriaOrcamento) {
		entityManager.persist(tipoCategoriaOrcamento);
	}

	@Override
	public void altera(TipoCategoriaOrcamento tipoCategoriaOrcamento) {
		entityManager.merge(tipoCategoriaOrcamento);
	}

	@Override
	public List<TipoCategoriaOrcamento> lista() {
		List<TipoCategoriaOrcamento> resultList = entityManager.createQuery("select t from TipoCategoriaOrcamento t").getResultList();
		return resultList;
	}

	@Override
	public TipoCategoriaOrcamento buscaPorId(Integer id) {
		return entityManager.find(TipoCategoriaOrcamento.class, id);
	}

	@Override
	public void remove(TipoCategoriaOrcamento tipoCategoriaOrcamento) {
		TipoCategoriaOrcamento tipoCategoriaOrcamentoARemover = buscaPorId(tipoCategoriaOrcamento.getCodigo());
		entityManager.remove(tipoCategoriaOrcamentoARemover);
	}

}
