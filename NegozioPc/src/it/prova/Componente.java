package it.prova;

public abstract class Componente {
	protected String seriale;
	protected String nome;
	protected PcPortatile pc;

	public Componente() {
	}

	public Componente(String seriale, String nome, PcPortatile pc) {
		super();
		this.seriale = seriale;
		this.nome = nome;
		this.pc = pc;
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

	public PcPortatile getPc() {
		return pc;
	}

	public void setPc(PcPortatile pc) {
		this.pc = pc;
	}

}
