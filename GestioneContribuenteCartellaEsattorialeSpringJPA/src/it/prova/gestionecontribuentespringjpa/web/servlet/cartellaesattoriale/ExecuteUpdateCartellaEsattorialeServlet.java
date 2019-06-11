package it.prova.gestionecontribuentespringjpa.web.servlet.cartellaesattoriale;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import it.prova.gestionecontribuentespringjpa.model.CartellaEsattoriale;
import it.prova.gestionecontribuentespringjpa.model.dto.CartellaEsattorialeDTO;
import it.prova.gestionecontribuentespringjpa.service.cartellaesattoriale.CartellaEsattorialeService;
import it.prova.gestionecontribuentespringjpa.service.contribuente.ContribuenteService;
import it.prova.gestionecontribuentespringjpa.utility.Utility;

@WebServlet("/ExecuteUpdateCartellaEsattorialeServlet")
public class ExecuteUpdateCartellaEsattorialeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private CartellaEsattorialeService cartellaEsattorialeService;

	@Autowired
	private ContribuenteService contribuenteService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	public ExecuteUpdateCartellaEsattorialeServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String destinazione = null;
		CartellaEsattorialeDTO cartellaEsattorialeDTO = new CartellaEsattorialeDTO();

		int importoInput = 0;

		try {
			importoInput = Integer.parseInt((String) request.getParameter("importoInput"));

		} catch (NumberFormatException e) {
			importoInput = -1;
		}

		Long idInputCartellaEsattoriale = Utility.parseFromStrinToLong(request.getParameter("idInput"));
		Long idInputContribuente = Long.parseLong((String) request.getParameter("contribuenteId"));
		cartellaEsattorialeDTO.setDenominazione(request.getParameter("denominazioneInput"));
		cartellaEsattorialeDTO.setDescrizione(request.getParameter("descrizioneInput"));
		cartellaEsattorialeDTO.setId(idInputCartellaEsattoriale);
		cartellaEsattorialeDTO.setImporto(importoInput);
		cartellaEsattorialeDTO.setContribuenteId(idInputContribuente);

		if (!cartellaEsattorialeDTO.validate().isEmpty()) {

			request.setAttribute("messaggio_errore", cartellaEsattorialeDTO.validate());
			request.setAttribute("listaContribuentiAttributeName", contribuenteService.listAllContribuenti());
			Long idTemp = Utility.parseFromStrinToLong(request.getParameter("idInput"));
			CartellaEsattoriale cartellaEsattorialeDaInserirePerModifica = cartellaEsattorialeService
					.caricaSingolaCartellaEsattoriale(idTemp);
			request.setAttribute("cartellaesattorialedamodificare_attribute", cartellaEsattorialeDaInserirePerModifica);
			destinazione = "/cartellaEsattoriale/modifica.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(destinazione);
			rd.forward(request, response);
			return;
		}

		CartellaEsattoriale cartellaEsattorialeDaInserire = CartellaEsattorialeDTO
				.buildCartellaEsattorialeInstance(cartellaEsattorialeDTO);
		cartellaEsattorialeDaInserire.setId(idInputCartellaEsattoriale);
		cartellaEsattorialeDaInserire
				.setContribuente(contribuenteService.caricaSingoloContribuente(idInputContribuente));

		cartellaEsattorialeService.aggiorna(cartellaEsattorialeDaInserire);
		request.setAttribute("listaCartelleEsattorialiAttributeName",
				cartellaEsattorialeService.listAllCartelleEsattoriali());

		destinazione = "/cartellaEsattoriale/result.jsp";

		RequestDispatcher rd = request.getRequestDispatcher(destinazione);
		rd.forward(request, response);

	}
}
