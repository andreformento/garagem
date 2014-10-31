package br.com.formento.garagem.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.Properties;

public class AplicacaoParametro implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static AplicacaoParametro instance;

	public static AplicacaoParametro getInstance() {
		if (instance == null)
			instance = new AplicacaoParametro();
		return instance;
	}

	private final String urlAplicacao;
	private final String urlDB;
	private final String user;
	private final String password;

	private AplicacaoParametro() {
		// http://docs.oracle.com/javase/tutorial/essential/environment/sysprop.html
		String diretorioHome = System.getProperty("user.home");
		System.out.println(diretorioHome);

		File arquivoPropriedade = new File(diretorioHome + "/garagem.properties");

		String urlAplicacaoInterno = "http://localhost:8080";
		String urlDBInterno = "jdbc:mysql://localhost:3306/garagem";
		String userInterno = "garagem";
		String passwordInterno = "garagem";

		if (arquivoPropriedade.isFile()) {
			FileInputStream fileInputStream;
			try {
				fileInputStream = new FileInputStream(arquivoPropriedade);

				Properties properties = new Properties();
				properties.load(fileInputStream);

				urlAplicacaoInterno = properties.getProperty("urlAplicacao").toString();
				urlDBInterno = properties.getProperty("urlDB").toString();
				userInterno = properties.getProperty("user").toString();
				passwordInterno = properties.getProperty("password").toString();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		urlDB = urlDBInterno;
		user = userInterno;
		password = passwordInterno;
		urlAplicacao = urlAplicacaoInterno;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getUrlAplicacao() {
		return urlAplicacao;
	}

	public String getUrlDB() {
		return urlDB;
	}

	public String getUser() {
		return user;
	}

	public String getPassword() {
		return password;
	}

}
