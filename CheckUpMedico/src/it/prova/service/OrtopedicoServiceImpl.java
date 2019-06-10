package it.prova.service;

public class OrtopedicoServiceImpl implements OrtopedicoService{

	RadiologoService radiologoService;
	
	@Override
	public void ortopedicoCheckUp() {
		radiologoService.radiologoCheckUp();
		System.out.println("check up ortopedico effettuato!");
	}

	public RadiologoService getRadiologoService() {
		return radiologoService;
	}

	public void setRadiologoService(RadiologoService radiologoService) {
		this.radiologoService = radiologoService;
	}
	
	

	

}
