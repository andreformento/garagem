package br.com.formento.garagem.modelo;

import java.io.Serializable;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class MatrizParametro implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4410857320691817382L;

	@NotNull
	@Min(1)
	@Valid
	private final Integer quantidadeDeLinhas;

	@NotNull
	@Min(1)
	@Valid
	private final Integer quantidadeDeColunas;

	public MatrizParametro(Integer quantidadeDeLinhas, Integer quantidadeDeColunas) {
		this.quantidadeDeLinhas = quantidadeDeLinhas;
		this.quantidadeDeColunas = quantidadeDeColunas;
	}

	public Integer getQuantidadeDeLinhas() {
		return quantidadeDeLinhas;
	}

	public Integer getQuantidadeDeColunas() {
		return quantidadeDeColunas;
	}

	public boolean isQuadrada() {
		return quantidadeDeColunas > 0 && quantidadeDeColunas.equals(quantidadeDeLinhas);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((quantidadeDeColunas == null) ? 0 : quantidadeDeColunas.hashCode());
		result = prime * result + ((quantidadeDeLinhas == null) ? 0 : quantidadeDeLinhas.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MatrizParametro other = (MatrizParametro) obj;
		if (quantidadeDeColunas == null) {
			if (other.quantidadeDeColunas != null)
				return false;
		} else if (!quantidadeDeColunas.equals(other.quantidadeDeColunas))
			return false;
		if (quantidadeDeLinhas == null) {
			if (other.quantidadeDeLinhas != null)
				return false;
		} else if (!quantidadeDeLinhas.equals(other.quantidadeDeLinhas))
			return false;
		return true;
	}

}
