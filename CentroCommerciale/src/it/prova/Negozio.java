package it.prova;

import java.util.ArrayList;
import java.util.List;

public class Negozio {
	private String ragioneSociale;
	private int partitaIva;
	private List<Item> items = new ArrayList<>();
	private List<Lavoratore> lavoratori = new ArrayList<>();
	private CentroCommerciale centro = new CentroCommerciale();

	public Negozio() {
	}

	public Negozio(String ragioneSociale, int partitaIva, List<Item> items, List<Lavoratore> lavoratori,
			CentroCommerciale centro) {
		super();
		this.ragioneSociale = ragioneSociale;
		this.partitaIva = partitaIva;
		this.items = items;
		this.lavoratori = lavoratori;
		this.centro = centro;
	}

	public String getRagioneSociale() {
		return ragioneSociale;
	}

	public void setRagioneSociale(String ragioneSociale) {
		this.ragioneSociale = ragioneSociale;
	}

	public int getPartitaIva() {
		return partitaIva;
	}

	public void setPartitaIva(int partitaIva) {
		this.partitaIva = partitaIva;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public List<Lavoratore> getLavoratori() {
		return lavoratori;
	}

	public void setLavoratori(List<Lavoratore> lavoratori) {
		this.lavoratori = lavoratori;
	}

	public CentroCommerciale getCentro() {
		return centro;
	}

	public void setCentro(CentroCommerciale centro) {
		this.centro = centro;
	}

	public boolean addToItems(Lavoratore lavoratore, Item item) {
		for (Lavoratore lab : lavoratori) {
			if (lavoratore.getNumeroMatricola().equals(lab.getNumeroMatricola())) {
				lavoratore.handleItemAdd(item);
				return true;
			}
		}
		return false;
	}

	public boolean removeFromItem(Lavoratore lavoratore, Item item) {
		for (Lavoratore lab : lavoratori) {
			if (!(lavoratore.getNumeroMatricola().equals(lab.getNumeroMatricola()))) {

				return false;
			}
		}
		lavoratore.handleItemRemove(item);
		return true;
	}

}
