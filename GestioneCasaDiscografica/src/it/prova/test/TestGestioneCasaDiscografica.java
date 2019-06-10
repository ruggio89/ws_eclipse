package it.prova.test;

import it.prova.dao.AutoreDao;
import it.prova.dao.CasaDiscograficaDao;
import it.prova.dao.CdDao;
import it.prova.model.Autore;
import it.prova.model.CasaDiscografica;
import it.prova.model.Cd;

public class TestGestioneCasaDiscografica {

	public static void main(String[] args) {
		
		System.out.println("Inizio....");
		CasaDiscograficaDao casaDiscograficaDao = new CasaDiscograficaDao();
		AutoreDao autoreDao = new AutoreDao();
		CdDao cdDao = new CdDao();
		
		for (CasaDiscografica casaDiscoItem : casaDiscograficaDao.list()) {
			System.out.println(casaDiscoItem);
		}
		
		for (Autore autoreItem : autoreDao.list()) {
			System.out.println(autoreItem);
		}
		
		for (Cd cdItem : cdDao.list()) {
			System.out.println(cdItem);
		}
		
//		CasaDiscografica casaDisco1 = new CasaDiscografica();
//		casaDisco1.setRagioneSociale("Virgin");
//		casaDisco1.setPartitaIva("1110938");
		
//		CasaDiscografica casaDisco2 = new CasaDiscografica();
//		casaDisco2.setRagioneSociale("Sony spa");
//		casaDisco2.setPartitaIva("555677");
		
		
		
		
//		casaDiscograficaDao.insert(casaDisco1);
//		casaDiscograficaDao.insert(casaDisco2);
		
		
//		Autore autore1 = new Autore("Tiziano", "Ferro", casaDiscograficaDao.selectById(5L));
//		Autore autore2 = new Autore("Ruggero", "Rossi", casaDiscograficaDao.selectById(6L));
		
//		autoreDao.insert(autore1);
//		autoreDao.insert(autore2);
		
//		autoreDao.delete(autoreDao.selectByIdWithJoin(2L));
		
//		Cd cd1 = new Cd("Non me lo so spiegare", "Pop", "Ciao", autoreDao.selectByIdWithJoin(3L));
//		Cd cd2 = new Cd("Ho comprato un pc", "Rock", "Il mio pc", autoreDao.selectByIdWithJoin(4L));
		
//		cdDao.insert(cd1);
//		cdDao.insert(cd2);
		
//		System.out.println(cdDao.delete(cdDao.selectByIdWithJoin(2L)));
		
		
//		cd1.setTitolo("Cosa ho che non va?");
//		cdDao.update(cd1);
	}

}
