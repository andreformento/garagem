package br.com.formento.garagem.dao.jpa;

import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import br.com.formento.garagem.dao.JpaDao;
import br.com.formento.garagem.dao.interfaces.OrcamentoDao;
import br.com.formento.garagem.model.Orcamento;
import br.com.formento.garagem.model.Usuario;

@Repository
public class JpaOrcamentoDao extends JpaDao<Orcamento, Integer> implements OrcamentoDao {
	
//	@Override
//	public Usuario getByLogin(String username) {
//		JpaDaoParameters<Usuario> jpaDaoParameters = makeParameters();
//
//		Root<Usuario> root = jpaDaoParameters.getRoot();
//		Path<Object> pathUsername = root.get("username");
//		Predicate predicate = jpaDaoParameters.getCriteriaBuilder().equal(pathUsername, username);
//
//		jpaDaoParameters.addFiltro(predicate);
//
//		return jpaDaoParameters.getSingleResult();
//	}
	
}
