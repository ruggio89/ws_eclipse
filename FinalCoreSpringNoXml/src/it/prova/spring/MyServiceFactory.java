package it.prova.spring;

import it.prova.service.EsameService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyServiceFactory {

	private static ApplicationContext ctx;

	static {
		try {
			ctx  = new AnnotationConfigApplicationContext(AppConfig.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static EsameService getEsameService() {
		return  ctx.getBean(EsameService.class);
	}
}
