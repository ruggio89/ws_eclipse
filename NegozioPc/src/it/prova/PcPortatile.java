package it.prova;

import java.util.ArrayList;
import java.util.List;

public class PcPortatile {
	private String seriale;
	private String nome;
	private List<Componente> componenti = new ArrayList<>();

	public PcPortatile() {
	}

	public PcPortatile(String seriale, String nome, List<Componente> componenti) {
		super();
		this.seriale = seriale;
		this.nome = nome;
		this.componenti = componenti;
	}

	public String getSeriale() {
		return seriale;
	}

	public void setSeriale(String seriale) {
		this.seriale = seriale;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Componente> getComponenti() {
		return componenti;
	}

	public void setComponenti(List<Componente> componenti) {
		this.componenti = componenti;
	}

	public boolean seSerialeEDiComponente(String numSeriale) {
		for (Componente componente : componenti) {
			if (componente.getSeriale().equals(numSeriale)) {
				return true;
			}
		}
		return false;
	}
}
