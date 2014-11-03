package br.com.formento.garagem.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
public class MvcConfig extends WebMvcConfigurerAdapter {

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		// http://stackoverflow.com/questions/5062586/equivalent-of-mvcdefault-servlet-handler-in-spring-annotation-based-configurati

		// Para acessar arquivos externos, como os da pasta resource
		// equivalente a <mvc:default-servlet-handler />
		configurer.enable();
	}

}
