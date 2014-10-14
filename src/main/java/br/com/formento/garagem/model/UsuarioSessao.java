package br.com.formento.garagem.model;

public class UsuarioSessao {
	private Usuario usuario;

	public UsuarioSessao() {
	}

	public void login(Usuario usuario) {
		this.usuario = usuario;
	}

	public void logout() {
		this.usuario = null;
	}

	public boolean isUsuarioLogado() {
		return usuario != null;
	}

}
