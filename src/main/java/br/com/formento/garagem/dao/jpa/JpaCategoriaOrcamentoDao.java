package br.com.formento.garagem.dao.jpa;

import java.util.List;

import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import br.com.formento.garagem.dao.JpaDao;
import br.com.formento.garagem.dao.JpaDaoParameters;
import br.com.formento.garagem.dao.interfaces.CategoriaOrcamentoDao;
import br.com.formento.garagem.model.CategoriaOrcamento;
import br.com.formento.garagem.model.TipoCategoriaOrcamento;

@Repository
public class JpaCategoriaOrcamentoDao extends JpaDao<CategoriaOrcamento, Integer> implements CategoriaOrcamentoDao {

	@Override
	public List<CategoriaOrcamento> getByTipoCategoriaOrcamento(TipoCategoriaOrcamento tipoCategoriaOrcamento) {
		JpaDaoParameters<CategoriaOrcamento> jpaDaoParameters = makeParameters();

		Root<CategoriaOrcamento> root = jpaDaoParameters.getRoot();
		Path<Object> pathFiltro = root.get("tipoCategoriaOrcamento");
		Predicate predicate = jpaDaoParameters.getCriteriaBuilder().equal(pathFiltro, tipoCategoriaOrcamento);

		jpaDaoParameters.addFiltro(predicate);

		return jpaDaoParameters.getResultList();
	}

}
