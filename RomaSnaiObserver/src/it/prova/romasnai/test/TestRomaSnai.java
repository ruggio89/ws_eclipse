package it.prova.romasnai.test;

import it.prova.romasnai.observer.QuoteDisplay;
import it.prova.romasnai.subject.RomaSnai;

public class TestRomaSnai {

	public static void main(String[] args) {

		RomaSnai romaSnai = new RomaSnai();
		QuoteDisplay quoteDisplay = new QuoteDisplay(romaSnai);

		romaSnai.setQuoteRoma(1.5f,  2.5f, 3.5f);
		
		
	}
}
