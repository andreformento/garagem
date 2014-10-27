package br.com.formento.garagem.compare;

import java.util.Comparator;

import br.com.formento.garagem.interfaces.IResultadoPesquisa;

public class ResultadoPesquisaPorValorComparator implements Comparator<IResultadoPesquisa> {

	@Override
	public int compare(IResultadoPesquisa o1, IResultadoPesquisa o2) {
		return o1.getValor().compareTo(o2.getValor());
	}

}
