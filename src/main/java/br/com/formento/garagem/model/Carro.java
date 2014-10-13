package br.com.formento.garagem.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the carro database table.
 * 
 */
@Entity
@Table(name="carro")
@NamedQuery(name="Carro.findAll", query="SELECT c FROM Carro c")
public class Carro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int codigo;

	private String ano;

	private String historia;

	private String marca;

	private String meta;

	private String modelo;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="carro")
	private List<Usuario> usuarios;

	//bi-directional one-to-one association to CarroFoto
	@OneToOne(mappedBy="carro")
	private CarroFoto carroFoto;

	//bi-directional many-to-one association to Orcamento
	@OneToMany(mappedBy="carro")
	private List<Orcamento> orcamentos;

	//bi-directional many-to-one association to UsuarioCarro
	@OneToMany(mappedBy="carro")
	private List<UsuarioCarro> usuarioCarros;

	public Carro() {
	}

	public int getCodigo() {
		return this.codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getAno() {
		return this.ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getHistoria() {
		return this.historia;
	}

	public void setHistoria(String historia) {
		this.historia = historia;
	}

	public String getMarca() {
		return this.marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getMeta() {
		return this.meta;
	}

	public void setMeta(String meta) {
		this.meta = meta;
	}

	public String getModelo() {
		return this.modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario addUsuario(Usuario usuario) {
		getUsuarios().add(usuario);
		usuario.setCarro(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setCarro(null);

		return usuario;
	}

	public CarroFoto getCarroFoto() {
		return this.carroFoto;
	}

	public void setCarroFoto(CarroFoto carroFoto) {
		this.carroFoto = carroFoto;
	}

	public List<Orcamento> getOrcamentos() {
		return this.orcamentos;
	}

	public void setOrcamentos(List<Orcamento> orcamentos) {
		this.orcamentos = orcamentos;
	}

	public Orcamento addOrcamento(Orcamento orcamento) {
		getOrcamentos().add(orcamento);
		orcamento.setCarro(this);

		return orcamento;
	}

	public Orcamento removeOrcamento(Orcamento orcamento) {
		getOrcamentos().remove(orcamento);
		orcamento.setCarro(null);

		return orcamento;
	}

	public List<UsuarioCarro> getUsuarioCarros() {
		return this.usuarioCarros;
	}

	public void setUsuarioCarros(List<UsuarioCarro> usuarioCarros) {
		this.usuarioCarros = usuarioCarros;
	}

	public UsuarioCarro addUsuarioCarro(UsuarioCarro usuarioCarro) {
		getUsuarioCarros().add(usuarioCarro);
		usuarioCarro.setCarro(this);

		return usuarioCarro;
	}

	public UsuarioCarro removeUsuarioCarro(UsuarioCarro usuarioCarro) {
		getUsuarioCarros().remove(usuarioCarro);
		usuarioCarro.setCarro(null);

		return usuarioCarro;
	}

}