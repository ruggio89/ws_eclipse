package it.prova;

public class Quadrato extends FiguraGeometrica {
	
	public int calcolaPerimetro() {
		int risultato;
		risultato = base * 4;
		return risultato;
	}
	
	public int calcolaArea() {
		int risultato;
		risultato = base * base;
		return risultato;
	}

}
