package br.com.formento.garagem.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the orcamento database table.
 * 
 */
@Entity
@Table(name="orcamento")
@NamedQuery(name="Orcamento.findAll", query="SELECT o FROM Orcamento o")
public class Orcamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int codigo;

	private String acao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_criacao")
	private Date dataCriacao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_prevista")
	private Date dataPrevista;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_real")
	private Date dataReal;

	private String detalhe;

	@Column(name="valor_previsto")
	private BigDecimal valorPrevisto;

	@Column(name="valor_real")
	private BigDecimal valorReal;

	//bi-directional many-to-one association to StatusOrcamento
	@ManyToOne
	@JoinColumn(name="cod_status_orcamento")
	private StatusOrcamento statusOrcamento;

	//bi-directional many-to-one association to CategoriaOrcamento
	@ManyToOne
	@JoinColumn(name="cod_CATEGORIA_orcamento")
	private CategoriaOrcamento categoriaOrcamento;

	//bi-directional many-to-one association to Carro
	@ManyToOne
	@JoinColumn(name="cod_carro")
	private Carro carro;

	//bi-directional many-to-one association to ParecerOrcamento
	@OneToMany(mappedBy="orcamento")
	private List<ParecerOrcamento> parecerOrcamentos;

	//bi-directional many-to-one association to ResultadoPesquisaPreco
	@OneToMany(mappedBy="orcamento")
	private List<ResultadoPesquisaPreco> resultadoPesquisaPrecos;

	public Orcamento() {
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

	public List<ParecerOrcamento> getParecerOrcamentos() {
		return this.parecerOrcamentos;
	}

	public void setParecerOrcamentos(List<ParecerOrcamento> parecerOrcamentos) {
		this.parecerOrcamentos = parecerOrcamentos;
	}

	public ParecerOrcamento addParecerOrcamento(ParecerOrcamento parecerOrcamento) {
		getParecerOrcamentos().add(parecerOrcamento);
		parecerOrcamento.setOrcamento(this);

		return parecerOrcamento;
	}

	public ParecerOrcamento removeParecerOrcamento(ParecerOrcamento parecerOrcamento) {
		getParecerOrcamentos().remove(parecerOrcamento);
		parecerOrcamento.setOrcamento(null);

		return parecerOrcamento;
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

}