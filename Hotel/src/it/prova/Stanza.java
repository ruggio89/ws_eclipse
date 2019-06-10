package it.prova;

public class Stanza {
	private int quotaAPersona;
	private int nStanza;
	private Cliente[] clienti;
	private Hotel hotel;
	
	public Stanza() {}
	
	public Stanza(int quotaAPersona, int nStanza, Cliente[] clienti) {
		this.quotaAPersona = quotaAPersona;
		this.nStanza = nStanza;
		this.clienti = clienti;
	}

	public int getQuotaAPersona() {
		return quotaAPersona;
	}

	public void setQuotaAPersona(int quotaAPersona) {
		this.quotaAPersona = quotaAPersona;
	}

	public int getnStanza() {
		return nStanza;
	}

	public void setnStanza(int nStanza) {
		this.nStanza = nStanza;
	}

	public Cliente[] getClienti() {
		return clienti;
	}

	public void setClienti(Cliente[] clienti) {
		this.clienti = clienti;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	

	
	
	
	
}
