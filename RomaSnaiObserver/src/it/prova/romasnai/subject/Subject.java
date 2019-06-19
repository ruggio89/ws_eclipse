package it.prova.romasnai.subject;

import it.prova.romasnai.observer.Observer;

public interface Subject {
	
	public void registerObserver(Observer o);

	public void removeObserver(Observer o);

	public void notifyObservers();
}
