package br.com.formento.garagem.dao;

import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import br.com.formento.garagem.model.Usuario;

@Repository
public class JpaUsuarioDao extends JpaDao<Usuario, Integer> implements UsuarioDao {

	@Override
	public Usuario getByLogin(String username) {
		JpaDaoParameters<Usuario> jpaDaoParameters = makeParameters();

		Root<Usuario> root = jpaDaoParameters.getRoot();
		Path<Object> pathUsername = root.get("username");
		Predicate predicate = jpaDaoParameters.getCriteriaBuilder().equal(pathUsername, username);

		jpaDaoParameters.addFiltro(predicate);

		return jpaDaoParameters.getSingleResult();
	}

}
