package br.com.formento.garagem.dao.jpa;

import org.springframework.stereotype.Repository;

import br.com.formento.garagem.dao.JpaDao;
import br.com.formento.garagem.dao.interfaces.CarroFotoDao;
import br.com.formento.garagem.model.Carro;
import br.com.formento.garagem.model.CarroFoto;

@Repository
public class JpaCarroFotoDao extends JpaDao<CarroFoto, Carro> implements CarroFotoDao {

}
