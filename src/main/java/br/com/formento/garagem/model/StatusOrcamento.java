package br.com.formento.garagem.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the status_orcamento database table.
 * 
 */
@Entity
@Table(name = "status_orcamento")
@NamedQuery(name = "StatusOrcamento.findAll", query = "SELECT s FROM StatusOrcamento s")
public class StatusOrcamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int codigo;

	private String descricao;

	private String explicacao;

	public StatusOrcamento() {
	}

	public StatusOrcamento(int codigo, String descricao, String explicacao) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.explicacao = explicacao;
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

	public String getExplicacao() {
		return this.explicacao;
	}

	public void setExplicacao(String explicacao) {
		this.explicacao = explicacao;
	}

}