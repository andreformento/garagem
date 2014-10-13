package br.com.formento.garagem.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the categoria_orcamento database table.
 * 
 */
@Entity
@Table(name="categoria_orcamento")
@NamedQuery(name="CategoriaOrcamento.findAll", query="SELECT c FROM CategoriaOrcamento c")
public class CategoriaOrcamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int codigo;

	private String descricao;

	//bi-directional many-to-one association to TipoCategoriaOrcamento
	@ManyToOne
	@JoinColumn(name="cod_tipo_cat_inve")
	private TipoCategoriaOrcamento tipoCategoriaOrcamento;

	//bi-directional many-to-one association to Orcamento
	@OneToMany(mappedBy="categoriaOrcamento")
	private List<Orcamento> orcamentos;

	public CategoriaOrcamento() {
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

	public TipoCategoriaOrcamento getTipoCategoriaOrcamento() {
		return this.tipoCategoriaOrcamento;
	}

	public void setTipoCategoriaOrcamento(TipoCategoriaOrcamento tipoCategoriaOrcamento) {
		this.tipoCategoriaOrcamento = tipoCategoriaOrcamento;
	}

	public List<Orcamento> getOrcamentos() {
		return this.orcamentos;
	}

	public void setOrcamentos(List<Orcamento> orcamentos) {
		this.orcamentos = orcamentos;
	}

	public Orcamento addOrcamento(Orcamento orcamento) {
		getOrcamentos().add(orcamento);
		orcamento.setCategoriaOrcamento(this);

		return orcamento;
	}

	public Orcamento removeOrcamento(Orcamento orcamento) {
		getOrcamentos().remove(orcamento);
		orcamento.setCategoriaOrcamento(null);

		return orcamento;
	}

}