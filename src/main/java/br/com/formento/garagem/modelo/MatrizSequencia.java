package br.com.formento.garagem.modelo;

import java.util.ArrayList;
import java.util.List;

public class MatrizSequencia {
	private final List<Valor> valores;
	private final int tamanho;

	public MatrizSequencia(int tamanho) {
		this.tamanho = tamanho;
		valores = new ArrayList<>();
		for (int i = 0; i < tamanho; i++)
			valores.add(new Valor(0d));
	}

	public List<Valor> getValores() {
		return valores;
	}

	public int getTamanho() {
		return tamanho;
	}

	public Valor getValorPorColuna(int coluna) {
		return valores.get(coluna);
	}

	@Override
	public String toString() {
		final String separador = "; ";
		
		boolean isPutSeparador = false;
		StringBuilder stringBuilder = new StringBuilder("[");
		for (Valor valor : valores) {
			if (isPutSeparador)
				stringBuilder.append(separador);
			stringBuilder.append(valor);
			isPutSeparador = true;
		}
		stringBuilder.append("]");

		return stringBuilder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + tamanho;
		result = prime * result + ((valores == null) ? 0 : valores.hashCode());
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
		MatrizSequencia other = (MatrizSequencia) obj;
		if (tamanho != other.tamanho)
			return false;
		if (valores == null) {
			if (other.valores != null)
				return false;
		} else if (!valores.equals(other.valores))
			return false;
		return true;
	}

}
