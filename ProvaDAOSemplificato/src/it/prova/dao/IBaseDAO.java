package it.prova.dao;

import java.util.List;

public interface IBaseDAO<T> {

	public List<T> list() throws Exception;

	public T get(Long id) throws Exception;

	public int update(T input) throws Exception;

	public int insert(T input) throws Exception;

	public int delete(T input) throws Exception;

	public List<T> findByExample(T input) throws Exception;

}
