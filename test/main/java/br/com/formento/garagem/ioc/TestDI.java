package br.com.formento.garagem.ioc;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDI extends BaseDI {

	@Autowired
	private Zoo zoo2;

	@Test
	public void metodoManualTest() {
		ApplicationContext appContext = new ClassPathXmlApplicationContext(
				"META-INF/spring-context.xml");
		assertNotNull(appContext);
		BeanFactory factory = appContext;
		Zoo zoo = (Zoo) factory.getBean("zoo");
		assertNotNull(zoo);
		zoo.testSound();
	}

	@Test
	public void metodoAutomatico() {
		assertNotNull(zoo2);
	}

}
