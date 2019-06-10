package it.prova;

public class Pinguino implements Volatile {
	private String continenteAppartenenza;

	public Pinguino() {
	}
	
	public Pinguino(String continenteAppartenenza) {
		this.continenteAppartenenza = continenteAppartenenza;
	}

	public String getContinenteAppartenenza() {
		return continenteAppartenenza;
	}

	public void setContinenteAppartenenza(String continenteAppartenenza) {
		this.continenteAppartenenza = continenteAppartenenza;
	}

	@Override
	public void vola() {
		System.out.println("Io non volo");
	}

	@Override
	public String stampaProprieta() {
		return this.continenteAppartenenza;
	}

	@Override
	public boolean sonoUguale(Volatile input) {
		if(input == null || !(input instanceof Pinguino)) {
			return false;
		}
		Pinguino temp =  (Pinguino)input;
		return this.continenteAppartenenza.equals(temp.getContinenteAppartenenza());
	}

}
