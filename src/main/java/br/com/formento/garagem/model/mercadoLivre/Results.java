package br.com.formento.garagem.model.mercadoLivre;

import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Results {

	private String thumbnail;

	private String price;

	private String permalink;

	private transient Double priceDouble;

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getPermalink() {
		return permalink;
	}

	public void setPermalink(String permalink) {
		this.permalink = permalink;
	}

	@Transient
	public Double getPriceDouble() {
		if (priceDouble == null) {
			if (price == null || price.trim().isEmpty())
				priceDouble = 0d;
			else
				priceDouble = Double.valueOf(price);
		}
		return priceDouble;
	}

	@Override
	public String toString() {
		return "Results [thumbnail=" + thumbnail + ", price=" + price + ", permalink=" + permalink + "]";
	}

}
