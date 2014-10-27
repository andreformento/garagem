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

/**
 * The persistent class for the metodo_pesquisa_preco database table.
 */
@Entity
@Table(name = "metodo_pesquisa_preco")
@NamedQuery(name = "MetodoPesquisaPreco.findAll", query = "SELECT m FROM MetodoPesquisaPreco m")
public class MetodoPesquisaPreco implements Serializable, Comparable<MetodoPesquisaPreco> {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int codigo;

	private String descricao;

	// bi-directional many-to-one association to MetodoPesprecoTpCatOrcame
	@OneToMany(mappedBy = "metodoPesquisaPreco")
	private List<MetodoPesprecoTpCatOrcame> metodoPesprecoTpCatOrcames;

	// bi-directional many-to-one association to ResultadoPesquisaPreco
	@OneToMany(mappedBy = "metodoPesquisaPreco")
	private List<ResultadoPesquisaPreco> resultadoPesquisaPrecos;

	public MetodoPesquisaPreco() {
	}

	public MetodoPesquisaPreco(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
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

	public List<MetodoPesprecoTpCatOrcame> getMetodoPesprecoTpCatOrcames() {
		return this.metodoPesprecoTpCatOrcames;
	}

	public void setMetodoPesprecoTpCatOrcames(List<MetodoPesprecoTpCatOrcame> metodoPesprecoTpCatOrcames) {
		this.metodoPesprecoTpCatOrcames = metodoPesprecoTpCatOrcames;
	}

	public MetodoPesprecoTpCatOrcame addMetodoPesprecoTpCatOrcame(MetodoPesprecoTpCatOrcame metodoPesprecoTpCatOrcame) {
		getMetodoPesprecoTpCatOrcames().add(metodoPesprecoTpCatOrcame);
		metodoPesprecoTpCatOrcame.setMetodoPesquisaPreco(this);

		return metodoPesprecoTpCatOrcame;
	}

	public MetodoPesprecoTpCatOrcame removeMetodoPesprecoTpCatOrcame(MetodoPesprecoTpCatOrcame metodoPesprecoTpCatOrcame) {
		getMetodoPesprecoTpCatOrcames().remove(metodoPesprecoTpCatOrcame);
		metodoPesprecoTpCatOrcame.setMetodoPesquisaPreco(null);

		return metodoPesprecoTpCatOrcame;
	}

	public List<ResultadoPesquisaPreco> getResultadoPesquisaPrecos() {
		return this.resultadoPesquisaPrecos;
	}

	public void setResultadoPesquisaPrecos(List<ResultadoPesquisaPreco> resultadoPesquisaPrecos) {
		this.resultadoPesquisaPrecos = resultadoPesquisaPrecos;
	}

	public ResultadoPesquisaPreco addResultadoPesquisaPreco(ResultadoPesquisaPreco resultadoPesquisaPreco) {
		getResultadoPesquisaPrecos().add(resultadoPesquisaPreco);
		resultadoPesquisaPreco.setMetodoPesquisaPreco(this);

		return resultadoPesquisaPreco;
	}

	public ResultadoPesquisaPreco removeResultadoPesquisaPreco(ResultadoPesquisaPreco resultadoPesquisaPreco) {
		getResultadoPesquisaPrecos().remove(resultadoPesquisaPreco);
		resultadoPesquisaPreco.setMetodoPesquisaPreco(null);

		return resultadoPesquisaPreco;
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
		MetodoPesquisaPreco other = (MetodoPesquisaPreco) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}

	@Override
	public int compareTo(MetodoPesquisaPreco o) {
		return descricao.compareTo(o.descricao);
	}

}
