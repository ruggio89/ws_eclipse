package it.prova;

public class Processore extends Componente {

	public Processore() {
	}

	public Processore(String seriale, String nome, PcPortatile pc) {
		this.seriale = seriale;
		this.nome = nome;
		this.pc = pc;
	}

}
