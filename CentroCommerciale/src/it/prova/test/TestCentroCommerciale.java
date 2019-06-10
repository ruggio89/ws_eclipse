package it.prova.test;

import java.util.ArrayList;

import java.util.List;

import it.prova.Boss;
import it.prova.CentroCommerciale;
import it.prova.Commesso;
import it.prova.Item;
import it.prova.Lavoratore;
import it.prova.Negozio;
import it.prova.PersonaleAmministrativo;

public class TestCentroCommerciale {

	public static void main(String[] args) {
		Negozio negozioTelevisori = new Negozio();
		Lavoratore commesso1 = new Commesso("Ruggero", "Rossi", "111", negozioTelevisori);
		Lavoratore personaleAmministrativo1 = new PersonaleAmministrativo("Paolo", "Verdi", "222", negozioTelevisori);
		Lavoratore boss1 = new Boss("Francesco", "Totti", "444", negozioTelevisori);

		
		Item televisore1 = new Item("A555");
		Item televisore2 = new Item("B456");
		Item televisore3 = new Item("C443");
	

		
		List<Item> listaTelevisori = new ArrayList<>();
		listaTelevisori.add(televisore1);
		listaTelevisori.add(televisore2);
		listaTelevisori.add(televisore3);
		
		List<Lavoratore> listaLavoratori = new ArrayList<>();
		listaLavoratori.add(commesso1);
		listaLavoratori.add(personaleAmministrativo1);
		listaLavoratori.add(boss1);
		
		CentroCommerciale euroma = new CentroCommerciale();
		
		negozioTelevisori = new Negozio("Trony", 334445, listaTelevisori, listaLavoratori, euroma);
//		Negozio negozioTelevisori2 = new Negozio("Unieuro", 45566, listaTelevisori, listaLavoratori, euroma);
		List<Negozio> listaNegozi = new ArrayList<>();
		listaNegozi.add(negozioTelevisori);
//		listaNegozi.add(negozioTelevisori2);
		
		CentroCommerciale euroma2 = new CentroCommerciale("Euroma", listaNegozi);
		
		
		System.out.println(negozioTelevisori.addToItems(commesso1, televisore3));
		System.out.println(negozioTelevisori.addToItems(personaleAmministrativo1, televisore3));
		System.out.println(negozioTelevisori.addToItems(boss1, televisore3));
		System.out.println(negozioTelevisori.removeFromItem(commesso1, televisore3));
		System.out.println(negozioTelevisori.removeFromItem(personaleAmministrativo1, televisore3));
		System.out.println(negozioTelevisori.removeFromItem(boss1, televisore3));
		


	}

}
