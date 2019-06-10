package it.prova;

import java.util.ArrayList;
import java.util.List;

public class FranchisingNegozi {
	private String nomeFranchising;
	private List<NegozioPc> listaNegoziPcDelFranchising = new ArrayList<>();
	private List<PcPortatile> listaPcFranchising = new ArrayList<PcPortatile>();
	private List<Componente> componentiFranchising = new ArrayList<>();

	public FranchisingNegozi() {
	}

	public FranchisingNegozi(String nomeFranchising, List<NegozioPc> listaNegoziPcDelFranchising,
			List<PcPortatile> listaPcFranchising, List<Componente> componentiFranchising) {
		super();
		this.nomeFranchising = nomeFranchising;
		this.listaNegoziPcDelFranchising = listaNegoziPcDelFranchising;
		this.listaPcFranchising = listaPcFranchising;
		this.componentiFranchising = componentiFranchising;
	}

	public String getNomeFranchising() {
		return nomeFranchising;
	}

	public void setNomeFranchising(String nomeFranchising) {
		this.nomeFranchising = nomeFranchising;
	}

	public List<NegozioPc> getListaNegoziPcDelFranchising() {
		return listaNegoziPcDelFranchising;
	}

	public void setListaNegoziPcDelFranchising(List<NegozioPc> listaNegoziPcDelFranchising) {
		this.listaNegoziPcDelFranchising = listaNegoziPcDelFranchising;
	}

	/*
	 * public trovaNegozio(String numeroSeriale) { for (NegozioPc negozio :
	 * listaNegoziPcDelFranchising) {
	 * if(negozio.getListaPc().contains(numeroSeriale)) { return true; } } }
	 */

	public List<PcPortatile> getListaPcFranchising() {
		return listaPcFranchising;
	}

	public void setListaPcFranchising(List<PcPortatile> listaPcFranchising) {
		this.listaPcFranchising = listaPcFranchising;
	}

	public List<Componente> getComponentiFranchising() {
		return componentiFranchising;
	}

	public void setComponentiFranchising(List<Componente> componentiFranchising) {
		this.componentiFranchising = componentiFranchising;
	}

	public boolean trovaNegozio(String numSeriale) {
		for (NegozioPc negozio : listaNegoziPcDelFranchising) {
			if (negozio.seSerialeEDiPc(numSeriale)) {
				System.out.println("Negozio trovato = " + negozio.getNome() + ". Contattare Assistenza tecnica");
				return true;
			}
		}
		System.out.println("Mi dispiace, probabilmente il seriale è sbagliato o non ha acquistato nei nostri negozi");
		return false;
	}

//	altro metodo, dandogli in input anche il portatile ci dice se si tratta di una componente
	public boolean trovaNegozio2(String numSeriale, PcPortatile portatile) {
		for (NegozioPc negozio : listaNegoziPcDelFranchising) {
			if (negozio.seSerialeEDiPc(numSeriale)) {
				System.out.println("Negozio trovato = " + negozio.getNome() + ". Sostituisci il pc");
				return true;
			} else if (portatile.seSerialeEDiComponente(numSeriale)) {
				System.out.println("Negozio trovato = " + negozio.getNome() + ". Sostituisci la componente");
				return true;
			}
		}
		System.out.println("Mi dispiace, probabilmente il seriale è sbagliato o non ha acquistato nei nostri negozi");
		return false;
	}

}
