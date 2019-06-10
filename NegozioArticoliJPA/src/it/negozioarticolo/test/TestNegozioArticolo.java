package it.negozioarticolo.test;

import it.negozioarticolo.service.ArticoloService;
import it.negozioarticolo.service.MyServiceFactory;
import it.negozioarticolo.service.NegozioService;

public class TestNegozioArticolo {

	public static void main(String[] args) {
		
		try {
			NegozioService negozioService = MyServiceFactory.getNegozioServiceInstance();
			ArticoloService articoloService = MyServiceFactory.getArticoloServiceInstance();
			
			System.out.println(negozioService.listAllNegozi());

			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
