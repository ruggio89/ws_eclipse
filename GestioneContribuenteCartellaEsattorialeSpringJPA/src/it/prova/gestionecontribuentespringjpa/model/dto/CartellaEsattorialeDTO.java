package it.prova.gestionecontribuentespringjpa.model.dto;

import java.util.ArrayList;
import java.util.List;

import it.prova.gestionecontribuentespringjpa.model.CartellaEsattoriale;

public class CartellaEsattorialeDTO {

	private Long id;
	private String denominazione;
	private String descrizione;
	private int importo;
	private Long contribuenteId;

	public CartellaEsattorialeDTO() {

	}

	public List<String> validate() {
		List<String> listaErrori = new ArrayList<String>();

		if (denominazione.equals("") || denominazione == null) {
			listaErrori.add("Inserire correttamente campo denominazione");
		}
		if (descrizione.equals("") || descrizione == null) {
			listaErrori.add("Inserire correttamente campo descrizione");
		}
		if (importo <= 0) {
			listaErrori.add("Inserire correttamente campo importo");
		}
		if (contribuenteId == null || contribuenteId <= 0) {
			listaErrori.add("Inserire contribuente");
		}
		return listaErrori;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDenominazione() {
		return denominazione;
	}

	public void setDenominazione(String denominazione) {
		this.denominazione = denominazione;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}



	public int getImporto() {
		return importo;
	}

	public void setImporto(int importo) {
		this.importo = importo;
	}

	public Long getContribuenteId() {
		return contribuenteId;
	}

	public void setContribuenteId(Long contribuenteId) {
		this.contribuenteId = contribuenteId;
	}

	public static CartellaEsattoriale buildCartellaEsattorialeInstance(CartellaEsattorialeDTO input) {
		CartellaEsattoriale result = new CartellaEsattoriale();

		result.setDenominazione(input.getDenominazione());
		result.setDescrizione(input.getDescrizione());
		result.setImporto(input.getImporto());

		return result;
	}
}
