package it.prova;

public class Raccoglitore {
	private String colore;
	private int spessore;
	private Foglio[] fogli;

	public Raccoglitore() {
	}
	
	public String getColore() {
		return colore;
	}

	public void setColore(String colore) {
		this.colore = colore;
	}

	public int getSpessore() {
		return spessore;
	}

	public void setSpessore(int spessore) {
		this.spessore = spessore;
	}

	public Foglio[] getFogli() {
		return fogli;
	}

	public void setFogli(Foglio[] fogli) {
		this.fogli = fogli;
	}
	
	public void addToFogli(Foglio f) {
		if(fogli == null) {
			fogli = new Foglio[1];
			fogli[0] = f;
			return;
		}
		Foglio[] temp = new Foglio[this.fogli.length + 1];
		for (int i = 0; i < fogli.length; i++) {
			temp[i] = fogli[i];
		}
		temp[temp.length - 1] = f;
		this.fogli = temp;
		
	}
	
	public void removeFrom(int indexToRemove) {
		if(fogli == null) {
			return;
		}
		int contatore = 0;
		Foglio[] temp = new Foglio[fogli.length - 1];
		for (int i = 0; i < fogli.length; i++) {
			if(i != indexToRemove) {
				temp[contatore] = fogli[i];
				contatore ++;
			}
		}
		this.fogli = temp;
		
	}
	
	public void stampaArray() {
		for (int i = 0; i < fogli.length; i++) {
			System.out.println(this.fogli[i].getTipologia() + " " + this.fogli[i].getQualita());
		}
	}
	
	
	
	

}
