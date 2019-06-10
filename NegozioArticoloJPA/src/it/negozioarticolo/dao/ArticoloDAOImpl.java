package it.negozioarticolo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Example.PropertySelector;
import org.hibernate.type.Type;

import it.negozioarticolo.model.Articolo;

public class ArticoloDAOImpl implements ArticoloDAO {
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Articolo> list() throws Exception {
		return entityManager.createQuery("from Articolo").getResultList();
	}

	@Override
	public Articolo get(long id) throws Exception {
		return entityManager.find(Articolo.class, id);
	}

	@Override
	public void update(Articolo o) throws Exception {
		if (o == null) {
			throw new Exception("Problema valore in input");
		}

		o = entityManager.merge(o);

	}

	@Override
	public void insert(Articolo o) throws Exception {
		if (o == null) {
			throw new Exception("Problema valore in input");
		}

		entityManager.persist(o);

	}

	@Override
	public void delete(Articolo o) throws Exception {
		if (o == null) {
			throw new Exception("Problema valore in input");
		}

		entityManager.remove(entityManager.merge(o));

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Articolo> findByExample(Articolo o) throws Exception {
		Session session = (Session) entityManager.getDelegate();

		@SuppressWarnings("serial")
		PropertySelector ps = new PropertySelector() {
			@Override
			public boolean include(Object object, String propertyName, Type type) {
				if (object == null)
					return false;
				// String
				if (object instanceof String)
					return StringUtils.isNotBlank((String) object);
				// Number
				if (object instanceof Integer)
					return ((Integer) object) != 0;
				return true;
			}
		};

		Criteria abitanteCriteria = session.createCriteria(Articolo.class);
		Example articoloExample = Example.create(o).setPropertySelector(ps);
		if (o.getNegozio() != null) {
			abitanteCriteria.createCriteria("municipio").add(Example.create(o.getNegozio()));
		}

		abitanteCriteria.add(articoloExample);
		return abitanteCriteria.list();
	}

	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;

	}

}
