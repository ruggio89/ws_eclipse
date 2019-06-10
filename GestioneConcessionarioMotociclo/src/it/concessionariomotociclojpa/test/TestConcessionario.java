package it.concessionariomotociclojpa.test;

import it.concessionariomotociclojpa.service.BatteriaDiTestService;
import it.concessionariomotociclojpa.service.MyServiceFactory;

public class TestConcessionario {

	public static void main(String[] args) {

		// ##########################################################
		String casoDaTestare = BatteriaDiTestService.ELENCA_CONCESSIONARI_CON_MOTOCICLI_CON_CILINDRATA_1200;
		// ##########################################################

		System.out.println("################ START   #################");
		System.out.println("################ eseguo il test " + casoDaTestare + "  #################");

		MyServiceFactory.getBatteriaDiTestServiceInstance().eseguiBatteriaDiTest(casoDaTestare);

		System.out.println("################ FINE   #################");

	}

}
