package br.com.formento.garagem.model;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import br.com.formento.garagem.interfaces.IResultadoPesquisa;

public class ResultadoPesquisaBase implements IResultadoPesquisa {

	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private Date dataPesquisa;

	private String link;

	private String caminhoImagem;

	private BigDecimal valor;

	private MetodoPesquisaPreco metodoPesquisaPreco;

	public ResultadoPesquisaBase() {
	}

	public ResultadoPesquisaBase(Date dataPesquisa, String link, String caminhoImagem, BigDecimal valor, MetodoPesquisaPreco metodoPesquisaPreco) {
		this.dataPesquisa = dataPesquisa;
		this.link = link;
		this.caminhoImagem = caminhoImagem;
		this.valor = valor;
		this.metodoPesquisaPreco = metodoPesquisaPreco;
	}

	@Override
	public Date getDataPesquisa() {
		return dataPesquisa;
	}

	@Override
	public void setDataPesquisa(Date dataPesquisa) {
		this.dataPesquisa = dataPesquisa;
	}

	@Override
	public String getLink() {
		return link;
	}

	@Override
	public void setLink(String link) {
		this.link = link;
	}

	@Override
	public String getCaminhoImagem() {
		return caminhoImagem;
	}

	@Override
	public void setCaminhoImagem(String caminhoImagem) {
		this.caminhoImagem = caminhoImagem;
	}

	@Override
	public BigDecimal getValor() {
		return valor;
	}

	@Override
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	@Override
	public MetodoPesquisaPreco getMetodoPesquisaPreco() {
		return metodoPesquisaPreco;
	}

	@Override
	public void setMetodoPesquisaPreco(MetodoPesquisaPreco metodoPesquisaPreco) {
		this.metodoPesquisaPreco = metodoPesquisaPreco;
	}

	@Override
	public String toString() {
		return "ResultadoPesquisaBase [dataPesquisa=" + dataPesquisa + ", link=" + link + ", caminhoImagem=" + caminhoImagem + ", valor=" + valor
				+ ", metodoPesquisaPreco=" + metodoPesquisaPreco + "]";
	}

}
