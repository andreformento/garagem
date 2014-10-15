package br.com.formento.garagem.dao;

import java.util.List;

public interface Dao<T, CHAVE> {
	T buscaPorId(CHAVE id);

	List<T> lista();

	void adiciona(T t);

	void altera(T t);

	void remove(CHAVE chave);

}
