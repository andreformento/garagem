package br.com.formento.garagem.dao;

public interface Dao<T, CHAVE> {
	T buscaPorId(CHAVE id);

	void adiciona(T t);

	void altera(T t);

	void remove(CHAVE chave);

}
