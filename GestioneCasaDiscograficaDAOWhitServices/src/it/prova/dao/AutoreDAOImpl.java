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

public class AutoreDAOImpl extends AbstractMySQLDAO implements AutoreDAO {

	@Override
	public void setConnection(Connection connection) {
		this.connection = connection;

	}

	@Override
	public List<Autore> list() throws Exception {
		if (isNotActive()) {
			return null;
		}

		ArrayList<Autore> arr = new ArrayList<Autore>();
		Autore autoreTemp = null;

		try (Statement ps = connection.createStatement()) {

			ResultSet rs = ps.executeQuery(
					"select * from autore a inner join casadiscografica c on c.idcasadiscografica=a.casadiscografica_id;");

			while (rs.next()) {
				autoreTemp = new Autore();
				autoreTemp.setNome(rs.getString("NOME"));
				autoreTemp.setCognome(rs.getString("COGNOME"));
				autoreTemp.setId(rs.getLong("idautore"));

				CasaDiscografica casaDiscograficaTemp = new CasaDiscografica();
				casaDiscograficaTemp.setRagioneSociale(rs.getString("ragionesociale"));
				casaDiscograficaTemp.setPartitaIva(rs.getString("partitaiva"));
				casaDiscograficaTemp.setId(rs.getLong("idcasadiscografica"));

				arr.add(autoreTemp);

			}

		} catch (Exception e) {

			e.printStackTrace();
			throw e;

		}
		return arr;
	}

	@Override
	public Autore get(Long id) throws Exception {
		if (isNotActive() || id < 1) {
			return null;
		}

		Autore result = null;

		try (Statement ps = connection.createStatement()) {
			ResultSet rs = ps.executeQuery(
					"SELECT * FROM gestionecasadiscografica.autore a left outer join gestionecasadiscografica.casadiscografica c on a.casadiscografica_id=c.idcasadiscografica where a.idautore="
							+ id);

			if (rs.next()) {
				result = new Autore();

				result.setId(rs.getLong("a.idautore"));
				result.setNome(rs.getString("a.nome"));
				result.setCognome(rs.getString("a.cognome"));

				CasaDiscografica casaDiscograficaTemp = new CasaDiscografica();
				casaDiscograficaTemp.setId(rs.getLong("idcasadiscografica"));
				casaDiscograficaTemp.setRagioneSociale(rs.getString("ragionesociale"));
				casaDiscograficaTemp.setPartitaIva(rs.getString("partitaiva"));
				// imposto l'indirizzo trovato dentro il mio abitante di
				// partenza
				result.setCasaDiscografica(casaDiscograficaTemp);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;

		}
		return result;
	}

	@Override
	public int update(Autore input) throws Exception {
		if (isNotActive() || input == null) {
			return -1;
		}

		int result = 0;

		try (PreparedStatement ps = connection
				.prepareStatement("UPDATE autore SET nome=?, cognome=?, casadiscografica_id=? where idautore=?;")) {
			ps.setString(1, input.getNome());
			ps.setString(2, input.getCognome());
			if (input.getCasaDiscografica() == null) {
				ps.setNull(3, java.sql.Types.BIGINT);
			} else {
				ps.setLong(3, input.getCasaDiscografica().getId());
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
	public int insert(Autore input) throws Exception {
		if (isNotActive() || input == null) {
			return -1;
		}

		int result = 0;
		
		try (PreparedStatement ps = connection
				.prepareStatement("INSERT INTO autore (nome, cognome, casadiscografica_id) VALUES (?, ?, ?);")) {
			ps.setString(1, input.getNome());
			ps.setString(2, input.getCognome());
			ps.setLong(3, input.getCasaDiscografica().getId());

			result = ps.executeUpdate();
			
		} catch (Exception e) {

			e.printStackTrace();
			throw e;

		}
		
		return result;
	}

	@Override
	public int delete(Autore input) throws Exception {
		if (isNotActive() || input == null) {
			return -1;
		}

		int result = 0;

		try (PreparedStatement ps = connection.prepareStatement("DELETE FROM autore WHERE idautore=" + input.getId())) {
			result = ps.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();
			throw e;
		}
		return result;
	}

	@Override
	public List<Autore> findByExample(Autore input) throws Exception {
		if (isNotActive() || input == null) {
			return null;
		}

		ArrayList<Autore> result = new ArrayList<Autore>();
		Autore autoreTemp = null;

		String query = "select * from autore where 1=1 ";
		if (input.getNome() != null && !input.getNome().equals("")) {
			query += " and nome='" + input.getNome() + "' ";
		}
		if (input.getCognome() != null && !input.getCognome().equals("")) {
			query += " and cognome='" + input.getCognome() + "' ";
		}
		if (input.getCasaDiscografica() != null && !(input.getCasaDiscografica().getId() < 1)) {
			query += " and casadiscografica_id='" + input.getCasaDiscografica().getId() + "' ";
		}

		// TODO: la data

		try (Statement ps = connection.createStatement()) {
			ResultSet rs = ps.executeQuery(query);

			while (rs.next()) {
				autoreTemp = new Autore();
				autoreTemp.setNome(rs.getString("nome"));
				autoreTemp.setCognome(rs.getString("cognome"));

				input.setId(rs.getLong("ID"));
				result.add(autoreTemp);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;

		}
		return result;
	}

	@Override
	public void populateCds(Autore input) throws Exception {
		if (input == null || input.getId() < 1) {
			return;
		}

		try (PreparedStatement ps = connection.prepareStatement(
				"SELECT * FROM gestionecasadiscografica.cd c inner join gestionecasadiscografica.autore a on a.idautore=c.autore_id where a.idautore=?; ")) {

			ps.setLong(1, input.getId());

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Cd cdTemp = new Cd();
				cdTemp.setId(rs.getLong("c.idcd"));
				cdTemp.setTitolo(rs.getString("c.titolo"));
				cdTemp.setGenere(rs.getString("c.genere"));
				cdTemp.setTraccia(rs.getString("c.traccia"));
				cdTemp.setAutore(input);

				input.getListaCd().add(cdTemp);
			}

		} catch (Exception e) {

			e.printStackTrace();
			throw e;
		}

	}

	@Override
	public List<Autore> findAllByCasaDiscografica(CasaDiscografica input) throws Exception {
		if (input == null) {
			return null;
		}

		Autore autoreTemp = null;
		List<Autore> result = new ArrayList<Autore>();

		try (PreparedStatement ps = connection.prepareStatement(
				"select * from gestionecasadiscografica.autore a inner join gestionecasadiscografica.casadiscografica c on c.idcasadiscografica=a.casadiscografica_id where c.idcasadiscografica=?")) {
			ps.setLong(1, input.getId());

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				autoreTemp = new Autore();
				autoreTemp.setNome(rs.getString("nome"));
				autoreTemp.setCognome(rs.getString("cognome"));
				autoreTemp.setId(rs.getLong("idautore"));

				result.add(autoreTemp);

			}
		} catch (Exception e) {

			e.printStackTrace();
			throw e;

		}
		return result;
	}

	@Override
	public List<Autore> findBbyCdWhereNTracceGreaterThan(int nTracceInput) throws Exception {
		if (nTracceInput < 1) {
			return null;
		}

		Autore autoreTemp = null;
		List<Autore> result = new ArrayList<Autore>();

		try (PreparedStatement ps = connection.prepareStatement(
				"select * from gestionecasadiscografica.autore a inner join gestionecasadiscografica.cd c on c.autore_id=a.idautore where c.traccia > ?")) {
			ps.setLong(1, nTracceInput);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				autoreTemp = new Autore();
				autoreTemp.setNome(rs.getString("nome"));
				autoreTemp.setCognome(rs.getString("cognome"));
				autoreTemp.setId(rs.getLong("idautore"));

				result.add(autoreTemp);

			}
		} catch (Exception e) {

			e.printStackTrace();
			throw e;

		}
		return result;
	}

}
