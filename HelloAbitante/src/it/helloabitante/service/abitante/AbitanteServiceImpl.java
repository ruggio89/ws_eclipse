package it.helloabitante.service.abitante;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import it.helloabitante.dao.MyConnection;
import it.helloabitante.dao.abitante.AbitanteDAO;
import it.helloabitante.model.Abitante;

public class AbitanteServiceImpl implements AbitanteService {
	
	private AbitanteDAO abitanteDAO;
	
	public void setAbitanteDAO(AbitanteDAO abitanteDAO) {
		this.abitanteDAO = abitanteDAO;
	}

	@Override
	public List<Abitante> cercaPerNomeECognome(String nome, String cognome)  {
		//abitanteDAO.setConnection(MyConnection.getConnection());
		return abitanteDAO.findByNomeAndCognome(nome, cognome);
	}

	@Override
	public List<Abitante> listaAbitanti() throws Exception {
		List<Abitante> result = new ArrayList<>();
		try(Connection connection = MyConnection.getConnection()) {

			// inietto la connection nel dao
			abitanteDAO.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = abitanteDAO.list();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} 
		return result;
	}

	@Override
	public Abitante caricaAbitanteId(Long id) throws Exception {
		Abitante result = null;
		try(Connection connection = MyConnection.getConnection()) {

			// inietto la connection nel dao
			abitanteDAO.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = abitanteDAO.get(id);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} 
		return result;
	}

	@Override
	public int aggiornaAbitante(Abitante input) throws Exception {
		int result = 0;
		try(Connection connection = MyConnection.getConnection()) {

			// inietto la connection nel dao
			abitanteDAO.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = abitanteDAO.update(input);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} 
		return result;
	}

	@Override
	public int inserisciAbitante(Abitante input) throws Exception {
		int result = 0;
		try(Connection connection = MyConnection.getConnection()) {

			// inietto la connection nel dao
			abitanteDAO.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = abitanteDAO.insert(input);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} 
		return result;
	}

	@Override
	public int rimuoviAbitante(Abitante input) throws Exception {
		int result = 0;
		try(Connection connection = MyConnection.getConnection()) {

			// inietto la connection nel dao
			abitanteDAO.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = abitanteDAO.delete(input);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	@Override
	public List<Abitante> findByExample(Abitante input) throws Exception {
		List<Abitante> result = new ArrayList<>();
		try(Connection connection = MyConnection.getConnection()) {

			// inietto la connection nel dao
			abitanteDAO.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = abitanteDAO.findByExample(input);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} 
		return result;
	}

}
