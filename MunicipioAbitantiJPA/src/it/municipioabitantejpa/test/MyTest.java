package it.municipioabitantejpa.test;

import java.util.List;

import it.municipioabitantejpa.model.Abitante;
import it.municipioabitantejpa.model.Municipio;
import it.municipioabitantejpa.service.MyServiceFactory;
import it.municipioabitantejpa.service.abitante.AbitanteService;
import it.municipioabitantejpa.service.municipio.MunicipioService;

public class MyTest {

	public static void main(String[] args) {

		try {
			MunicipioService municipioService = MyServiceFactory.getMunicipioServiceInstance();
			AbitanteService abitanteService = MyServiceFactory.getAbitanteServiceInstance();

			// creo nuovo municipio
			Municipio nuovoMunicipio = new Municipio("Municipio I", "I", "Via dei Grandi");
			// salvo
//			municipioService.inserisciNuovo(nuovoMunicipio);
//			System.out.println("Municipio appena inserito: " + nuovoMunicipio);

			// creo nuovo abitante e lo aggiungo al municipio
			Abitante nuovoAbitante = new Abitante("Mimmo", "Settimo", 17, "Via Salvati");

			// lo aggiungo tramite il 'proprietario della relazione'
//			nuovoAbitante.setMunicipio(nuovoMunicipio);
//			nuovoMunicipio.getAbitanti().add(nuovoAbitante);
			//devo chiamare aggiorna per salvare l'aggiunta
//			municipioService.aggiorna(nuovoMunicipio);
			

			
			System.out.println("Ei suoi abitanti:" + nuovoMunicipio.getAbitanti());

			// per cancellare tutto il municipio
//			long idMunicipioesistente = 3;
//			Municipio municipioEsistente2 = municipioService.caricaSingoloMunicipio(idMunicipioesistente);
//			 municipioService.rimuovi(nuovoMunicipio);

//			System.out.println("########### RIMOZIONE ABITANTE ########################");
//			long idAbitanteEsistente = 16;
//			Abitante abitanteEsistente2 = abitanteService.caricaSingoloAbitante(idAbitanteEsistente);
//			if(abitanteEsistente2 != null ) {
//				abitanteService.rimuovi(abitanteEsistente2);
//				abitanteEsistente2 = abitanteService.caricaSingoloAbitante(idAbitanteEsistente);
				//ATTENZIONE!!! Se si modifica in EAGER il caricamento di Municipio dalla 
				//classe Abitante la cancellazione non va in quanto esiste nella sessione
				//di hibernate un riferimento al proprietario della relazione
//				if(abitanteEsistente2 == null )
//					System.out.println("Cancellazione ok");
//				else
//					System.out.println("Cancellazione fallita!!!");
//			}
//			System.out.println("########### FINE RIMOZIONE ABITANTE ########################");
			
			
			
			// elencare i municipi
//			System.out.println("Elenco i municipi:");
//			for (Municipio municipioItem : municipioService.listAllMunicipi()) {
//				System.out.println(municipioItem);
//			}
			

			System.out.println("########### EXAMPLE ########################");
			// find by example: voglio ricercare i municipi con ubicazione 'Via
			// dei Grandi'
//			Municipio municipioExample = new Municipio();
//			municipioExample.setUbicazione("Via dei Grandi");
//			for (Municipio municipioItem : municipioService.findByExample(municipioExample)) {
//				System.out.println(municipioItem);
//			}
			
			System.out.println("########### EXAMPLE ########################");
			// find by example: voglio ricercare gli abitanti di un determinato municipio passando
			//dal bean abitante
//			Abitante abitanteExample = new Abitante();
//			abitanteExample.setMunicipio(municipioService.caricaSingoloMunicipio(22L));
//			List<Abitante> listaSuExample = abitanteService.findByExample(abitanteExample);
//			System.out.println("Trovati................."+listaSuExample.size());
//			System.out.println("....................................................");
//			for (Abitante abitanteItem : listaSuExample) {
//				System.out.println(abitanteItem);
//			}
			// carico un abitante e cambio eta
//			Abitante abitanteEsistente = abitanteService.caricaSingoloAbitante(2L);
//			if (abitanteEsistente != null) {
//				abitanteEsistente.setEta(50);
//				abitanteService.aggiorna(abitanteEsistente);
//			}

			System.out.println("####################");
			// quando carico un Municipio ho già i suoi abitanti
//			Municipio municipioACaso = municipioService.caricaSingoloMunicipio(5L);
//			if (municipioACaso != null) {
//				for (Abitante abitanteItem : municipioACaso.getAbitanti()) {
//					System.out.println(abitanteItem);
//				}
//			}
			
			System.out.println("############## fyndByAbitantiMinorenni #################");
//			System.out.println(municipioService.TrovaAbitantiMinorenni());
			
			System.out.println("############## findAllByNomeCheIniziaPer #################");
//			System.out.println(municipioService.trovaMunicipiCheInizianoCon("mu"));
			
			System.out.println("############## findAllByCognome (abitante) #################");
//			System.out.println(abitanteService.trovaPerCognome("rossi"));
			
			System.out.println("############## findAllByCodiceMunicipio (abitante) #################");
			System.out.println(abitanteService.trovaPerCodiceMunicipio("I"));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
