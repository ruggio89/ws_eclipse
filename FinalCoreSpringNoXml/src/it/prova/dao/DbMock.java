package it.prova.dao;

import java.util.ArrayList;
import java.util.List;

import it.prova.model.Esame;
import it.prova.model.Studente;

public class DbMock {
	
	public static final List<Esame> ESAMI = new ArrayList<Esame>();
	
	static {
		Esame esame1 = new Esame(1,"Esame maturità liceo");
		Studente studente1 = new Studente("Mario", "Rossi",esame1);
		esame1.addToStudenti(studente1);
		Studente studente2 = new Studente("Giuseppe", "Bianchi",esame1);
		esame1.addToStudenti(studente2);
		Studente studente3 = new Studente("Francesco", "Verdi",esame1);
		esame1.addToStudenti(studente3);
		ESAMI.add(esame1);
		
		Esame esame2 = new Esame(2, "Esame generale");
		Studente st1 = new Studente("Ruggero", "Rossi", esame2);
		esame2.addToStudenti(st1);
		Studente st2 = new Studente("Ciccio", "Graziani", esame2);
		esame2.addToStudenti(st2);
		Studente st3 = new Studente("Mimmo", "Bianchi", esame2);
		ESAMI.add(esame2);
	}

}
