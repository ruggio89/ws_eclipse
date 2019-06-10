package it.prova.test;

import it.prova.FiguraGeometrica;
import it.prova.Quadrato;
import it.prova.Triangolo;

public class TestFiguraGeometrica {

	public static void main(String[] args) {
		FiguraGeometrica f1 = new FiguraGeometrica();
		FiguraGeometrica f2 = new Triangolo();
		FiguraGeometrica f3 = new Quadrato();
		
		Quadrato q1 = new Quadrato();
		Triangolo t1 = new Triangolo();
		
		t1.setBase(10);
		t1.setAltezza(10);
		
		f2.setBase(40);
		f2.setAltezza(20);
		
		q1.setBase(30);
		
		System.out.println(t1.calcolaArea());
		System.out.println(q1.calcolaArea());
		System.out.println(t1.calcolaPerimetro());
		System.out.println(q1.calcolaPerimetro());
		System.out.println(f1.calcolaPerimetro());
		System.out.println(f2.calcolaArea());
	}

}
