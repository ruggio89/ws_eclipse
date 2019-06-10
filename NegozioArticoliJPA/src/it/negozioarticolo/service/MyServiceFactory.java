package it.negozioarticolo.service;

import it.negozioarticolo.dao.MyDaoFactory;

public class MyServiceFactory {
	
	public static NegozioService getNegozioServiceInstance() {
		NegozioService negozioServiceInstance = new NegozioServiceImpl();
		negozioServiceInstance.setNegozioDAO(MyDaoFactory.getNegozioDAOInstance());
		return negozioServiceInstance;
	}
	
	public static ArticoloService getArticoloServiceInstance() {
		ArticoloService articoloServiceInstance = new ArticoloServiceImpl();
		articoloServiceInstance.setArticoloDAO(MyDaoFactory.getArticoloDAOInstance());
		return articoloServiceInstance;
	}
}
