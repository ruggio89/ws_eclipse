package it.prova.ebayspringjpa.dao.categoria;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Example.PropertySelector;
import org.hibernate.type.Type;
import org.springframework.stereotype.Component;

import it.prova.ebayspringjpa.model.Categoria;

@Component
public class CategoriaDAOImpl implements CategoriaDAO{

	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Categoria> list() {
		return entityManager.createQuery("from Categoria").getResultList();
	}

	@Override
	public Categoria get(long id) {
		Categoria result = (Categoria) entityManager.find(Categoria.class, id);
		return result;
	}

	@Override
	public void update(Categoria categoriaInstance) {
		categoriaInstance = entityManager.merge(categoriaInstance);		
	}

	@Override
	public void insert(Categoria categoriaInstance) {
		entityManager.persist(categoriaInstance);			
	}

	@Override
	public void delete(Categoria categoriaInstance) {
		entityManager.remove(entityManager.merge(categoriaInstance));		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Categoria> findByExample(Categoria categoriaInstance) {
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

		Example categoriaExample = Example.create(categoriaInstance).setPropertySelector(ps);
		Criteria criteria = session.createCriteria(Categoria.class).add(categoriaExample);
		return criteria.list();
	}

}
