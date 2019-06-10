package it.prova.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.prova.dao.DbMock;
import it.prova.dao.MateriaPrimaDAO;
import it.prova.model.MateriaPrima;

@Component
public class MateriaPrimaServiceImpl implements MateriaPrimaService{
	@Autowired
	private AssemblaggioService assemblaggioService;
	@Autowired
	private LavorazioneService lavorazioneService;
	@Autowired
	private MessaInOperaService messaInOperaService;
	@Autowired
	private VerniciaturaService verniciaturaService;
	@Autowired
	private ProntaService prontaService;
	@Autowired
	private MateriaPrimaDAO materiaPrimaDAO;
	
	
	@Override
	public void avviaLavorazione(MateriaPrima input) {
		System.out.println("Inizio lavorazione........................");
		System.out.println("************************************");
		for (MateriaPrima mPrima : DbMock.MATERIAPRIMA) {
			System.out.println("Inizio lavorazione: " + input);
			lavorazioneService.statoLavorazione(input);
			assemblaggioService.statoAssemblaggio(input);
			verniciaturaService.statoVerniciatura(input);
			messaInOperaService.statoMessaInOpera(input);
			prontaService.statoPronta(input);
		}
		System.out.println("************************************");
		System.out.println("Termine lavorazione........................");
		
	}

	@Override
	public MateriaPrima caricaMateriaPrima(int id) {
		return materiaPrimaDAO.get(id);
	}

}