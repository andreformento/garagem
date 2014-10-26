// http://www.javacodegeeks.com/2010/07/java-mail-spring-gmail-smtp.html
package br.com.formento.garagem.service;

import java.io.UnsupportedEncodingException;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private SimpleMailMessage alertMailMessage;

	public void sendMail(String from, String to, String subject, String body) {
		MimeMessage mimeMessage = mailSender.createMimeMessage();

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

		mailSender.send(mimeMessage);
	}

	public void sendAlertMail(String alert) {
		SimpleMailMessage mailMessage = new SimpleMailMessage(alertMailMessage);
		mailMessage.setText(alert);
		mailSender.send(mailMessage);
	}

}