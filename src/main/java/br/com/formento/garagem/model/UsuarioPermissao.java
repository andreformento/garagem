package br.com.formento.garagem.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the usuario_permissao database table.
 * 
 */
@Entity
@Table(name="usuario_permissao")
@NamedQuery(name="UsuarioPermissao.findAll", query="SELECT u FROM UsuarioPermissao u")
public class UsuarioPermissao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int codigo;

	//bi-directional many-to-one association to Permissao
	@ManyToOne
	@JoinColumn(name="cod_permissao")
	private Permissao permissao;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="cod_usuario")
	private Usuario usuario;

	public UsuarioPermissao() {
	}

	public int getCodigo() {
		return this.codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Permissao getPermissao() {
		return this.permissao;
	}

	public void setPermissao(Permissao permissao) {
		this.permissao = permissao;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}