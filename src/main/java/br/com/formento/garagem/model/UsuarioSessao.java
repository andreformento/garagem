package br.com.formento.garagem.model;

import java.util.List;

import br.com.formento.garagem.compare.UsuarioComparatorUsernamePassword;
import br.com.formento.garagem.enums.PermissaoEnum;

public class UsuarioSessao {
	private final UsuarioComparatorUsernamePassword usuarioComparatorUsernamePassword;

	private Usuario usuario;
	private List<TipoCategoriaOrcamento> listTipoCategoriaOrcamento;
	private List<UsuarioPermissao> listUsuarioPermissao;
	private List<Carro> listCarro;
	private Boolean isPermitidoAdministrar;

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

	public void setListUsuarioPermissao(List<UsuarioPermissao> listUsuarioPermissao) {
		this.listUsuarioPermissao = listUsuarioPermissao;
	}

	public void setListCarro(List<Carro> listCarro) {
		this.listCarro = listCarro;
	}

	public void logout() {
		this.usuario = null;
		this.listTipoCategoriaOrcamento = null;
		this.listUsuarioPermissao = null;
		this.listCarro = null;
		this.isPermitidoAdministrar = null;
	}

	public boolean isUsuarioLogado() {
		return usuario != null;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public boolean getPermitidoAdministrar() {
		if (isPermitidoAdministrar == null) {
			isPermitidoAdministrar = false;
			if (isUsuarioLogado())
				for (UsuarioPermissao usuarioPermissao : listUsuarioPermissao)
					if (usuarioPermissao.getPermissao().getPermissaoEnum().equals(PermissaoEnum.ADMINISTRAR)) {
						isPermitidoAdministrar = true;
						break;
					}
		}

		return isPermitidoAdministrar;
	}

	public List<TipoCategoriaOrcamento> getListTipoCategoriaOrcamento() {
		return listTipoCategoriaOrcamento;
	}

	public Carro getCarroSelecionado() {
		if (isUsuarioLogado())
			return usuario.getCarro();
		else
			return null;
	}

	public List<UsuarioPermissao> getListUsuarioPermissao() {
		return listUsuarioPermissao;
	}

	public List<Carro> getListCarro() {
		return listCarro;
	}

}
