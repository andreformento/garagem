package br.com.formento.garagem.ioc;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.formento.garagem.dao.interfaces.TipoCategoriaOrcamentoDao;

public class TestDI extends BaseDI {

	@Autowired
	private TipoCategoriaOrcamentoDao tipoCategoriaOrcamentoDao;

	//
	// @Test
	// public void metodoManualTest() {
	// ApplicationContext appContext = new ClassPathXmlApplicationContext(
	// "META-INF/spring-context.xml");
	// assertNotNull(appContext);
	// BeanFactory factory = appContext;
	// Zoo zoo = (Zoo) factory.getBean("zoo");
	// assertNotNull(zoo);
	// zoo.testSound();
	// }

	// refatorar configurações de teste
	@Test
	public void instanciaTest() {
		assertNotNull(tipoCategoriaOrcamentoDao);
	}

}
