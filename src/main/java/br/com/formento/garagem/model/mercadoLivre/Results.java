package br.com.formento.garagem.model.mercadoLivre;

import java.util.Arrays;

import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Results {
	private String currency_id;

	private String accepts_mercadopago;

	private String stop_time;

	private String condition;

	private String original_price;

	private String listing_type_id;

	private String category_id;

	private Seller_address seller_address;

	private String site_id;

	private Seller seller;

	private Installments installments;

	private Differential_pricing differential_pricing;

	private String id;

	private Shipping shipping;

	private String title;

	private String available_quantity;

	private String thumbnail;

	private String price;

	private String permalink;

	private Address address;

	private String subtitle;

	private String buying_mode;

	private String[] attributes;

	private String sold_quantity;

	private transient Double priceDouble;

	public String getCurrency_id() {
		return currency_id;
	}

	public void setCurrency_id(String currency_id) {
		this.currency_id = currency_id;
	}

	public String getAccepts_mercadopago() {
		return accepts_mercadopago;
	}

	public void setAccepts_mercadopago(String accepts_mercadopago) {
		this.accepts_mercadopago = accepts_mercadopago;
	}

	public String getStop_time() {
		return stop_time;
	}

	public void setStop_time(String stop_time) {
		this.stop_time = stop_time;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getOriginal_price() {
		return original_price;
	}

	public void setOriginal_price(String original_price) {
		this.original_price = original_price;
	}

	public String getListing_type_id() {
		return listing_type_id;
	}

	public void setListing_type_id(String listing_type_id) {
		this.listing_type_id = listing_type_id;
	}

	public String getCategory_id() {
		return category_id;
	}

	public void setCategory_id(String category_id) {
		this.category_id = category_id;
	}

	public Seller_address getSeller_address() {
		return seller_address;
	}

	public void setSeller_address(Seller_address seller_address) {
		this.seller_address = seller_address;
	}

	public String getSite_id() {
		return site_id;
	}

	public void setSite_id(String site_id) {
		this.site_id = site_id;
	}

	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	public Installments getInstallments() {
		return installments;
	}

	public void setInstallments(Installments installments) {
		this.installments = installments;
	}

	public Differential_pricing getDifferential_pricing() {
		return differential_pricing;
	}

	public void setDifferential_pricing(Differential_pricing differential_pricing) {
		this.differential_pricing = differential_pricing;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Shipping getShipping() {
		return shipping;
	}

	public void setShipping(Shipping shipping) {
		this.shipping = shipping;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAvailable_quantity() {
		return available_quantity;
	}

	public void setAvailable_quantity(String available_quantity) {
		this.available_quantity = available_quantity;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getPrice() {
		return price;
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

	public void setPrice(String price) {
		this.price = price;
	}

	public String getPermalink() {
		return permalink;
	}

	public void setPermalink(String permalink) {
		this.permalink = permalink;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public String getBuying_mode() {
		return buying_mode;
	}

	public void setBuying_mode(String buying_mode) {
		this.buying_mode = buying_mode;
	}

	public String[] getAttributes() {
		return attributes;
	}

	public void setAttributes(String[] attributes) {
		this.attributes = attributes;
	}

	public String getSold_quantity() {
		return sold_quantity;
	}

	public void setSold_quantity(String sold_quantity) {
		this.sold_quantity = sold_quantity;
	}

	@Override
	public String toString() {
		return "Results [currency_id=" + currency_id + ", accepts_mercadopago=" + accepts_mercadopago + ", stop_time=" + stop_time + ", condition="
				+ condition + ", original_price=" + original_price + ", listing_type_id=" + listing_type_id + ", category_id=" + category_id
				+ ", seller_address=" + seller_address + ", site_id=" + site_id + ", seller=" + seller + ", installments=" + installments
				+ ", differential_pricing=" + differential_pricing + ", id=" + id + ", shipping=" + shipping + ", title=" + title
				+ ", available_quantity=" + available_quantity + ", thumbnail=" + thumbnail + ", price=" + price + ", permalink=" + permalink
				+ ", address=" + address + ", subtitle=" + subtitle + ", buying_mode=" + buying_mode + ", attributes=" + Arrays.toString(attributes)
				+ ", sold_quantity=" + sold_quantity + "]";
	}

}
