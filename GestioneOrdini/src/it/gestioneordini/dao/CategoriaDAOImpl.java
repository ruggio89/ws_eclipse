package it.gestioneordini.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;

import it.gestioneordini.model.Categoria;
import it.gestioneordini.model.Ordine;

public class CategoriaDAOImpl implements CategoriaDAO{
	
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Categoria> list() throws Exception {
		return entityManager.createQuery("from Categoria").getResultList();
	}

	@Override
	public Categoria get(long id) throws Exception {
		return entityManager.find(Categoria.class, id);
	}

	@Override
	public void update(Categoria o) throws Exception {
		if (o == null) {
			throw new Exception("Problema valore in input");
		}
		o = entityManager.merge(o);
	}

	@Override
	public void insert(Categoria o) throws Exception {
		if (o == null) {
			throw new Exception("Problema valore in input");
		}

		entityManager.persist(o);
	}

	@Override
	public void delete(Categoria o) throws Exception {
		if (o == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.remove(entityManager.merge(o));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Categoria> findByExample(Categoria o) throws Exception {
		if (o == null) {
			throw new Exception("Problema valore in input");
		}

		Session session = (Session) entityManager.getDelegate();
		Example categoriaExample = Example.create(o).excludeZeroes();
		Criteria criteria = session.createCriteria(Categoria.class).add(categoriaExample);
		return criteria.list();
	}

	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Categoria> findCategoriaOfArticoliByOrdine(Ordine input) throws Exception {
		if(input == null) {
			throw new Exception("Problema valore input");
		}
		Query query = entityManager.createQuery("select c from Categoria c join fetch c.articoli a join fetch a.ordine o where o like :ord group by c");
		query.setParameter("ord", input);
		
		return query.getResultList();
	}

}
