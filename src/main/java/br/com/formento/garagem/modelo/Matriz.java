package br.com.formento.garagem.modelo;

import java.util.ArrayList;
import java.util.List;

public class Matriz {
	private final MatrizParametro parametro;

	private List<MatrizLinha> listMatrizLinha;

	public Matriz() {
		this(null);
	}

	public Matriz(MatrizParametro parametro) {
		this.parametro = parametro;
	}

	public MatrizParametro getParametro() {
		return parametro;
	}

	public List<MatrizLinha> getListMatrizLinha() {
		if (listMatrizLinha == null) {
			listMatrizLinha = new ArrayList<MatrizLinha>();

			for (int i = 0; i < parametro.getQuantidadeDeLinhas(); i++)
				listMatrizLinha.add(new MatrizLinha(parametro.getQuantidadeDeColunas()));
		}
		return listMatrizLinha;
	}

	public List<Valor> getDiagonalPrincipal() {
		List<Valor> diagonalPrincipal = new ArrayList<>();
		if (parametro.isQuadrada())
			for (int i = 0; i < parametro.getQuantidadeDeLinhas(); i++)
				diagonalPrincipal.add(getListMatrizLinha().get(i).getMatrizSequencia().getValorPorColuna(i));
		return diagonalPrincipal;
	}

	public List<Valor> getValoresColuna(int coluna) {
		List<Valor> valoresColuna = new ArrayList<>();
		for (int i = 0; i < parametro.getQuantidadeDeLinhas(); i++)
			valoresColuna.add(getLinha(i).getMatrizSequencia().getValorPorColuna(coluna));

		return valoresColuna;
	}

	public boolean isColunaNula(int coluna) {
		for (Valor valor : getValoresColuna(coluna))
			if (valor.getNumero() != 0d)
				return false;
		return true;
	}

	public MatrizLinha getLinha(int linha) {
		return getListMatrizLinha().get(linha);
	}

	public List<Valor> getResultados() {
		ArrayList<Valor> resultados = new ArrayList<Valor>();
		for (MatrizLinha matrizLinha : listMatrizLinha)
			resultados.add(matrizLinha.getResultado());

		return resultados;
	}

	public Valor getPivot() {
		return getListMatrizLinha().get(0).getMatrizSequencia().getValorPorColuna(0);
	}

	public void permutar(int indiceLinha1, int indiceLinha2) {
		MatrizLinha matrizLinha1 = getListMatrizLinha().get(indiceLinha1);
		MatrizLinha matrizLinha2 = getListMatrizLinha().get(indiceLinha2);

		getListMatrizLinha().set(indiceLinha1, matrizLinha2);
		getListMatrizLinha().set(indiceLinha2, matrizLinha1);
	}

	public Valor getValor(int linha, int coluna) {
		return getLinha(linha).getMatrizSequencia().getValorPorColuna(coluna);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((listMatrizLinha == null) ? 0 : listMatrizLinha.hashCode());
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
		Matriz other = (Matriz) obj;
		if (listMatrizLinha == null) {
			if (other.listMatrizLinha != null)
				return false;
		} else if (!listMatrizLinha.equals(other.listMatrizLinha))
			return false;
		return true;
	}

	public StringBuilder imprimirLinha(int indiceLinha) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(indiceLinha);
		stringBuilder.append(" ");

		stringBuilder.append(getLinha(indiceLinha));

		return stringBuilder;
	}

	@Override
	public String toString() {
		final String separador = "\n";

		StringBuilder stringBuilder = new StringBuilder();
		for (int indiceLinha = 0; indiceLinha < getParametro().getQuantidadeDeLinhas(); indiceLinha++) {
			stringBuilder.append(imprimirLinha(indiceLinha));

			if (indiceLinha > 0)
				stringBuilder.append(separador);
		}

		return stringBuilder.toString();
	}

}
