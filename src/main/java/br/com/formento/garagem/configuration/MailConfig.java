package br.com.formento.garagem.configuration;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import br.com.formento.garagem.model.AplicacaoParametro;

@Configuration
public class MailConfig {

	@Bean
	public JavaMailSender javaMailService() {
		JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();

		javaMailSender.setHost(AplicacaoParametro.getInstance().getEmailHost());
		javaMailSender.setPort(AplicacaoParametro.getInstance().getEmailPort());

		javaMailSender.setUsername(AplicacaoParametro.getInstance().getEmailUsername());
		javaMailSender.setPassword(AplicacaoParametro.getInstance().getEmailPassword());

		javaMailSender.setJavaMailProperties(getMailProperties());

		return javaMailSender;
	}

	private Properties getMailProperties() {
		Properties properties = new Properties();
		properties.setProperty("mail.transport.protocol", AplicacaoParametro.getInstance().getEmailProtocol());
		properties.setProperty("mail.smtp.auth", AplicacaoParametro.getInstance().getEmailAuth());
		properties.setProperty("mail.smtp.starttls.enable", AplicacaoParametro.getInstance().getEmailStarttls());
		properties.setProperty("mail.debug", AplicacaoParametro.getInstance().getEmailDebug());
		return properties;
	}
}