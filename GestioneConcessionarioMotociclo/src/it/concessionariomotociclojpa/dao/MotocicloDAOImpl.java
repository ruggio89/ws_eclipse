package it.concessionariomotociclojpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.springframework.stereotype.Component;

import it.concessionariomotociclojpa.model.Motociclo;

@Component
public class MotocicloDAOImpl implements MotocicloDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Motociclo> list() {
		return entityManager.createQuery("from Motociclo").getResultList();
	}

	@Override
	public Motociclo get(Long id) {
		return entityManager.find(Motociclo.class, id);
	}

	@Override
	public void update(Motociclo o) {
		o = entityManager.merge(o);
	}

	@Override
	public void insert(Motociclo o) {
		entityManager.persist(o);
	}

	@Override
	public void delete(Motociclo o) {
		entityManager.remove(entityManager.merge(o));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Motociclo> findByExample(Motociclo o) {
		Session session = (Session) entityManager.getDelegate();
		Example motocicloExample = Example.create(o).excludeZeroes();
		Criteria criteria = session.createCriteria(Motociclo.class).add(motocicloExample);
		return criteria.list();
	}

	@Override
	public void refresh(Motociclo o) {
		entityManager.refresh(entityManager.merge(o));
	}

	@Override
	public Long numeroMotocicliImmatricolazioneMinore2010InTorino() {
		return (Long) entityManager.createQuery(
				"select count(m) from Motociclo m join m.concessionario c where m.annoImmatricolazione < 2010 and c.citta = 'torino'")
				.getSingleResult();
	}

}
