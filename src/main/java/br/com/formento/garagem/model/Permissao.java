package br.com.formento.garagem.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.com.formento.garagem.enums.PermissaoEnum;

/**
 * The persistent class for the permissao database table.
 * 
 */
@Entity
@Table(name = "permissao")
@NamedQuery(name = "Permissao.findAll", query = "SELECT p FROM Permissao p")
public class Permissao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int codigo;

	private String descricao;

	private String identificador;
	@Transient
	private transient PermissaoEnum permissaoEnum;

	// bi-directional many-to-one association to UsuarioPermissao
	@OneToMany(mappedBy = "permissao")
	private List<UsuarioPermissao> usuarioPermissaos;

	public Permissao() {
	}

	public int getCodigo() {
		return this.codigo;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public String getIdentificador() {
		return this.identificador;
	}

	public List<UsuarioPermissao> getUsuarioPermissaos() {
		return this.usuarioPermissaos;
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

	@Transient
	public PermissaoEnum getPermissaoEnum() {
		if (permissaoEnum == null)
			permissaoEnum = PermissaoEnum.valueOf(getIdentificador());

		return permissaoEnum;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((identificador == null) ? 0 : identificador.hashCode());
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
		Permissao other = (Permissao) obj;
		if (identificador == null) {
			if (other.identificador != null)
				return false;
		} else if (!identificador.equals(other.identificador))
			return false;
		return true;
	}

}
