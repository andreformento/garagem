package br.com.formento.garagem.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ResultadoPesquisaList implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5845835415917737028L;

	private static final Gson GSON = new GsonBuilder().create();

	private Orcamento orcamento;
	private String jsonListResultadoPesquisa;
	private List<ResultadoPesquisaBase> lista;
	private String indicesRemovidos;

	public ResultadoPesquisaList() {

	}

	public ResultadoPesquisaList(Orcamento orcamento, List<ResultadoPesquisaBase> lista) {
		this.orcamento = orcamento;
		setLista(lista);
	}

	public Orcamento getOrcamento() {
		return orcamento;
	}

	public void setOrcamento(Orcamento orcamento) {
		this.orcamento = orcamento;
	}

	public String getJsonListResultadoPesquisa() {
		return jsonListResultadoPesquisa;
	}

	public void setJsonListResultadoPesquisa(String jsonListResultadoPesquisa) {
		this.jsonListResultadoPesquisa = jsonListResultadoPesquisa;
	}

	public List<ResultadoPesquisaBase> getLista() {
		if (jsonListResultadoPesquisa != null && lista == null) {
			ResultadoPesquisaBase[] resultadoPesquisaArray = GSON.fromJson(jsonListResultadoPesquisa, ResultadoPesquisaBase[].class);
			lista = Arrays.asList(resultadoPesquisaArray);
		}
		return lista;
	}

	public void setLista(List<ResultadoPesquisaBase> lista) {
		this.jsonListResultadoPesquisa = GSON.toJson(lista, List.class);
		this.lista = lista;
	}

	public String getIndicesRemovidos() {
		return indicesRemovidos;
	}

	public void setIndicesRemovidos(String indicesRemovidos) {
		this.indicesRemovidos = indicesRemovidos;
	}

}
