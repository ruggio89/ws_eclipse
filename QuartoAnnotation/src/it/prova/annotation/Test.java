package it.prova.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(
				AppConfig.class);
		AgenziaNoleggio cust = context.getBean(AgenziaNoleggio.class);
		
		cust.getCliente().setNome("Mario");
		cust.getCliente().ordina();
	}

}
