package it.gestioneordini.dao;

import java.util.List;

import it.gestioneordini.model.Categoria;
import it.gestioneordini.model.Ordine;

public interface OrdineDAO extends IBaseDAO<Ordine>{
	
	public List<Ordine> findOrdiniByCategoria(Categoria input) throws Exception;
	
}
