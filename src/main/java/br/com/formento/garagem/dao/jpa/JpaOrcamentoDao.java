package br.com.formento.garagem.dao.jpa;

import java.util.List;

import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import br.com.formento.garagem.dao.JpaDao;
import br.com.formento.garagem.dao.JpaDaoParameters;
import br.com.formento.garagem.dao.interfaces.OrcamentoDao;
import br.com.formento.garagem.model.Carro;
import br.com.formento.garagem.model.CategoriaOrcamento;
import br.com.formento.garagem.model.Orcamento;

@Repository
public class JpaOrcamentoDao extends JpaDao<Orcamento, Integer> implements OrcamentoDao {

	@Override
	public List<Orcamento> getByCarroECategoriaOrcamento(Carro carro, CategoriaOrcamento categoriaOrcamento) {
		JpaDaoParameters<Orcamento> jpaDaoParameters = makeParameters();

		Root<Orcamento> root = jpaDaoParameters.getRoot();

		Path<Object> pathCarro = root.get("carro");
		Predicate predicateCarro = jpaDaoParameters.getCriteriaBuilder().equal(pathCarro, carro);
		jpaDaoParameters.addFiltro(predicateCarro);

		Path<Object> pathCategoriaOrcamento = root.get("categoriaOrcamento");
		Predicate predicateCategoriaOrcamento = jpaDaoParameters.getCriteriaBuilder().equal(pathCategoriaOrcamento, categoriaOrcamento);
		jpaDaoParameters.addFiltro(predicateCategoriaOrcamento);

		return jpaDaoParameters.getResultList();
	}

}
