package it.municipioabitantejpa.test;

import it.municipioabitantejpa.service.BatteriaDiTestService;
import it.municipioabitantejpa.service.MyServiceFactory;

import org.springframework.stereotype.Component;

@Component
public class MyTest {

	public static void main(String[] args) {

		// DA VALORIZZARE SECONDO I CASI ESPOSTI NELLE COSTANTI SOPRA
		// ##########################################################
		String casoDaTestare = BatteriaDiTestService.FIND_ALL_ABITANTE_UBICAZIONE_CONTIENE;
		// ##########################################################

		System.out.println("################ START   #################");
		System.out.println("################ eseguo il test " + casoDaTestare
				+ "  #################");

		MyServiceFactory.getBatteriaDiTestServiceInstance()
				.eseguiBatteriaDiTest(casoDaTestare);

		System.out.println("################ FINE   #################");

	}
}
