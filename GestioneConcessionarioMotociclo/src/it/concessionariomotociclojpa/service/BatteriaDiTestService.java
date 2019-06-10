package it.concessionariomotociclojpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.concessionariomotociclojpa.model.Concessionario;
import it.concessionariomotociclojpa.model.Motociclo;

@Component
public class BatteriaDiTestService {

	@Autowired
	private ConcessionarioService concessionarioService;

	@Autowired
	private MotocicloService motocicloService;

	// casi di test
	public static final String INSERISCI_NUOVO_CONCESSIONARIO = "INSERISCI_NUOVO_CONCESSIONARIO";
	public static final String INSERISCI_MOTOCICLI_DATO_UN_CONCESSIONARIO = "INSERISCI_MOTOCICLI_DATO_UN_CONCESSIONARIO";
	public static final String ELENCA_TUTTI_I_CONCESSIONARI = "ELENCA_TUTTI_I_CONCESSIONARI";
	public static final String ELENCA_TUTTI_I_MOTOCICLI = "ELENCA_TUTTI_I_MOTOCICLI";
	public static final String RIMUOVI_CONCESSIONARIO_E_MOTOCICLI = "RIMUOVI_CONCESSIONARIO_E_MOTOCICLI";
	public static final String FIND_BY_EXAMPLE_BY_MARCA = "FIND_BY_EXAMPLE_BY_MARCA";
	public static final String ELENCA_CONCESSIONARI_CON_MOTOCICLI_CON_CILINDRATA_1200 = "ELENCA_CONCESSIONARI_CON_MOTOCICLI_CON_CILINDRATA_1200";
	public static final String NUMERO_MOTOCICLI_IMMATRICOLATI_PRIMA_DEL_2010_A_TORINO = "NUMERO_MOTOCICLI_IMMATRICOLATI_PRIMA_DEL_2010_A_TORINO";
	public static final String LISTA_PARTITA_IVA_CONCESSIONARI_MILANO_PER_HONDA_IMMATRICOLATE_TRA_2012_E_2016 = "LISTA_PARTITA_IVA_CONCESSIONARI_MILANO_PER_HONDA_IMMATRICOLATE_TRA_2012_E_2016";
	public static final String UPDATE_CONCESSIONARIO_SET_CITTA = "UPDATE_CONCESSIONARIO_SET_CITTA";

	public void eseguiBatteriaDiTest(String casoDaTestare) {
		try {
			switch (casoDaTestare) {

			case INSERISCI_NUOVO_CONCESSIONARIO:
				// creo nuovo concessionario
				Concessionario nuovoConcessionario = new Concessionario("Ciclomotori Giusti", "Torino", "55559869");
				// salvo
				concessionarioService.inserisciNuovo(nuovoConcessionario);
				System.out.println("Concessionario appena inserito: " + nuovoConcessionario);
				break;

			case INSERISCI_MOTOCICLI_DATO_UN_CONCESSIONARIO:
				// / creo nuovo motociclo
				Motociclo nuovoMotociclo = new Motociclo("Ducati", "Monster 500H", 1800, 2016);
				nuovoMotociclo.setConcessionario(concessionarioService.caricaSingoloConcessionario(2L));
				// salvo
				motocicloService.inserisciNuovo(nuovoMotociclo);

				break;

			case ELENCA_TUTTI_I_CONCESSIONARI:
				// elenca i concessionari
				System.out.println("Elenco i concessionari:");
				for (Concessionario concessionarioItem : concessionarioService.listAllConcessionari()) {
					System.out.println(concessionarioItem);
				}

				break;

			case ELENCA_CONCESSIONARI_CON_MOTOCICLI_CON_CILINDRATA_1200:

				System.out.println("Elenco i concessionari con motocicli con cilindrata maggiore di 1200:");
				for (Concessionario concessionarioItem : concessionarioService
						.trovaMotocicloCilindrataMaggiore1200PerDenominazione()) {
					System.out.println(concessionarioItem);
				}

				break;

			case NUMERO_MOTOCICLI_IMMATRICOLATI_PRIMA_DEL_2010_A_TORINO:

				System.out.println("Elenco i motocicli immatricolati prima del 2010 a Torino:");
				System.out.println(motocicloService.numeroMotocicliImmatricolazioneMinore2010InTorino());

				break;

			case LISTA_PARTITA_IVA_CONCESSIONARI_MILANO_PER_HONDA_IMMATRICOLATE_TRA_2012_E_2016:

				System.out.println(
						"Elenco i concessionari per partita inva a Milano che hanno Honda immatricolate tra 2012 e 2016");
				for (Concessionario concessionarioItem : concessionarioService
						.listPartitaIvaAMilanoPerHondaTra2012E2016()) {
					System.out.println(concessionarioItem.getPartitaIva());
				}

				break;

			case UPDATE_CONCESSIONARIO_SET_CITTA:
				Concessionario concessionarioEsistente = concessionarioService.caricaSingoloConcessionario(1L);
				if (concessionarioEsistente != null) {
					concessionarioEsistente.setCitta("Milano");
					concessionarioService.aggiorna(concessionarioEsistente);
				}
				break;

			case RIMUOVI_CONCESSIONARIO_E_MOTOCICLI:
				// per cancellare tutto il concessionario
				concessionarioService.rimuovi(concessionarioService.caricaSingoloConcessionario(24L));

				break;

			case FIND_BY_EXAMPLE_BY_MARCA:
				System.out.println("########### EXAMPLE ########################");
				Motociclo motocicloExample = new Motociclo();
				motocicloExample.setMarca("Honda");
				for (Motociclo motocicloItem : motocicloService.findByExample(motocicloExample)) {
					System.out.println(motocicloItem);
				}

				break;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
