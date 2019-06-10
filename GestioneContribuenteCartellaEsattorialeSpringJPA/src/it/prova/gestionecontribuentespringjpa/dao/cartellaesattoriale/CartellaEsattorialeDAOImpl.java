package it.prova.gestionecontribuentespringjpa.dao.cartellaesattoriale;

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

import it.prova.gestionecontribuentespringjpa.model.CartellaEsattoriale;

@Component
public class CartellaEsattorialeDAOImpl implements CartellaEsattorialeDAO{

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<CartellaEsattoriale> list() {
		return entityManager.createQuery("from CartellaEsattoriale").getResultList();
	}

	@Override
	public CartellaEsattoriale get(long id) {
		CartellaEsattoriale result = (CartellaEsattoriale) entityManager.find(CartellaEsattoriale.class, id);
		return result;
	}

	@Override
	public void update(CartellaEsattoriale cartellaEsattorialeInstance) {
		cartellaEsattorialeInstance = entityManager.merge(cartellaEsattorialeInstance);		
	}

	@Override
	public void insert(CartellaEsattoriale cartellaEsattorialeInstance) {
		entityManager.persist(cartellaEsattorialeInstance);		
	}

	@Override
	public void delete(CartellaEsattoriale cartellaEsattorialeInstance) {
		entityManager.remove(entityManager.merge(cartellaEsattorialeInstance));		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CartellaEsattoriale> findByExample(CartellaEsattoriale cartellaEsattorialeInstance) {
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

		Criteria contribuenteCriteria = session.createCriteria(CartellaEsattoriale.class);
		Example contribuenteExample = Example.create(cartellaEsattorialeInstance).setPropertySelector(ps).enableLike(MatchMode.START);
		if (cartellaEsattorialeInstance.getContribuente() != null) {
			contribuenteCriteria.createCriteria("municipio").add(Example.create(cartellaEsattorialeInstance.getContribuente()));
		}

		contribuenteCriteria.add(contribuenteExample);
		return contribuenteCriteria.list();
	}

}
