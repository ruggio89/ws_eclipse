package it.prova.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.prova.connection.MyConnection;
import it.prova.model.Articolo;
import it.prova.model.Negozio;

public class ArticoloDAO {

	public List<Articolo> list() {

		List<Articolo> result = new ArrayList<Articolo>();

		try (Connection c = MyConnection.getConnection()) {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery("select * from articolo a inner join negozio i on i.idnegozio=a.negozio_id;");

			while (rs.next()) {
				Articolo articoloTemp = new Articolo();
				articoloTemp.setNome(rs.getString("NOME"));
				articoloTemp.setMatricola(rs.getString("matricola"));
				articoloTemp.setId(rs.getLong("idarticolo"));

				Negozio negozioTemp = new Negozio();
				negozioTemp.setId(rs.getLong("idnegozio"));
				negozioTemp.setNome(rs.getString("nome"));
				negozioTemp.setIndirizzo(rs.getString("indirizzo"));

				articoloTemp.setNegozio(negozioTemp);
				result.add(articoloTemp);
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return result;
	}

	public int insert(Articolo articoloInput) {

		if (articoloInput.getNegozio() == null || articoloInput.getNegozio().getId() < 1)
			return -1;

		int result = 0;

		try (Connection c = MyConnection.getConnection()) {

			PreparedStatement ps = c
					.prepareStatement("INSERT INTO articolo (nome, matricola,negozio_id) VALUES (?, ?, ?);");
			ps.setString(1, articoloInput.getNome());
			ps.setString(2, articoloInput.getMatricola());
			ps.setLong(3, articoloInput.getNegozio().getId());

			result = ps.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();

		}

		return result;
	}

	// TODO

	public Articolo selectByIdWithJoin(Long idInput) {
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Articolo result = null;

		try {

			c = MyConnection.getConnection();
			ps = c.prepareStatement(
					"SELECT * FROM negozi.articolo a left outer join negozi.negozio n on a.negozio_id=n.idnegozio where a.idarticolo=?; ");
			ps.setLong(1, idInput);

			rs = ps.executeQuery();

			if (rs.next()) {
				result = new Articolo();

				result.setId(rs.getLong("a.idarticolo"));
				result.setNome(rs.getString("a.nome"));
				result.setMatricola(rs.getString("a.matricola"));

				Negozio row = new Negozio();
				row.setId(rs.getLong("n.idnegozio"));
				row.setNome(rs.getString("n.nome"));
				row.setIndirizzo(rs.getString("n.indirizzo"));
				// imposto l'indirizzo trovato dentro il mio abitante di
				// partenza
				result.setNegozio(row);
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

	public int update(Articolo articoloInput) {

		int result = 0;

		try (Connection c = MyConnection.getConnection()) {

			PreparedStatement ps = c
					.prepareStatement("UPDATE articolo SET nome=?, matricola=?, negozio_id=? where idarticolo=?;");
			ps.setString(1, articoloInput.getNome());
			ps.setString(2, articoloInput.getMatricola());
			if (articoloInput.getNegozio() == null) {
				ps.setNull(4, java.sql.Types.BIGINT);
			} else {
				ps.setLong(4, articoloInput.getNegozio().getId());
			}
			ps.setLong(5, articoloInput.getId());

			result = ps.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return result;
	}

	public int delete(Articolo articoloInput) {
		if (articoloInput == null || articoloInput.getId() < 1) {
			return 0;
		}

		Connection c = null;
		PreparedStatement ps = null;
		int result = 0;

		try {

			c = MyConnection.getConnection();
			ps = c.prepareStatement("DELETE from articolo where idarticolo=?;");
			ps.setLong(1, articoloInput.getId());

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

	// implementare inoltre
	public List<Articolo> findAllByNegozio(Negozio negozioInput) {

		if (negozioInput == null) {
			return null;
		}

		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		List<Articolo> result = new ArrayList<Articolo>();

		try {

			c = MyConnection.getConnection();
			ps = c.prepareStatement(
					"select * from articolo a inner join negozio n on n.idnegozio=a.negozio_id where n.nome=? and n.indirizzo=?");
			ps.setString(1, negozioInput.getNome());
			ps.setString(2, negozioInput.getIndirizzo());

			rs = ps.executeQuery();

			while (rs.next()) {
				Articolo temp = new Articolo();
				temp.setNome(rs.getString("NOME"));
				temp.setMatricola(rs.getString("MATRICOLA"));
				temp.setId(rs.getLong("idarticolo"));

				Negozio negozioTemp = new Negozio();
				negozioTemp.setId(rs.getLong("idnegozio"));
				negozioTemp.setNome(rs.getString("NOME"));
				negozioTemp.setIndirizzo(rs.getString("INDIRIZZO"));

				temp.setNegozio(negozioTemp);
				
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

	public List<Articolo> findAllByMatricola(String matricolaInput) {
		if (matricolaInput == null) {
			return null;
		}

		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		List<Articolo> result = new ArrayList<Articolo>();

		try {

			c = MyConnection.getConnection();
			ps = c.prepareStatement(
					"select * from articolo a inner join negozio n on n.idnegozio=a.negozio_id where a.matricola=?");
			ps.setString(1, matricolaInput);

			rs = ps.executeQuery();

			while (rs.next()) {
				Articolo temp = new Articolo();
				temp.setNome(rs.getString("NOME"));
				temp.setMatricola(rs.getString("MATRICOLA"));
				temp.setId(rs.getLong("idarticolo"));

				Negozio negozioTemp = new Negozio();
				negozioTemp.setId(rs.getLong("idnegozio"));
				negozioTemp.setNome(rs.getString("NOME"));
				negozioTemp.setIndirizzo(rs.getString("INDIRIZZO"));

				temp.setNegozio(negozioTemp);
				
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

	public List<Articolo> findAllByIndirizzoNegozio(String indirizzoNegozioInput) {
		if (indirizzoNegozioInput == null) {
			return null;
		}

		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		List<Articolo> result = new ArrayList<Articolo>();

		try {

			c = MyConnection.getConnection();
			ps = c.prepareStatement(
					"select * from articolo a inner join negozio n on n.idnegozio=a.negozio_id where n.indirizzo=?");
			ps.setString(1, indirizzoNegozioInput);

			rs = ps.executeQuery();

			while (rs.next()) {
				Articolo temp = new Articolo();
				temp.setNome(rs.getString("NOME"));
				temp.setMatricola(rs.getString("MATRICOLA"));
				temp.setId(rs.getLong("idarticolo"));

				Negozio negozioTemp = new Negozio();
				negozioTemp.setId(rs.getLong("idnegozio"));
				negozioTemp.setNome(rs.getString("NOME"));
				negozioTemp.setIndirizzo(rs.getString("INDIRIZZO"));

				temp.setNegozio(negozioTemp);
				
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
