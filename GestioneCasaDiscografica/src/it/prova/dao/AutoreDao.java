package it.prova.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.prova.connection.MyConnection;
import it.prova.model.Autore;
import it.prova.model.CasaDiscografica;

public class AutoreDao {

	public List<Autore> list() {

		List<Autore> result = new ArrayList<Autore>();

		try (Connection c = MyConnection.getConnection()) {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(
					"select * from autore a left outer join casadiscografica c on c.idcasadiscografica=a.casadiscografica_id;");

			while (rs.next()) {
				Autore autoreTemp = new Autore();
				autoreTemp.setNome(rs.getString("NOME"));
				autoreTemp.setCognome(rs.getString("COGNOME"));
				autoreTemp.setId(rs.getLong("idautore"));

				CasaDiscografica casaDiscograficaTemp = new CasaDiscografica();
				casaDiscograficaTemp.setId(rs.getLong("idcasadiscografica"));
				casaDiscograficaTemp.setRagioneSociale(rs.getString("ragionesociale"));
				casaDiscograficaTemp.setPartitaIva(rs.getString("partitaiva"));

				autoreTemp.setCasaDiscografica(casaDiscograficaTemp);
				result.add(autoreTemp);
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return result;
	}

	public int insert(Autore autoreInput) {

		if (autoreInput.getCasaDiscografica() == null)
			return -1;

		int result = 0;

		try (Connection c = MyConnection.getConnection()) {

			PreparedStatement ps = c
					.prepareStatement("INSERT INTO autore (nome, cognome, casadiscografica_id) VALUES (?, ?, ?);");
			ps.setString(1, autoreInput.getNome());
			ps.setString(2, autoreInput.getCognome());
			ps.setLong(3, autoreInput.getCasaDiscografica().getId());

			result = ps.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();

		}

		return result;
	}

	public int update(Autore autoreInput) {

		int result = 0;

		try (Connection c = MyConnection.getConnection()) {

			PreparedStatement ps = c
					.prepareStatement("UPDATE autore SET nome=?, cognome=?, casadiscografica_id=? where idautore=?;");
			ps.setString(1, autoreInput.getNome());
			ps.setString(2, autoreInput.getCognome());
			if (autoreInput.getCasaDiscografica() == null) {
				ps.setNull(3, java.sql.Types.BIGINT);
			} else {
				ps.setLong(3, autoreInput.getCasaDiscografica().getId());
			}
			ps.setLong(4, autoreInput.getId());

			result = ps.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return result;
	}

	public int delete(Autore autoreInput) {
		if (autoreInput == null || autoreInput.getId() < 1) {
			return 0;
		}

		Connection c = null;
		PreparedStatement ps = null;
		int result = 0;

		try {

			c = MyConnection.getConnection();
			ps = c.prepareStatement("DELETE from autore where idautore=?;");
			ps.setLong(1, autoreInput.getId());

			result = ps.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			try {
				ps.close();
				c.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return result;
	}
	
	public Autore selectByIdWithJoin(Long idInput) {
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Autore result = null;

		try {

			c = MyConnection.getConnection();
			ps = c.prepareStatement(
					"SELECT * FROM gestionecasadiscografica.autore a left outer join gestionecasadiscografica.casadiscografica c on a.casadiscografica_id=c.idcasadiscografica where a.idautore=?; ");
			ps.setLong(1, idInput);

			rs = ps.executeQuery();

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
			} else {
				result = null;
			}

		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			try {
				rs.close();
				ps.close();
				c.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
