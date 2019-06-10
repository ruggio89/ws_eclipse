package it.prova.spring;

import it.prova.service.ImpresaRistrutturazioneService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyServiceFactory {

	private static ApplicationContext ctx;

	static {
		try {
			ctx = new ClassPathXmlApplicationContext("beans.xml");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static ImpresaRistrutturazioneService getImpresaRistrutturazioneService() {
		return (ImpresaRistrutturazioneService) ctx.getBean("ImpresaRistrutturazioneService");
	}
}
