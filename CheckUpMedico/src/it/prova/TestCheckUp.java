package it.prova;

import it.prova.spring.MyServiceFactory;

public class TestCheckUp {

	public static void main(String[] args) {
		MyServiceFactory.getCheckUpService().checkUpCompleto();

	}

}
