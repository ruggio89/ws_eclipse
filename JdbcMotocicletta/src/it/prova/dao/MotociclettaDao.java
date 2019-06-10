package it.prova.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.prova.connection.MyConnection;
import it.prova.model.Motocicletta;

public class MotociclettaDao {

	public List<Motocicletta> list() {

		Connection c = null;
		ResultSet rs = null;
		Statement s = null;
		Motocicletta temp = null;
		List<Motocicletta> result = new ArrayList<Motocicletta>();

		try {

			c = MyConnection.getConnection();
			s = c.createStatement();

			rs = s.executeQuery("select * from motocicletta;");

			while (rs.next()) {
				temp = new Motocicletta();
				temp.setMarca(rs.getString("MARCA"));
				temp.setModello(rs.getString("MODELLO"));
				temp.setCilindrata(rs.getInt("cilindrata"));
				temp.setId(rs.getLong("id"));
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

	public List<Motocicletta> selectByMarcaModello(String marca, String modello) {

		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Motocicletta temp = null;
		List<Motocicletta> result = new ArrayList<Motocicletta>();

		try {

			c = MyConnection.getConnection();
			ps = c.prepareStatement("select * from motocicletta u where u.marca=? and u.modello=?;");
			ps.setString(1, marca);
			ps.setString(2, modello);

			rs = ps.executeQuery();

			while (rs.next()) {
				temp = new Motocicletta();
				temp.setMarca(rs.getString("MARCA"));
				temp.setModello(rs.getString("MODELLO"));
				temp.setCilindrata(rs.getInt("cilindrata"));
				temp.setId(rs.getLong("id"));
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

	// =============================================== INSERT
	public int insert(Motocicletta input) {

		Connection c = null;
		PreparedStatement ps = null;
		int result = 0;

		try {

			c = MyConnection.getConnection();
			ps = c.prepareStatement("INSERT INTO motocicletta (marca, modello, cilindrata) VALUES (?, ?, ?);");
			ps.setString(1, input.getMarca());
			ps.setString(2, input.getModello());
			ps.setInt(3, input.getCilindrata());

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

	// =============================================== UPDATE
	public int update(Motocicletta input) {

		if (input == null || input.getId() < 1) {
			return 0;
		}

		Connection c = null;
		PreparedStatement ps = null;
		int result = 0;

		try {

			c = MyConnection.getConnection();
			ps = c.prepareStatement("UPDATE motocicletta SET marca=?, modello=?, cilindrata=? where id=?;");
			ps.setString(1, input.getMarca());
			ps.setString(2, input.getModello());
			ps.setInt(3, input.getCilindrata());
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

	// =============================================== DELETE
	public int delete(Motocicletta input) {

		if (input == null || input.getId() < 1) {
			return 0;
		}

		Connection c = null;
		PreparedStatement ps = null;
		int result = 0;

		try {

			c = MyConnection.getConnection();
			ps = c.prepareStatement("DELETE from motocicletta where id=?;");
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

	public Motocicletta findById(long input) {

		if (input < 1) {
			return null;
		}

		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Motocicletta result = null;

		try {

			c = MyConnection.getConnection();
			ps = c.prepareStatement("select * from motocicletta u where u.id=?;");
			ps.setLong(1, input);

			rs = ps.executeQuery();

			if (rs.next()) {
				result = new Motocicletta();
				result.setMarca(rs.getString("MARCA"));
				result.setModello(rs.getString("MODELLO"));
				result.setCilindrata(rs.getInt("cilindrata"));
				result.setId(rs.getLong("id"));

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

	public List<Motocicletta> findAllByCilindrataMaggioreDi(int cilindrataCriterio) {

		if (cilindrataCriterio < 1) {
			return null;
		}

		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Motocicletta temp = null;
		List<Motocicletta> result = new ArrayList<>();

		try {

			c = MyConnection.getConnection();
			ps = c.prepareStatement("select * from motocicletta u where u.cilindrata>?;");
			ps.setLong(1, cilindrataCriterio);

			rs = ps.executeQuery();

			while (rs.next()) {
				temp = new Motocicletta();
				temp.setMarca(rs.getString("MARCA"));
				temp.setModello(rs.getString("MODELLO"));
				temp.setCilindrata(rs.getInt("cilindrata"));
				temp.setId(rs.getLong("id"));
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
