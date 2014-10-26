package br.com.formento.garagem.model.mercadoLivre;

import java.util.Arrays;

//import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MercadoLivreResultado {
	private Results[] results;

	private String query;

	private String site_id;

	private Paging paging;

	public Results[] getResults() {
		return results;
	}

	public void setResults(Results[] results) {
		this.results = results;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public String getSite_id() {
		return site_id;
	}

	public void setSite_id(String site_id) {
		this.site_id = site_id;
	}

	public Paging getPaging() {
		return paging;
	}

	public void setPaging(Paging paging) {
		this.paging = paging;
	}

	@Override
	public String toString() {
		return "MercadoLivreResultado [results=" + Arrays.toString(results) + ", query=" + query + ", site_id=" + site_id + ", paging=" + paging
				+ "]";
	}

}
