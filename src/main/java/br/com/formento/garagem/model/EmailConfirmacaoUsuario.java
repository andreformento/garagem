package br.com.formento.garagem.model;

import br.com.formento.garagem.service.MailService;

public class EmailConfirmacaoUsuario {

	private final Usuario usuario;
	private final MailService mailService;

	private StringBuilder linkConfirmacao;
	private StringBuilder corpoEmail;
	private String applicationUrl;

	public EmailConfirmacaoUsuario(Usuario usuario, MailService mailService, String applicationUrl) {
		this.usuario = usuario;
		this.mailService = mailService;
		this.applicationUrl = applicationUrl;
	}

	public StringBuilder getLinkConfirmacao() {
		if (linkConfirmacao == null) {
			linkConfirmacao = new StringBuilder();
			linkConfirmacao.append(applicationUrl);
			linkConfirmacao.append("confirmacaoRegistro");
			linkConfirmacao.append("?codigo=");
			linkConfirmacao.append(usuario.getCodigo());
			linkConfirmacao.append("&username=");
			linkConfirmacao.append(usuario.getUsername());
			linkConfirmacao.append("&password=");
			linkConfirmacao.append(usuario.getPassword());
		}
		return linkConfirmacao;
	}

	public StringBuilder getCorpoEmail() {
		if (corpoEmail == null) {
			corpoEmail = new StringBuilder();

			corpoEmail.append("<!DOCTYPE html>");
			corpoEmail.append("<html>");
			corpoEmail.append("<head>");
			corpoEmail.append("<meta http-equiv='Content-Type' content='text/html; charset=utf-8'>");
			corpoEmail.append("</head>");
			corpoEmail.append("<body>");
			corpoEmail.append("	<div>");
			corpoEmail.append("		<p>Seu cadastro foi realizado com sucesso. Para que o seu registro");
			corpoEmail.append("			seja habilitado, por favor, confirmar o recebimento do email pelo link abaixo.</p>");
			corpoEmail.append("	</div>");
			corpoEmail.append("	<div class='centro'>");
			corpoEmail.append("		<a href='");
			corpoEmail.append(getLinkConfirmacao());
			corpoEmail.append("'>Confirmar registro</a>");
			corpoEmail.append("	</div>");
			corpoEmail.append("	<div>");
			corpoEmail.append("		<p>Caso tenha algum problema, copie o link abaixo e cole no seu navegador:</p>");
			corpoEmail.append("	</div>");
			corpoEmail.append("	<div>");
			corpoEmail.append(getLinkConfirmacao());
			corpoEmail.append("</div>");
			corpoEmail.append("	<div>");
			corpoEmail.append("		<p>Equipe portal garagem.</p>");
			corpoEmail.append("	</div>");
			corpoEmail.append("</html>");
		}
		return corpoEmail;
	}

	public void enviar() {
		mailService.sendMail("garagemportal@gmail.com", usuario.getUsername(), "Confirmar cadastro - Portal", getCorpoEmail().toString());
	}

}
