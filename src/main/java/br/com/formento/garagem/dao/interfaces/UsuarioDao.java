package br.com.formento.garagem.dao.interfaces;

import br.com.formento.garagem.dao.Dao;
import br.com.formento.garagem.model.Usuario;

public interface UsuarioDao extends Dao<Usuario, Integer> {

	Usuario getByUsername(String login);

}
