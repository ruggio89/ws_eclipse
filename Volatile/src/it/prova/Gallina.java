package it.prova;

public class Gallina implements Volatile {
	private String piumaggio;

	public Gallina() {
	}
	
	public Gallina(String piumaggio) {
		this.piumaggio = piumaggio;
	}
	
	public String getPiumaggio() {
		return piumaggio;
	}

	public void setPiumaggio(String piumaggio) {
		this.piumaggio = piumaggio;
	}

	@Override
	public void vola() {
		System.out.println("Io salto");

	}

	@Override
	public String stampaProprieta() {
		return this.piumaggio;
	}

	@Override
	public boolean sonoUguale(Volatile input) {
		if(input == null || !(input instanceof Gallina)) {
			return false;
		}
		Gallina temp = (Gallina)input;
		return this.piumaggio.equals(temp.getPiumaggio());
	}

}
