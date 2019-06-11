package it.prova.gestionecontribuentespringjpa.web.servlet.contribuente;

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

import it.prova.gestionecontribuentespringjpa.model.Contribuente;
import it.prova.gestionecontribuentespringjpa.model.dto.ContribuenteDTO;
import it.prova.gestionecontribuentespringjpa.service.contribuente.ContribuenteService;

@WebServlet("/ExecuteInsertContribuenteServlet")
public class ExecuteInsertContribuenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private ContribuenteService contribuenteService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	public ExecuteInsertContribuenteServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String destinazione = null;
		ContribuenteDTO contribuenteDTO = new ContribuenteDTO();

		contribuenteDTO.setNome(request.getParameter("nomeInput"));
		contribuenteDTO.setCognome(request.getParameter("cognomeInput"));
		contribuenteDTO.setCodiceFiscale(request.getParameter("codiceFiscaleInput"));
		contribuenteDTO.setIndirizzo(request.getParameter("indirizzoInput"));

		if (!contribuenteDTO.validate().isEmpty()) {
			for (String messaggioItem : contribuenteDTO.validate()) {

				request.setAttribute("messaggio_errore", contribuenteDTO.validate());
				destinazione = "/contribuente/aggiungi.jsp";
				RequestDispatcher rd = request.getRequestDispatcher(destinazione);
				rd.forward(request, response);
				return;
			}

		}

		Contribuente contribuenteDaInserire = ContribuenteDTO.buildContribuenteInstance(contribuenteDTO);
		contribuenteService.inserisciNuovo(contribuenteDaInserire);

		request.setAttribute("listaContribuentiAttributeName", contribuenteService.listAllContribuenti());
		destinazione = "/contribuente/result.jsp";

		RequestDispatcher rd = request.getRequestDispatcher(destinazione);
		rd.forward(request, response);

	}

}
