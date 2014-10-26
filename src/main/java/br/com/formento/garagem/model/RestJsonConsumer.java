package br.com.formento.garagem.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import br.com.formento.garagem.model.mercadoLivre.MercadoLivreResultado;

public class RestJsonConsumer {

	private static RestJsonConsumer instance;

	public static RestJsonConsumer getInstance() {
		if (instance == null)
			instance = new RestJsonConsumer();

		return instance;
	}

	private RestTemplate restTemplate;
	private String link = "https://api.mercadolibre.com/sites/MLB/search?q=";

	private RestJsonConsumer() {
		// Setup the RestTemplate configuration.
		restTemplate = new RestTemplate();
		// restTemplate.setRequestFactory(new CommonsClientHttpRequestFactory());
		List<HttpMessageConverter<?>> messageConverterList = restTemplate.getMessageConverters();

		// Set HTTP Message converter using a JSON implementation.
		MappingJackson2HttpMessageConverter jsonMessageConverter = new MappingJackson2HttpMessageConverter();

		// Add supported media type returned by BI API.
		List<MediaType> supportedMediaTypes = new ArrayList<MediaType>();
		supportedMediaTypes.add(new MediaType("text", "plain"));
		supportedMediaTypes.add(new MediaType("application", "json"));
		jsonMessageConverter.setSupportedMediaTypes(supportedMediaTypes);
		messageConverterList.add(jsonMessageConverter);
		restTemplate.setMessageConverters(messageConverterList);
	}

	public MercadoLivreResultado resultado(String parametro) {
		StringBuilder url = new StringBuilder();
		url.append(link);
		url.append(parametro);

		return restTemplate.getForObject(url.toString(), MercadoLivreResultado.class);
	}

}
