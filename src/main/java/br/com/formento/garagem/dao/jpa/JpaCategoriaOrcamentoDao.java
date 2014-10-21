package br.com.formento.garagem.dao.jpa;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.formento.garagem.dao.JpaDao;
import br.com.formento.garagem.dao.interfaces.CategoriaOrcamentoDao;
import br.com.formento.garagem.model.CategoriaOrcamento;

@Repository
public class JpaCategoriaOrcamentoDao extends JpaDao<CategoriaOrcamento, Integer> implements CategoriaOrcamentoDao {

	@Override
	public List<CategoriaOrcamento> lista() {
		return super.lista();
	}

}
