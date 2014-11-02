// http://www.javacodegeeks.com/2010/07/java-mail-spring-gmail-smtp.html
package br.com.formento.garagem.service;

import java.io.UnsupportedEncodingException;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {

	@Autowired
	private JavaMailSender javaMailSender;

	public void sendMail(String from, String to, String subject, String body) {
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();

		try {
			mimeMessage.setSubject(subject);

			mimeMessage.setFrom(new InternetAddress(from, "Garagem"));

			mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(to, to));

			mimeMessage.setContent(body, "text/html; charset=utf-8");
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		javaMailSender.send(mimeMessage);
	}

}