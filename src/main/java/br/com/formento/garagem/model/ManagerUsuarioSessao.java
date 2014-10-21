package br.com.formento.garagem.model;

import javax.servlet.http.HttpServletRequest;

public class ManagerUsuarioSessao {

	private final HttpServletRequest httpServletRequest;

	public ManagerUsuarioSessao(HttpServletRequest httpServletRequest) {
		this.httpServletRequest = httpServletRequest;
	}

	public UsuarioSessao getUsuarioSessao() {
		UsuarioSessao usuarioSessao;

		if (httpServletRequest.getSession().getAttribute(UsuarioSessao.class.getSimpleName()) instanceof UsuarioSessao)
			usuarioSessao = (UsuarioSessao) httpServletRequest.getSession().getAttribute(UsuarioSessao.class.getSimpleName());
		else {
			usuarioSessao = new UsuarioSessao();
			httpServletRequest.getSession().setAttribute(UsuarioSessao.class.getSimpleName(), usuarioSessao);
		}
		
		return usuarioSessao;
	}

}
