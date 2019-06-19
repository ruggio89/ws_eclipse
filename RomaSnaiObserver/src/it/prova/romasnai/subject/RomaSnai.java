package it.prova.romasnai.subject;

import java.util.ArrayList;

import it.prova.romasnai.observer.Observer;

public class RomaSnai implements Subject {

	private ArrayList<Observer> observers;
	private float quotaVittoria;
	private float quotaPareggio;
	private float quotaSconfitta;

	public RomaSnai() {
		observers = new ArrayList<>();
	}

	public ArrayList<Observer> getObservers() {
		return observers;
	}

	public void setObservers(ArrayList<Observer> observers) {
		this.observers = observers;
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
	public void registerObserver(Observer o) {
		observers.add(o);
	}

	@Override
	public void removeObserver(Observer o) {
		int i = observers.indexOf(o);
		if (i >= 0) {
			observers.remove(i);
		}
	}

	@Override
	public void notifyObservers() {
		for (Observer observerItem : observers) {
			observerItem.update(quotaVittoria, quotaPareggio, quotaSconfitta);
		}
	}

	public void quoteCambiate() {
		notifyObservers();
	}

	public void setQuoteRoma(float quotaVittoria, float quotaPareggio, float quotaSconfitta) {
		this.quotaVittoria = quotaVittoria;
		this.quotaPareggio = quotaPareggio;
		this.quotaSconfitta = quotaSconfitta;
		quoteCambiate();
	}

}
