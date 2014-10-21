package br.com.formento.garagem.dao.interfaces;

import java.util.List;

import br.com.formento.garagem.dao.Dao;
import br.com.formento.garagem.model.Carro;
import br.com.formento.garagem.model.Usuario;

public interface CarroDao extends Dao<Carro, Integer> {

	List<Carro> getByUsuario(Usuario usuario);

}
