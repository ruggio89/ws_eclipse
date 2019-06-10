package it.prova.service;

import it.prova.model.MateriaPrima;

public interface MateriaPrimaService {
	public void avviaLavorazione(MateriaPrima input);
	public MateriaPrima caricaMateriaPrima(int id);
}
