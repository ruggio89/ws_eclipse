package it.prova.gestionecontribuentespringjpa.dao.contribuente;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Example.PropertySelector;
import org.hibernate.criterion.MatchMode;
import org.hibernate.type.Type;
import org.springframework.stereotype.Component;

import it.prova.gestionecontribuentespringjpa.model.Contribuente;

@Component
public class ContribuenteDAOImpl implements ContribuenteDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Contribuente> list() {
		return entityManager.createQuery("from Contribuente").getResultList();
	}

	@Override
	public Contribuente get(long id) {
		Contribuente result = (Contribuente) entityManager.find(Contribuente.class, id);
		return result;
	}

	@Override
	public void update(Contribuente contribuenteInstance) {
		contribuenteInstance = entityManager.merge(contribuenteInstance);

	}

	@Override
	public void insert(Contribuente contribuenteInstance) {
		entityManager.persist(contribuenteInstance);
	}

	@Override
	public void delete(Contribuente contribuenteInstance) {
		entityManager.remove(entityManager.merge(contribuenteInstance));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Contribuente> findByExample(Contribuente contribuenteInstance) {
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

		Example contribuenteExample = Example.create(contribuenteInstance).setPropertySelector(ps)
				.enableLike(MatchMode.START);
		Criteria criteria = session.createCriteria(Contribuente.class).add(contribuenteExample);
		return criteria.list();
	}

}
