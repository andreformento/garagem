package br.com.formento.garagem.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import br.com.formento.garagem.model.ManagerUsuarioSessao;

/**
 * Essa classe deve ser refatorada
 * 
 * @author andre.formento
 */
public class AutorizadorInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse response, Object controller) throws Exception {
		ManagerUsuarioSessao managerUsuarioSessao = new ManagerUsuarioSessao(httpServletRequest);

		String uri = httpServletRequest.getRequestURI();

		if (uri.endsWith("loginPage") || uri.endsWith("loginExec") || uri.contains("resources") || uri.endsWith("_Template")
				|| uri.endsWith("Layout")) {
			return true;
		} else {
			if (!managerUsuarioSessao.getUsuarioSessao().isUsuarioLogado())
				response.sendRedirect("loginPage");
			return managerUsuarioSessao.getUsuarioSessao().isUsuarioLogado();
		}
	}

}
