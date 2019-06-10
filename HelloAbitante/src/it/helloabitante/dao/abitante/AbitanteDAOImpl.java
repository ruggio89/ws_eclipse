package it.helloabitante.dao.abitante;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.helloabitante.dao.DB_Mock;
import it.helloabitante.model.Abitante;

public class AbitanteDAOImpl implements AbitanteDAO {

	private Connection connection;

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	@Override
	public List<Abitante> findByNomeAndCognome(String nome, String cognome) {
		List<Abitante> result = new ArrayList<>();

		for (Abitante abitanteItem : DB_Mock.LISTA_ABITANTI) {
			if (abitanteItem.getNome().equals(nome) && abitanteItem.getCognome().equals(cognome))
				result.add(abitanteItem);
		}
		return result;
	}

	@Override
	public List<Abitante> list() throws Exception {

		ArrayList<Abitante> arr = new ArrayList<Abitante>();
		Abitante temp = null;

		try (Statement ps = connection.createStatement()) {

			ResultSet rs = ps.executeQuery("select * from abitante");

			while (rs.next()) {
				temp = new Abitante();
				temp.setNome(rs.getString("NOME"));
				temp.setCognome(rs.getString("COGNOME"));
				temp.setIdAbitante(rs.getLong("idabitante"));
				temp.setEta(rs.getInt("eta"));
				temp.setCodiceFiscale(rs.getString("CODICEFISCALE"));
				temp.setMottoDiVita(rs.getString("MOTTODIVITA"));
				arr.add(temp);

			}

		} catch (Exception e) {

			e.printStackTrace();
			throw e;

		}
		return arr;
	}

	@Override
	public Abitante get(Long id) throws Exception {
		if (id < 1) {
			return null;
		}

		Abitante temp = null;

		try (Statement ps = connection.createStatement()) {
			ResultSet rs = ps.executeQuery("select * from abitante where idabitante=" + id);

			if (rs.next()) {
				temp = new Abitante();
				temp.setNome(rs.getString("NOME"));
				temp.setCognome(rs.getString("COGNOME"));
				temp.setIdAbitante(rs.getLong("idabitante"));
				temp.setEta(rs.getInt("eta"));
				temp.setCodiceFiscale(rs.getString("CODICEFISCALE"));
				temp.setMottoDiVita(rs.getString("MOTTODIVITA"));
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;

		}
		return temp;
	}

	@Override
	public int update(Abitante input) throws Exception {
		if (input == null) {
			return -1;
		}

		int result = 0;

		try (PreparedStatement ps = connection.prepareStatement(
				"UPDATE abitante SET nome=?, cognome=?, codicefiscale=?, eta=?, mottodivita=? where idabitante=?;")) {
			ps.setString(1, input.getNome());
			ps.setString(2, input.getCognome());
			ps.setString(3, input.getCodiceFiscale());
			ps.setInt(4, input.getEta());
			ps.setString(5, input.getMottoDiVita());
			ps.setLong(6, input.getIdAbitante());
			result = ps.executeUpdate();
		} catch (Exception e) {

			e.printStackTrace();
			throw e;

		}
		return result;
	}

	@Override
	public int insert(Abitante input) throws Exception {
		if (input == null) {
			return -1;
		}

		int result = 0;

		try (PreparedStatement ps = connection.prepareStatement(
				"INSERT INTO abitante (nome, cognome, codicefiscale, eta, mottodivita) VALUES (?, ?, ?, ?, ?);")) {
			ps.setString(1, input.getNome());
			ps.setString(2, input.getCognome());
			ps.setString(3, input.getCodiceFiscale());
			ps.setInt(4, input.getEta());
			ps.setString(5, input.getMottoDiVita());
			result = ps.executeUpdate();
		} catch (Exception e) {

			e.printStackTrace();
			throw e;

		}
		return result;
	}

	@Override
	public int delete(Abitante input) throws Exception {
		if (input == null) {
			return -1;
		}

		int result = 0;

		try (PreparedStatement ps = connection.prepareStatement("DELETE FROM abitante WHERE idabitante=" + input.getIdAbitante())) {
			result = ps.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();
			throw e;
		}
		return result;
	}

	@Override
	public List<Abitante> findByExample(Abitante input) throws Exception {
		if (input == null) {
			return null;
		}

		ArrayList<Abitante> result = new ArrayList<Abitante>();
		Abitante temp = null;

		String query = "select * from abitante where 1=1 ";
		if (input.getCognome() != null && !input.getCognome().equals("")) {
			query += " and cognome='" + input.getCognome() + "' ";
		}
		if (input.getNome() != null && !input.getNome().equals("")) {
			query += " and nome='" + input.getNome() + "' ";
		}

		if (input.getCodiceFiscale() != null && !input.getCodiceFiscale().equals("")) {
			query += " and codicefiscale='" + input.getCodiceFiscale() + "' ";
		}

		if (input.getEta() != 0) {
			query += " and eta='" + input.getEta() + "' ";
		}

		if (input.getMottoDiVita() != null && !input.getMottoDiVita().equals("")) {
			query += " and mottodivita='" + input.getMottoDiVita() + "' ";
		}

		try (Statement ps = connection.createStatement()) {
			ResultSet rs = ps.executeQuery(query);

			while (rs.next()) {
				temp = new Abitante();
				temp.setNome(rs.getString("NOME"));
				temp.setCognome(rs.getString("COGNOME"));
				temp.setEta(rs.getInt("eta"));
				temp.setCodiceFiscale(rs.getString("CODICEFISCALE"));
				temp.setMottoDiVita(rs.getString("MOTTODIVITA"));
				temp.setIdAbitante(rs.getLong("IDABITANTE"));
				result.add(temp);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;

		}
		return result;
	}

}
