package it.prova.test;

import java.util.ArrayList;
import java.util.List;

import it.prova.Componente;
import it.prova.FranchisingNegozi;
import it.prova.NegozioPc;
import it.prova.PcPortatile;
import it.prova.Processore;
import it.prova.SchedaMadre;

public class TestNegozioPc {
	public static void main(String[] args) {
		FranchisingNegozi franchisingEuronics = new FranchisingNegozi();
		
		NegozioPc negozioEuronicsViaMosca = new NegozioPc();
		NegozioPc negozioEuronicsViaRoma = new NegozioPc();
		
		PcPortatile pcAsus = new PcPortatile();
		PcPortatile pcMsi = new PcPortatile();
		
		Componente schedaMadreAsus = new SchedaMadre("F55G", "Strix-ggt", pcAsus);
		Componente schedaMadreMsi = new SchedaMadre("H66U", "Msi-hhtn", pcMsi);
		Componente processoreIntel = new Processore("H00P", "Intel i5", pcAsus);
		Componente processoreAmd = new Processore("M44W", "AMD dual core", pcMsi);
		List<Componente> listaComponentiPcAsus = new ArrayList<Componente>();
		listaComponentiPcAsus.add(schedaMadreAsus);
		listaComponentiPcAsus.add(processoreIntel);
		List<Componente> listaComponentiPcMsi = new ArrayList<Componente>();
		listaComponentiPcMsi.add(schedaMadreMsi);
		listaComponentiPcMsi.add(processoreAmd);
		
		pcAsus.setSeriale("ASUS0098");
		pcAsus.setNome("Asus Rog");
		pcAsus.setComponenti(listaComponentiPcAsus);
		pcMsi.setSeriale("MSIXX44");
		pcMsi.setNome("Msi Titan");
		pcMsi.setComponenti(listaComponentiPcMsi);
		
		List<PcPortatile> listaPcAsus = new ArrayList<PcPortatile>();
		listaPcAsus.add(pcAsus);
		List<PcPortatile> listaPcMsi = new ArrayList<PcPortatile>();
		listaPcMsi.add(pcMsi);
		
		negozioEuronicsViaMosca.setNome("Euronics Tufano");
		negozioEuronicsViaMosca.setVia("Via Mosca");
		negozioEuronicsViaMosca.setListaPc(listaPcAsus);
		negozioEuronicsViaMosca.setFranchisingNegozio(franchisingEuronics);
		negozioEuronicsViaRoma.setNome("Euronics Nuovo");
		negozioEuronicsViaRoma.setVia("Via Roma");
		negozioEuronicsViaRoma.setListaPc(listaPcMsi);
		negozioEuronicsViaRoma.setFranchisingNegozio(franchisingEuronics);
		
		List<NegozioPc> listaNegoziPc = new ArrayList<NegozioPc>();
		listaNegoziPc.add(negozioEuronicsViaRoma);
		listaNegoziPc.add(negozioEuronicsViaMosca);
		
		List<PcPortatile> listaPcTutti = new ArrayList<PcPortatile>();
		listaPcTutti.add(pcMsi);
		listaPcTutti.add(pcAsus);
		
		List<Componente> listaComponentiTutti = new ArrayList<Componente>();
		listaComponentiTutti.add(processoreAmd);
		listaComponentiTutti.add(processoreIntel);
		listaComponentiTutti.add(schedaMadreMsi);
		listaComponentiTutti.add(schedaMadreAsus);
		
		franchisingEuronics.setNomeFranchising("Euronics");
		franchisingEuronics.setListaNegoziPcDelFranchising(listaNegoziPc);
		franchisingEuronics.setListaPcFranchising(listaPcTutti);
		franchisingEuronics.setComponentiFranchising(listaComponentiTutti);
		
//		testo il metodo trovaNegozio per trovare il negozio in base al seriale inserito
		franchisingEuronics.trovaNegozio("F55G");
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
