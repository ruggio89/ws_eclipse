package it.prova.dao;

import org.springframework.stereotype.Component;

import it.prova.model.MateriaPrima;

@Component
public class MateriaPrimaDAOImpl implements MateriaPrimaDAO {

	@Override
	public MateriaPrima getId(int id) {

		for (MateriaPrima item : DbMock.MATERIEPRIME) {
			if (item.getId() == id)
				return item;
		}
		return null;
	}
	
}
