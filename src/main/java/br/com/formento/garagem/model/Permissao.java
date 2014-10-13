package br.com.formento.garagem.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the permissao database table.
 * 
 */
@Entity
@Table(name="permissao")
@NamedQuery(name="Permissao.findAll", query="SELECT p FROM Permissao p")
public class Permissao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int codigo;

	private String descricao;

	private String identificador;

	//bi-directional many-to-one association to UsuarioPermissao
	@OneToMany(mappedBy="permissao")
	private List<UsuarioPermissao> usuarioPermissaos;

	public Permissao() {
	}

	public int getCodigo() {
		return this.codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getIdentificador() {
		return this.identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public List<UsuarioPermissao> getUsuarioPermissaos() {
		return this.usuarioPermissaos;
	}

	public void setUsuarioPermissaos(List<UsuarioPermissao> usuarioPermissaos) {
		this.usuarioPermissaos = usuarioPermissaos;
	}

	public UsuarioPermissao addUsuarioPermissao(UsuarioPermissao usuarioPermissao) {
		getUsuarioPermissaos().add(usuarioPermissao);
		usuarioPermissao.setPermissao(this);

		return usuarioPermissao;
	}

	public UsuarioPermissao removeUsuarioPermissao(UsuarioPermissao usuarioPermissao) {
		getUsuarioPermissaos().remove(usuarioPermissao);
		usuarioPermissao.setPermissao(null);

		return usuarioPermissao;
	}

}