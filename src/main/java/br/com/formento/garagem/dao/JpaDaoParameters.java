package br.com.formento.garagem.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class JpaDaoParameters<T> {
	private final EntityManager entityManager;
	private final Class<T> classeEntidade;

	private List<Predicate> filtros;
	private CriteriaBuilder criteriaBuilder;
	private CriteriaQuery<T> criteriaQuery;
	private Root<T> root;
	private TypedQuery<T> typedQuery;

	public JpaDaoParameters(EntityManager entityManager, Class<T> classeEntidade) {
		this.entityManager = entityManager;
		this.classeEntidade = classeEntidade;
	}

	private List<Predicate> getFiltros() {
		if (filtros == null)
			filtros = new ArrayList<Predicate>();
		return filtros;
	}

	public boolean addFiltro(Predicate predicate) {
		return getFiltros().add(predicate);
	}

	public CriteriaBuilder getCriteriaBuilder() {
		if (criteriaBuilder == null)
			criteriaBuilder = entityManager.getCriteriaBuilder();
		return criteriaBuilder;
	}

	public CriteriaQuery<T> getCriteriaQuery() {
		if (criteriaQuery == null)
			criteriaQuery = getCriteriaBuilder().createQuery(classeEntidade);
		return criteriaQuery;
	}

	public Root<T> getRoot() {
		if (root == null)
			root = getCriteriaQuery().from(classeEntidade);
		return root;
	}

	private void configureWhere() {
		Predicate[] predicates;
		predicates = getFiltros().toArray(new Predicate[getFiltros().size()]);
		getCriteriaQuery().where(predicates);
	}

	public TypedQuery<T> getTypedQuery() {
		if (typedQuery == null)
			typedQuery = entityManager.createQuery(getCriteriaQuery());
		return typedQuery;
	}

	public T getSingleResult() {
		configureWhere();
		try {
			return getTypedQuery().getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public List<T> getResultList() {
		getRoot();
		configureWhere();
		return getTypedQuery().getResultList();
	}

}
