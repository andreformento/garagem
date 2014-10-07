package br.com.formento.garagem.modelo;

public class MatrizLinha {
	private final MatrizSequencia matrizSequencia;
	private final Valor resultado;

	public MatrizLinha(int tamanho) {
		matrizSequencia = new MatrizSequencia(tamanho);
		resultado = new Valor(0d);
	}

	public MatrizSequencia getMatrizSequencia() {
		return matrizSequencia;
	}

	public Valor getResultado() {
		return resultado;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(matrizSequencia);
		stringBuilder.append(" ");
		stringBuilder.append(resultado);

		return stringBuilder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((resultado == null) ? 0 : resultado.hashCode());
		result = prime * result + ((matrizSequencia == null) ? 0 : matrizSequencia.hashCode());
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
		MatrizLinha other = (MatrizLinha) obj;
		if (resultado == null) {
			if (other.resultado != null)
				return false;
		} else if (!resultado.equals(other.resultado))
			return false;
		if (matrizSequencia == null) {
			if (other.matrizSequencia != null)
				return false;
		} else if (!matrizSequencia.equals(other.matrizSequencia))
			return false;
		return true;
	}

}
