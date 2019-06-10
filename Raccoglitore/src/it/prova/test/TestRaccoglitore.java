package it.prova.test;

import it.prova.Foglio;
import it.prova.Raccoglitore;

public class TestRaccoglitore {

	public static void main(String[] args) {
		Raccoglitore r = new Raccoglitore();
		Foglio f1 = new Foglio("A4","liscio");
		Foglio f2 = new Foglio("A5", "ruvido");
		Foglio f3 = new Foglio("A4", "liscio");
		
		
		r.addToFogli(f1);
		r.addToFogli(f2);
		r.addToFogli(f3);
		
		
		r.removeFrom(2);
		r.stampaArray();
		
		
		
	}

}
