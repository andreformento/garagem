package br.com.formento.garagem.model.mercadoLivre;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Shipping {
	private String free_shipping;

	private String mode;

	public String getFree_shipping() {
		return free_shipping;
	}

	public void setFree_shipping(String free_shipping) {
		this.free_shipping = free_shipping;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	@Override
	public String toString() {
		return "Shipping [free_shipping=" + free_shipping + ", mode=" + mode + "]";
	}

}
