package br.com.formento.garagem.dao.interfaces;

import br.com.formento.garagem.dao.Dao;
import br.com.formento.garagem.model.Carro;
import br.com.formento.garagem.model.CarroFoto;

public interface CarroFotoDao extends Dao<CarroFoto, Integer> {

	CarroFoto getByCarro(Carro carro);

}
