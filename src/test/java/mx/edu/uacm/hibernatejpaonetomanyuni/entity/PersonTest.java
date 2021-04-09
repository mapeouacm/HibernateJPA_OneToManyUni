package mx.edu.uacm.hibernatejpaonetomanyuni.entity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

@SpringBootTest
public class PersonTest {
	
	private static final Logger log = LogManager.getLogger(PersonTest.class);
	
	@PersistenceContext
	private EntityManager em;
	
	@Test
	@Transactional
	@Rollback(false)
	public void debeGuardarPerson(){
		log.debug(">Entrando a debeGuardarPerson <");
		
		Person person = new Person("Pepe");
		Phone phone1 = new Phone("954000000");
		Phone phone2 = new Phone("600000000");

		person.getPhones().add(phone1);
		person.getPhones().add(phone2);
		em.persist(person);
		em.flush();
		
	}

}
