package br.com.formento.garagem.model;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;
import java.util.Locale;
import java.util.TreeSet;

import br.com.formento.garagem.compare.ResultadoPesquisaPorValorComparator;
import br.com.formento.garagem.interfaces.IResultadoPesquisa;

public class OrcamentoValor {

	private TreeSet<IResultadoPesquisa> resultadoPesquisaTree;
	private String valorFormatado;
	private ResultadoPesquisaPorValorComparator resultadoPesquisaPorValorComparator;

	public OrcamentoValor() {
	}

	public OrcamentoValor(List<? extends IResultadoPesquisa> resultadoPesquisaList) {
		this.resultadoPesquisaPorValorComparator = new ResultadoPesquisaPorValorComparator();
		this.resultadoPesquisaTree = new TreeSet<IResultadoPesquisa>(resultadoPesquisaPorValorComparator);
		this.resultadoPesquisaTree.addAll(resultadoPesquisaList);
	}

	public void setValorFormatado(String valorFormatado) {
		this.valorFormatado = valorFormatado;
	}

	public boolean getExisteValor() {
		return !resultadoPesquisaTree.isEmpty();
	}

	public IResultadoPesquisa getMenorValor() {
		if (getExisteValor())
			return resultadoPesquisaTree.first();
		else
			return null;
	}

	public IResultadoPesquisa getMaiorValor() {
		if (getExisteValor())
			return resultadoPesquisaTree.last();
		else
			return null;
	}

	public String getValorFormatado() {
		if (valorFormatado == null) {
			StringBuilder valor = new StringBuilder();

			if (getExisteValor()) {
				DecimalFormat formatoDois = new DecimalFormat("##,###,###,##0.00", new DecimalFormatSymbols(new Locale("pt", "BR")));
				formatoDois.setMinimumFractionDigits(2);
				formatoDois.setParseBigDecimal(true);

				final String monetario = "R$ ";

				valor.append(monetario);
				valor.append(formatoDois.format(getMenorValor().getValor()));
				if (resultadoPesquisaPorValorComparator.compare(getMenorValor(), getMaiorValor()) < 0) {
					valor.append(" - ");
					valor.append(monetario);
					valor.append(formatoDois.format(getMaiorValor().getValor()));
				}
			}

			valorFormatado = valor.toString();
		}
		return valorFormatado;
	}
}
