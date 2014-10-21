package br.com.formento.garagem.dao.interfaces;

import java.util.List;

import br.com.formento.garagem.dao.Dao;
import br.com.formento.garagem.model.Usuario;
import br.com.formento.garagem.model.UsuarioPermissao;

public interface UsuarioPermissaoDao extends Dao<UsuarioPermissao, Integer> {

	List<UsuarioPermissao> getByUsuario(Usuario usuario);

}
