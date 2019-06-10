package it.prova;

public class Aquila implements Volatile {
	private String razzaAquila;

	public Aquila() {
	}

	public Aquila(String razzaAquila) {
		this.razzaAquila = razzaAquila;
	}

	public String getRazzaAquila() {
		return razzaAquila;
	}

	public void setRazzaAquila(String razzaAquila) {
		this.razzaAquila = razzaAquila;
	}

	@Override
	public void vola() {
		System.out.println("So volare");

	}

	@Override
	public String stampaProprieta() {
		return this.razzaAquila;
	}

	@Override
	public boolean sonoUguale(Volatile input) {
		if(input == null || !(input instanceof Aquila)) {
			return false;
		}
		Aquila temp = (Aquila)input;
		return this.razzaAquila.equals(temp.getRazzaAquila());
	}

}
