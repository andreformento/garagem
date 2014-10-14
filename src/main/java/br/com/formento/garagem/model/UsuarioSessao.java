package br.com.formento.garagem.model;

import java.util.List;

import br.com.formento.garagem.compare.UsuarioComparatorUsernamePassword;
import br.com.formento.garagem.enums.PermissaoEnum;

public class UsuarioSessao {
	private final UsuarioComparatorUsernamePassword usuarioComparatorUsernamePassword;

	private Usuario usuario;
	private List<TipoCategoriaOrcamento> listTipoCategoriaOrcamento;

	public UsuarioSessao() {
		this.usuarioComparatorUsernamePassword = new UsuarioComparatorUsernamePassword();
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

	public void setListTipoCategoriaOrcamento(List<TipoCategoriaOrcamento> listTipoCategoriaOrcamento) {
		this.listTipoCategoriaOrcamento = listTipoCategoriaOrcamento;
	}

	public void logout() {
		this.usuario = null;
		this.listTipoCategoriaOrcamento = null;
	}

	public boolean isUsuarioLogado() {
		return usuario != null;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public boolean getPermitidoAdministrar() {
		if (!isUsuarioLogado())
			return false;

		for (UsuarioPermissao usuarioPermissao : usuario.getUsuarioPermissaos())
			if (usuarioPermissao.getPermissao().getPermissaoEnum().equals(PermissaoEnum.ADMINISTRAR))
				return true;
		return false;
	}

	public List<TipoCategoriaOrcamento> getListTipoCategoriaOrcamento() {
		return listTipoCategoriaOrcamento;
	}

}
