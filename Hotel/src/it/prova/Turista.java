package it.prova;

public class Turista extends Cliente{
	
	public Turista(String nome, String cognome) {
		this.nome = nome;
		this.cognome = cognome;
	}

	
	
	@Override
	public int sommaRealeDaPagare() {
		int quota = stanza.getQuotaAPersona();
		return quota;
	}
	
	

}
