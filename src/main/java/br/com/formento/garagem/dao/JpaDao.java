package br.com.formento.garagem.dao;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EmbeddedId;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.PersistenceContext;

public class JpaDao<T, CHAVE> implements Dao<T, CHAVE> {

	@PersistenceContext
	private EntityManager entityManager;

	private Class<T> classeEntidade;

	@SuppressWarnings("unchecked")
	public JpaDao() {
		Class<?> thisClass = getClass();
		ParameterizedType parameterizedType = (ParameterizedType) thisClass.getGenericSuperclass();

		Type type = parameterizedType.getActualTypeArguments()[0];
		this.classeEntidade = (Class<T>) type;
	}

	protected EntityManager getEntityManager() {
		return entityManager;
	}

	protected JpaDaoParameters<T> makeParameters() {
		JpaDaoParameters<T> jpaDaoParameters = new JpaDaoParameters<T>(entityManager, classeEntidade);
		return jpaDaoParameters;
	}

	@Override
	public void adiciona(T t) {
		getEntityManager().persist(t);
	}

	@Override
	public void altera(T t) {
		getEntityManager().merge(t);
	}

	@Override
	public void remove(CHAVE chave) {
		T entidadeARemover = buscaPorId(chave);
		if (entidadeARemover != null)
			getEntityManager().remove(entidadeARemover);
	}

	@Override
	public List<T> lista() {
		JpaDaoParameters<T> jpaDaoParameters = makeParameters();
		return jpaDaoParameters.getResultList();
	}

	@Override
	public T buscaPorId(CHAVE chave) {
		String nomePropriedadeChave = null;

		Field[] fields = this.classeEntidade.getDeclaredFields();
		for (Field f : fields) {
			Id annotationId = f.getAnnotation(Id.class);
			if (annotationId != null) {
				nomePropriedadeChave = f.getName();
				break;
			}

			EmbeddedId annotationEmbeddedId = f.getAnnotation(EmbeddedId.class);
			if (annotationEmbeddedId != null) {
				nomePropriedadeChave = f.getName();
				break;
			}
		}

		JpaDaoParameters<T> jpaDaoParameters = makeParameters();

		jpaDaoParameters.addFiltro(jpaDaoParameters.getCriteriaBuilder().equal(jpaDaoParameters.getRoot().get(nomePropriedadeChave), chave));

		return jpaDaoParameters.getSingleResult();
	}

}
