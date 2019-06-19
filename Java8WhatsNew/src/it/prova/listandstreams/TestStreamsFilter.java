package it.prova.listandstreams;

import java.util.List;
import java.util.stream.Collectors;

public class TestStreamsFilter {

	public static void main(String[] args) {
		List<Autore> listaAutori = MockData.AUTORI_LIST;

		// voglio una sott-lista degli autori under 30
		System.out.println("voglio una sott-lista degli autori under 30");
		List<Autore> listaAutoriUnderTrenta = listaAutori.stream().filter(autoreItem -> autoreItem.getEta() < 30)
				.collect(Collectors.toList());

		// la stampo
		listaAutoriUnderTrenta
				.forEach(autoreItem -> System.out.println(autoreItem.getNome() + " di anni " + autoreItem.getEta()));

		System.out.println("voglio trasformare la lista di autori under 30 in String x es. mario rossi con cf ADKF3120");
		// voglio trasformare la lista di autori under 30 in String x es. mario rossi
		// con cf ADKF3120
		List<String> messaggiListaAutoriUnderTrenta = listaAutoriUnderTrenta.stream().map(autoreItem -> {
			String messaggio = autoreItem.getNome() + " " + autoreItem.getCognome() + " con CF "
					+ autoreItem.getCodiceFiscale();
			return messaggio;
		}).collect(Collectors.toList());
		//stampo
		messaggiListaAutoriUnderTrenta.forEach(s -> System.out.println(s));
		
		System.out.println("nella listaAutori totale voglio cercare se esiste almeno un Autore col CF terminante in 98");
		//nella listaAutori totale voglio cercare se esiste almeno un Autore col CF terminante in 98
		//in Java classico?????????????????? mamma mia
		Autore autoreDaCercare = listaAutori.stream().filter(autoreItem -> autoreItem.getCodiceFiscale().endsWith("98")).findAny()
        .orElse(null);
		System.out.println(autoreDaCercare.getCodiceFiscale());
		

		System.out.println("degli autori under 30 voglio la lista di libri");
		// degli autori under 30 voglio la lista di libri
		List<Libro> listaLibriDegliUnderTrenta = listaAutoriUnderTrenta.stream().flatMap(x -> x.getLibri().stream())
				.collect(Collectors.toList());
		//map produce un output per ogni elemento che valuta, flatmap un numero indefinito  

		// stampo i titoli
		listaLibriDegliUnderTrenta.forEach(libroItem -> System.out.println(libroItem.getTitolo()));
		
		System.out.println("voglio la lista dei nomi degli autori con libri oltre 600 pagine");
		//voglio la lista dei nomi degli autori con libri oltre 600 pagine
		List<String> listaNomiAutoriConLibriOltreSeicentoPagine = 
			listaAutori.stream()
			.filter(autoreItem -> autoreItem.getLibri()
					.stream().anyMatch(libroItem -> libroItem.getPagine()>600))
			.map(autoreItem -> autoreItem.getNome())
			.collect(Collectors.toList());
		listaNomiAutoriConLibriOltreSeicentoPagine.forEach(l -> System.out.println(l));

	}

}
