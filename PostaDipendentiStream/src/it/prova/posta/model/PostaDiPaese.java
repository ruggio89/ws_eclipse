package it.prova.posta.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PostaDiPaese {

	private Long id;
	private String denominazione;
	private String indirizzoSede;
	private Date dataApertura;
	private int numeroDipendenti;
	private List<Destinatario> destinatari = new ArrayList<Destinatario>();

	public PostaDiPaese() {
		super();
	}

	public PostaDiPaese(String denominazione, String indirizzoSede, Date dataApertura, int numeroDipendenti) {
		super();
		this.denominazione = denominazione;
		this.indirizzoSede = indirizzoSede;
		this.dataApertura = dataApertura;
		this.numeroDipendenti = numeroDipendenti;
	}

	public PostaDiPaese(Long id, String denominazione, String indirizzoSede, Date dataApertura, int numeroDipendenti,
			List<Destinatario> destinatari) {
		super();
		this.id = id;
		this.denominazione = denominazione;
		this.indirizzoSede = indirizzoSede;
		this.dataApertura = dataApertura;
		this.numeroDipendenti = numeroDipendenti;
		this.destinatari = destinatari;
	}

	public PostaDiPaese(String denominazione, String indirizzoSede, Date dataApertura, int numeroDipendenti,
			List<Destinatario> destinatari) {
		super();
		this.denominazione = denominazione;
		this.indirizzoSede = indirizzoSede;
		this.dataApertura = dataApertura;
		this.numeroDipendenti = numeroDipendenti;
		this.destinatari = destinatari;
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

	public String getIndirizzoSede() {
		return indirizzoSede;
	}

	public void setIndirizzoSede(String indirizzoSede) {
		this.indirizzoSede = indirizzoSede;
	}

	public Date getDataApertura() {
		return dataApertura;
	}

	public void setDataApertura(Date dataApertura) {
		this.dataApertura = dataApertura;
	}

	public int getNumeroDipendenti() {
		return numeroDipendenti;
	}

	public void setNumeroDipendenti(int numeroDipendenti) {
		this.numeroDipendenti = numeroDipendenti;
	}

	public List<Destinatario> getDestinatari() {
		return destinatari;
	}

	public void setDestinatari(List<Destinatario> destinatari) {
		this.destinatari = destinatari;
	}

	@Override
	public String toString() {
		return "PostaDiPaese [id=" + id + ", denominazione=" + denominazione + ", indirizzoSede=" + indirizzoSede
				+ ", dataApertura=" + dataApertura + ", numeroDipendenti=" + numeroDipendenti + ", destinatario="
				+ destinatari + "]";
	}

}
