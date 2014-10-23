package br.com.formento.garagem.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * The persistent class for the carro_foto database table.
 * 
 */
@Entity
@Table(name = "carro_foto")
@NamedQuery(name = "CarroFoto.findAll", query = "SELECT c FROM CarroFoto c")
public class CarroFoto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "codigo_carro")
	private int codigoCarro;

	@Lob
	private byte[] imagem;

	// bi-directional one-to-one association to Carro
	@OneToOne
	@JoinColumn(name = "codigo_carro")
	private Carro carro;

	public CarroFoto() {
	}

	public CarroFoto(byte[] imagem, Carro carro) {
		this.imagem = imagem;
		this.carro = carro;
	}

	public int getCodigoCarro() {
		return this.codigoCarro;
	}

	public void setCodigoCarro(int codigoCarro) {
		this.codigoCarro = codigoCarro;
	}

	public byte[] getImagem() {
		return this.imagem;
	}

	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	}

	public Carro getCarro() {
		return this.carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

}