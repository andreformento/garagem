package br.com.formento.garagem.util;

import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;

public class ServletUtils {
	private final HttpServletRequest httpServletRequest;

	public ServletUtils(HttpServletRequest httpServletRequest) {
		this.httpServletRequest = httpServletRequest;
	}

	// http://nxhoaf.wordpress.com/2012/12/20/get-url-base-hostname-of-the-servlet/
	// http://www.java2s.com/Code/Java/Servlets/GetBaseUrlforservlet.htm
	public String getUrlBase() throws MalformedURLException {
		URL requestUrl = new URL(httpServletRequest.getRequestURL().toString());
		String portString = requestUrl.getPort() <= -1 ? "" : ":" + requestUrl.getPort();

		StringBuilder result = new StringBuilder();
		result.append(requestUrl.getProtocol());
		result.append("://");
		result.append(requestUrl.getHost());
		result.append(portString);
		result.append("/");

		String[] split = requestUrl.getPath().split("/");
		if (split.length > 1) {
			result.append(split[1]);
			result.append("/");
		}

		return result.toString();
	}

}
