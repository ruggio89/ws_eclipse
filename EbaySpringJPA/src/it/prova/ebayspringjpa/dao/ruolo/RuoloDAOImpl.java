package it.prova.ebayspringjpa.dao.ruolo;

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

import it.prova.ebayspringjpa.model.Ruolo;

@Component
public class RuoloDAOImpl implements RuoloDAO{

	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Ruolo> list() {
		return entityManager.createQuery("from Ruolo").getResultList();
	}

	@Override
	public Ruolo get(long id) {
		Ruolo result = (Ruolo) entityManager.find(Ruolo.class, id);
		return result;
	}

	@Override
	public void update(Ruolo ruoloInstance) {
		ruoloInstance = entityManager.merge(ruoloInstance);		
	}

	@Override
	public void insert(Ruolo ruoloInstance) {
		entityManager.persist(ruoloInstance);		
	}

	@Override
	public void delete(Ruolo ruoloInstance) {
		entityManager.remove(entityManager.merge(ruoloInstance));		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Ruolo> findByExample(Ruolo ruoloInstance) {
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

		Example ruoloExample = Example.create(ruoloInstance).setPropertySelector(ps);
		Criteria criteria = session.createCriteria(Ruolo.class).add(ruoloExample);
		return criteria.list();
	}

}
