package br.com.formento.garagem.enums;

public enum ResultadoLoginEnum {
	SUCESSO("redirect:index"), INATIVO("redirect:loginPage?mensagem=Login inativo. Verifique seu email"), INVALIDO(
			"redirect:loginPage?mensagem=Login ou senha incorreto");

	private final String pagina;

	private ResultadoLoginEnum(String pagina) {
		this.pagina = pagina;
	}

	public String getPagina() {
		return pagina;
	}

}
