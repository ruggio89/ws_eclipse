package it.prova.ebayspringjpa.service.categoria;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import it.prova.ebayspringjpa.dao.categoria.CategoriaDAO;
import it.prova.ebayspringjpa.model.Categoria;

@Component
public class CategoriaServiceImpl implements CategoriaService {

	@Autowired
	private CategoriaDAO categoriaDAO;

	@Transactional(readOnly = true)
	public List<Categoria> listAllCategorie() {
		return categoriaDAO.list();
	}

	@Transactional(readOnly = true)
	public Categoria caricaSingolaCategoria(Long id) {
		return categoriaDAO.get(id);
	}

	@Transactional
	public void aggiorna(Categoria categoriaInstance) {
		categoriaDAO.update(categoriaInstance);
	}

	@Transactional
	public void inserisciNuova(Categoria categoriaInstance) {
		categoriaDAO.insert(categoriaInstance);
	}

	@Transactional
	public void rimuovi(Categoria categoriaInstance) {
		categoriaDAO.delete(categoriaInstance);
	}

	@Transactional(readOnly = true)
	public List<Categoria> findByExample(Categoria example) {
		return categoriaDAO.findByExample(example);
	}

	@Transactional(readOnly = true)
	public Categoria caricaEager(Long id) {
		return categoriaDAO.getEager(id);
	}

}
