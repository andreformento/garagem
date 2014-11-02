package br.com.formento.garagem.modelo;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.formento.garagem.dao.interfaces.UsuarioDao;
import br.com.formento.garagem.ioc.BaseDI;
import br.com.formento.garagem.model.EmailConfirmacaoUsuario;
import br.com.formento.garagem.model.Usuario;
import br.com.formento.garagem.service.MailService;

public class EmailConfirmacaoUsuarioTest extends BaseDI {

	@Autowired
	private MailService mailService;

	@Autowired
	private UsuarioDao usuarioDao;

	@Test
	public void envioTest() {
		Usuario usuario = usuarioDao.buscaPorId(3);
		assertNotNull(usuario);

		EmailConfirmacaoUsuario emailConfirmacaoUsuario = new EmailConfirmacaoUsuario(usuario, mailService, "http://localhost:8080/garagem/");
		assertNotNull(emailConfirmacaoUsuario);

		StringBuilder linkConfirmacao = emailConfirmacaoUsuario.getLinkConfirmacao();
		assertNotNull(linkConfirmacao);
		System.out.println(linkConfirmacao);

		StringBuilder corpoEmail = emailConfirmacaoUsuario.getCorpoEmail();
		assertNotNull(corpoEmail);
		System.out.println(corpoEmail);

		emailConfirmacaoUsuario.enviar();
	}

}
