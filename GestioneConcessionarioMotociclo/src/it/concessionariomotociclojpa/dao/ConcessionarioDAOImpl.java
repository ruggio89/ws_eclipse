package it.concessionariomotociclojpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.springframework.stereotype.Component;

import it.concessionariomotociclojpa.model.Concessionario;

@Component
public class ConcessionarioDAOImpl implements ConcessionarioDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Concessionario> list() {
		return entityManager.createQuery("from Concessionario").getResultList();
	}

	@Override
	public Concessionario get(Long id) {
		return entityManager.find(Concessionario.class, id);
	}

	@Override
	public void update(Concessionario o) {
		o = entityManager.merge(o);

	}

	@Override
	public void insert(Concessionario o) {
		entityManager.persist(o);

	}

	@Override
	public void delete(Concessionario o) {
		entityManager.remove(entityManager.merge(o));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Concessionario> findByExample(Concessionario o) {
		Session session = (Session) entityManager.getDelegate();
		Example concessionarioExample = Example.create(o).excludeZeroes();
		Criteria criteria = session.createCriteria(Concessionario.class).add(concessionarioExample);
		return criteria.list();
	}

	@Override
	public void refresh(Concessionario o) {
		entityManager.refresh(entityManager.merge(o));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Concessionario> findMotocicloCilindrataMaggiore1200PerDenominazione() {
		return entityManager.createQuery(
				"select c from Concessionario c join fetch c.motocicli m where m.cilindrata = 1200 order by c.denominazione")
				.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Concessionario> listPartitaIvaAMilanoPerHondaTra2012E2016() {
		return entityManager.createQuery(
				"select c from Concessionario c join c.motocicli m where c.citta = 'milano' and m.marca = 'honda' and m.annoImmatricolazione between 2012 and 2016 order by c.partitaIva")
				.getResultList();
	}

}
