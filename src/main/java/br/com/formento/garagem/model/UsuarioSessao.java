package br.com.formento.garagem.model;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import br.com.formento.garagem.compare.UsuarioComparatorUsernamePassword;

public class UsuarioSessao {
	private final UsuarioComparatorUsernamePassword usuarioComparatorUsernamePassword;
	private final PasswordEncoder encoder;
	private Usuario usuario;

	public UsuarioSessao() {
		this.usuarioComparatorUsernamePassword = new UsuarioComparatorUsernamePassword();
		this.encoder = new BCryptPasswordEncoder();
	}

	public boolean login(Usuario usuarioByView, Usuario usuarioByLogin) {
		logout();

		String newPassword = MD5Converter.getMD5(usuarioByView.getPassword());
		usuarioByView.setPassword(newPassword);

		boolean isLoginValido = usuarioComparatorUsernamePassword.compare(usuarioByView, usuarioByLogin) == 0;
		if (isLoginValido)
			this.usuario = usuarioByLogin;

		return isLoginValido;

	}

	public void logout() {
		this.usuario = null;
	}

	public boolean isUsuarioLogado() {
		return usuario != null;
	}

}
