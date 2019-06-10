package it.prova.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import id.prova.model.Autore;
import id.prova.model.CasaDiscografica;

public class CasaDiscograficaDAOImpl extends AbstractMySQLDAO implements CasaDiscograficaDAO {

	@Override
	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	@Override
	public int delete(CasaDiscografica casaDiscograficaInput) throws Exception {

		if (isNotActive() || casaDiscograficaInput == null) {
			return -1;
		}

		int result = 0;

		try (PreparedStatement ps = connection
				.prepareStatement("DELETE FROM casadiscografica WHERE idcasadiscografica=?")) {
			ps.setLong(1, casaDiscograficaInput.getId());
			result = ps.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();
			throw e;
		}
		return result;
	}

	@Override
	public CasaDiscografica get(Long id) throws Exception {
		if (isNotActive() || id < 1) {
			return null;
		}

		CasaDiscografica userTemp = null;

		try (Statement ps = connection.createStatement()) {
			ResultSet rs = ps.executeQuery("select * from casadiscografica where idcasadiscografica=" + id);

			if (rs.next()) {
				userTemp = new CasaDiscografica();
				userTemp.setId(rs.getLong("idcasadiscografica"));
				userTemp.setRagioneSociale(rs.getString("ragionesociale"));
				userTemp.setPartitaIva(rs.getString("partitaiva"));
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;

		}
		return userTemp;
	}

	@Override
	public int update(CasaDiscografica input) throws Exception {
		if (isNotActive() || input == null) {
			return -1;
		}

		int result = 0;

		try (PreparedStatement ps = connection.prepareStatement(
				"UPDATE casadiscografica SET ragionesociale=?, partitaiva=? where idcasadiscografica=?;")) {
			ps.setString(1, input.getRagioneSociale());
			ps.setString(2, input.getPartitaIva());
			ps.setLong(3, input.getId());
			result = ps.executeUpdate();
		} catch (Exception e) {

			e.printStackTrace();
			throw e;

		}
		return result;
	}

	@Override
	public int insert(CasaDiscografica input) throws Exception {
		if (isNotActive() || input == null) {
			return -1;
		}

		int result = 0;

		try (PreparedStatement ps = connection
				.prepareStatement("INSERT INTO casadiscografica (ragionesociale, partitaiva) VALUES (?, ?);")) {
			ps.setString(1, input.getRagioneSociale());
			ps.setString(2, input.getPartitaIva());
			result = ps.executeUpdate();
		
		} catch (Exception e) {

			e.printStackTrace();
			throw e;

		}
		return result;
	}

	@Override
	public List<CasaDiscografica> findByExample(CasaDiscografica input) throws Exception {
		if (isNotActive() || input == null) {
			return null;
		}

		ArrayList<CasaDiscografica> result = new ArrayList<CasaDiscografica>();
		CasaDiscografica casaDiscograficaTemp = null;

		String query = "select * from casadiscografica where 1=1 ";
		if (input.getRagioneSociale() != null && !input.getRagioneSociale().equals("")) {
			query += " and ragionesociale='" + input.getRagioneSociale() + "' ";
		}
		if (input.getPartitaIva() != null && !input.getPartitaIva().equals("")) {
			query += " and partitaiva='" + input.getPartitaIva() + "' ";
		}

		// TODO: la data

		try (Statement ps = connection.createStatement()) {
			ResultSet rs = ps.executeQuery(query);

			while (rs.next()) {
				casaDiscograficaTemp = new CasaDiscografica();
				casaDiscograficaTemp.setRagioneSociale(rs.getString("ragionesociale"));
				casaDiscograficaTemp.setPartitaIva(rs.getString("partitaiva"));
				input.setId(rs.getLong("ID"));
				result.add(casaDiscograficaTemp);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;

		}
		return result;
	}

	@Override
	public List<CasaDiscografica> list() throws Exception {
		if (isNotActive()) {
			return null;
		}

		ArrayList<CasaDiscografica> arr = new ArrayList<CasaDiscografica>();
		CasaDiscografica casaDiscograficaTemp = null;

		try (Statement ps = connection.createStatement()) {

			ResultSet rs = ps.executeQuery("select * from casadiscografica");

			while (rs.next()) {
				casaDiscograficaTemp = new CasaDiscografica();
				casaDiscograficaTemp.setId(rs.getLong("idcasadiscografica"));
				casaDiscograficaTemp.setRagioneSociale(rs.getString("ragionesociale"));
				casaDiscograficaTemp.setPartitaIva(rs.getString("partitaiva"));
				arr.add(casaDiscograficaTemp);

			}

		} catch (Exception e) {

			e.printStackTrace();
			throw e;

		}
		return arr;
	}

	@Override
	public void populateAutore(CasaDiscografica input) throws Exception {
		if (input == null || input.getId() < 1) {
			return;
		}

		try (PreparedStatement ps = connection.prepareStatement(
				"SELECT * FROM gestionecasadiscografica.autore a inner join gestionecasadiscografica.casadiscografica c on c.idcasadiscografica=a.casadiscografica_id where c.idcasadiscografica=?; ")) {

			ps.setLong(1, input.getId());

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Autore autoreTemp = new Autore();
				autoreTemp.setId(rs.getLong("a.idautore"));
				autoreTemp.setNome(rs.getString("a.nome"));
				autoreTemp.setCognome(rs.getString("a.cognome"));
				autoreTemp.setCasaDiscografica(input);

				input.getListaAutori().add(autoreTemp);
			}

		} catch (Exception e) {

			e.printStackTrace();
			throw e;
		}

	}

	@Override
	public List<CasaDiscografica> findAllByAutore(Autore input) throws Exception {
		return null;
	}

	@Override
	public List<CasaDiscografica> findAllByAutoreWhereCognomeIniziaCon(String iniziale) throws Exception {
		if (iniziale == null) {
			return null;
		}

		CasaDiscografica casaTemp = null;
		List<CasaDiscografica> result = new ArrayList<CasaDiscografica>();

		try (PreparedStatement ps = connection.prepareStatement(
				"select * from gestionecasadiscografica.casadiscografica c inner join autore a on c.idcasadiscografica=a.casadiscografica_id where a.cognome like ? ;")) {
			ps.setString(1, iniziale + "%");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				casaTemp = new CasaDiscografica();
				casaTemp.setRagioneSociale(rs.getString("ragionesociale"));
				casaTemp.setPartitaIva(rs.getString("partitaiva"));
				casaTemp.setId(rs.getLong("idcasadiscografica"));

				result.add(casaTemp);

			}
		} catch (Exception e) {

			e.printStackTrace();
			throw e;

		}
		return result;
	}

	@Override
	public List<CasaDiscografica> findAllByCdWhereGenereEqual(String genere) throws Exception {
		if (genere == null) {
			return null;
		}

		CasaDiscografica casaTemp = null;
		List<CasaDiscografica> result = new ArrayList<CasaDiscografica>();

		try (PreparedStatement ps = connection.prepareStatement(
				"select * from gestionecasadiscografica.casadiscografica c inner join autore a on c.idcasadiscografica=a.casadiscografica_id inner join gestionecasadiscografica.cd d on a.idautore=d.autore_id where d.genere=? group by c.ragionesociale;")) {
			ps.setString(1, genere);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				casaTemp = new CasaDiscografica();
				casaTemp.setRagioneSociale(rs.getString("ragionesociale"));
				casaTemp.setPartitaIva(rs.getString("partitaiva"));
				casaTemp.setId(rs.getLong("idcasadiscografica"));

				result.add(casaTemp);

			}
		} catch (Exception e) {

			e.printStackTrace();
			throw e;

		}
		return result;
	}

}
