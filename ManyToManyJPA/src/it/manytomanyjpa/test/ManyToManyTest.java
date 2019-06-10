package it.manytomanyjpa.test;

import java.util.Date;

import it.manytomanyjpa.model.Ruolo;
import it.manytomanyjpa.model.Utente;
import it.manytomanyjpa.service.MyServiceFactory;
import it.manytomanyjpa.service.RuoloService;
import it.manytomanyjpa.service.UtenteService;

public class ManyToManyTest {

	public static void main(String[] args) {
		UtenteService utenteServiceInstance = MyServiceFactory.getUtenteServiceInstance();
		RuoloService ruoloServiceInstance = MyServiceFactory.getRuoloServiceInstance();

		// ora passo alle operazioni CRUD
		try {

			

			Utente utenteNuovo = new Utente("ciccio.lillo", "55557", "ciccio", "lillo", new Date());
//			utenteServiceInstance.inserisciNuovo(utenteNuovo);

//			Ruolo ruoloNuovo = new Ruolo("Hacker","ROLE_HACKER");
//			ruoloServiceInstance.inserisciNuovo(ruoloNuovo);
//			Ruolo ruoloNuovo2 = new Ruolo("Classic User","ROLE_CLASSIC_USER");
//			ruoloServiceInstance.inserisciNuovo(ruoloNuovo2);

//			Ruolo ruoloDaDb = ruoloServiceInstance.caricaSingoloElemento(19L);
//
//			Utente utenteDaDb = utenteServiceInstance.caricaSingoloElemento(12L);
//			if (utenteDaDb != null) {
//				utenteDaDb.getRuoli().add(ruoloDaDb);
//			}
//			
//			utenteServiceInstance.aggiorna(utenteDaDb);
			
			//aggiorno ruolo 
//			Ruolo ruoloEsistente = ruoloServiceInstance.caricaSingoloElemento(17L);
//			ruoloEsistente.setDescrizione("Spazzino");
//			ruoloServiceInstance.aggiorna(ruoloEsistente);
			
			// aggiorna utente
//			Utente utenteEsistente = utenteServiceInstance.caricaSingoloElemento(9L);
//			utenteEsistente.setUsername("pippo.loscemo");
//			utenteServiceInstance.aggiorna(utenteEsistente);
			
			//findByExample utente
//			System.out.println("############## FyndByExample utente #############");
//			Utente utenteExample = new Utente();
//			utenteExample.setNome("pippo");
//			for (Utente u : utenteServiceInstance.findByExample(utenteExample)) {
//				System.out.println(u);
//			}
			
			// findByExample ruolo
//			System.out.println("############## FyndByExample ruolo #############");
//			Ruolo ruoloExample = new Ruolo();
//			ruoloExample.setDescrizione("Administrator");
//			for (Ruolo r : ruoloServiceInstance.findByExample(ruoloExample)) {
//				System.out.println(r);
//			}
			
			// findByRuolo
//			System.out.println("################ findAllByRuolo ################");
//			Ruolo ruoloDaCercare = ruoloServiceInstance.caricaSingoloElemento(19L);
//			for (Utente u : utenteServiceInstance.findByRuolo(ruoloDaCercare)) {
//				System.out.println(u);
//			}
			
			
			
			// lista utenti
			System.out.println("Elenca utenti: ");
			for (Utente u : utenteServiceInstance.listAll()) {
				System.out.println(u);
			}
			
			//lista ruoli
			System.out.println("Elenca ruoli: ");
			for (Ruolo r : ruoloServiceInstance.listAll()) {
				System.out.println(r);
			}
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
