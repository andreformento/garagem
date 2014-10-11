package br.com.formento.garagem.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the parecer_orcamento database table.
 * 
 */
@Entity
@Table(name="parecer_orcamento")
@NamedQuery(name="ParecerOrcamento.findAll", query="SELECT p FROM ParecerOrcamento p")
public class ParecerOrcamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int codigo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_parecer")
	private Date dataParecer;

	private String parecer;

	//bi-directional many-to-one association to Orcamento
	@ManyToOne
	@JoinColumn(name="cod_orcamento")
	private Orcamento orcamento;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="cod_usuario")
	private Usuario usuario;

	public ParecerOrcamento() {
	}

	public int getCodigo() {
		return this.codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Date getDataParecer() {
		return this.dataParecer;
	}

	public void setDataParecer(Date dataParecer) {
		this.dataParecer = dataParecer;
	}

	public String getParecer() {
		return this.parecer;
	}

	public void setParecer(String parecer) {
		this.parecer = parecer;
	}

	public Orcamento getOrcamento() {
		return this.orcamento;
	}

	public void setOrcamento(Orcamento orcamento) {
		this.orcamento = orcamento;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}