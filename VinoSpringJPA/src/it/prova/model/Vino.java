package it.prova.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vino {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;
	private String cantina;
	private String uva;
	private String localita;
	private Integer annata;
	
	public Vino() {
		super();
	}

	public Vino(String nome, String cantina, String uva, String localita, Integer annata) {
		super();
		this.nome = nome;
		this.cantina = cantina;
		this.uva = uva;
		this.localita = localita;
		this.annata = annata;
	}

	public Vino(Long id, String nome, String cantina, String uva, String localita, Integer annata) {
		super();
		this.id = id;
		this.nome = nome;
		this.cantina = cantina;
		this.uva = uva;
		this.localita = localita;
		this.annata = annata;
	}
	
	

	public Vino(String nome, String cantina, String uva, String localita) {
		super();
		this.nome = nome;
		this.cantina = cantina;
		this.uva = uva;
		this.localita = localita;
	}
	
	

	public Vino(Long id, String nome, String cantina, String uva, String localita) {
		super();
		this.id = id;
		this.nome = nome;
		this.cantina = cantina;
		this.uva = uva;
		this.localita = localita;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCantina() {
		return cantina;
	}

	public void setCantina(String cantina) {
		this.cantina = cantina;
	}

	public String getUva() {
		return uva;
	}

	public void setUva(String uva) {
		this.uva = uva;
	}

	public String getLocalita() {
		return localita;
	}

	public void setLocalita(String localita) {
		this.localita = localita;
	}

	public Integer getAnnata() {
		return annata;
	}

	public void setAnnata(Integer annata) {
		this.annata = annata;
	}
	
	

}
