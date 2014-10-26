package br.com.formento.garagem.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.security.crypto.codec.Base64;

/**
 * The persistent class for the carro_foto database table.
 */
@Entity
@Table(name = "carro_foto")
@NamedQuery(name = "CarroFoto.findAll", query = "SELECT c FROM CarroFoto c")
public class CarroFoto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "codigo")
	private int codigo;

	// @Column(name = "cod_carro")
	// private int codCarro;

	@Column(length = 3000000, columnDefinition = "mediumblob")
	private byte[] imagem;

	// bi-directional one-to-one association to Carro
	@OneToOne
	@JoinColumn(name = "cod_carro")
	private Carro carro;

	@Transient
	private transient String encoded;

	public CarroFoto() {
	}

	public CarroFoto(Carro carro) {
		this.carro = carro;
	}

	public int getCodigo() {
		return codigo;
	}

	public byte[] getImagem() {
		return this.imagem;
	}

	public void setImagem(byte[] imagem) {
		this.encoded = null;
		this.imagem = imagem;
	}

	public Carro getCarro() {
		return this.carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

	@Transient
	public String getEncode() {
		if (imagem != null && encoded == null) {
			byte[] encode64 = Base64.encode(imagem);
			this.encoded = new String(encode64);
		}
		return encoded;
	}

}
