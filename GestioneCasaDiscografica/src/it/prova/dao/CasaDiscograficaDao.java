package it.prova.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.prova.connection.MyConnection;
import it.prova.model.CasaDiscografica;

public class CasaDiscograficaDao {

	public List<CasaDiscografica> list() {

		List<CasaDiscografica> result = new ArrayList<CasaDiscografica>();
		CasaDiscografica casaDiscograficaTemp = null;

		try (Connection c = MyConnection.getConnection()) {

			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery("select * from casadiscografica a ;");

			while (rs.next()) {
				casaDiscograficaTemp = new CasaDiscografica();
				casaDiscograficaTemp.setId(rs.getLong("idcasadiscografica"));
				casaDiscograficaTemp.setRagioneSociale(rs.getString("ragionesociale"));
				casaDiscograficaTemp.setPartitaIva(rs.getString("partitaiva"));

				result.add(casaDiscograficaTemp);
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return result;
	}

	public int insert(CasaDiscografica casaDiscograficaInput) {

		int result = 0;

		try (Connection c = MyConnection.getConnection()) {

			PreparedStatement ps = c
					.prepareStatement("INSERT INTO casadiscografica (ragionesociale, partitaiva) VALUES (?, ?);");
			ps.setString(1, casaDiscograficaInput.getRagioneSociale());
			ps.setString(2, casaDiscograficaInput.getPartitaIva());

			result = ps.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();

		}

		return result;
	}

	public int update(CasaDiscografica casaDiscograficaInput) {
		if (casaDiscograficaInput == null || casaDiscograficaInput.getId() < 1) {
			return 0;
		}

		Connection c = null;
		PreparedStatement ps = null;
		int result = 0;

		try {

			c = MyConnection.getConnection();
			ps = c.prepareStatement(
					"UPDATE casadiscografica SET ragionesociale=?, partitaiva=? where idcasadiscografica=?;");
			ps.setString(1, casaDiscograficaInput.getRagioneSociale());
			ps.setString(2, casaDiscograficaInput.getPartitaIva());
			ps.setLong(3, casaDiscograficaInput.getId());

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

	public int delete(CasaDiscografica casaDiscograficaInput) {
		if (casaDiscograficaInput == null || casaDiscograficaInput.getId() < 1) {
			return 0;
		}

		Connection c = null;
		PreparedStatement ps = null;
		int result = 0;

		try {

			c = MyConnection.getConnection();
			ps = c.prepareStatement("DELETE from casadiscografica where idcasadiscografica=?;");
			ps.setLong(1, casaDiscograficaInput.getId());

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
	
	public CasaDiscografica selectById(Long idCasaDiscograficaInput) {

		if (idCasaDiscograficaInput == null || idCasaDiscograficaInput < 1)
			return null;

		CasaDiscografica result = null;

		try (Connection c = MyConnection.getConnection()) {

			PreparedStatement ps = c.prepareStatement("select * from casadiscografica c where c.idcasadiscografica=?;");
			ps.setLong(1, idCasaDiscograficaInput);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				result = new CasaDiscografica();
				result.setId(rs.getLong("idcasadiscografica"));
				result.setRagioneSociale(rs.getString("ragionesociale"));
				result.setPartitaIva(rs.getString("partitaiva"));
			} else {
				result = null;
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return result;
	}

}
