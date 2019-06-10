package it.gestioneordini.dao;

import it.gestioneordini.model.Articolo;
import it.gestioneordini.model.Categoria;

public interface ArticoloDAO extends IBaseDAO<Articolo>{
	
	public int findSommaPrezziDegliArticoliDiUnaCategoria(Categoria input) throws Exception;
	
}
