package it.prova.test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import it.prova.Persona;

public class TestProvaMappe {

	public static void main(String[] args) {

		Map<Integer, String> cittadini = new HashMap<Integer, String>();
		cittadini.put(1, "Ruggero");
		cittadini.put(3, "Claudio");
		cittadini.put(2, "Sonia");
		cittadini.put(4, "Rebecca");
		cittadini.replace(6, "Asia");
		
		System.out.println(cittadini);
		
		Map<String, String> cittadini2 = new HashMap<String, String>();
		cittadini2.put("Ciccio", "Via cicciobello");
		cittadini2.put("Daniele", "Via ponteciccio");
		cittadini2.put("Coso", "Via matti");
		
		System.out.println(cittadini2);
		System.out.println(cittadini2.get("Daniele"));
		
		Persona p1 = new Persona("Caio", "Settimo");
		Persona p2 = new Persona("Sempronio", "Ottavo");
		Set<Persona> setPersone = new HashSet<Persona>();
		
		setPersone.add(p1);
		setPersone.add(p2);
		
		System.out.println("Ho una lista di persone = " + setPersone.toString() + ". Bravo!");
		

	}

}
