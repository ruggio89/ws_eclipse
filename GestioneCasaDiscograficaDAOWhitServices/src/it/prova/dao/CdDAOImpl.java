package it.prova.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import id.prova.model.Autore;
import id.prova.model.CasaDiscografica;
import id.prova.model.Cd;

public class CdDAOImpl extends AbstractMySQLDAO implements CdDAO{

	@Override
	public List<Cd> list() throws Exception {
		if (isNotActive()) {
			return null;
		}

		ArrayList<Cd> arr = new ArrayList<Cd>();
		Cd cdTemp = null;

		try (Statement ps = connection.createStatement()) {

			ResultSet rs = ps.executeQuery("select * from cd c inner join autore a on a.idautore=c.autore_id;");

			while (rs.next()) {
				cdTemp = new Cd();
				cdTemp.setTitolo(rs.getString("TITOLO"));
				cdTemp.setGenere(rs.getString("GENERE"));
				cdTemp.setTraccia(rs.getString("TRACCIA"));
				cdTemp.setId(rs.getLong("idcd"));
				
				Autore autoreTemp = new Autore();
				autoreTemp.setNome(rs.getString("NOME"));
				autoreTemp.setCognome(rs.getString("COGNOME"));
				autoreTemp.setId(rs.getLong("idautore"));
				
				cdTemp.setAutore(autoreTemp);
				arr.add(cdTemp);

			}

		} catch (Exception e) {

			e.printStackTrace();
			throw e;

		}
		return arr;
	}

	@Override
	public Cd get(Long id) throws Exception {
		if (isNotActive() || id < 1) {
			return null;
		}

		Cd result = null;

		try (Statement ps = connection.createStatement()) {
			ResultSet rs = ps.executeQuery("SELECT * FROM gestionecasadiscografica.cd c inner join gestionecasadiscografica.autore a on c.autore_id=a.idautore where c.idcd=" + id);

			if (rs.next()) {
				result = new Cd();

				result.setTitolo(rs.getString("TITOLO"));
				result.setGenere(rs.getString("GENERE"));
				result.setTraccia(rs.getString("TRACCIA"));
				result.setId(rs.getLong("idcd"));
				
				Autore autoreTemp = new Autore();
				autoreTemp.setId(rs.getLong("a.idautore"));
				autoreTemp.setNome(rs.getString("a.nome"));
				autoreTemp.setCognome(rs.getString("a.cognome"));
				// imposto l'indirizzo trovato dentro il mio abitante di
				// partenza
				result.setAutore(autoreTemp);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;

		}
		return result;
	}

	@Override
	public int update(Cd input) throws Exception {
		if (isNotActive() || input == null) {
			return -1;
		}

		int result = 0;

		try (PreparedStatement ps = connection.prepareStatement(
				"UPDATE cd SET titolo=?, genere=?, traccia=?, autore_id=? where idcd=?;")) {
			ps.setString(1, input.getTitolo());
			ps.setString(2, input.getGenere());
			if (input.getAutore() == null) {
				ps.setNull(3, java.sql.Types.BIGINT);
			} else {
				ps.setLong(3, input.getAutore().getId());
			}
			ps.setLong(4, input.getId());
			result = ps.executeUpdate();
		} catch (Exception e) {

			e.printStackTrace();
			throw e;

		}
		return result;
	}

	@Override
	public int insert(Cd input) throws Exception {
		if (isNotActive() || input == null) {
			return -1;
		}

		int result = 0;

		try (PreparedStatement ps = connection.prepareStatement(
				"INSERT INTO cd (titolo, genere, traccia, autore_id) VALUES (?, ?, ?, ?);")) {
			ps.setString(1, input.getTitolo());
			ps.setString(2, input.getGenere());
			ps.setString(3, input.getTraccia());
			ps.setLong(4, input.getAutore().getId());
			
			result = ps.executeUpdate();
		} catch (Exception e) {

			e.printStackTrace();
			throw e;

		}
		return result;
	}

	@Override
	public int delete(Cd input) throws Exception {
		if (isNotActive() || input == null) {
			return -1;
		}

		int result = 0;

		try (PreparedStatement ps = connection.prepareStatement("DELETE FROM cd WHERE idcd=" + input.getId())) {
			result = ps.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();
			throw e;
		}
		return result;
	}

	@Override
	public List<Cd> findByExample(Cd input) throws Exception {
		if (isNotActive() || input == null) {
			return null;
		}

		ArrayList<Cd> result = new ArrayList<Cd>();
		Cd cdTemp = null;

		String query = "select * from cd where 1=1 ";
		if (input.getTitolo() != null && !input.getTitolo().equals("")) {
			query += " and titolo='" + input.getTitolo() + "' ";
		}
		if (input.getGenere() != null && !input.getGenere().equals("")) {
			query += " and genere='" + input.getGenere() + "' ";
		}
		if (input.getTraccia() != null && !input.getTraccia().equals("")) {
			query += " and traccia='" + input.getTraccia() + "' ";
		}
		if (input.getAutore() != null && !(input.getAutore().getId()<1)) {
			query += " and autore_id='" + input.getAutore().getId() + "' ";
		}


		// TODO: la data

		try (Statement ps = connection.createStatement()) {
			ResultSet rs = ps.executeQuery(query);

			while (rs.next()) {
				cdTemp = new Cd();
				cdTemp.setTitolo(rs.getString("titolo"));
				cdTemp.setGenere(rs.getString("genere"));
				cdTemp.setTraccia(rs.getString("traccia"));
				
				input.setId(rs.getLong("ID"));
				result.add(cdTemp);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;

		}
		return result;
	}

	@Override
	public void setConnection(Connection connection) {
		this.connection = connection;
		
	}

	@Override
	public List<Cd> findAllByGenere(String genere) throws Exception {
		if (genere == null) {
			return null;
		}

		Cd cdTemp = null;
		List<Cd> result = new ArrayList<Cd>();

		try (PreparedStatement ps = connection.prepareStatement(
				"select * from gestionecasadiscografica.cd c where c.genere=?")) {
			ps.setString(1, genere);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				cdTemp = new Cd();
				cdTemp.setTitolo(rs.getString("titolo"));
				cdTemp.setGenere(rs.getString("genere"));
				cdTemp.setTraccia(rs.getString("traccia"));

				result.add(cdTemp);

			}
		} catch (Exception e) {

			e.printStackTrace();
			throw e;

		}
		return result;
	}

	@Override
	public List<Cd> findAllByAutoreWhereTitoloIniziaCon(Autore autoreInput, String iniziale) throws Exception {
		if (autoreInput == null || iniziale.equals(null)) {
			return null;
		}

		Cd cdTemp = null;
		List<Cd> result = new ArrayList<Cd>();

		try (PreparedStatement ps = connection.prepareStatement(
				"select * from gestionecasadiscografica.cd c inner join gestionecasadiscografica.autore a on a.idautore=c.autore_id where c.titolo like ?")) {
			ps.setString(1, iniziale + "%");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				cdTemp = new Cd();
				cdTemp.setTitolo(rs.getString("titolo"));
				cdTemp.setGenere(rs.getString("genere"));
				cdTemp.setTraccia(rs.getString("traccia"));

				result.add(cdTemp);

			}
		} catch (Exception e) {

			e.printStackTrace();
			throw e;

		}
		return result;
	}

}
