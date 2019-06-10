package it.prova.test;

import it.prova.model.MateriaPrima;
import it.prova.service.MateriaPrimaService;
import it.prova.spring.MyServiceFactory;

public class TestMateriaPrima {
	public static void main(String[] args) {
		MateriaPrimaService materiaPrimaService = MyServiceFactory.getMateriaPrimaService();
		
		MateriaPrima materiaPrima = materiaPrimaService.caricaMateriaPrima(1);
		
		materiaPrimaService.avviaProcessoDiLavorazioneMateriaPrima(materiaPrima);
	}
}
