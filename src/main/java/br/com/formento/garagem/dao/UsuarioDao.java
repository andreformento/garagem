package br.com.formento.garagem.dao;

import br.com.formento.garagem.model.Usuario;

public interface UsuarioDao extends Dao<Usuario, Integer> {

	Usuario getByLogin(String login);

}
