package br.com.formento.garagem.enums;

import br.com.formento.garagem.interfaces.IFerramentaPesquisa;
import br.com.formento.garagem.model.FerramentaPesquisaMercadoLivre;
import br.com.formento.garagem.model.MetodoPesquisaPreco;

public enum MetodoPesquisaPrecoEnum {
	MERCADO_LIVRE(new FerramentaPesquisaMercadoLivre());

	private final IFerramentaPesquisa ferramentaPesquisa;

	private MetodoPesquisaPrecoEnum(IFerramentaPesquisa ferramentaPesquisa) {
		this.ferramentaPesquisa = ferramentaPesquisa;
	}

	public IFerramentaPesquisa getFerramentaPesquisa() {
		return ferramentaPesquisa;
	}

	public static MetodoPesquisaPrecoEnum getByInstancia(MetodoPesquisaPreco instancia) {
		for (MetodoPesquisaPrecoEnum e : values())
			if (e.getFerramentaPesquisa().getMetodoPesquisaPreco().equals(instancia))
				return e;

		return null;
	}

}
