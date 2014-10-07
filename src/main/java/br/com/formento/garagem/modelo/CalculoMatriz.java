package br.com.formento.garagem.modelo;

import br.com.formento.garagem.interfaces.ICalculoMatriz;

public abstract class CalculoMatriz implements ICalculoMatriz {
	private final Matriz matriz;

	public CalculoMatriz(Matriz matriz) {
		this.matriz = matriz;
	}

	@Override
	public Matriz getMatriz() {
		return matriz;
	}

}
