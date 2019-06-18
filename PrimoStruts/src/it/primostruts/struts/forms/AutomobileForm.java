package it.primostruts.struts.forms;

import org.apache.struts.action.ActionForm;

public class AutomobileForm extends ActionForm {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String marca;
	private String modello;
	private Integer cilindrata;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModello() {
		return modello;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

	public Integer getCilindrata() {
		return cilindrata;
	}

	public void setCilindrata(Integer cilindrata) {
		this.cilindrata = cilindrata;
	}

}
