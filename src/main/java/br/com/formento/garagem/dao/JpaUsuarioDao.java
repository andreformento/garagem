package br.com.formento.garagem.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import br.com.formento.garagem.model.Usuario;

@Repository
public class JpaUsuarioDao implements UsuarioDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void adiciona(Usuario entidade) {
		entityManager.persist(entidade);
	}

	@Override
	public void altera(Usuario entidade) {
		entityManager.merge(entidade);
	}

	@Override
	public List<Usuario> lista() {
		List<Usuario> resultList = entityManager.createQuery("select t from Usuario t").getResultList();
		return resultList;
	}

	@Override
	public Usuario buscaPorId(Integer id) {
		return entityManager.find(Usuario.class, id);
	}

	@Override
	public void remove(Usuario entidade) {
		Usuario entidadeARemover = buscaPorId(entidade.getCodigo());
		entityManager.remove(entidadeARemover);
	}

	@Override
	public Usuario getByLogin(String login) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Usuario> cq = cb.createQuery(Usuario.class);
		Root<Usuario> root = cq.from(Usuario.class);
		cq.select(root);

		Path<String> name = root.get("email");
		Predicate loginFilter = cb.and(cb.equal(name, login));
		cq.where(loginFilter);

		TypedQuery<Usuario> query = entityManager.createQuery(cq);
		// query.getResultList()

		try {
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

}
