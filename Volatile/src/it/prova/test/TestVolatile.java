package it.prova.test;

import it.prova.Aquila;
import it.prova.Gallina;
import it.prova.Pinguino;
import it.prova.Volatile;

public class TestVolatile {

	public static void main(String[] args) {
		Volatile v1 = new Aquila("reale");
		Volatile v2 = new Aquila("bianca");
		v1.vola();
		if(v1.sonoUguale(v2)) {
			System.out.println("razze uguali");
		} else {
			System.out.println("razze non uguali");
		}
		System.out.println(v1.stampaProprieta());
		
		v1 = new Gallina("corto");
		v2 = new Gallina("corto");
		v1.vola();
		if(v1.sonoUguale(v2)) {
			System.out.println("piumaggio uguale");
		} else {
			System.out.println("Piumaggio diverso");
		}
		System.out.println(v1.stampaProprieta());
		
		v1 = new Pinguino("Polo Nord");
		v2 = new Pinguino("Polo Sud");
		v1.vola();
		if(v1.sonoUguale(v2)) {
			System.out.println("continente uguale");
		} else {
			System.out.println("continente diverso");
		}
		System.out.println(v1.stampaProprieta());
		
		

	}

}
