package br.com.formento.garagem.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the metodo_pespreco_tp_cat_orcame database table.
 * 
 */
@Entity
@Table(name="metodo_pespreco_tp_cat_orcame")
@NamedQuery(name="MetodoPesprecoTpCatOrcame.findAll", query="SELECT m FROM MetodoPesprecoTpCatOrcame m")
public class MetodoPesprecoTpCatOrcame implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int codigo;

	//bi-directional many-to-one association to MetodoPesquisaPreco
	@ManyToOne
	@JoinColumn(name="cod_metodo_pesquisa_preco")
	private MetodoPesquisaPreco metodoPesquisaPreco;

	//bi-directional many-to-one association to TipoCategoriaOrcamento
	@ManyToOne
	@JoinColumn(name="cod_tipo_categoria_orcamento")
	private TipoCategoriaOrcamento tipoCategoriaOrcamento;

	public MetodoPesprecoTpCatOrcame() {
	}

	public int getCodigo() {
		return this.codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public MetodoPesquisaPreco getMetodoPesquisaPreco() {
		return this.metodoPesquisaPreco;
	}

	public void setMetodoPesquisaPreco(MetodoPesquisaPreco metodoPesquisaPreco) {
		this.metodoPesquisaPreco = metodoPesquisaPreco;
	}

	public TipoCategoriaOrcamento getTipoCategoriaOrcamento() {
		return this.tipoCategoriaOrcamento;
	}

	public void setTipoCategoriaOrcamento(TipoCategoriaOrcamento tipoCategoriaOrcamento) {
		this.tipoCategoriaOrcamento = tipoCategoriaOrcamento;
	}

}