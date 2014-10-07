package br.com.formento.garagem.interfaces;

import br.com.formento.garagem.modelo.Matriz;
import br.com.formento.garagem.modelo.MatrizLinha;
import br.com.formento.garagem.modelo.Mensagem;

public interface ICalculoMatriz {

	Matriz getMatriz();

	MatrizLinha getResultado();

	Mensagem getMensagem();

}
