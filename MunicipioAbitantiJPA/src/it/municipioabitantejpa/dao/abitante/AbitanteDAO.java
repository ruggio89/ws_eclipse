package it.municipioabitantejpa.dao.abitante;

import java.util.List;

import it.municipioabitantejpa.dao.IBaseDAO;
import it.municipioabitantejpa.model.Abitante;

public interface AbitanteDAO extends IBaseDAO<Abitante> {
	
	public List<Abitante> findAllByCognome(String input) throws Exception;
	
	public List<Abitante> findAllByCodiceMunicipioIniziaCon(String input) throws Exception;
}
