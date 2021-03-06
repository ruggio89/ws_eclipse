package it.prova.dao;

import org.springframework.stereotype.Component;

import it.prova.model.MateriaPrima;

@Component
public class MateriaPrimaDaoImpl implements MateriaPrimaDao{

	@Override
	public MateriaPrima get(int id) {
		for (MateriaPrima materiaItem: DbMock.MATERIAPRIMA) {
			if(materiaItem.getId() == id)
				return materiaItem;
		}
		return null;
	}
	
}
