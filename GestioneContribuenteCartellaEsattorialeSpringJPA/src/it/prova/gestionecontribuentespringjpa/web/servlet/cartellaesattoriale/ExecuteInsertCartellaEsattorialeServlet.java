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

		String denominazioneInput = request.getParameter("denominazioneInput");
		String descrizioneInput = request.getParameter("descrizioneInput");
		Integer importoInput = Utility.parseFromStrinToInt(request.getParameter("importoInput"));

		Long idInputContribuente = Long.parseLong(request.getParameter("contribuenteId"));

		if (denominazioneInput.equals("") || descrizioneInput.equals("") || importoInput == null || importoInput <= 0
				|| idInputContribuente == null || idInputContribuente <= 0L) {
			String messaggioDaInviarePagina = "Attenzione, è necessario valorizzare!";
			request.setAttribute("listaContribuentiAttributeName", contribuenteService.listAllContribuenti());
			request.setAttribute("messaggio_errore", messaggioDaInviarePagina);
			destinazione = "/cartellaEsattoriale/aggiungi.jsp";
		} else {

			Contribuente contribuenteInput = new Contribuente(idInputContribuente);
			CartellaEsattoriale cartellaEsattorialeDaInserire = new CartellaEsattoriale(denominazioneInput,
					descrizioneInput, importoInput, contribuenteInput);
			cartellaEsattorialeService.inserisciNuova(cartellaEsattorialeDaInserire);
			request.setAttribute("listaCartelleEsattorialiAttributeName", cartellaEsattorialeService.listAllCartelleEsattoriali());

			destinazione = "/cartellaEsattoriale/result.jsp";

		}

		RequestDispatcher rd = request.getRequestDispatcher(destinazione);
		rd.forward(request, response);
	}

}
