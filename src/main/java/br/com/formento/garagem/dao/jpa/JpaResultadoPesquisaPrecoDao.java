package br.com.formento.garagem.dao.jpa;

import java.util.List;

import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import br.com.formento.garagem.dao.JpaDao;
import br.com.formento.garagem.dao.JpaDaoParameters;
import br.com.formento.garagem.dao.interfaces.ResultadoPesquisaPrecoDao;
import br.com.formento.garagem.enums.TipoEntidadeOrdenacao;
import br.com.formento.garagem.model.MetodoPesquisaPreco;
import br.com.formento.garagem.model.Orcamento;
import br.com.formento.garagem.model.ResultadoPesquisaPreco;

@Repository
public class JpaResultadoPesquisaPrecoDao extends JpaDao<ResultadoPesquisaPreco, Integer> implements ResultadoPesquisaPrecoDao {

	private JpaDaoParameters<ResultadoPesquisaPreco> makeParametersResultado(Orcamento orcamento) {
		JpaDaoParameters<ResultadoPesquisaPreco> jpaDaoParameters = makeParameters();

		Root<ResultadoPesquisaPreco> root = jpaDaoParameters.getRoot();

		jpaDaoParameters.addFiltro(jpaDaoParameters.getCriteriaBuilder().equal(root.get("orcamento"), orcamento));

		jpaDaoParameters.addEntidadeOrdenacao(TipoEntidadeOrdenacao.ASCENDENTE, "ordem");

		return jpaDaoParameters;
	}

	@Override
	public List<ResultadoPesquisaPreco> getByMetodoOrcamentoLink(MetodoPesquisaPreco metodoPesquisaPreco, Orcamento orcamento, String link) {
		JpaDaoParameters<ResultadoPesquisaPreco> parameters = makeParametersResultado(orcamento);

		parameters.addFiltro(parameters.getCriteriaBuilder().equal(parameters.getRoot().get("link"), link));
		parameters.addFiltro(parameters.getCriteriaBuilder().equal(parameters.getRoot().get("metodoPesquisaPreco"), metodoPesquisaPreco));

		return parameters.getResultList();
	}

	@Override
	public List<ResultadoPesquisaPreco> getByOrcamento(Orcamento orcamento) {
		JpaDaoParameters<ResultadoPesquisaPreco> parameters = makeParametersResultado(orcamento);

		return parameters.getResultList();
	}

}
