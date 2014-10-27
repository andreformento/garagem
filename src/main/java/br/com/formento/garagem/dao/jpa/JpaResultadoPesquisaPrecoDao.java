package br.com.formento.garagem.dao.jpa;

import java.util.List;

import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import br.com.formento.garagem.dao.JpaDao;
import br.com.formento.garagem.dao.JpaDaoParameters;
import br.com.formento.garagem.dao.interfaces.ResultadoPesquisaPrecoDao;
import br.com.formento.garagem.model.MetodoPesquisaPreco;
import br.com.formento.garagem.model.Orcamento;
import br.com.formento.garagem.model.ResultadoPesquisaPreco;

@Repository
public class JpaResultadoPesquisaPrecoDao extends JpaDao<ResultadoPesquisaPreco, Integer> implements ResultadoPesquisaPrecoDao {

	@Override
	public List<ResultadoPesquisaPreco> getByMetodoOrcamentoLink(MetodoPesquisaPreco metodoPesquisaPreco, Orcamento orcamento, String link) {
		JpaDaoParameters<ResultadoPesquisaPreco> jpaDaoParameters = makeParameters();

		Root<ResultadoPesquisaPreco> root = jpaDaoParameters.getRoot();

		jpaDaoParameters.addFiltro(jpaDaoParameters.getCriteriaBuilder().equal(root.get("link"), link));
		jpaDaoParameters.addFiltro(jpaDaoParameters.getCriteriaBuilder().equal(root.get("orcamento"), orcamento));
		jpaDaoParameters.addFiltro(jpaDaoParameters.getCriteriaBuilder().equal(root.get("metodoPesquisaPreco"), metodoPesquisaPreco));

		return jpaDaoParameters.getResultList();
	}

}
