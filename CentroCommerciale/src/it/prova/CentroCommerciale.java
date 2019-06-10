package it.prova;

import java.util.List;

public class CentroCommerciale {
	private String nomeCentro;
	private List<Negozio> negozi;
	
	public CentroCommerciale() {}

	public CentroCommerciale(String nomeCentro, List<Negozio> negozi) {
		this.nomeCentro = nomeCentro;
		this.negozi = negozi;
	}

	public String getNomeCentro() {
		return nomeCentro;
	}

	public void setNomeCentro(String nomeCentro) {
		this.nomeCentro = nomeCentro;
	}

	public List<Negozio> getNegozi() {
		return negozi;
	}

	public void setNegozi(List<Negozio> negozi) {
		this.negozi = negozi;
	}
	
	
	
	
	
}
