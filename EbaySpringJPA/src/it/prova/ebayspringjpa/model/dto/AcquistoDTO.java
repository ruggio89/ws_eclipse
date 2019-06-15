package it.prova.ebayspringjpa.model.dto;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import it.prova.ebayspringjpa.model.Acquisto;
import it.prova.ebayspringjpa.model.Utente;

public class AcquistoDTO {

	private Long id;
	private String descrizione;
	private Integer anno;
	private double prezzo;
	private Utente utente;

	public AcquistoDTO() {

	}

	public List<String> validate() {
		List<String> listaErrori = new ArrayList<String>();

		if (StringUtils.isEmpty(this.descrizione)) {
			listaErrori.add("Inserire correttamente campo Descrizione");
		}
		if (prezzo < 0) {
			listaErrori.add("Inserire correttamente campo Prezzo");
		}
		return listaErrori;
	}

	public static Acquisto buildAnnuncioIntance(AcquistoDTO input) {
		Acquisto result = new Acquisto();

		result.setDescrizione(input.getDescrizione());
		result.setPrezzo(input.getPrezzo());

		return result;
	}

	public static AcquistoDTO buildAcquistoDTOIntance(Acquisto input) {
		AcquistoDTO result = new AcquistoDTO();

		result.setDescrizione(input.getDescrizione());
		result.setPrezzo(input.getPrezzo());

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

	public Integer getAnno() {
		return anno;
	}

	public void setAnno(Integer anno) {
		this.anno = anno;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

}
