package br.com.formento.garagem.enums;

import br.com.formento.garagem.modelo.CalculoMatriz;
import br.com.formento.garagem.modelo.MetodoGaussSeidel;
import br.com.formento.garagem.modelo.MetodoTriangulacaoDeGauss;

public enum EMetodoCalculoMatriz {
	TRIANGULACAO_DE_GAUSS(MetodoTriangulacaoDeGauss.class, "Triangula��o de Gauss"), GAUSS_SEIDEL(
			MetodoGaussSeidel.class, "Gauss-Seidel");

	private final Class<? extends CalculoMatriz> classe;
	private final String descricao;

	private EMetodoCalculoMatriz(Class<? extends CalculoMatriz> classe, String descricao) {
		this.classe = classe;
		this.descricao = descricao;
	}

	public Class<? extends CalculoMatriz> getClasse() {
		return classe;
	}

	public String getDescricao() {
		return descricao;
	}

}
