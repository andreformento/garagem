package br.com.formento.garagem.dao.jpa;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.formento.garagem.dao.JpaDao;
import br.com.formento.garagem.dao.interfaces.TipoCategoriaOrcamentoDao;
import br.com.formento.garagem.model.TipoCategoriaOrcamento;

@Repository
public class JpaTipoCategoriaOrcamentoDao extends JpaDao<TipoCategoriaOrcamento, Integer> implements TipoCategoriaOrcamentoDao {

	@Override
	public List<TipoCategoriaOrcamento> lista() {
		return super.lista();
	}

}
