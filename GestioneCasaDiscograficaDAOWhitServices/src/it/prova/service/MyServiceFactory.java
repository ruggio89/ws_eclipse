package it.prova.service;

import it.prova.dao.AutoreDAOImpl;
import it.prova.dao.CasaDiscograficaDAOImpl;
import it.prova.dao.CdDAOImpl;

public class MyServiceFactory {
	
	public static CasaDiscograficaService geCasaDiscograficaServiceImpl() {
		CasaDiscograficaService casaDiscograficaService = new CasaDiscograficaServiceImpl();
		casaDiscograficaService.setCasaDiscograficaDao(new CasaDiscograficaDAOImpl());
		return casaDiscograficaService;
	}
	
	public static AutoreService getAutoreServiceImpl() {
		AutoreService autoreService = new AutoreServiceImpl();
		autoreService.setAutoreDao(new AutoreDAOImpl());
		return autoreService;
	}
	
	public static CdService getCdServiceImpl() {
		CdService cdService = new CdSreviceImpl();
		cdService.setCdDAO(new CdDAOImpl());
		return cdService;
	}
}
