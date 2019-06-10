package it.miopackage.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.miopackage.jdbc.connection.MyConnection;
import it.miopackage.jdbc.model.Indirizzo;

public class IndirizzoDAO {

	public List<Indirizzo> list() {

		Connection c = null;
		ResultSet rs = null;
		Statement s = null;
		Indirizzo temp = null;
		List<Indirizzo> result = new ArrayList<Indirizzo>();

		try {

			c = MyConnection.getConnection();
			s = c.createStatement();

			rs = s.executeQuery("select * from indirizzo;");

			while (rs.next()) {
				temp = new Indirizzo();
				temp.setCitta(rs.getString("CITTA"));
				temp.setCivico(rs.getString("CIVICO"));
				temp.setVia(rs.getString("VIA"));
				temp.setId(rs.getLong("idindirizzo"));
				result.add(temp);

			}

		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			try {
				rs.close();
				s.close();
				c.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public Indirizzo selectById(Long id) {

		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Indirizzo result = null;

		try {

			c = MyConnection.getConnection();
			ps = c.prepareStatement("select * from indirizzo i where i.idindirizzo=?;");
			ps.setLong(1, id);

			rs = ps.executeQuery();

			if (rs.next()) {
				result = new Indirizzo();
				result.setId(rs.getLong("idindirizzo"));
				result.setCitta(rs.getString("citta"));
				result.setVia(rs.getString("via"));
				result.setCivico(rs.getString("civico"));
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

	public int insert(Indirizzo indirizzoNuovo) {

		Connection c = null;
		PreparedStatement ps = null;
		int result = 0;

		try {

			c = MyConnection.getConnection();
			ps = c.prepareStatement("INSERT INTO indirizzo (citta, via,civico) VALUES (?, ?,?);");
			ps.setString(1, indirizzoNuovo.getCitta());
			ps.setString(2, indirizzoNuovo.getVia());
			ps.setString(3, indirizzoNuovo.getCivico());

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

	public int update(Indirizzo input) {

		if (input == null || input.getId() < 1) {
			return 0;
		}

		Connection c = null;
		PreparedStatement ps = null;
		int result = 0;

		try {

			c = MyConnection.getConnection();
			ps = c.prepareStatement("UPDATE indirizzo SET citta=?, civico=?, via=? where idindirizzo=?;");
			ps.setString(1, input.getCitta());
			ps.setString(2, input.getCivico());
			ps.setString(3, input.getVia());
			ps.setLong(4, input.getId());

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

	public int delete(Indirizzo input) {

		if (input == null || input.getId() < 1) {
			return 0;
		}

		Connection c = null;
		PreparedStatement ps = null;
		int result = 0;

		try {

			c = MyConnection.getConnection();
			ps = c.prepareStatement("DELETE from indirizzo where idindirizzo=?;");
			ps.setLong(1, input.getId());

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

	public Long insertIndirizzoObtainingLastId(Indirizzo indirizzoNuovo) {

		Connection c = null;
		PreparedStatement ps = null;
		Long result = 0L;

		try {

			c = MyConnection.getConnection();
			ps = c.prepareStatement("INSERT INTO indirizzo (citta, via,civico) VALUES (?, ?,?);",
					Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, indirizzoNuovo.getCitta());
			ps.setString(2, indirizzoNuovo.getVia());
			ps.setString(3, indirizzoNuovo.getCivico());

			ps.executeUpdate();

			// per avere il last inserted
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				result = rs.getLong(1);
			}

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

	public int[] insertBatch(List<Indirizzo> indirizziNuovi) {

		Connection c = null;
		PreparedStatement ps = null;
		int[] result = null;

		try {

			c = MyConnection.getConnection();
			ps = c.prepareStatement("INSERT INTO indirizzo (citta, via,civico) VALUES (?, ?,?);");

			for (Indirizzo indirizzoItem : indirizziNuovi) {
				ps.setString(1, indirizzoItem.getCitta());
				ps.setString(2, indirizzoItem.getVia());
				ps.setString(3, indirizzoItem.getCivico());
				ps.addBatch();
			}

			result = ps.executeBatch();

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

	public List<Indirizzo> findAllByViaECitta(String inputVia, String inputCitta) {

		if (inputVia == null || inputCitta == null) {
			return null;
		}

		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Indirizzo temp = null;
		List<Indirizzo> result = new ArrayList<>();

		try {

			c = MyConnection.getConnection();
			ps = c.prepareStatement("select * from indirizzo u where u.via=? and u.citta=?;");
			ps.setString(1, inputVia);
			ps.setString(2, inputCitta);

			rs = ps.executeQuery();

			while (rs.next()) {
				temp = new Indirizzo();
				temp.setCitta(rs.getString("CITTA"));
				temp.setCivico(rs.getString("CIVICO"));
				temp.setVia(rs.getString("VIA"));
				temp.setId(rs.getLong("idindirizzo"));
				result.add(temp);

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
