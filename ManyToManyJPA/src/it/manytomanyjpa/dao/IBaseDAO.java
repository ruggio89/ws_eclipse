package it.manytomanyjpa.dao;

import java.util.List;

import javax.persistence.EntityManager;

public interface IBaseDAO<T> {

	public List<T> list() throws Exception;

	public T get(long id) throws Exception;

	public void update(T o) throws Exception;

	public void insert(T o) throws Exception;

	public void delete(T o) throws Exception;

	public List<T> findByExample(T o) throws Exception;

	// questo mi serve per l'injection
	public void setEntityManager(EntityManager entityManager);

}
