package br.com.formento.garagem.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.formento.garagem.interfaces.IFerramentaPesquisa;
import br.com.formento.garagem.interfaces.IResultadoPesquisa;
import br.com.formento.garagem.model.mercadoLivre.MercadoLivreResultado;
import br.com.formento.garagem.model.mercadoLivre.Results;

public class FerramentaPesquisaMercadoLivre implements IFerramentaPesquisa {

	private final MetodoPesquisaPreco metodoPesquisaPreco;

	public FerramentaPesquisaMercadoLivre() {
		this.metodoPesquisaPreco = new MetodoPesquisaPreco(1, "Mercado Livre");
	}

	@Override
	public List<IResultadoPesquisa> gerarResultadoPesquisaList(String tagBusca) {
		List<IResultadoPesquisa> lista = new ArrayList<>();

		RestJsonConsumer restJsonConsumer = RestJsonConsumer.getInstance();
		MercadoLivreResultado mercadoLivreResultado = restJsonConsumer.resultado(tagBusca);

		if (mercadoLivreResultado.getResults().length > 0) {
			Date dataPesquisa = new Date();

			for (Results jsonResult : mercadoLivreResultado.getResults()) {
				Double priceDouble = jsonResult.getPriceDouble();
				if (priceDouble == null || priceDouble.compareTo(Double.valueOf(0d)) <= 0)
					continue;

				String link = jsonResult.getPermalink();
				if (link == null || link.isEmpty())
					continue;

				String caminhoImagem = jsonResult.getThumbnail();

				BigDecimal valor = new BigDecimal(priceDouble);

				IResultadoPesquisa resultadoPesquisa = new ResultadoPesquisaBase();
				resultadoPesquisa.setDataPesquisa(dataPesquisa);
				resultadoPesquisa.setLink(link);
				resultadoPesquisa.setCaminhoImagem(caminhoImagem);
				resultadoPesquisa.setValor(valor);
				resultadoPesquisa.setMetodoPesquisaPreco(metodoPesquisaPreco);
				resultadoPesquisa.setOrdem(lista.size() + 1);

				lista.add(resultadoPesquisa);

				if (lista.size() >= 15)
					break;
			}
		}

		return lista;
	}

	@Override
	public MetodoPesquisaPreco getMetodoPesquisaPreco() {
		return this.metodoPesquisaPreco;
	}

}
