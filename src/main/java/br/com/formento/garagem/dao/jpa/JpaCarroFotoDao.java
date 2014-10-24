package br.com.formento.garagem.dao.jpa;

import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import br.com.formento.garagem.dao.JpaDao;
import br.com.formento.garagem.dao.JpaDaoParameters;
import br.com.formento.garagem.dao.interfaces.CarroFotoDao;
import br.com.formento.garagem.model.Carro;
import br.com.formento.garagem.model.CarroFoto;

@Repository
public class JpaCarroFotoDao extends JpaDao<CarroFoto, Integer> implements CarroFotoDao {

	@Override
	public CarroFoto getByCarro(Carro carro) {
		JpaDaoParameters<CarroFoto> jpaDaoParameters = makeParameters();

		Root<CarroFoto> root = jpaDaoParameters.getRoot();
		Path<Object> pathcarro = root.get("carro");
		Predicate predicate = jpaDaoParameters.getCriteriaBuilder().equal(pathcarro, carro);

		jpaDaoParameters.addFiltro(predicate);

		return jpaDaoParameters.getSingleResult();
	}

}
