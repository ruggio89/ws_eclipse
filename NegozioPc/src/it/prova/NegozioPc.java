package it.prova;

import java.util.ArrayList;
import java.util.List;

public class NegozioPc {
	private String nome;
	private String via;
	private List<PcPortatile> listaPc = new ArrayList<PcPortatile>();
	private List<Componente> listaComponentiNegozio = new ArrayList<Componente>();
	private FranchisingNegozi franchisingNegozio = new FranchisingNegozi();

	public NegozioPc() {
	}

	public NegozioPc(String nome, String via, List<PcPortatile> listaPc, List<Componente> listaComponentiNegozio,
			FranchisingNegozi franchisingNegozio) {
		super();
		this.nome = nome;
		this.via = via;
		this.listaPc = listaPc;
		this.listaComponentiNegozio = listaComponentiNegozio;
		this.franchisingNegozio = franchisingNegozio;
	}

	public List<Componente> getListaComponentiNegozio() {
		return listaComponentiNegozio;
	}

	public void setListaComponentiNegozio(List<Componente> listaComponentiNegozio) {
		this.listaComponentiNegozio = listaComponentiNegozio;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<PcPortatile> getListaPc() {
		return listaPc;
	}

	public void setListaPc(List<PcPortatile> listaPc) {
		this.listaPc = listaPc;
	}

	public String getVia() {
		return via;
	}

	public void setVia(String via) {
		this.via = via;
	}

	public FranchisingNegozi getFranchisingNegozio() {
		return franchisingNegozio;
	}

	public void setFranchisingNegozio(FranchisingNegozi franchisingNegozio) {
		this.franchisingNegozio = franchisingNegozio;
	}

	public boolean seSerialeEDiPc(String numSeriale) {
		for (PcPortatile portatile : listaPc) {
			if (portatile.getSeriale().equals(numSeriale)) {
				return true;
			} else if (portatile.seSerialeEDiComponente(numSeriale)) {
				return true;
			}
		}

		return false;
	}

}
