package it.prova.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import id.prova.connection.MyConnection;
import id.prova.model.Autore;
import id.prova.model.Cd;
import it.prova.dao.CdDAO;
import it.prova.dao.Constants;

public class CdSreviceImpl implements CdService {
	
	private CdDAO cdDao;
	
	@Override
	public void setCdDAO(CdDAO cdDao) {
		this.cdDao = cdDao;
		
	}

	@Override
	public List<Cd> listAllCd() throws Exception {
		List<Cd> result = new ArrayList<>();
		try(Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			cdDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = cdDao.list();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} 
		return result;
	}

	@Override
	public Cd findCdById(Long idInput) throws Exception {
		Cd result = null;
		try(Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			cdDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = cdDao.get(idInput);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} 
		return result;
	}

	@Override
	public int aggiornaCd(Cd input) throws Exception {
		int result = 0;
		try(Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			cdDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = cdDao.update(input);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} 
		return result;
	}

	@Override
	public int inserisciNuovoCd(Cd input) throws Exception {
		int result = 0;
		try(Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			cdDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = cdDao.insert(input);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} 
		return result;
	}

	@Override
	public int rimuoviCd(Cd input) throws Exception {
		int result = 0;
		try(Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			cdDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = cdDao.delete(input);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	@Override
	public List<Cd> findByExample(Cd input) throws Exception {
		List<Cd> result = new ArrayList<>();
		try(Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			cdDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = cdDao.findByExample(input);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} 
		return result;
	}

	@Override
	public List<Cd> trovaCdDaGenere(String genere) throws Exception {
		List<Cd> result = new ArrayList<>();
		try(Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			cdDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = cdDao.findAllByGenere(genere);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} 
		return result;
	}

	@Override
	public List<Cd> trovaTuttiICdDaAutoreDoveTitoloIniziaCon(Autore autoreInput, String iniziale) throws Exception {
		List<Cd> result = new ArrayList<>();
		try(Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			cdDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = cdDao.findAllByAutoreWhereTitoloIniziaCon(autoreInput, iniziale);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} 
		return result;
	}

}
