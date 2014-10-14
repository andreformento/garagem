package br.com.formento.garagem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

//@Configuration
//@PropertySource("classpath:META-INF/springConfig.properties")
//@ComponentScan(basePackages = "br.com.formento.garagem.*", excludeFilters = @Filter(Configuration.class))
//@EnableWebMvc
public class SpringConfig extends WebMvcConfigurerAdapter {

//	@Bean(name = "resourceBundleMessageSource")
//	public static final ReloadableResourceBundleMessageSource resourceBundleMessageSource() {
//		ReloadableResourceBundleMessageSource resourceBundleMessageSource = new ReloadableResourceBundleMessageSource();
//		resourceBundleMessageSource.setBasename("classpath:messages");
//		resourceBundleMessageSource.setDefaultEncoding("UTF-8");
//		return resourceBundleMessageSource;
//	}
//
//	@Bean
//	public InternalResourceViewResolver viewResolver() {
//		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//		resolver.setPrefix("/WEB-INF/views/");
//		resolver.setSuffix(".jsp");
//		return resolver;
//	}
//
//	@Override
//	public void addResourceHandlers(ResourceHandlerRegistry registry) {
//		registry.addResourceHandler("/images/**").addResourceLocations("/resources/images/");
//	}

}
