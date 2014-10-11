package br.com.formento.garagem.model;

import java.io.Serializable;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int codigo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_cadastro")
	private Date dataCadastro;

	private String email;

	@Column(columnDefinition = "char(35)")
	private String senha;

	// bi-directional many-to-one association to ParecerOrcamento
	@OneToMany(mappedBy = "usuario")
	private List<ParecerOrcamento> parecerOrcamentos;

	// bi-directional many-to-one association to Carro
	@ManyToOne
	@JoinColumn(name = "cod_ultimo_carro")
	private Carro carro;

	// bi-directional many-to-one association to UsuarioNivel
	@ManyToOne
	@JoinColumn(name = "cod_usuario_nivel")
	private UsuarioNivel usuarioNivel;

	// bi-directional many-to-one association to UsuarioCarro
	@OneToMany(mappedBy = "usuario")
	private List<UsuarioCarro> usuarioCarros;

	public Usuario() {
	}

	public int getCodigo() {
		return this.codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Date getDataCadastro() {
		return this.dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<ParecerOrcamento> getParecerOrcamentos() {
		return this.parecerOrcamentos;
	}

	public void setParecerOrcamentos(List<ParecerOrcamento> parecerOrcamentos) {
		this.parecerOrcamentos = parecerOrcamentos;
	}

	public ParecerOrcamento addParecerOrcamento(ParecerOrcamento parecerOrcamento) {
		getParecerOrcamentos().add(parecerOrcamento);
		parecerOrcamento.setUsuario(this);

		return parecerOrcamento;
	}

	public ParecerOrcamento removeParecerOrcamento(ParecerOrcamento parecerOrcamento) {
		getParecerOrcamentos().remove(parecerOrcamento);
		parecerOrcamento.setUsuario(null);

		return parecerOrcamento;
	}

	public Carro getCarro() {
		return this.carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

	public UsuarioNivel getUsuarioNivel() {
		return this.usuarioNivel;
	}

	public void setUsuarioNivel(UsuarioNivel usuarioNivel) {
		this.usuarioNivel = usuarioNivel;
	}

	public List<UsuarioCarro> getUsuarioCarros() {
		return this.usuarioCarros;
	}

	public void setUsuarioCarros(List<UsuarioCarro> usuarioCarros) {
		this.usuarioCarros = usuarioCarros;
	}

	public UsuarioCarro addUsuarioCarro(UsuarioCarro usuarioCarro) {
		getUsuarioCarros().add(usuarioCarro);
		usuarioCarro.setUsuario(this);

		return usuarioCarro;
	}

	public UsuarioCarro removeUsuarioCarro(UsuarioCarro usuarioCarro) {
		getUsuarioCarros().remove(usuarioCarro);
		usuarioCarro.setUsuario(null);

		return usuarioCarro;
	}

}