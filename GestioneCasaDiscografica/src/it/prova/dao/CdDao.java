package it.prova.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.prova.connection.MyConnection;
import it.prova.model.Autore;
import it.prova.model.Cd;

public class CdDao {

	public List<Cd> list() {

		List<Cd> result = new ArrayList<Cd>();

		try (Connection c = MyConnection.getConnection()) {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery("select * from cd c left outer join autore a on a.idautore=c.autore_id;");

			while (rs.next()) {
				Cd cdTemp = new Cd();
				cdTemp.setTitolo(rs.getString("TITOLO"));
				cdTemp.setGenere(rs.getString("GENERE"));
				cdTemp.setTraccia(rs.getString("TRACCIA"));
				cdTemp.setId(rs.getLong("idautore"));

				Autore autoreTemp = new Autore();
				autoreTemp.setNome(rs.getString("NOME"));
				autoreTemp.setCognome(rs.getString("COGNOME"));
				autoreTemp.setId(rs.getLong("idautore"));

				cdTemp.setAutore(autoreTemp);
				result.add(cdTemp);
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return result;
	}

	public int insert(Cd cdInput) {

		if (cdInput.getAutore() == null)
			return -1;

		int result = 0;

		try (Connection c = MyConnection.getConnection()) {

			PreparedStatement ps = c
					.prepareStatement("INSERT INTO cd (titolo, genere, traccia, autore_id) VALUES (?, ?, ?, ?);");
			ps.setString(1, cdInput.getTitolo());
			ps.setString(2, cdInput.getGenere());
			ps.setString(3, cdInput.getTraccia());
			ps.setLong(4, cdInput.getAutore().getId());

			result = ps.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();

		}

		return result;
	}

	public int update(Cd cdInput) {

		int result = 0;

		try (Connection c = MyConnection.getConnection()) {

			PreparedStatement ps = c
					.prepareStatement("UPDATE cd SET titolo=?, genere=?, traccia=?, autore_id=? where idcd=?;");
			ps.setString(1, cdInput.getTitolo());
			ps.setString(2, cdInput.getGenere());
			ps.setString(3, cdInput.getTraccia());
			if (cdInput.getAutore() == null) {
				ps.setNull(4, java.sql.Types.BIGINT);
			} else {
				ps.setLong(4, cdInput.getAutore().getId());
			}
			ps.setLong(5, cdInput.getId());

			result = ps.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return result;
	}

	public int delete(Cd cdInput) {
		if (cdInput == null || cdInput.getId() < 1) {
			return 0;
		}

		Connection c = null;
		PreparedStatement ps = null;
		int result = 0;

		try {

			c = MyConnection.getConnection();
			ps = c.prepareStatement("DELETE from cd where idcd=?;");
			ps.setLong(1, cdInput.getId());

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
	
	public Cd selectByIdWithJoin(Long idInput) {
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Cd result = null;

		try {

			c = MyConnection.getConnection();
			ps = c.prepareStatement(
					"SELECT * FROM gestionecasadiscografica.cd c left outer join gestionecasadiscografica.autore a on c.autore_id=a.idautore where c.idcd=?; ");
			ps.setLong(1, idInput);

			rs = ps.executeQuery();

			if (rs.next()) {
				result = new Cd();

				result.setTitolo(rs.getString("TITOLO"));
				result.setGenere(rs.getString("GENERE"));
				result.setTraccia(rs.getString("TRACCIA"));
				result.setId(rs.getLong("idcd"));

				Autore autoreTemp = new Autore();
				autoreTemp.setNome(rs.getString("NOME"));
				autoreTemp.setCognome(rs.getString("COGNOME"));
				autoreTemp.setId(rs.getLong("idautore"));
				// imposto l'indirizzo trovato dentro il mio abitante di
				// partenza
				result.setAutore(autoreTemp);
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
	
	public List<Cd> findByExample(Cd example) {
		
		if(example.getId() < 1) {
			return null;
		}
		
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Cd temp = null;
		List<Cd> result = new ArrayList<Cd>();

		try {
			
			String query = "SELECT * FROM gestionecasadiscografica.cd c left outer join gestionecasadiscografica.autore a on c.autore_id=a.idautore where ";
			String newQuery = "";
			if(example.getTitolo() != null && !example.getTitolo().equals("")) {
				newQuery = query + "c.titolo=" + example.getTitolo();
			}
			if(example.getGenere() != null && !example.getGenere().equals("")) {
				newQuery += query + ",c.genere=" + example.getGenere();
			}
			if(example.getTraccia() != null && !example.getTraccia().equals("")) {
				newQuery += query + ",c.traccia=" + example.getTraccia();
			}
			if(example.getAutore().getId() != null) {
				newQuery += query + ",c.autore_id=" + example.getAutore().getId();
			}
			
			
			c = MyConnection.getConnection();
			
			ps = c.prepareStatement(newQuery);

			rs = ps.executeQuery();

			if (rs.next()) {
				temp = new Cd();

				temp.setTitolo(rs.getString("TITOLO"));
				temp.setGenere(rs.getString("GENERE"));
				temp.setTraccia(rs.getString("TRACCIA"));
				temp.setId(rs.getLong("idcd"));

				Autore autoreTemp = new Autore();
				autoreTemp.setNome(rs.getString("NOME"));
				autoreTemp.setCognome(rs.getString("COGNOME"));
				autoreTemp.setId(rs.getLong("idautore"));
				// imposto l'indirizzo trovato dentro il mio abitante di
				// partenza
				temp.setAutore(autoreTemp);
				
				result.add(temp);
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
