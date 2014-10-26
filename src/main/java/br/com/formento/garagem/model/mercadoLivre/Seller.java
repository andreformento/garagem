package br.com.formento.garagem.model.mercadoLivre;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Seller {
	private String id;

	private String power_seller_status;

	private String real_estate_agency;

	private String car_dealer;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPower_seller_status() {
		return power_seller_status;
	}

	public void setPower_seller_status(String power_seller_status) {
		this.power_seller_status = power_seller_status;
	}

	public String getReal_estate_agency() {
		return real_estate_agency;
	}

	public void setReal_estate_agency(String real_estate_agency) {
		this.real_estate_agency = real_estate_agency;
	}

	public String getCar_dealer() {
		return car_dealer;
	}

	public void setCar_dealer(String car_dealer) {
		this.car_dealer = car_dealer;
	}

	@Override
	public String toString() {
		return "Seller [id=" + id + ", power_seller_status=" + power_seller_status + ", real_estate_agency=" + real_estate_agency + ", car_dealer="
				+ car_dealer + "]";
	}

}
