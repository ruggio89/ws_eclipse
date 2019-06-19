package it.prova.posta.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import it.prova.posta.mock.MockData;
import it.prova.posta.model.Destinatario;
import it.prova.posta.model.PostaDiPaese;

public class TestPostaDestinatariStream {

	public static void main(String[] args) throws ParseException {

		List<PostaDiPaese> listaPoste = MockData.POSTA_LIST;
		List<Destinatario> listaDestinatari = MockData.DESTINATARIO_LIST;

		// #1
		System.out.println("#### POSTE IL CUI INDIRIZZO CONTENGA 'MI' ####");
		List<PostaDiPaese> listaPosteConMI = listaPoste.stream()
				.filter(postaItem -> postaItem.getIndirizzoSede().contains("MI")).collect(Collectors.toList());
		// stampo
		listaPosteConMI.forEach(
				postaItem -> System.out.println("Posta con indirizzo a Milano: " + postaItem.getDenominazione()));

		// #2
		System.out.println("#### POSTE APERTE DOPO IL 01/03/2019 ####");
		Date dataPerControllo = new SimpleDateFormat("dd/MM/yyyy").parse("01/03/2019");
		List<PostaDiPaese> listaPosteDopoDataInput = listaPoste.stream()
				.filter(postaItem -> postaItem.getDataApertura().after(dataPerControllo)).collect(Collectors.toList());
		// stampo
		listaPosteDopoDataInput.forEach(
				postaItem -> System.out.println("Posta aperta dopo il 01/03/19: " + postaItem.getDenominazione()));

		// #3
		System.out.println("#### LISTA INDIRIZZI DI POSTE IL CUI NUMERO DI DIPENDENDI E' > 20 ####");
		List<String> listaIndirizziPoste = listaPoste.stream().filter(postaItem -> postaItem.getNumeroDipendenti() > 20)
				.collect(Collectors.toList()).stream().map(postaItem -> {
					String indirizzoPosta = "Indirizzo di Poste con N dipendenti > 20: " + postaItem.getIndirizzoSede();
					return indirizzoPosta;
				}).collect(Collectors.toList());
		// stampo
		listaIndirizziPoste.forEach(indirizzoItem -> System.out.println(indirizzoItem));

		// #4
		System.out.println("#### LISTA INDIRIZZI DI DESTINATARI DI POSTE CON ALMENO 10 DIPENDENTI ####");
		List<String> listaIndirizziDestinatari = listaPoste.stream()
				.filter(postaItem -> postaItem.getNumeroDipendenti() > 10).collect(Collectors.toList()).stream()
				.flatMap(postaItem -> postaItem.getDestinatari().stream()).collect(Collectors.toList()).stream()
				.map(destinatarioItem -> destinatarioItem.getIndirizzo()).collect(Collectors.toList());
		// stamp
		listaIndirizziDestinatari.forEach(indirizzoItem -> System.out.println(indirizzoItem));

		// #5
		System.out.println("#### LISTA DESTINATARI CON CC CON POSTE TRA 50 E 100 DIPENDENTI ####");
		List<Destinatario> destinatariConContoCorrente = listaPoste.stream()
				.filter(item -> item.getNumeroDipendenti() > 50 && item.getNumeroDipendenti() < 100)
				.collect(Collectors.toList()).stream().flatMap(item -> item.getDestinatari().stream())
				.filter(item2 -> item2.isPossessoreCC()).collect(Collectors.toList());
		System.out.println(destinatariConContoCorrente);

		// #6
		Date dataPerControllo1 = new SimpleDateFormat("dd/MM/yyyy").parse("30/01/2000");
		System.out.println("#### LISTA ETA DESTINATARI DELLE POSTE CENTRALE E ALMENO DA GENNAIO 2000 ####");
		List<Integer> listaEtaDestinatri = listaPoste.stream()
				.filter(postaItem -> postaItem.getDenominazione().contains("Centrale")
						&& postaItem.getDataApertura().after(dataPerControllo1))
				.collect(Collectors.toList()).stream().flatMap(postaItem -> postaItem.getDestinatari().stream())
				.collect(Collectors.toList()).stream().map(destinatarioItem -> destinatarioItem.getEta())
				.collect(Collectors.toList());
		// stamp
		listaEtaDestinatri.forEach(etaItem -> System.out.println(etaItem));
	}
}
