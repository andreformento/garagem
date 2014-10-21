package br.com.formento.garagem.model;

import br.com.formento.garagem.enums.TipoEntidadeOrdenacao;

public class EntidadeOrdenacao {
	private final TipoEntidadeOrdenacao tipoEntidadeOrdenacao;
	private final String nomeCampo;

	public EntidadeOrdenacao(TipoEntidadeOrdenacao tipoEntidadeOrdenacao, String nomeCampo) {
		this.tipoEntidadeOrdenacao = tipoEntidadeOrdenacao;
		this.nomeCampo = nomeCampo;
	}

	public TipoEntidadeOrdenacao getTipoEntidadeOrdenacao() {
		return tipoEntidadeOrdenacao;
	}

	public String getNomeCampo() {
		return nomeCampo;
	}

}
