package br.com.formento.garagem.interfaces;

import java.math.BigDecimal;
import java.util.Date;

import br.com.formento.garagem.model.MetodoPesquisaPreco;

public interface IResultadoPesquisa {

	Date getDataPesquisa();

	void setDataPesquisa(Date dataPesquisa);

	String getLink();

	void setLink(String caminhoImagem);

	String getCaminhoImagem();

	void setCaminhoImagem(String caminhoImagem);

	BigDecimal getValor();

	void setValor(BigDecimal valor);

	MetodoPesquisaPreco getMetodoPesquisaPreco();

	void setMetodoPesquisaPreco(MetodoPesquisaPreco metodoPesquisaPreco);

	int getOrdem();

	void setOrdem(int ordem);

}
