package br.com.formento.garagem.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * The persistent class for the usuario database table.
 */
@Entity
@Table(name = "usuario")
@NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int codigo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_cadastro")
	private Date dataCadastro;

	@NotEmpty
	@Email
	private String username;

	@NotEmpty
	private String password;

	// bi-directional many-to-one association to Carro
	@ManyToOne
	@JoinColumn(name = "cod_ultimo_carro")
	private Carro carro;

	// bi-directional many-to-one association to UsuarioPermissao
	@OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER)
	private List<UsuarioPermissao> usuarioPermissaos;

	// bi-directional many-to-one association to ParecerOrcamento
	@OneToMany(mappedBy = "usuario")
	private List<ParecerOrcamento> parecerOrcamentos;

	// bi-directional many-to-one association to UsuarioCarro
	@OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER)
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Carro getCarro() {
		return this.carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

	public List<UsuarioPermissao> getUsuarioPermissaos() {
		return this.usuarioPermissaos;
	}

	public void setUsuarioPermissaos(List<UsuarioPermissao> usuarioPermissaos) {
		this.usuarioPermissaos = usuarioPermissaos;
	}

	public UsuarioPermissao addUsuarioPermissao(UsuarioPermissao usuarioPermissao) {
		getUsuarioPermissaos().add(usuarioPermissao);
		usuarioPermissao.setUsuario(this);

		return usuarioPermissao;
	}

	public UsuarioPermissao removeUsuarioPermissao(UsuarioPermissao usuarioPermissao) {
		getUsuarioPermissaos().remove(usuarioPermissao);
		usuarioPermissao.setUsuario(null);

		return usuarioPermissao;
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
		Usuario other = (Usuario) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}

}