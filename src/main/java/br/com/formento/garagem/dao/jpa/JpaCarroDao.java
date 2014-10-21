package br.com.formento.garagem.dao.jpa;

import java.util.List;

import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import br.com.formento.garagem.dao.JpaDao;
import br.com.formento.garagem.dao.JpaDaoParameters;
import br.com.formento.garagem.dao.interfaces.CarroDao;
import br.com.formento.garagem.enums.TipoEntidadeOrdenacao;
import br.com.formento.garagem.model.Carro;
import br.com.formento.garagem.model.Usuario;

@Repository
public class JpaCarroDao extends JpaDao<Carro, Integer> implements CarroDao {

	@Override
	public List<Carro> getByUsuario(Usuario usuario) {
		JpaDaoParameters<Carro> jpaDaoParameters = makeParameters();

		Root<Carro> root = jpaDaoParameters.getRoot();
		Path<Object> pathUsername = root.get("usuario");
		Predicate predicate = jpaDaoParameters.getCriteriaBuilder().equal(pathUsername, usuario);

		jpaDaoParameters.addFiltro(predicate);

		jpaDaoParameters.addEntidadeOrdenacao(TipoEntidadeOrdenacao.ASCENDENTE, "marca", "modelo", "ano");

		return jpaDaoParameters.getResultList();
	}

}
