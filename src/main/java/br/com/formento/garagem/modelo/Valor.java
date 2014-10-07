package br.com.formento.garagem.modelo;

public class Valor {
	private double numero;

	public Valor(double numero) {
		this.numero = numero;
	}

	public double getNumero() {
		return numero;
	}

	public void setNumero(double numero) {
		this.numero = numero;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(numero);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Valor other = (Valor) obj;
		if (Double.doubleToLongBits(numero) != Double.doubleToLongBits(other.numero))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.valueOf(numero);
	}

}
