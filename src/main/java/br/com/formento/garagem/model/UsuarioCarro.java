package br.com.formento.garagem.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the usuario_carro database table.
 * 
 */
@Entity
@Table(name="usuario_carro")
@NamedQuery(name="UsuarioCarro.findAll", query="SELECT u FROM UsuarioCarro u")
public class UsuarioCarro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int codigo;

	//bi-directional many-to-one association to Carro
	@ManyToOne
	@JoinColumn(name="cod_carro")
	private Carro carro;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="cod_usuario")
	private Usuario usuario;

	public UsuarioCarro() {
	}

	public int getCodigo() {
		return this.codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Carro getCarro() {
		return this.carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}