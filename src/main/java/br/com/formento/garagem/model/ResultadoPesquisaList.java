package br.com.formento.garagem.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.formento.garagem.interfaces.IResultadoPesquisa;

public class ResultadoPesquisaList implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5845835415917737028L;

	private Orcamento orcamento;

	private List<IResultadoPesquisa> lista;

	public ResultadoPesquisaList() {

	}

	public ResultadoPesquisaList(Orcamento orcamento) {
		this.lista = new ArrayList<>();
		this.orcamento = orcamento;
	}

	public boolean addAll(List<IResultadoPesquisa> adicionar) {
		return lista.addAll(adicionar);
	}

	public List<IResultadoPesquisa> getLista() {
		return lista;
	}

	public Orcamento getOrcamento() {
		return orcamento;
	}

}
