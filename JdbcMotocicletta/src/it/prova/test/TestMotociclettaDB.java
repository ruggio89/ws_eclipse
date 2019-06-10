package it.prova.test;

import java.util.List;

import it.prova.model.Motocicletta;
import it.prova.dao.MotociclettaDao;

public class TestMotociclettaDB {

	public static void main(String[] args) {

		System.out.println("Iniziamo!");

		MotociclettaDao motociclettaDaoInput = new MotociclettaDao();

		for (Motocicletta motociclettaItem : motociclettaDaoInput.list()) {
			System.out.println(motociclettaItem);
		}

		// facciamo qualche insert
		Motocicletta motociclettaDaInserire = new Motocicletta("yamaha", "sport", 250);
		motociclettaDaoInput.insert(motociclettaDaInserire);
		Motocicletta altramotoMotociclettaDaInserire = new Motocicletta("suzuki", "sss", 150);
		motociclettaDaoInput.insert(altramotoMotociclettaDaInserire);

		System.out.println(motociclettaDaoInput.findAllByCilindrataMaggioreDi(200));

	}

}
