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

import br.com.formento.garagem.enums.TipoEntidadeOrdenacao;
import br.com.formento.garagem.model.EntidadeOrdenacao;
import br.com.formento.garagem.model.EntidadeOrdenacaoList;

public class JpaDaoParameters<T> {
	private final EntityManager entityManager;
	private final Class<T> classeEntidade;

	private List<Predicate> filtros;
	private EntidadeOrdenacaoList entidadeOrdenacaoList;
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

	private EntidadeOrdenacaoList getEntidadeOrdenacaoList() {
		if (entidadeOrdenacaoList == null)
			entidadeOrdenacaoList = new EntidadeOrdenacaoList(getCriteriaBuilder(), getRoot());
		return entidadeOrdenacaoList;
	}

	public boolean addFiltro(Predicate predicate) {
		return getFiltros().add(predicate);
	}

	public void addEntidadeOrdenacao(TipoEntidadeOrdenacao tipoEntidadeOrdenacao, String nomeCampo, String... nomesCampo) {
		addEntidadeOrdenacao(new EntidadeOrdenacao(tipoEntidadeOrdenacao, nomeCampo));
		for (String campo : nomesCampo)
			addEntidadeOrdenacao(new EntidadeOrdenacao(tipoEntidadeOrdenacao, campo));
	}

	private boolean addEntidadeOrdenacao(EntidadeOrdenacao entidadeOrdenacao) {
		return getEntidadeOrdenacaoList().add(entidadeOrdenacao);
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

		getCriteriaQuery().orderBy(getEntidadeOrdenacaoList().getListOrder());
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
