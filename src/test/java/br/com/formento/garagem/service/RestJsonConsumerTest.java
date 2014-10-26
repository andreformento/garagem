package br.com.formento.garagem.service;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import br.com.formento.garagem.model.RestJsonConsumer;
import br.com.formento.garagem.model.mercadoLivre.MercadoLivreResultado;
import br.com.formento.garagem.model.mercadoLivre.Results;

public class RestJsonConsumerTest {
	@Test
	public void pesquisaTest() {
		RestJsonConsumer restJsonConsumer = RestJsonConsumer.getInstance();
		assertNotNull(restJsonConsumer);

		MercadoLivreResultado mercadoLivreResultado = restJsonConsumer.resultado("Bateria Moura 60 Amperes");
		assertNotNull(mercadoLivreResultado);
		assertNotNull(mercadoLivreResultado.getResults());

		for (Results result : mercadoLivreResultado.getResults()) {
			assertNotNull(result.getPriceDouble());
			assertNotEquals(Double.valueOf(0d), result.getPriceDouble());
		}
	}

}
