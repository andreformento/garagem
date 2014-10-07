package br.com.formento.garagem.modelo;

import br.com.formento.garagem.enums.EStatusMensagem;

public class MetodoTriangulacaoDeGauss extends CalculoMatriz {

	private Mensagem mensagem;

	public MetodoTriangulacaoDeGauss(Matriz matriz) {
		super(matriz);
	}

	@Override
	public Mensagem getMensagem() {
		if (mensagem == null) {
			final StringBuilder detalhe;
			final EStatusMensagem eStatusMensagem;

			if (!getMatriz().getParametro().isQuadrada()) {
				detalhe = new StringBuilder("N�o � uma matriz quadrada");
				eStatusMensagem = EStatusMensagem.NAO_VALIDO;
			} else if (getMatriz().isColunaNula(0)) {
				detalhe = new StringBuilder("Na primeira coluna todos os elementos s�o nulos");
				eStatusMensagem = EStatusMensagem.NAO_VALIDO;
			} else {
				detalhe = new StringBuilder();

				// se o pivot for nulo, tem que encontrar uma linha que o pivot n�o seja nulo e permutar
				if (getMatriz().getPivot().getNumero() == 0d) {
					int indiceLinhaPermutar = 0;
					for (int i = 0; 1 < getMatriz().getParametro().getQuantidadeDeLinhas(); i++) {
						if (getMatriz().getValor(i, 0).getNumero() != 0d) {
							indiceLinhaPermutar = i;
							break;
						}
					}
					getMatriz().permutar(0, indiceLinhaPermutar);

					detalhe.append("Permutou a linha\n");
					detalhe.append(getMatriz().imprimirLinha(0));
					detalhe.append("\nCom a linha\n");
					detalhe.append(getMatriz().imprimirLinha(indiceLinhaPermutar));
				}

				eStatusMensagem = EStatusMensagem.CALCULADO;
			}

			mensagem = new Mensagem(eStatusMensagem, detalhe);
		}
		return mensagem;
	}

	@Override
	public MatrizLinha getResultado() {
		return null;
	}

}
