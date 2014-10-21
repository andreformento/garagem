package br.com.formento.garagem.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import br.com.formento.garagem.enums.TipoEntidadeOrdenacao;

public class EntidadeOrdenacaoList {
	private final CriteriaBuilder criteriaBuilder;
	private final Root<?> root;
	private final ArrayList<EntidadeOrdenacao> campos;

	public EntidadeOrdenacaoList(CriteriaBuilder criteriaBuilder, Root<?> root) {
		this.criteriaBuilder = criteriaBuilder;
		this.root = root;
		this.campos = new ArrayList<EntidadeOrdenacao>();
	}

	public boolean add(EntidadeOrdenacao entidadeOrdenacao) {
		return campos.add(entidadeOrdenacao);
	}

	public List<Order> getListOrder() {
		List<Order> resultado = new ArrayList<Order>();

		for (EntidadeOrdenacao entidadeOrdenacao : campos) {
			Path<Object> pathOrdenar = root.get(entidadeOrdenacao.getNomeCampo());

			if (entidadeOrdenacao.getTipoEntidadeOrdenacao().equals(TipoEntidadeOrdenacao.ASCENDENTE))
				resultado.add(criteriaBuilder.asc(pathOrdenar));
			else
				resultado.add(criteriaBuilder.desc(pathOrdenar));
		}

		return resultado;
	}

}
