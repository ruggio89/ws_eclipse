package it.prova.service;

public class CheckUpServiceImpl implements CheckUpService {

	private EmatologoService ematologoService;
	private CardiologoService cardiologoService;
	private OrtopedicoService ortopedicoService;
	private MedicoGenericoService medicoGenericoService;
	private RadiologoService radiologoService;

	@Override
	public void checkUpCompleto() {
		System.out.println("Avvio check up completo del paziente.....");
		ematologoService.ematologoCheckUp();
		cardiologoService.cardiologoCheckUp();
		ortopedicoService.ortopedicoCheckUp();
		medicoGenericoService.medicoGenericoCheckUp();
		System.out.println("Check Up completato....");

	}

	public EmatologoService getEmatologoService() {
		return ematologoService;
	}

	public void setEmatologoService(EmatologoService ematologoService) {
		this.ematologoService = ematologoService;
	}

	public OrtopedicoService getOrtopedicoService() {
		return ortopedicoService;
	}

	public void setOrtopedicoService(OrtopedicoService ortopedicoService) {
		this.ortopedicoService = ortopedicoService;
	}

	public MedicoGenericoService getMedicoGenericoService() {
		return medicoGenericoService;
	}

	public void setMedicoGenericoService(MedicoGenericoService medicoGenericoService) {
		this.medicoGenericoService = medicoGenericoService;
	}

	public CardiologoService getCardiologoService() {
		return cardiologoService;
	}

	public void setCardiologoService(CardiologoService cardiologoService) {
		this.cardiologoService = cardiologoService;
	}

	public RadiologoService getRadiologoService() {
		return radiologoService;
	}

	public void setRadiologoService(RadiologoService radiologoService) {
		this.radiologoService = radiologoService;
	}

}
