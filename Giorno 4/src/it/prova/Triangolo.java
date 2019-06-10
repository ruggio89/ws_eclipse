package it.prova;

public class Triangolo extends FiguraGeometrica {
	
	public int calcolaPerimetro() {
		int risultato = base * 3;
		return risultato;
	}
	
	public int calcolaArea() {
		int risultato = (base * altezza)/2;
		return risultato;
	}
}
