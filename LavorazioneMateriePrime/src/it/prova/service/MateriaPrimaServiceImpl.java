package it.prova.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.prova.dao.DbMock;
import it.prova.dao.MateriaPrimaDao;
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
	private MateriaPrimaDao materiaPrimaDao;

	@SuppressWarnings("unused")
	@Override
	public void avviaProcessoDiLavorazioneMateriaPrima(MateriaPrima input) {
		System.out.println("Inizio lavorazione........................");
		System.out.println("************************************");
		for (MateriaPrima mPrima : DbMock.MATERIAPRIMA) {
			System.out.println("Inizio lavorazione: " + input);
			lavorazioneService.statoLavorazione(input);
			assemblaggioService.statoInAssemblaggio(input);
			verniciaturaService.statoInVerniciatura(input);
			messaInOperaService.statoInMessaInOpera(input);
			prontaService.statoPronta(input);
		}
		System.out.println("************************************");
		System.out.println("Termine lavorazione........................");

	}

	@Override
	public MateriaPrima caricaMateriaPrima(int id) {
		return materiaPrimaDao.get(id);
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

	public MateriaPrimaDao getMateriaPrimaDao() {
		return materiaPrimaDao;
	}

	public void setMateriaPrimaDao(MateriaPrimaDao materiaPrimaDao) {
		this.materiaPrimaDao = materiaPrimaDao;
	}

	public ProntaService getProntaService() {
		return prontaService;
	}

	public void setProntaService(ProntaService prontaService) {
		this.prontaService = prontaService;
	}

}
