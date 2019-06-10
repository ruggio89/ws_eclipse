package it.prova.web.servlet;

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

import it.prova.model.Persona;
import it.prova.service.PersonaService;
import it.prova.utility.Utility;

@WebServlet("/ExecuteModificaPersonaServlet")
public class ExecuteModificaPersonaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private PersonaService personaService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	public ExecuteModificaPersonaServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String destinazione = null;

		Long idInput = Utility.parseFromStrinToLong(request.getParameter("idInput"));
		Integer etaInputParsed = Utility.parseFromStrinToInt(request.getParameter("etaInput"));
		String nomeInput = request.getParameter("nomeInput");
		String cognomeInput = request.getParameter("cognomeInput");
		String codiceFiscaleInput = request.getParameter("cfInput");
		String indirizzoInput = request.getParameter("indirizzoInput");

		if (nomeInput.equals("") || cognomeInput.equals("") || codiceFiscaleInput.equals("")
				|| indirizzoInput.equals("") || etaInputParsed == null || etaInputParsed <= 0) {
			String messaggioDaInviarePagina = "Attenzione, è necessario valorizzare!";
			request.setAttribute("messaggio_errore", messaggioDaInviarePagina);
			Long idTemp = Utility.parseFromStrinToLong(request.getParameter("idInput"));
			Persona personaDaInserirePerModifica = personaService.caricaSingolaPersona(idTemp);
			request.setAttribute("personadamodificare_attribute", personaDaInserirePerModifica);
			destinazione = "modificapersona.jsp";
		} else {
			try {
				Persona personaDaModificare = new Persona(idInput, nomeInput, cognomeInput, codiceFiscaleInput, indirizzoInput,
						etaInputParsed);
				personaService.aggiorna(personaDaModificare);
				request.setAttribute("listaPersoneAttributeName", personaService.listPersone());
				destinazione = "result.jsp";
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		RequestDispatcher rd = request.getRequestDispatcher(destinazione);
		rd.forward(request, response);
	}

}
