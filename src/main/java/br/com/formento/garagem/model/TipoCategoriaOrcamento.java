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
 * The persistent class for the tipo_categoria_orcamento database table.
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

	// bi-directional many-to-one association to CategoriaOrcamento
	@OneToMany(mappedBy = "tipoCategoriaOrcamento")
	private List<CategoriaOrcamento> categoriaOrcamentos;

	// bi-directional many-to-one association to MetodoPesprecoTpCatOrcame
	@OneToMany(mappedBy = "tipoCategoriaOrcamento")
	private List<MetodoPesprecoTpCatOrcame> metodoPesprecoTpCatOrcames;

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

	public List<CategoriaOrcamento> getCategoriaOrcamentos() {
		return this.categoriaOrcamentos;
	}

	public void setCategoriaOrcamentos(List<CategoriaOrcamento> categoriaOrcamentos) {
		this.categoriaOrcamentos = categoriaOrcamentos;
	}

	public CategoriaOrcamento addCategoriaOrcamento(CategoriaOrcamento categoriaOrcamento) {
		getCategoriaOrcamentos().add(categoriaOrcamento);
		categoriaOrcamento.setTipoCategoriaOrcamento(this);

		return categoriaOrcamento;
	}

	public CategoriaOrcamento removeCategoriaOrcamento(CategoriaOrcamento categoriaOrcamento) {
		getCategoriaOrcamentos().remove(categoriaOrcamento);
		categoriaOrcamento.setTipoCategoriaOrcamento(null);

		return categoriaOrcamento;
	}

	public List<MetodoPesprecoTpCatOrcame> getMetodoPesprecoTpCatOrcames() {
		return this.metodoPesprecoTpCatOrcames;
	}

	public void setMetodoPesprecoTpCatOrcames(List<MetodoPesprecoTpCatOrcame> metodoPesprecoTpCatOrcames) {
		this.metodoPesprecoTpCatOrcames = metodoPesprecoTpCatOrcames;
	}

	public MetodoPesprecoTpCatOrcame addMetodoPesprecoTpCatOrcame(MetodoPesprecoTpCatOrcame metodoPesprecoTpCatOrcame) {
		getMetodoPesprecoTpCatOrcames().add(metodoPesprecoTpCatOrcame);
		metodoPesprecoTpCatOrcame.setTipoCategoriaOrcamento(this);

		return metodoPesprecoTpCatOrcame;
	}

	public MetodoPesprecoTpCatOrcame removeMetodoPesprecoTpCatOrcame(MetodoPesprecoTpCatOrcame metodoPesprecoTpCatOrcame) {
		getMetodoPesprecoTpCatOrcames().remove(metodoPesprecoTpCatOrcame);
		metodoPesprecoTpCatOrcame.setTipoCategoriaOrcamento(null);

		return metodoPesprecoTpCatOrcame;
	}

}