package it.primostruts.dao;

import it.primostruts.model.Utente;

public class UtenteDAO {

	//CLASSE FINTA
	
	public UtenteDAO(String fintaConnection) {
		// TODO Auto-generated constructor stub
	}
	
	public Utente findByLoginAndPassword(String loginInput, String passwordInput){
		if(loginInput == null || loginInput.isEmpty() || passwordInput == null || passwordInput.isEmpty()){
			return null;
		}
		//SIMULA CHIAMATA
		return new Utente(loginInput, passwordInput);
	}

}
