package it.concessionariomotociclojpa.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "concessionario")
public class Concessionario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String denominazione;
	private String citta;
	private String partitaIva;
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "concessionario", orphanRemoval = true)
	private Set<Motociclo> motocicli = new HashSet<>();

	public Concessionario() {
	}

	public Concessionario(String denominazione, String citta, String partitaIva) {
		super();
		this.denominazione = denominazione;
		this.citta = citta;
		this.partitaIva = partitaIva;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDenominazione() {
		return denominazione;
	}

	public void setDenominazione(String denominazione) {
		this.denominazione = denominazione;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public String getPartitaIva() {
		return partitaIva;
	}

	public void setPartitaIva(String partitaIva) {
		this.partitaIva = partitaIva;
	}

	public Set<Motociclo> getMotocicli() {
		return motocicli;
	}

	public void setMotocicli(Set<Motociclo> motocicli) {
		this.motocicli = motocicli;
	}

	@Override
	public String toString() {
		return "Concessionario [id=" + id + ", denominazione=" + denominazione + ", citta=" + citta + ", partitaIva="
				+ partitaIva + "]";
	}

}
