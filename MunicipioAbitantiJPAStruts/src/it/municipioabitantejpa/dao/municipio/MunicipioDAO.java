package it.municipioabitantejpa.dao.municipio;

import java.util.List;

import it.municipioabitantejpa.dao.IBaseDAO;
import it.municipioabitantejpa.model.Municipio;

public interface MunicipioDAO extends IBaseDAO<Municipio> {

	public List<Municipio> findAllByAbitantiMinorenni() throws Exception;

	public List<Municipio> findAllByDescrizioneIniziaCon(String iniziale) throws Exception;

}
