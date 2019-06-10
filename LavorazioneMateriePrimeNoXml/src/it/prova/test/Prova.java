package it.prova.test;

import it.prova.dao.DbMock;
import it.prova.model.MateriaPrima;
import it.prova.service.MateriaPrimaService;
import it.prova.spring.MyServiceFactory;

public class Prova {

	public static void main(String[] args) {
		MateriaPrimaService materiaPrimaService = MyServiceFactory.getMateriaPrimaService();

		for (MateriaPrima input : DbMock.MATERIEPRIME) {

			materiaPrimaService.avviaLavorazione(input);
		}

	}

}
