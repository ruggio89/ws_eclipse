package it.negozioarticolo.dao;

public class MyDaoFactory {

	public static NegozioDAO getNegozioDAOInstance() {
		return new NegozioDAOImpl();
	}
	
	public static ArticoloDAO getArticoloDAOInstance() {
		return new ArticoloDAOImpl();
	}
	
}
