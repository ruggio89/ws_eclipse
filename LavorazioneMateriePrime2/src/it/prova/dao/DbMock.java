package it.prova.dao;

import java.util.ArrayList;
import java.util.List;

import it.prova.model.MateriaPrima;
import it.prova.model.StatoMateria;

public class DbMock {

	public static final List<MateriaPrima> MATERIAPRIMA = new ArrayList<MateriaPrima>();
	
	static {
		MateriaPrima materiaPrima1 = new MateriaPrima(1, "Cemento", StatoMateria.IN_INSERIMENTO);
		MATERIAPRIMA.add(materiaPrima1);
	}
	
}
