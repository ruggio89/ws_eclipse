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

public class NegozioDAO {

	public List<Negozio> list() {

		List<Negozio> result = new ArrayList<Negozio>();
		Negozio negozioTemp = null;

		try (Connection c = MyConnection.getConnection()) {

			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery("select * from negozio a ;");

			while (rs.next()) {
				negozioTemp = new Negozio();
				negozioTemp.setId(rs.getLong("idnegozio"));
				negozioTemp.setNome(rs.getString("nome"));
				negozioTemp.setIndirizzo(rs.getString("indirizzo"));

				result.add(negozioTemp);
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return result;
	}

	public Negozio selectById(Long idNegozioInput) {

		if (idNegozioInput == null || idNegozioInput < 1)
			return null;

		Negozio result = null;

		try (Connection c = MyConnection.getConnection()) {

			PreparedStatement ps = c.prepareStatement("select * from negozio i where i.idnegozio=?;");
			ps.setLong(1, idNegozioInput);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				result = new Negozio();
				result.setId(rs.getLong("idnegozio"));
				result.setNome(rs.getString("nome"));
				result.setIndirizzo(rs.getString("indirizzo"));
			} else {
				result = null;
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return result;
	}

	public int insert(Negozio negozioInput) {

		int result = 0;

		try (Connection c = MyConnection.getConnection()) {

			PreparedStatement ps = c.prepareStatement("INSERT INTO negozio (nome, indirizzo) VALUES (?, ?);");
			ps.setString(1, negozioInput.getNome());
			ps.setString(2, negozioInput.getIndirizzo());

			result = ps.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();

		}

		return result;
	}

	// TODO
	public int update(Negozio negozioInput) {
		if (negozioInput == null || negozioInput.getId() < 1) {
			return 0;
		}

		Connection c = null;
		PreparedStatement ps = null;
		int result = 0;

		try {

			c = MyConnection.getConnection();
			ps = c.prepareStatement("UPDATE negozio SET nome=?, indirizzo=? where idnegozio=?;");
			ps.setString(1, negozioInput.getNome());
			ps.setString(2, negozioInput.getIndirizzo());
			ps.setLong(3, negozioInput.getId());

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

	public int delete(Negozio negozioInput) {
		if (negozioInput == null || negozioInput.getId() < 1) {
			return 0;
		}

		Connection c = null;
		PreparedStatement ps = null;
		int result = 0;

		try {

			c = MyConnection.getConnection();
			ps = c.prepareStatement("DELETE from negozio where idnegozio=?;");
			ps.setLong(1, negozioInput.getId());

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

	// prende negozioInput e grazie al suo id va sulla tabella articoli e poi
	// ad ogni iterazione sul resultset aggiunge agli articoli di negozioInput
	public void populateArticoli(Negozio negozioInput) {
		if(negozioInput == null || negozioInput.getId() < 1) {
			return ;
		}
		
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		

		try {

			c = MyConnection.getConnection();
			ps = c.prepareStatement(
					"SELECT * FROM negozi.negozio n left outer join negozi.articolo a on a.indirizzo_id=n.idnegozio where n.idnegozio=?; ");
			ps.setLong(1, negozioInput.getId());

			rs = ps.executeQuery();

			while (rs.next()) {
				Articolo temp = new Articolo();
				temp.setId(rs.getLong("a.idarticolo"));
				temp.setNome(rs.getString("a.nome"));
				temp.setMatricola(rs.getString("a.matricola"));
				temp.setNegozio(negozioInput);
				negozioInput.getArticoli().add(temp);
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
	}

	// implementare inoltre
	public List<Negozio> findAllByIniziali(String inizialeInput) {
		if (inizialeInput == null) {
			return null;
		}

		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Negozio n = null;
		List<Negozio> result = new ArrayList<>();

		try {

			c = MyConnection.getConnection();
			ps = c.prepareStatement("select * from negozio where nome like ? ;");
			ps.setString(1, inizialeInput + "%");

			rs = ps.executeQuery();

			while (rs.next()) {
				n = new Negozio();
				n.setNome(rs.getString("NOME"));
				n.setIndirizzo(rs.getString("INDIRIZZO"));
				n.setId(rs.getLong("idnegozio"));

				result.add(n);

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
