package it.prova;

public class Ferrari extends Automobile {
	private int tempi;
	private int cavalli;

	public Ferrari() {
	}

	public int getTempi() {
		return tempi;
	}

	public void setTempi(int tempi) {
		this.tempi = tempi;
	}

	public int getCavalli() {
		return cavalli;
	}

	public void setCavalli(int cavalli) {
		this.cavalli = cavalli;
	}

	public void metodo1() {
		System.out.println("Sono in motore");
	}
}
