package br.com.formento.garagem.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import br.com.formento.garagem.model.UsuarioSessao;

/**
 * Essa classe deve ser refatorada
 * 
 * @author andre.formento
 *
 */
public class AutorizadorInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object controller) throws Exception {
		if (!(request.getSession().getAttribute(UsuarioSessao.class.getSimpleName()) instanceof UsuarioSessao))
			request.getSession().setAttribute(UsuarioSessao.class.getSimpleName(), new UsuarioSessao());

		String uri = request.getRequestURI();

		if (uri.endsWith("loginPage") || uri.contains("resources") || uri.endsWith("_Template") || uri.endsWith("Layout")) {
			return true;
		} else {
			UsuarioSessao usuarioSessao = (UsuarioSessao) request.getSession().getAttribute(UsuarioSessao.class.getSimpleName());

			response.sendRedirect("loginPage");
			return usuarioSessao.isUsuarioLogado();
		}
	}

}
