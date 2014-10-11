package br.com.formento.garagem.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the metodo_pesquisa_preco database table.
 * 
 */
@Entity
@Table(name="metodo_pesquisa_preco")
@NamedQuery(name="MetodoPesquisaPreco.findAll", query="SELECT m FROM MetodoPesquisaPreco m")
public class MetodoPesquisaPreco implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int codigo;

	private String descricao;

	//bi-directional many-to-one association to MetodoPesprecoTpCatOrcame
	@OneToMany(mappedBy="metodoPesquisaPreco")
	private List<MetodoPesprecoTpCatOrcame> metodoPesprecoTpCatOrcames;

	//bi-directional many-to-one association to ResultadoPesquisaPreco
	@OneToMany(mappedBy="metodoPesquisaPreco")
	private List<ResultadoPesquisaPreco> resultadoPesquisaPrecos;

	public MetodoPesquisaPreco() {
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

}