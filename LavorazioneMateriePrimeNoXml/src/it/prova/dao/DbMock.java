package it.prova.dao;

import java.util.ArrayList;
import java.util.List;

import it.prova.model.MateriaPrima;
import it.prova.model.StatoMateria;

public class DbMock {

	public static final List<MateriaPrima> MATERIEPRIME = new ArrayList<MateriaPrima>();

	static {
		MateriaPrima cemento = new MateriaPrima(1, "Cemento", StatoMateria.IN_INSERIMENTO);
		MateriaPrima legno = new MateriaPrima(2, "legno", StatoMateria.IN_INSERIMENTO);
		MateriaPrima alluminio = new MateriaPrima(3, "alluminio", StatoMateria.IN_INSERIMENTO);
		MATERIEPRIME.add(cemento);
		MATERIEPRIME.add(legno);
		MATERIEPRIME.add(alluminio);

	}

}
