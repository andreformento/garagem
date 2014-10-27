package br.com.formento.garagem.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * The persistent class for the orcamento database table.
 */
@Entity
@Table(name = "orcamento")
@NamedQuery(name = "Orcamento.findAll", query = "SELECT o FROM Orcamento o")
public class Orcamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int codigo;

	private String acao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_criacao")
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private Date dataCriacao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_prevista")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dataPrevista;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_real")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dataReal;

	private String detalhe;

	@Column(name = "valor_previsto")
	private BigDecimal valorPrevisto;

	@Column(name = "valor_real")
	private BigDecimal valorReal;

	@Column(name = "tag_busca")
	private String tagBusca;

	@Column(name = "check_busca")
	private String checkBusca;

	// bi-directional many-to-one association to StatusOrcamento
	@ManyToOne
	@JoinColumn(name = "cod_status_orcamento")
	private StatusOrcamento statusOrcamento;

	// bi-directional many-to-one association to CategoriaOrcamento
	@ManyToOne
	@JoinColumn(name = "cod_CATEGORIA_orcamento")
	private CategoriaOrcamento categoriaOrcamento;

	// bi-directional many-to-one association to Carro
	@ManyToOne
	@JoinColumn(name = "cod_carro")
	private Carro carro;

	// bi-directional many-to-one association to ResultadoPesquisaPreco
	@OneToMany(mappedBy = "orcamento")
	private List<ResultadoPesquisaPreco> resultadoPesquisaPrecos;

	@Transient
	private transient OrcamentoValor orcamentoValor;

	public Orcamento() {
	}

	public Orcamento(int codigo, String tagBusca) {
		this.codigo = codigo;
		this.tagBusca = tagBusca;
	}

	public int getCodigo() {
		return this.codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getAcao() {
		return this.acao;
	}

	public void setAcao(String acao) {
		this.acao = acao;
	}

	public Date getDataCriacao() {
		return this.dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Date getDataPrevista() {
		return this.dataPrevista;
	}

	public void setDataPrevista(Date dataPrevista) {
		this.dataPrevista = dataPrevista;
	}

	public Date getDataReal() {
		return this.dataReal;
	}

	public void setDataReal(Date dataReal) {
		this.dataReal = dataReal;
	}

	public String getDetalhe() {
		return this.detalhe;
	}

	public void setDetalhe(String detalhe) {
		this.detalhe = detalhe;
	}

	public BigDecimal getValorPrevisto() {
		return this.valorPrevisto;
	}

	public void setValorPrevisto(BigDecimal valorPrevisto) {
		this.valorPrevisto = valorPrevisto;
	}

	public BigDecimal getValorReal() {
		return this.valorReal;
	}

	public void setValorReal(BigDecimal valorReal) {
		this.valorReal = valorReal;
	}

	public String getTagBusca() {
		return tagBusca;
	}

	public void setTagBusca(String tagBusca) {
		this.tagBusca = tagBusca;
	}

	public String getCheckBusca() {
		return checkBusca;
	}

	public void setCheckBusca(String checkBusca) {
		this.checkBusca = checkBusca;
	}

	public StatusOrcamento getStatusOrcamento() {
		return this.statusOrcamento;
	}

	public void setStatusOrcamento(StatusOrcamento statusOrcamento) {
		this.statusOrcamento = statusOrcamento;
	}

	public CategoriaOrcamento getCategoriaOrcamento() {
		return this.categoriaOrcamento;
	}

	public void setCategoriaOrcamento(CategoriaOrcamento categoriaOrcamento) {
		this.categoriaOrcamento = categoriaOrcamento;
	}

	public Carro getCarro() {
		return this.carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

	public List<ResultadoPesquisaPreco> getResultadoPesquisaPrecos() {
		return this.resultadoPesquisaPrecos;
	}

	public void setResultadoPesquisaPrecos(List<ResultadoPesquisaPreco> resultadoPesquisaPrecos) {
		this.resultadoPesquisaPrecos = resultadoPesquisaPrecos;
	}

	public ResultadoPesquisaPreco addResultadoPesquisaPreco(ResultadoPesquisaPreco resultadoPesquisaPreco) {
		getResultadoPesquisaPrecos().add(resultadoPesquisaPreco);
		resultadoPesquisaPreco.setOrcamento(this);

		return resultadoPesquisaPreco;
	}

	public ResultadoPesquisaPreco removeResultadoPesquisaPreco(ResultadoPesquisaPreco resultadoPesquisaPreco) {
		getResultadoPesquisaPrecos().remove(resultadoPesquisaPreco);
		resultadoPesquisaPreco.setOrcamento(null);

		return resultadoPesquisaPreco;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
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
		Orcamento other = (Orcamento) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}

	@Transient
	public OrcamentoValor getOrcamentoValor() {
		if (orcamentoValor == null)
			orcamentoValor = new OrcamentoValor(resultadoPesquisaPrecos);

		return orcamentoValor;
	}

}