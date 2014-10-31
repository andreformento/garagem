package br.com.formento.garagem.model.mercadoLivre;

import java.util.Arrays;

//import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MercadoLivreResultado {
	private Results[] results;

	public Results[] getResults() {
		return results;
	}

	public void setResults(Results[] results) {
		this.results = results;
	}

	@Override
	public String toString() {
		return "MercadoLivreResultado [results=" + Arrays.toString(results) + "]";
	}

}
