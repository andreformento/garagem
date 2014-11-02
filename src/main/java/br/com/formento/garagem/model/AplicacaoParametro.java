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

	private final String dataBaseUrl;
	private final String dataBaseUsername;
	private final String dataBasePassword;

	private final String emailHost;
	private final int emailPort;
	private final String emailUsername;
	private final String emailPassword;
	private final String emailProtocol;
	private final String emailAuth;
	private final String emailStarttls;
	private final String emailDebug;

	// http://docs.oracle.com/javase/tutorial/essential/environment/sysprop.html
	private AplicacaoParametro() {
		String dataBaseUrlInterno = "jdbc:mysql://localhost:3306/garagem";
		String dataBaseUsernameInterno = "garagem";
		String dataBasePasswordInterno = "garagem";

		String emailHostInterno = "smtp.gmail.com";
		String emailPortInterno = "587";
		String emailUsernameInterno = "garagemportal@gmail.com";
		String emailPasswordInterno = "";
		String emailProtocolInterno = "smtp";
		String emailAuthInterno = "true";
		String emailStarttlsInterno = "true";
		String emailDebugInterno = "false";

		String diretorioHome = System.getProperty("user.home");

		File arquivoPropriedade = new File(diretorioHome + "/garagem.properties");
		if (arquivoPropriedade.isFile()) {
			FileInputStream fileInputStream;
			try {
				fileInputStream = new FileInputStream(arquivoPropriedade);

				Properties properties = new Properties();
				properties.load(fileInputStream);

				dataBaseUrlInterno = properties.getProperty("dataBase.url", dataBaseUrlInterno);
				dataBaseUsernameInterno = properties.getProperty("dataBase.username", dataBaseUsernameInterno);
				dataBasePasswordInterno = properties.getProperty("dataBase.password", dataBasePasswordInterno);

				emailHostInterno = properties.getProperty("email.host", emailHostInterno);
				emailPortInterno = properties.getProperty("email.port", emailPortInterno);
				emailUsernameInterno = properties.getProperty("email.username", emailUsernameInterno);
				emailPasswordInterno = properties.getProperty("email.password", emailPasswordInterno);
				emailProtocolInterno = properties.getProperty("email.transport.protocol", emailProtocolInterno);
				emailAuthInterno = properties.getProperty("email.smtp.auth", emailAuthInterno);
				emailStarttlsInterno = properties.getProperty("email.smtp.starttls.enable", emailStarttlsInterno);
				emailDebugInterno = properties.getProperty("email.debug", emailDebugInterno);

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		dataBaseUrl = dataBaseUrlInterno;
		dataBaseUsername = dataBaseUsernameInterno;
		dataBasePassword = dataBasePasswordInterno;

		emailHost = emailHostInterno;
		emailPort = Integer.valueOf(emailPortInterno);
		emailUsername = emailUsernameInterno;
		emailPassword = emailPasswordInterno;
		emailProtocol = emailProtocolInterno;
		emailAuth = emailAuthInterno;
		emailStarttls = emailStarttlsInterno;
		emailDebug = emailDebugInterno;
	}

	public String getDataBaseUrl() {
		return dataBaseUrl;
	}

	public String getDataBaseUsername() {
		return dataBaseUsername;
	}

	public String getDataBasePassword() {
		return dataBasePassword;
	}

	public String getEmailHost() {
		return emailHost;
	}

	public int getEmailPort() {
		return emailPort;
	}

	public String getEmailUsername() {
		return emailUsername;
	}

	public String getEmailPassword() {
		return emailPassword;
	}

	public String getEmailProtocol() {
		return emailProtocol;
	}

	public String getEmailAuth() {
		return emailAuth;
	}

	public String getEmailStarttls() {
		return emailStarttls;
	}

	public String getEmailDebug() {
		return emailDebug;
	}

}
