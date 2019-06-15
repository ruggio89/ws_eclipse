package it.prova.ebayspringjpa.service.categoria;

import java.util.List;

import it.prova.ebayspringjpa.model.Categoria;

public interface CategoriaService {
	
	public List<Categoria> listAllCategorie() ;

	public Categoria caricaSingolaCategoria(Long id);

	public void aggiorna(Categoria categoriaInstance);

	public void inserisciNuova(Categoria categoriaInstance);

	public void rimuovi(Categoria categoriaInstance);

	public List<Categoria> findByExample(Categoria example);
}
