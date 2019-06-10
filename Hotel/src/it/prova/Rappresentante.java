package it.prova;

public class Rappresentante extends Cliente {
	
	public Rappresentante(String nome, String cognome) {
		this.nome = nome;
		this.cognome = cognome;
	}

	@Override
	public int sommaRealeDaPagare() {
		int sconto = (stanza.getQuotaAPersona() * 20) / 100;
		int quota = stanza.getQuotaAPersona() - sconto;
		return quota;
	}

}
