package br.com.formento.garagem.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import br.com.formento.garagem.interfaces.IResultadoPesquisa;

/**
 * The persistent class for the resultado_pesquisa_preco database table.
 */
@Entity
@Table(name = "resultado_pesquisa_preco")
@NamedQuery(name = "ResultadoPesquisaPreco.findAll", query = "SELECT r FROM ResultadoPesquisaPreco r")
public class ResultadoPesquisaPreco implements IResultadoPesquisa, Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int codigo;

	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_pesquisa")
	private Date dataPesquisa;

	private String link;

	@Column(name = "caminho_imagem")
	private String caminhoImagem;

	private BigDecimal valor;

	private int ordem;

	// bi-directional many-to-one association to MetodoPesquisaPreco
	@ManyToOne
	@JoinColumn(name = "cod_metodo_pesquisa_preco")
	private MetodoPesquisaPreco metodoPesquisaPreco;

	// bi-directional many-to-one association to Orcamento
	@ManyToOne
	@JoinColumn(name = "cod_orcamento")
	private Orcamento orcamento;

	public ResultadoPesquisaPreco() {
	}

	public ResultadoPesquisaPreco(Orcamento orcamento) {
		this.orcamento = orcamento;
	}

	public void configurarResultadoPesquisa(IResultadoPesquisa resultadoPesquisa) {
		this.caminhoImagem = resultadoPesquisa.getCaminhoImagem();
		this.dataPesquisa = resultadoPesquisa.getDataPesquisa();
		this.link = resultadoPesquisa.getLink();
		this.metodoPesquisaPreco = resultadoPesquisa.getMetodoPesquisaPreco();
		this.valor = resultadoPesquisa.getValor();
		this.ordem = resultadoPesquisa.getOrdem();
	}

	public int getCodigo() {
		return this.codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Date getDataPesquisa() {
		return dataPesquisa;
	}

	public String getLink() {
		return link;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public MetodoPesquisaPreco getMetodoPesquisaPreco() {
		return metodoPesquisaPreco;
	}

	public Orcamento getOrcamento() {
		return this.orcamento;
	}

	public void setOrcamento(Orcamento orcamento) {
		this.orcamento = orcamento;
	}

	public String getCaminhoImagem() {
		return caminhoImagem;
	}

	public void setDataPesquisa(Date dataPesquisa) {
		this.dataPesquisa = dataPesquisa;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public void setCaminhoImagem(String caminhoImagem) {
		this.caminhoImagem = caminhoImagem;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public void setMetodoPesquisaPreco(MetodoPesquisaPreco metodoPesquisaPreco) {
		this.metodoPesquisaPreco = metodoPesquisaPreco;
	}

	@Override
	public int getOrdem() {
		return ordem;
	}

	@Override
	public void setOrdem(int ordem) {
		this.ordem = ordem;
	}

}