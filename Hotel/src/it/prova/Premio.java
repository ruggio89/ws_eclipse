package it.prova;

public class Premio extends Cliente {
	
	public Premio(String nome, String cognome) {
		this.nome = nome;
		this.cognome = cognome;
	}

	@Override
	public int sommaRealeDaPagare() {
		return 0;
	}
	
	

}
