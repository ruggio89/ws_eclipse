package it.gestioneordini.dao;

import java.util.List;

import it.gestioneordini.model.Categoria;
import it.gestioneordini.model.Ordine;

public interface CategoriaDAO extends IBaseDAO<Categoria>{
	
	public List<Categoria> findCategoriaOfArticoliByOrdine(Ordine input) throws Exception;
	
}
