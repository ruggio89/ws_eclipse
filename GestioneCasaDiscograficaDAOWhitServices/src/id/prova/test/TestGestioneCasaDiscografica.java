package id.prova.test;

import id.prova.model.Autore;
import id.prova.model.CasaDiscografica;
import id.prova.model.Cd;
import it.prova.service.AutoreService;
import it.prova.service.CasaDiscograficaService;
import it.prova.service.CdService;
import it.prova.service.MyServiceFactory;

public class TestGestioneCasaDiscografica {

	public static void main(String[] args) {
		CasaDiscografica newCasaDiscograficaInstance = new CasaDiscografica("Mimma", "56667567");
		
		//parlo direttamente con il service
		CasaDiscograficaService casaDiscograficaService = MyServiceFactory.geCasaDiscograficaServiceImpl();
		
		AutoreService autoreService = MyServiceFactory.getAutoreServiceImpl();
		
		CdService cdService = MyServiceFactory.getCdServiceImpl();
		
		
		try {
			//provo ad inserire una casa discografica
//			System.out.println(casaDiscograficaService.inserisciNuovaCasaDiscografica(newCasaDiscograficaInstance));
			
			//provo una delete di casa discografica
//			System.out.println(casaDiscograficaService.rimuoviCasaDiscografica(casaDiscograficaService.findCasaDiscograficaById(7L)));
			
			//provo a fare un update
//			newCasaDiscograficaInstance = casaDiscograficaService.findCasaDiscograficaById(8L);
//			newCasaDiscograficaInstance.setPartitaIva("s");
//			System.out.println(casaDiscograficaService.aggiornaCasaDiscografica(newCasaDiscograficaInstance));
			
//			System.out.println("################ fyndByExample #################");
//			System.out.println(casaDiscograficaService.findByExample(newCasaDiscograficaInstance));
			
//			for (CasaDiscografica casaDiscoItem : casaDiscograficaService.listAllCasaDiscografica()){
//				System.out.println(casaDiscoItem);
//			}
			
			//provo ad inserire autore
			Autore newAutoreInstance = new Autore("dante", "alighieri", casaDiscograficaService.findCasaDiscograficaById(8L));
//			System.out.println(autoreService.inserisciNuovaAutore(newAutoreInstance));
			
//			list di autore (RIVEDI)
//			System.out.println("############## lista di autore #################");
//			for (Autore autoreItem : autoreService.listAllAutore()) {
//				System.out.println(autoreItem);
//			}
			
			//prova update autore
//			newAutoreInstance= autoreService.findAutoreById(5L);
//			newAutoreInstance.setNome("carlo");
//			System.out.println(autoreService.aggiornaAutore(newAutoreInstance));
			
			//provo a inserire un cd
			Cd newCdInstance = new Cd("troppo complicato", "rock", "oh no no!", autoreService.findAutoreById(6L));
//			System.out.println(cdService.inserisciNuovoCd(newCdInstance));
			
			//provo pupolateCds
//			newAutoreInstance = autoreService.findAutoreById(5L);
//			autoreService.aggiungiCdAdAutore(newAutoreInstance);
//			System.out.println("############### provo populateCds ##############");
//			for (Cd cdItem : newAutoreInstance.getListaCd()) {
//				System.out.println(cdItem);
//			}
			
			//provo list di cd
//			System.out.println("############## lista di cd #################");
//			for (Cd cdItem : cdService.listAllCd()) {
//				System.out.println(cdItem);
//			}
			
			//provo delete di cd
//			System.out.println(cdService.rimuoviCd(cdService.findCdById(4L)));
			
			
			//provo populate di casa discografica
//			newCasaDiscograficaInstance = casaDiscograficaService.findCasaDiscograficaById(8L);
//			casaDiscograficaService.aggiungiAutoreACasaDiscografica(newCasaDiscograficaInstance);
//			System.out.println("############## populateAutore #################");
//			for (Autore autoreItem : newCasaDiscograficaInstance.getListaAutori()) {
//				System.out.println(autoreItem);
//			}
			
			//provo findbynomecheiniziaper
//			System.out.println("############## FindByInizialeCognome #################");
//			for (CasaDiscografica autoreitem : casaDiscograficaService.trovaAutoreConCognomeCheIniziaPer("r")) {
//				System.out.println(autoreitem);
//			}
			
			//provo findByGenere
//			System.out.println("############## FindByGenere #################");
//			for (CasaDiscografica autoreitem : casaDiscograficaService.trovaTuttiICdPerGenere("neomelodico")) {
//				System.out.println(autoreitem);
//			}
			
			//provo findByCasaDiscografica
//			System.out.println("############## FindByCasaDiscografica #################");
//			for (Autore autoreitem : autoreService.trovaAutoriDaCasaDiscografica(casaDiscograficaService.findCasaDiscograficaById(8L))) {
//				System.out.println(autoreitem);
//			}
			
			//provo findAllByGenere su cd
//			System.out.println("############## FindByGenere su cd #################");
//			for (Cd cdItem : cdService.trovaCdDaGenere("neomelodico")) {
//				System.out.println(cdItem);
//			}
			
			//prova findAllByAutoreWhereTitoloIniziaCon
//			System.out.println("############## findAllByAutoreWhereTitoloIniziaCon #################");
//			for (Cd cdItem : cdService.trovaTuttiICdDaAutoreDoveTitoloIniziaCon(autoreService.findAutoreById(5L), "no")) {
//				System.out.println(cdItem);
//			}
			
			//provo transaction
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
}
