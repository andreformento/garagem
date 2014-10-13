package br.com.formento.garagem.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the resultado_pesquisa_preco database table.
 * 
 */
@Entity
@Table(name="resultado_pesquisa_preco")
@NamedQuery(name="ResultadoPesquisaPreco.findAll", query="SELECT r FROM ResultadoPesquisaPreco r")
public class ResultadoPesquisaPreco implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int codigo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_pesquisa")
	private Date dataPesquisa;

	private String link;

	private BigDecimal valor;

	//bi-directional many-to-one association to MetodoPesquisaPreco
	@ManyToOne
	@JoinColumn(name="metodo_pesquisa_preco_codigo")
	private MetodoPesquisaPreco metodoPesquisaPreco;

	//bi-directional many-to-one association to Orcamento
	@ManyToOne
	private Orcamento orcamento;

	public ResultadoPesquisaPreco() {
	}

	public int getCodigo() {
		return this.codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Date getDataPesquisa() {
		return this.dataPesquisa;
	}

	public void setDataPesquisa(Date dataPesquisa) {
		this.dataPesquisa = dataPesquisa;
	}

	public String getLink() {
		return this.link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public BigDecimal getValor() {
		return this.valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public MetodoPesquisaPreco getMetodoPesquisaPreco() {
		return this.metodoPesquisaPreco;
	}

	public void setMetodoPesquisaPreco(MetodoPesquisaPreco metodoPesquisaPreco) {
		this.metodoPesquisaPreco = metodoPesquisaPreco;
	}

	public Orcamento getOrcamento() {
		return this.orcamento;
	}

	public void setOrcamento(Orcamento orcamento) {
		this.orcamento = orcamento;
	}

}