package it.municipioabitantejpa.service.abitante;

import java.util.List;

import it.municipioabitantejpa.dao.abitante.AbitanteDAO;
import it.municipioabitantejpa.model.Abitante;

public interface AbitanteService {
	
	public List<Abitante> listAllAbitanti() throws Exception;

	public Abitante caricaSingoloAbitante(Long id) throws Exception;

	public void aggiorna(Abitante abitanteInstance) throws Exception;

	public void inserisciNuovo(Abitante abitanteInstance) throws Exception;

	public void rimuovi(Abitante abitanteInstance) throws Exception;

	public List<Abitante> findByExample(Abitante example) throws Exception;
	
	//per injection
	public void setAbitanteDAO(AbitanteDAO abitanteDAO);
	
	public List<Abitante> trovaPerCognome(String input) throws Exception;
	
	public List<Abitante> trovaPerCodiceMunicipio(String input) throws Exception;

}
