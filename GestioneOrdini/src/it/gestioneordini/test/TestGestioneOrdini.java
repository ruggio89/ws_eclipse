package it.gestioneordini.test;

import it.gestioneordini.model.Articolo;
import it.gestioneordini.model.Categoria;
import it.gestioneordini.model.Ordine;
import it.gestioneordini.service.ArticoloService;
import it.gestioneordini.service.CategoriaService;
import it.gestioneordini.service.MyServiceFactory;
import it.gestioneordini.service.OrdineService;

public class TestGestioneOrdini {

	public static void main(String[] args) {
		
		OrdineService ordineServiceInstance = MyServiceFactory.getOrdineServiceInstance();
		ArticoloService articoloServiceInstance = MyServiceFactory.getArticoloServiceInstance();
		CategoriaService categoriaServiceInstance = MyServiceFactory.getCategoriaServiceInstance();
		
		try {
			
			Ordine ordineNuovo = new Ordine("mimmo graziani", "via roma 334");
//			ordineServiceInstance.inserisciNuovo(ordineNuovo);
			
//			Articolo articoloNuovo = new Articolo("cicciobello", 20);
//			Ordine ordineEsistente = ordineServiceInstance.caricaSingoloElemento(1L);
//			articoloNuovo.setOrdine(ordineEsistente);
//			ordineEsistente.getArticoli().add(articoloNuovo);
//			ordineServiceInstance.aggiorna(ordineEsistente);
			
			Categoria categoriaNuova = new Categoria("Giocattoli");
//			categoriaServiceInstance.inserisciNuovo(categoriaNuova);
			Categoria categoriaNuova2 = new Categoria("Scarpe");
//			categoriaServiceInstance.inserisciNuovo(categoriaNuova2);
			
			Categoria categoriaEsistente = categoriaServiceInstance.caricaSingoloElemento(2L);
			Articolo articoloEsistente = articoloServiceInstance.caricaSingoloElemento(2L);
//			articoloEsistente.getCategorie().add(categoriaEsistente);
//			articoloServiceInstance.aggiorna(articoloEsistente);
			
//			categoriaEsistente.aggiungiArticolo(articoloEsistente);
			
			System.out.println("############# voglioTuttiGliOrdininEffettuatiPerUnaDeterminataCategoria #############");
			for (Ordine o : ordineServiceInstance.voglioTuttiGliOrdininEffettuatiPerUnaDeterminataCategoria(categoriaEsistente)) {
				System.out.println(o);
			}
			
			Ordine ordineEsistente = ordineServiceInstance.caricaSingoloElemento(1L);
			System.out.println("############# voglioTutteLeCategorieDegliArticoliDiUnDeterminatoOrdine #############");
			for (Categoria a : categoriaServiceInstance.voglioTutteLeCategorieDegliArticoliDiUnDeterminatoOrdine(ordineEsistente)) {
				System.out.println(a);
			}
			
			System.out.println("############# voglioLaSommaTotaleDiTuttiIPrezziDegliArticoliLegatiAdUnaCategoria #############");
			System.out.println(articoloServiceInstance.voglioLaSommaTotaleDiTuttiIPrezziDegliArticoliLegatiAdUnaCategoria(categoriaEsistente));
			
			
			
			
			System.out.println("############ Lista di categorie #############");
			for (Categoria c : categoriaServiceInstance.listAll()) {
				System.out.println(c);
			}
			
			System.out.println("############ Lista di articoli #############");
			for (Articolo a : articoloServiceInstance.listAll()) {
				System.out.println(a);
			}
			
			System.out.println("############ Lista di ordini #############");
			for (Ordine o : ordineServiceInstance.listAll()) {
				System.out.println(o);
			}
			
				
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
