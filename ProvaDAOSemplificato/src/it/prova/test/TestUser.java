package it.prova.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import it.prova.connection.MyConnection;
import it.prova.dao.Constants;
import it.prova.dao.user.UserDAO;
import it.prova.dao.user.UserDAOImpl;
import it.prova.model.User;

public class TestUser {

	public static void main(String[] args) {
		User newUserInstance = new User("marco", "bianchi", "tttt", null);
		newUserInstance.setDateCreated(new Date());
		
		
		
		UserDAO userDAOInstance = null;
		Connection connection = null;
		try {
			connection = MyConnection.getConnection(Constants.DRIVER_NAME,Constants.CONNECTION_URL);
			userDAOInstance = new UserDAOImpl(connection);
			
			
			System.out.println("In tabella ci sono "+userDAOInstance.list().size()+" elementi.");
//			userDAOInstance.insert(newUserInstance);
			User founded = userDAOInstance.get(3L);
			System.out.println(founded);
//			userDAOInstance.delete(founded);
//			System.out.println("In tabella ci sono "+userDAOInstance.list().size()+" elementi.");
			
			//da fare il test dopo aver implementato in UserDAOImpl
			User example = new User();
			example.setNome("ruggero");
			System.out.println("In tabella ci sono "+userDAOInstance.findByExample(example).size()+" "+example.getNome());
			
			System.out.println("########################################################################################");
			//cerca gli utenti creati dopo una certa data
			String dataDaCuiPartire = "2019-01-31";
			Date dateCreatedInput = new SimpleDateFormat("yyyy-MM-dd").parse(dataDaCuiPartire);
			for (User userItem : userDAOInstance.findAllWhereDateCreatedGreaterThan(dateCreatedInput)) {
				System.out.println(userItem);
			}
			
			//prova findByExample
			System.out.println("############################## findByExample #######################");
			for (User userItem : userDAOInstance.findByExample(newUserInstance)) {
				System.out.println(userItem);
			}
			
			//prova findAllByCognome
			System.out.println("############################## findAllByCognome #######################");
			for (User userItem : userDAOInstance.findAllByCognome("rossi")) {
				System.out.println(userItem);
			}
			
			//prova findAllByLoginIniziaCon
			System.out.println("############################## findAllByLoginIniziaCon #######################");
			for (User userItem : userDAOInstance.findAllByLoginIniziaCon("rug")) {
				System.out.println(userItem);
			}
			
			//prova findByLoginAndPassword
			System.out.println("############################## findByLoginAndPassword #######################");
			System.out.println(userDAOInstance.findByLoginAndPassword("ruggio.rossi", "ciao"));
			
			// prova findAllByPasswordIsNull
			System.out.println("############################## findAllByPasswordIsNull #######################");
			for (User userItem : userDAOInstance.findAllByPasswordIsNull()) {
				System.out.println(userItem);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
