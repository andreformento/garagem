package br.com.formento.garagem.dao.jpa;

import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import br.com.formento.garagem.dao.JpaDao;
import br.com.formento.garagem.dao.JpaDaoParameters;
import br.com.formento.garagem.dao.interfaces.UsuarioDao;
import br.com.formento.garagem.model.Usuario;

@Repository
public class JpaUsuarioDao extends JpaDao<Usuario, Integer> implements UsuarioDao {

	@Override
	public Usuario getByUsername(String username) {
		JpaDaoParameters<Usuario> jpaDaoParameters = makeParameters();

		Root<Usuario> root = jpaDaoParameters.getRoot();
		Path<Object> pathFiltro = root.get("username");
		Predicate predicate = jpaDaoParameters.getCriteriaBuilder().equal(pathFiltro, username);

		jpaDaoParameters.addFiltro(predicate);

		return jpaDaoParameters.getSingleResult();
	}

}
