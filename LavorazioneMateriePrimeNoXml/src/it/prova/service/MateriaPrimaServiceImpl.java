package it.prova.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.prova.dao.MateriaPrimaDAO;
import it.prova.model.MateriaPrima;

@Component
public class MateriaPrimaServiceImpl implements MateriaPrimaService {

	@Autowired
	private LavorazioneService lavorazioneService;
	@Autowired
	private AssemblaggioService assemblaggioService;
	@Autowired
	private VerniciaturaService verniciaturaService;
	@Autowired
	private MessaInOperaService messaInOperaService;
	@Autowired
	private ProntaService prontaService;
	@Autowired
	private MateriaPrimaDAO materiaPrimaDAO;
		
	@Override
	public void avviaLavorazione(MateriaPrima input) {
		System.out.println("Inizio lavorazione........................");
		System.out.println("************************************");
		System.out.println(input);
		lavorazioneService.statoInLavorazione(input);
		assemblaggioService.statoAssemblaggio(input);
		verniciaturaService.statoVerniciatura(input);
		messaInOperaService.statoMessaInOpera(input);
		prontaService.statoPronta(input);
		System.out.println("************************************");
		System.out.println("Termine lavorazione........................");

	}

	public LavorazioneService getLavorazioneService() {
		return lavorazioneService;
	}

	public void setLavorazioneService(LavorazioneService lavorazioneService) {
		this.lavorazioneService = lavorazioneService;
	}

	public AssemblaggioService getAssemblaggioService() {
		return assemblaggioService;
	}

	public void setAssemblaggioService(AssemblaggioService assemblaggioService) {
		this.assemblaggioService = assemblaggioService;
	}

	public VerniciaturaService getVerniciaturaService() {
		return verniciaturaService;
	}

	public void setVerniciaturaService(VerniciaturaService verniciaturaService) {
		this.verniciaturaService = verniciaturaService;
	}

	public MessaInOperaService getMessaInOperaService() {
		return messaInOperaService;
	}

	public void setMessaInOperaService(MessaInOperaService messaInOperaService) {
		this.messaInOperaService = messaInOperaService;
	}

	public ProntaService getProntaService() {
		return prontaService;
	}

	public void setProntaService(ProntaService prontaService) {
		this.prontaService = prontaService;
	}

	public MateriaPrimaDAO getMateriaPrimaDAO() {
		return materiaPrimaDAO;
	}

	public void setMateriaPrimaDAO(MateriaPrimaDAO materiaPrimaDAO) {
		this.materiaPrimaDAO = materiaPrimaDAO;
	}
	
	

}
