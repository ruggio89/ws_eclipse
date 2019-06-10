package it.municipioabitantejpa.dao.abitante;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Example.PropertySelector;
import org.hibernate.type.Type;

import it.municipioabitantejpa.model.Abitante;

public class AbitanteDAOImpl implements AbitanteDAO {

	private EntityManager entityManager;

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Abitante> list() throws Exception {
		return entityManager.createQuery("from Abitante").getResultList();
	}

	@Override
	public Abitante get(long id) throws Exception { 
		return entityManager.find(Abitante.class, id);
	}

	@Override
	public void update(Abitante abitanteInstance) throws Exception {
		if (abitanteInstance == null) {
			throw new Exception("Problema valore in input");
		}

		abitanteInstance = entityManager.merge(abitanteInstance);
	}

	@Override
	public void insert(Abitante abitanteInstance) throws Exception {
		if (abitanteInstance == null) {
			throw new Exception("Problema valore in input");
		}

		entityManager.persist(abitanteInstance);
	}

	@Override
	public void delete(Abitante abitanteInstance) throws Exception {
		if (abitanteInstance == null) {
			throw new Exception("Problema valore in input");
		}

		entityManager.remove(entityManager.merge(abitanteInstance));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Abitante> findByExample(Abitante abitanteInstance) throws Exception {
		Session session = (Session) entityManager.getDelegate();

		@SuppressWarnings("serial")
		PropertySelector ps = new PropertySelector() {
			@Override
			public boolean include(Object object, String propertyName, Type type) {
				if(object == null)
					return false;
				//String
				if(object instanceof String) 
					return StringUtils.isNotBlank((String) object);
				//Number
				if(object instanceof Integer)
					return ((Integer)object) != 0;
				return true;
			}
		};

		Criteria abitanteCriteria = session.createCriteria(Abitante.class);
		Example abitanteExample = Example.create(abitanteInstance).setPropertySelector(ps);
		if (abitanteInstance.getMunicipio() != null) {
			abitanteCriteria.createCriteria("municipio").add(Example.create(abitanteInstance.getMunicipio()));
		}

		abitanteCriteria.add(abitanteExample);
		return abitanteCriteria.list();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Abitante> findAllByCognome(String input) throws Exception {
		if(input == null) {
			throw new Exception("Inserire stringa correttemente");
		}
		Query query = entityManager.createQuery("SELECT a from Abitante a where a.cognome like :cog");
		query.setParameter("cog", input);
		
		return query.getResultList();
	
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Abitante> findAllByCodiceMunicipioIniziaCon(String input) throws Exception {
		if(input == null) {
			throw new Exception("Inserire stringa correttemente");
		}
		Query query = entityManager.createQuery("select a from Abitante a join a.municipio m where m.codice like :cod ");
		query.setParameter("cod", input + "%");
		
		return query.getResultList();
	}

}
