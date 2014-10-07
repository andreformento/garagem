package br.com.formento.garagem.modelo;

import java.io.Serializable;
import java.util.Calendar;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Tarefa implements Serializable, Comparable<Tarefa> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6724316099207758611L;

	private Long id;

	@NotNull
	@Size(min = 5)
	private String descricao;
	private Calendar dataFinalizacao;

	public Tarefa() {
	}

	public Tarefa(String descricao) {
		this.descricao = descricao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isFinalizado() {
		return dataFinalizacao != null;
	}

	public Calendar getDataFinalizacao() {
		return dataFinalizacao;
	}

	public void setDataFinalizacao(Calendar dataFinalizacao) {
		this.dataFinalizacao = dataFinalizacao;
	}

	@Override
	public int compareTo(Tarefa o) {
		if (descricao == null || o.descricao == null)
			return id.compareTo(o.id);
		else
			return descricao.compareTo(o.descricao);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Tarefa other = (Tarefa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public void finalizar() {
		dataFinalizacao = Calendar.getInstance();
	}

}
