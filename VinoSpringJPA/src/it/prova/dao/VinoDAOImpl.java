package it.prova.dao;

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

import it.prova.model.Vino;

@Component
public class VinoDAOImpl implements VinoDAO{
	
	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Vino> list() {
		return em.createQuery("from Vino").getResultList();
	}

	@Override
	public Vino get(Long id) {
		return em.find(Vino.class, id);
	}

	@Override
	public void update(Vino vinoInstance) {
		vinoInstance = em.merge(vinoInstance);
	}

	@Override
	public void insert(Vino vinoInstance) {
		em.persist(vinoInstance);
	}

	@Override
	public void delete(Vino vinoInstance) {
		em.remove(em.merge(vinoInstance));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Vino> findByExample(Vino vinoInstance) {
		Session session = (Session) em.getDelegate();

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

		Example vinoExample = Example.create(vinoInstance).setPropertySelector(ps);
		Criteria criteria = session.createCriteria(Vino.class).add(vinoExample);
		return criteria.list();
	}

	
}
