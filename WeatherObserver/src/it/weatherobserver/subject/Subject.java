package it.weatherobserver.subject;

import it.weatherobserver.observer.Observer;

public interface Subject {
	public void registerObserver(Observer o);

	public void removeObserver(Observer o);

	public void notifyObservers();
}
