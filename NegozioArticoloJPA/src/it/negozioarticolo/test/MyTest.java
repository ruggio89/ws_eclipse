package it.negozioarticolo.test;

import it.negozioarticolo.model.Articolo;
import it.negozioarticolo.model.Negozio;
import it.negozioarticolo.service.ArticoloService;
import it.negozioarticolo.service.MyServiceFactory;
import it.negozioarticolo.service.NegozioService;

public class MyTest {
	public static void main(String[] args) {
		NegozioService negozioService = MyServiceFactory.getNegozioServiceInstance();
		ArticoloService articoloService = MyServiceFactory.getArticoloServiceInstance();
		
		try {
//			Negozio negozioNew = new Negozio ("Lillo srls", "98082398");
			Negozio negozioEsistente = negozioService.caricaSingoloNegozio(2L);

			
			// inserisco negozio
//			negozioService.inserisciNuovo(negozioNew);
//			System.out.println("Hai inserito: " + negozioNew);
			
//			System.out.println(negozioService.caricaSingoloNegozio(1L));
			
			Articolo articoloNew = new Articolo("Filetto danese", "Carne");
			
//			articoloNew.setNegozio(negozioEsistente);
//			negozioEsistente.getArticoli().add(articoloNew);
//			negozioService.aggiorna(negozioEsistente);
			
			// rimuovo l'intero negozio (con articoli annessi)
//			negozioService.rimuovi(negozioEsistente);
			
			// rimuovo articolo
//			Articolo articoloEsistente = articoloService.caricaSingoloArticolo(6L);
//			if(articoloEsistente != null) {
//				articoloService.rimuovi(articoloEsistente);
//				articoloEsistente = articoloService.caricaSingoloArticolo(6L);
//			} if(articoloEsistente == null) {
//				System.out.println("Cancellazione ok!");
//			} else {
//				System.out.println("Cancellazione fallita!");
//			}
			
			
			//lista negozio
			for (Negozio neg : negozioService.listAllNegozi()) {
				System.out.println(neg);
			}
			
			//list articoli
			for (Articolo art : articoloService.listAllArticolo()) {
				System.out.println(art);
			}
			
			
			
			
			
			
			
			
			
			
			
//			System.out.println(negozioService.listAllNegozi());
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
