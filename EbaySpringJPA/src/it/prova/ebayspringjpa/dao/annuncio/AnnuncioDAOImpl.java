package it.prova.ebayspringjpa.dao.annuncio;

import java.util.List;
import java.util.Set;

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

import it.prova.ebayspringjpa.model.Annuncio;
import it.prova.ebayspringjpa.model.Categoria;
import it.prova.ebayspringjpa.model.Utente;

@Component
public class AnnuncioDAOImpl implements AnnuncioDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Annuncio> list() {
		return entityManager.createQuery("from Annuncio").getResultList();
	}

	@Override
	public Annuncio get(long id) {
		Annuncio result = (Annuncio) entityManager.find(Annuncio.class, id);
		return result;
	}

	@Override
	public void update(Annuncio annuncioInstance) {
		annuncioInstance = entityManager.merge(annuncioInstance);
	}

	@Override
	public void insert(Annuncio annuncioInstance) {
		entityManager.persist(annuncioInstance);
	}

	@Override
	public void delete(Annuncio annuncioInstance) {
		entityManager.remove(entityManager.merge(annuncioInstance));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Annuncio> findByExample(Annuncio annuncioInstance) {
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

		Example annuncioExample = Example.create(annuncioInstance).setPropertySelector(ps);
		Criteria criteria = session.createCriteria(Annuncio.class).add(annuncioExample);
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Annuncio> findByNomeECategoria(String testo, Set<Categoria> categorie) {
		Query q = entityManager.createQuery(
				"Select a from Annuncio a left join fetch a.categorie c where a.testoAnnuncio like :testoAnnuncio and a.apertoChiuso=1 and c in (:listaParam)");
		q.setParameter("testoAnnuncio", testo + "%");
		q.setParameter("listaParam", categorie);

		return q.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Annuncio> findByNomeCategoriaEPrezzo(String testo, Set<Categoria> categorie, double prezzo) {
		Query q = entityManager.createQuery(
				"Select distinct a from Annuncio a left join fetch a.categorie c where a.testoAnnuncio like :testoAnnuncio and c in (:listaParam) and a.prezzo between 0 and :prezzo and a.apertoChiuso=1");
		q.setParameter("testoAnnuncio", testo + "%");
		q.setParameter("listaParam", categorie);
		q.setParameter("prezzo", prezzo);

		return q.getResultList();
	}
	
	@Override
	public Annuncio getEagerCategorie(Long id) {
		Query q = entityManager.createQuery("Select a from Annuncio a join fetch a.categorie where a.id=:id");
		q.setParameter("id", id);
		
		return (Annuncio) q.getSingleResult();
	}

	@Override
	public Annuncio getEagerCategorieEUtente(Long id) {
		Query q = entityManager.createQuery("SELECT a from Annuncio a JOIN FETCH a.categorie JOIN FETCH a.utente WHERE a.id= :id");
		q.setParameter("id", id);
		return (Annuncio) q.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Annuncio> listEagerCategorie() {
		return entityManager.createQuery("Select a from Annuncio a join fetch a.categorie").getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Annuncio> findByUtenteECategoria(Utente utente) {
		Query q = entityManager.createQuery("SELECT a from Annuncio a join fetch a.utente join fetch a.categorie where a.utente= :utente");
		q.setParameter("utente", utente);
		
		return q.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Annuncio> findByCategoria(Utente utente) {
		Query q = entityManager.createQuery("SELECT a from Annuncio a join fetch a.categorie where a.utente= :utente");
		q.setParameter("utente", utente);
		
		return q.getResultList();
	}

}
