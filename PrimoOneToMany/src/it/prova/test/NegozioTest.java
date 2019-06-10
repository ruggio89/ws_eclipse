package it.prova.test;

import it.prova.dao.ArticoloDAO;
import it.prova.dao.NegozioDAO;
import it.prova.model.Articolo;
import it.prova.model.Negozio;

public class NegozioTest {

	public static void main(String[] args) {
		NegozioDAO negozioDAOInstance = new NegozioDAO();
		ArticoloDAO articoloDAOInstance = new ArticoloDAO();
		
		System.out.println("Negozi sul db:");
		for (Negozio negozioItel : negozioDAOInstance.list()) {
			System.out.println(negozioItel);
		}
		
		//provo una insert di negozio
		//Negozio negozio = new Negozio("Negozio2", "via montebello 34");
		//negozioDAOInstance.insert(negozio);
		
		System.out.println("cerco un negozio con id 1");
		Negozio negozioConIdCheDicoIo = negozioDAOInstance.selectById(1L);
		System.out.println(negozioConIdCheDicoIo);
		
		//update di negozio
		//negozioConIdCheDicoIo.setNome("GetIn");
		//negozioDAOInstance.update(negozioConIdCheDicoIo);
		
		System.out.println("cerco un articolo con id 1");
		Articolo articoloConIdCheDicoIo = articoloDAOInstance.selectByIdWithJoin(1L);
		System.out.println(articoloConIdCheDicoIo);
		//update di articolo
		
		System.out.println("Trovo negozi che iniziano per G");
		for (Negozio negozioItem : negozioDAOInstance.findAllByIniziali("g")) {
			System.out.println(negozioItem);
		}
		
		System.out.println("Trovo gli articoli da negozio");
		for (Articolo articoloInput : articoloDAOInstance.findAllByNegozio(negozioConIdCheDicoIo)) {
			System.out.println(articoloInput);
		}
		
		System.out.println("Trovo articolo da matricola");
		for (Articolo articoloInput : articoloDAOInstance.findAllByMatricola("matricola2")) {
			System.out.println(articoloInput);
		}
		
		System.out.println("Trovo gli articoli da indirizzo negozio:");
		for (Articolo articoloInput : articoloDAOInstance.findAllByIndirizzoNegozio("via montebello 34")){
			System.out.println(articoloInput);
		}
		
		
		
		//inserisco un articolo
		//articoloDAOInstance.insert(new Articolo("articolo2", "matricola2", negozioConIdCheDicoIo));
		
		System.out.println("Articoli presenti sul db:");
		for (Articolo articoloItem : articoloDAOInstance.list()) {
			System.out.println(articoloItem);
		}
		
		/*
		 * se io voglio caricare un negozio e contestualmente anche i suoi articoli
		 * dovrò sfruttare il populateArticoli presente dentro negoziodao. Per esempio
		 * Negozio negozioCaricatoDalDb = negozioDAOInstance.selectById...
		 * 
		 * negozioDAOInstance.populateArticoli(negozioCaricatoDalDb);
		 * 
		 * e da qui in poi il negozioCaricatoDalDb.getArticoli() non deve essere più a size=0
		 * LAZY FETCHING (poi ve lo spiego)
		 */

	}

}
