package it.prova.test;

import it.prova.Cliente;
import it.prova.Hotel;
import it.prova.Premio;
import it.prova.Rappresentante;
import it.prova.Stanza;
import it.prova.Turista;

public class TestHotel {
	public static void main(String[] args) {
		Hotel h1 = new Hotel();

		Turista turista = new Turista("Ruggero", "Rossi");
		Premio premio = new Premio("Alfredo", "Verdi");
		Rappresentante rappresentante = new Rappresentante("Simone", "Bianchi");
		

		Cliente[] arrC = { turista, rappresentante, premio };
		Stanza stanza1 = new Stanza(150, 230, arrC);
		Stanza stanza2 = new Stanza(100, 240, arrC);

		turista.setStanza(stanza1);
		rappresentante.setStanza(stanza1);
		premio.setStanza(stanza1);

		Stanza[] arrS = { stanza1, stanza2 };
		h1.setStanze(arrS);

		System.out.println(h1.calcolaConto(stanza2));

		System.out.println(turista.sommaRealeDaPagare());
		System.out.println(rappresentante.sommaRealeDaPagare());
		System.out.println(premio.sommaRealeDaPagare());

	}
}
