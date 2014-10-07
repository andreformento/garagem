package br.com.formento.garagem.modelo;

import br.com.formento.garagem.enums.EStatusMensagem;

public class MetodoGaussSeidel extends CalculoMatriz {

	public MetodoGaussSeidel(Matriz matriz) {
		super(matriz);
	}

	@Override
	public MatrizLinha getResultado() {
		return null;
	}

	@Override
	public Mensagem getMensagem() {
		return new Mensagem(EStatusMensagem.ERRO, new StringBuilder("N�o implementado"));
	}

}
