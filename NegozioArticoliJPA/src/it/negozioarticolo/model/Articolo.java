package it.negozioarticolo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "articolo")
public class Articolo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	@Column(name = "nome")
	private String nome;
	@Column(name = "tipologia")
	private String tipologia;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "negozio_id", nullable = false)
	private Negozio negozio;

	public Articolo() {
	}

	public Articolo(Long id, String nome, String tipologia, Negozio negozio) {
		super();
		this.id = id;
		this.nome = nome;
		this.tipologia = tipologia;
		this.negozio = negozio;
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

	public String getTipologia() {
		return tipologia;
	}

	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}

	public Negozio getNegozio() {
		return negozio;
	}

	public void setNegozio(Negozio negozio) {
		this.negozio = negozio;
	}

}
