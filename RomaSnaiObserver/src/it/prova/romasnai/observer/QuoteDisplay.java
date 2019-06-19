package it.prova.romasnai.observer;

import it.prova.romasnai.subject.RomaSnai;

public class QuoteDisplay implements Observer, DisplayElement {

	private float quotaVittoria;
	private float quotaPareggio;
	private float quotaSconfitta;
	private RomaSnai romaSnai;

	public RomaSnai getRomaSnai() {
		return romaSnai;
	}

	public void setRomaSnai(RomaSnai romaSnai) {
		this.romaSnai = romaSnai;
	}

	public float getQuotaVittoria() {
		return quotaVittoria;
	}

	public void setQuotaVittoria(float quotaVittoria) {
		this.quotaVittoria = quotaVittoria;
	}

	public float getQuotaPareggio() {
		return quotaPareggio;
	}

	public void setQuotaPareggio(float quotaPareggio) {
		this.quotaPareggio = quotaPareggio;
	}

	public float getQuotaSconfitta() {
		return quotaSconfitta;
	}

	public void setQuotaSconfitta(float quotaSconfitta) {
		this.quotaSconfitta = quotaSconfitta;
	}

	@Override
	public void display() {
		System.out.println("La prossima partita della Magica Roma ha le seguenti quote: \n - VITTORIA: " + quotaVittoria
				+ "\n - PAREGGIO: " + quotaPareggio + "\n - SCONFITTA: " + quotaSconfitta);
	}

	@Override
	public void update(float quotaVittoria, float quotaPareggio, float quotaSconfitta) {
		this.quotaVittoria = quotaVittoria;
		this.quotaPareggio = quotaPareggio;
		this.quotaSconfitta = quotaSconfitta;
		display();
	}

	public QuoteDisplay(RomaSnai romaSnai) {
		this.romaSnai = romaSnai;
		romaSnai.registerObserver(this);
	}

}
