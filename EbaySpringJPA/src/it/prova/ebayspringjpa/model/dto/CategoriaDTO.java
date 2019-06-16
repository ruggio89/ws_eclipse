package it.prova.ebayspringjpa.model.dto;

import it.prova.ebayspringjpa.model.Categoria;
import it.prova.ebayspringjpa.model.Utente;

public class CategoriaDTO {

	private Long id;
	private String descrizione;
	private String codice;

	public CategoriaDTO() {

	}

	public CategoriaDTO(Long id, String descrizione, String codice) {
		super();
		this.id = id;
		this.descrizione = descrizione;
		this.codice = codice;
	}

	public CategoriaDTO(String descrizione, String codice) {
		super();
		this.descrizione = descrizione;
		this.codice = codice;
	}
	
	public static Categoria buildCategoriaInstance(UtenteDTO input) {
		Utente result = new Utente();

		result.setNome(input.getNome());
		result.setCognome(input.getCognome());
		result.setUsername(input.getUsername());
		result.setPassword(input.getPassword());
		result.setCreditoResiduo(input.getCreditoResiduo());
		result.setDataRegistrazione(input.getDataRegistrazione());

		return result;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}
}
