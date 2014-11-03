package br.com.formento.garagem.ioc;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.formento.garagem.configuration.MailConfig;
import br.com.formento.garagem.configuration.PersistenceJPAConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { MailConfig.class, PersistenceJPAConfig.class })
@Transactional(propagation = Propagation.REQUIRED)
public class BaseDI {

}
