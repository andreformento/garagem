package br.com.formento.garagem.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the usuario_nivel database table.
 * 
 */
@Entity
@Table(name="usuario_nivel")
@NamedQuery(name="UsuarioNivel.findAll", query="SELECT u FROM UsuarioNivel u")
public class UsuarioNivel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int codigo;

	private String descricao;

	private String identificador;

	public UsuarioNivel() {
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

}