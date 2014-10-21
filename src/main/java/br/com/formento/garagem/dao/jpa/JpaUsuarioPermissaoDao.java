package br.com.formento.garagem.dao.jpa;

import java.util.List;

import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import br.com.formento.garagem.dao.JpaDao;
import br.com.formento.garagem.dao.JpaDaoParameters;
import br.com.formento.garagem.dao.interfaces.UsuarioPermissaoDao;
import br.com.formento.garagem.model.Usuario;
import br.com.formento.garagem.model.UsuarioPermissao;

@Repository
public class JpaUsuarioPermissaoDao extends JpaDao<UsuarioPermissao, Integer> implements UsuarioPermissaoDao {

	@Override
	public List<UsuarioPermissao> getByUsuario(Usuario usuario) {
		JpaDaoParameters<UsuarioPermissao> jpaDaoParameters = makeParameters();

		Root<UsuarioPermissao> root = jpaDaoParameters.getRoot();
		Path<Object> pathUsuario = root.get("usuario");
		Predicate predicate = jpaDaoParameters.getCriteriaBuilder().equal(pathUsuario, usuario);

		jpaDaoParameters.addFiltro(predicate);

		return jpaDaoParameters.getResultList();
	}

}
