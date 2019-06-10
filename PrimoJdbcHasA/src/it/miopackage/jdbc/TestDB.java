package it.miopackage.jdbc;

import java.util.ArrayList;
import java.util.List;

import it.miopackage.jdbc.dao.AbitanteDAO;
import it.miopackage.jdbc.dao.IndirizzoDAO;
import it.miopackage.jdbc.model.Abitante;
import it.miopackage.jdbc.model.Indirizzo;

public class TestDB {

	public static void main(String[] args) {
		System.out.println("Inizio....");
		// questi servono solo per invocare
		AbitanteDAO abitanteDAOInstance = new AbitanteDAO();
		IndirizzoDAO indirizzoDAOInstance = new IndirizzoDAO();

		Abitante abitante = abitanteDAOInstance.selectJoinById(1L);

		System.out.println(abitante);

		// update di abitante
		// abitante.setNome(null);
		// System.out.println(abitanteDAOInstance.update(abitante));

		// delete di abitante
		// System.out.println(abitanteDAOInstance.delete(abitante));

		Indirizzo indirizzo = new Indirizzo("Cuneo", "Via dei sorci", "10");
		// indirizzoDAOInstance.insert(indirizzo);

		System.out.println("Troviamo gli indirizzi che hanno stessa via e stessa città.....");
		for (Indirizzo indirizzoInput : indirizzoDAOInstance.findAllByViaECitta("Via dei venti", "Roma")) {
			System.out.println(indirizzoInput);
		}
		

		System.out.println("Troviamo gli abitanti che hanno stessa città.....");
		for (Abitante abitanteItem : abitanteDAOInstance.findByCitta("Cuneo")) {
			System.out.println(abitanteItem);
		}

		System.out.println("Troviamo l'abitante che ha l'indirizzo di input.....");
		System.out.println(abitanteDAOInstance.findByIndirizzo(indirizzo));

		System.out.println("Troviamo gli abitanti che hanno il nome con iniziale.....");
		for (Abitante abitanteItem : abitanteDAOInstance.findAllByNomeConIniziale("g")) {
			System.out.println(abitanteItem);
		}
		/*
		 * abitante = new Abitante("giorgio", "bianchi", 77); abitante.setIndirizzo(new
		 * Indirizzo("Cuneo", "Via dei sorci", "10"));
		 * abitanteDAOInstance.insertCompleto(abitante);
		 * 
		 * 
		 * 
		 * System.out.println("Lista di indirizzi....."); for (Indirizzo indirizzoItem :
		 * indirizzoDAOInstance.list()) { System.out.println(indirizzoItem); }
		 * 
		 * System.out.println("Situazione sul db...."); for (Abitante abitanteItem :
		 * abitanteDAOInstance.list()) { System.out.println(abitanteItem); }
		 */

		/*
		 * System.out.println("*****************PROVA BATCH******************");
		 * List<Indirizzo> listaNuoviIndirizzi = new ArrayList<Indirizzo>();
		 * listaNuoviIndirizzi.add(new Indirizzo("Ancona", "Via dei sorci", "45"));
		 * listaNuoviIndirizzi.add(new Indirizzo("Bari", "Via dei sorci", "41L"));
		 * indirizzoDAOInstance.insertBatch(listaNuoviIndirizzi);
		 * 
		 * System.out.println("*****************PROVA GET LAST ID******************");
		 * Long lastId = indirizzoDAOInstance .insertIndirizzoObtainingLastId(new
		 * Indirizzo("Modena", "Via dei mille", "l145")); System.out.println(lastId);
		 */
	}
}
