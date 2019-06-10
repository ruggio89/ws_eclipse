package it.prova.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import id.prova.connection.MyConnection;
import id.prova.model.Autore;
import id.prova.model.CasaDiscografica;
import it.prova.dao.CasaDiscograficaDAO;
import it.prova.dao.Constants;
import it.prova.dao.AbstractMySQLDAO;
import it.prova.dao.AutoreDAO;


public class CasaDiscograficaServiceImpl extends AbstractMySQLDAO implements CasaDiscograficaService {
	
	private CasaDiscograficaDAO casaDiscograficaDao;
	private AutoreDAO autoreDao;

	@Override
	public void setCasaDiscograficaDao(CasaDiscograficaDAO casaDiscograficaDao) {
		this.casaDiscograficaDao = casaDiscograficaDao;
		
	}

	@Override
	public List<CasaDiscografica> listAllCasaDiscografica() throws Exception {
		List<CasaDiscografica> result = new ArrayList<>();
		try(Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			casaDiscograficaDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = casaDiscograficaDao.list();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} 
		return result;
	}
	

	@Override
	public CasaDiscografica findCasaDiscograficaById(Long idInput) throws Exception {
		CasaDiscografica result = null;
		try(Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			casaDiscograficaDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = casaDiscograficaDao.get(idInput);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} 
		return result;
	}
	
	@Override
	public int inserisciNuovaCasaDiscografica(CasaDiscografica input) throws Exception {
		int result = 0;
		
		try(Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {
			
			// inietto la connection nel dao
			casaDiscograficaDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = casaDiscograficaDao.insert(input);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} 
		return result;
	}

	@Override
	public int aggiornaCasaDiscografica(CasaDiscografica input) throws Exception {
		int result = 0;
		try(Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			casaDiscograficaDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = casaDiscograficaDao.update(input);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} 
		return result;
	}

	@Override
	public int rimuoviCasaDiscografica(CasaDiscografica input) throws Exception {
		int result = 0;
		try(Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			casaDiscograficaDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = casaDiscograficaDao.delete(input);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	@Override
	public List<CasaDiscografica> findByExample(CasaDiscografica input) throws Exception {
		List<CasaDiscografica> result = new ArrayList<>();
		try(Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			casaDiscograficaDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = casaDiscograficaDao.findByExample(input);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} 
		return result;
	}

	@Override
	public void aggiungiAutoreACasaDiscografica(CasaDiscografica input) throws Exception {
		try(Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			casaDiscograficaDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			casaDiscograficaDao.populateAutore(input);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
	}

	@Override
	public List<CasaDiscografica> trovaAutoreInCaseDiscografiche(Autore input) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CasaDiscografica> trovaAutoreConCognomeCheIniziaPer(String iniziale) throws Exception {
		List<CasaDiscografica> result = new ArrayList<>();
		try(Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			casaDiscograficaDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = casaDiscograficaDao.findAllByAutoreWhereCognomeIniziaCon(iniziale);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} 
		return result;
	}

	@Override
	public List<CasaDiscografica> trovaTuttiICdPerGenere(String genere) throws Exception {
		List<CasaDiscografica> result = new ArrayList<>();
		try(Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			casaDiscograficaDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = casaDiscograficaDao.findAllByCdWhereGenereEqual(genere);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} 
		return result;
	}

	@Override
	public int aggiornaDueVolte(CasaDiscografica input, CasaDiscografica input2) throws Exception {
		int result = 0;
		try(Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {
			connection.setAutoCommit(false);
			// inietto la connection nel dao
			casaDiscograficaDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = casaDiscograficaDao.update(input);
			result = casaDiscograficaDao.update(input2);
			connection.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} 
		return result;
	}

	

	
}
