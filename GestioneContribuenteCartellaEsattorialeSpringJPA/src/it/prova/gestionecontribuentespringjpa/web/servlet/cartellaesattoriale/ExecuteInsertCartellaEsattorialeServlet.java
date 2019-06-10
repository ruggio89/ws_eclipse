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
import it.prova.gestionecontribuentespringjpa.model.Contribuente;
import it.prova.gestionecontribuentespringjpa.model.dto.CartellaEsattorialeDTO;
import it.prova.gestionecontribuentespringjpa.model.dto.ContribuenteDTO;
import it.prova.gestionecontribuentespringjpa.service.cartellaesattoriale.CartellaEsattorialeService;
import it.prova.gestionecontribuentespringjpa.service.contribuente.ContribuenteService;
import it.prova.gestionecontribuentespringjpa.utility.Utility;

@WebServlet("/ExecuteInsertCartellaEsattorialeServlet")
public class ExecuteInsertCartellaEsattorialeServlet extends HttpServlet {
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

	public ExecuteInsertCartellaEsattorialeServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String destinazione = null;
		int importoInputId = 0;
		Long contribuenteInputId = 0L;

		try {
			importoInputId = Integer.parseInt((String) request.getParameter("importoInput"));
			contribuenteInputId = Long.parseLong((String) request.getParameter("contribuenteId"));
		} catch (NumberFormatException e) {
			importoInputId = -1;
			contribuenteInputId = -1L;
		}
		
		CartellaEsattorialeDTO cartellaEsattorialeDTO = new CartellaEsattorialeDTO();

		cartellaEsattorialeDTO.setDenominazione(request.getParameter("denominazioneInput"));
		cartellaEsattorialeDTO.setDescrizione(request.getParameter("descrizioneInput"));
		cartellaEsattorialeDTO.setImporto(importoInputId);
		cartellaEsattorialeDTO.setContribuenteId(contribuenteInputId);
		

		if (!cartellaEsattorialeDTO.validate().isEmpty()) {
			for (String messaggioItem : cartellaEsattorialeDTO.validate()) {
				
				request.setAttribute("listaContribuentiAttributeName", contribuenteService.listAllContribuenti());
				request.setAttribute("messaggio_errore", cartellaEsattorialeDTO.validate());
				destinazione = "/cartellaEsattoriale/aggiungi.jsp";
				RequestDispatcher rd = request.getRequestDispatcher(destinazione);
				rd.forward(request, response);
			}
//			String messaggioDaInviarePagina = "Attenzione, è necessario valorizzare!";
//			request.setAttribute("listaContribuentiAttributeName", contribuenteService.listAllContribuenti());
//			request.setAttribute("messaggio_errore", messaggioDaInviarePagina);
//			destinazione = "/cartellaEsattoriale/aggiungi.jsp";
//		} else {
//
//			Contribuente contribuenteInput = new Contribuente(idInputContribuente);
//			CartellaEsattoriale cartellaEsattorialeDaInserire = CartellaEsattorialeDTO.buildCartellaEsattorialeInstance(cartellaEsattorialeDTO);
//			cartellaEsattorialeDaInserire.setContribuente(contribuenteInput);
//			
//			cartellaEsattorialeService.inserisciNuova(cartellaEsattorialeDaInserire);
//			request.setAttribute("listaCartelleEsattorialiAttributeName", cartellaEsattorialeService.listAllCartelleEsattoriali());
//
//			destinazione = "/cartellaEsattoriale/result.jsp";
//
//		}
		
		CartellaEsattoriale cartellaEsattorialeDaInserire = CartellaEsattorialeDTO.buildCartellaEsattorialeInstance(cartellaEsattorialeDTO);
		cartellaEsattorialeDaInserire.setContribuente(contribuenteService.caricaSingoloContribuente(contribuenteInputId));
		
		cartellaEsattorialeService.inserisciNuova(cartellaEsattorialeDaInserire);
		request.setAttribute("listaCartelleEsattorialiAttributeName", cartellaEsattorialeService.listAllCartelleEsattoriali());

		destinazione = "/cartellaEsattoriale/result.jsp";

		RequestDispatcher rd = request.getRequestDispatcher(destinazione);
		rd.forward(request, response);
		}
	}

}
