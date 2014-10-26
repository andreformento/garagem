package br.com.formento.garagem.model.mercadoLivre;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Differential_pricing {
	private String id;

	private String[] payment_methods;

	private String[] installments;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String[] getPayment_methods() {
		return payment_methods;
	}

	public void setPayment_methods(String[] payment_methods) {
		this.payment_methods = payment_methods;
	}

	public String[] getInstallments() {
		return installments;
	}

	public void setInstallments(String[] installments) {
		this.installments = installments;
	}

	@Override
	public String toString() {
		return "Differential_pricing [id=" + id + ", payment_methods=" + Arrays.toString(payment_methods) + ", installments="
				+ Arrays.toString(installments) + "]";
	}

}
