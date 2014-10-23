package br.com.formento.garagem.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the tipo_categoria_orcamento database table.
 * 
 */
@Entity
@Table(name = "tipo_categoria_orcamento")
@NamedQuery(name = "TipoCategoriaOrcamento.findAll", query = "SELECT t FROM TipoCategoriaOrcamento t")
public class TipoCategoriaOrcamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int codigo;

	private String descricao;

	public TipoCategoriaOrcamento() {
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

	@Override
	public String toString() {
		return "TipoCategoriaOrcamento [codigo=" + codigo + ", descricao=" + descricao + "]";
	}

}