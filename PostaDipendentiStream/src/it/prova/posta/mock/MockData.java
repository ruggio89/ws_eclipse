package it.prova.posta.mock;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import it.prova.posta.model.Destinatario;
import it.prova.posta.model.PostaDiPaese;

public class MockData {

	public static final List<PostaDiPaese> POSTA_LIST = new ArrayList<>();
	public static final List<Destinatario> DESTINATARIO_LIST = new ArrayList<>();

	static {
		try {
			PostaDiPaese postaMilano = new PostaDiPaese("Posta Centrale di Milano", "Via Ciccio 33, MI",
					new SimpleDateFormat("dd/MM/yyyy").parse("12/05/2019"), 19);
			Destinatario destinatario1 = new Destinatario("Ruggero", "Rossi", 29, "Via Bello 34", true, postaMilano);
			postaMilano.getDestinatari().add(destinatario1);
			Destinatario destinatario2 = new Destinatario("Marco", "Bianchi", 35, "Via Mimmo 6", false, postaMilano);
			postaMilano.getDestinatari().add(destinatario2);
			POSTA_LIST.add(postaMilano);

			PostaDiPaese postaRoma = new PostaDiPaese("Posta Laterale di Roma", "Via Mosca 353, RM",
					new SimpleDateFormat("dd/MM/yyyy").parse("15/04/2019"), 10);
			Destinatario destinatario3 = new Destinatario("Mimmo", "Verdi", 56, "Via Bello Bello 66", true, postaRoma);
			postaRoma.getDestinatari().add(destinatario3);
			Destinatario destinatario4 = new Destinatario("Bruno", "Coso", 21, "Via Lessie 666", true, postaRoma);
			postaRoma.getDestinatari().add(destinatario4);
			POSTA_LIST.add(postaRoma);

			PostaDiPaese postaGenova = new PostaDiPaese("Posta Centrale di Genova", "Via Veloce 3, GE",
					new SimpleDateFormat("dd/MM/yyyy").parse("15/04/2018"), 30);
			Destinatario destinatario5 = new Destinatario("Giacomo", "Grande", 33, "Via Brutto 55", true, postaGenova);
			postaGenova.getDestinatari().add(destinatario5);
			POSTA_LIST.add(postaGenova);

			PostaDiPaese postaMonza = new PostaDiPaese("Posta Bilaterale di Monza", "Via Freddo 3667, MO",
					new SimpleDateFormat("dd/MM/yyyy").parse("15/06/2019"), 90);
			Destinatario destinatario6 = new Destinatario("Francesco", "Malore", 44, "Via Mongo 66", true, postaMonza);
			postaMonza.getDestinatari().add(destinatario6);
			Destinatario destinatario7 = new Destinatario("Mastro", "Birra", 77, "Via Vero 66", false, postaMonza);
			postaMonza.getDestinatari().add(destinatario7);
			Destinatario destinatario8 = new Destinatario("Beatrice", "Grasso", 54, "Via Morte 654", false, postaMonza);
			postaMonza.getDestinatari().add(destinatario8);

			POSTA_LIST.add(postaMonza);
			
			DESTINATARIO_LIST.add(destinatario8);
			DESTINATARIO_LIST.add(destinatario7);
			DESTINATARIO_LIST.add(destinatario6);
			DESTINATARIO_LIST.add(destinatario5);
			DESTINATARIO_LIST.add(destinatario4);
			DESTINATARIO_LIST.add(destinatario3);
			DESTINATARIO_LIST.add(destinatario2);
			DESTINATARIO_LIST.add(destinatario1);

		} catch (ParseException e) {
			e.printStackTrace();
		}

	}
}
