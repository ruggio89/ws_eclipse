package it.prova.ebayspringjpa.service.categoria;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.prova.ebayspringjpa.dao.categoria.CategoriaDAO;
import it.prova.ebayspringjpa.model.Categoria;

@Component
public class CategoriaServiceImpl implements CategoriaService {

	@Autowired
	private CategoriaDAO categoriaDAO;

	@Override
	public List<Categoria> listAllCategorie() {
		return categoriaDAO.list();
	}

	@Override
	public Categoria caricaSingolaCategoria(Long id) {
		return categoriaDAO.get(id);
	}

	@Override
	public void aggiorna(Categoria categoriaInstance) {
		categoriaDAO.update(categoriaInstance);
	}

	@Override
	public void inserisciNuova(Categoria categoriaInstance) {
		categoriaDAO.insert(categoriaInstance);
	}

	@Override
	public void rimuovi(Categoria categoriaInstance) {
		categoriaDAO.delete(categoriaInstance);
	}

	@Override
	public List<Categoria> findByExample(Categoria example) {
		return categoriaDAO.findByExample(example);
	}

}
