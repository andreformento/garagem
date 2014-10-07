package br.com.formento.garagem.modelo;

import br.com.formento.garagem.enums.EStatusMensagem;

public class Mensagem {
	private final EStatusMensagem eStatusMensagem;
	private final StringBuilder detalhe;

	public Mensagem(EStatusMensagem eStatusMensagem, StringBuilder detalhe) {
		this.eStatusMensagem = eStatusMensagem;
		this.detalhe = detalhe;
	}

	public EStatusMensagem geteStatusMensagem() {
		return eStatusMensagem;
	}

	public StringBuilder getDetalhe() {
		return detalhe;
	}

}
