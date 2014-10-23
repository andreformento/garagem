package br.com.formento.garagem.enums;

import br.com.formento.garagem.model.StatusOrcamento;

public enum StatusOrcamentoEnum {
	RECEBER_EMAIL(new StatusOrcamento(1, "Receber atualização", "Receber atualização periodicamente")), DESATIVADO(new StatusOrcamento(2,
			"Desativado", "Desativado"));

	private final StatusOrcamento statusOrcamento;

	private StatusOrcamentoEnum(StatusOrcamento statusOrcamento) {
		this.statusOrcamento = statusOrcamento;
	}

	public StatusOrcamento getStatusOrcamento() {
		return statusOrcamento;
	}

	public static StatusOrcamentoEnum getByCodigo(int codigo) {
		for (StatusOrcamentoEnum statusOrcamentoEnum : values())
			if (statusOrcamentoEnum.getStatusOrcamento().getCodigo() == codigo)
				return statusOrcamentoEnum;

		return null;
	}

}
