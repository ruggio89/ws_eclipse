package it.prova.ebayspringjpa.dao.acquisto;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Example.PropertySelector;
import org.hibernate.type.Type;
import org.springframework.stereotype.Component;

import it.prova.ebayspringjpa.model.Acquisto;
import it.prova.ebayspringjpa.model.Utente;

@Component
public class AcquistoDAOImpl implements AcquistoDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Acquisto> list() {
		return entityManager.createQuery("from Ruolo").getResultList();
	}

	@Override
	public Acquisto get(long id) {
		Acquisto result = (Acquisto) entityManager.find(Acquisto.class, id);
		return result;
	}

	@Override
	public void update(Acquisto acquistoInstance) {
		acquistoInstance = entityManager.merge(acquistoInstance);
	}

	@Override
	public void insert(Acquisto acquistoInstance) {
		entityManager.persist(acquistoInstance);
	}

	@Override
	public void delete(Acquisto acquistoInstance) {
		entityManager.remove(entityManager.merge(acquistoInstance));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Acquisto> findByExample(Acquisto acquistoInstance) {
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

		Example acquistoExample = Example.create(acquistoInstance).setPropertySelector(ps);
		Criteria criteria = session.createCriteria(Acquisto.class).add(acquistoExample);
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Acquisto> findByUtente(Utente utente) {
		Query q = entityManager.createQuery("SELECT a from Acquisto a join fetch a.utente where a.utente= :utente");
		q.setParameter("utente", utente);
		
		return q.getResultList();
	}

}
