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

		String nomeInput = request.getParameter("nomeInput");
		String cognomeInput = request.getParameter("cognomeInput");
		String codiceFiscaleInput = request.getParameter("codiceFiscaleInput");
		String indirizzoInput = request.getParameter("indirizzoInput");

		if (nomeInput.equals("") || cognomeInput.equals("") || codiceFiscaleInput.equals("")
				|| indirizzoInput.equals("")) {
			String messaggioDaInviarePagina = "Attenzione, è necessario valorizzare!";
			request.setAttribute("messaggio_errore", messaggioDaInviarePagina);
			destinazione = "/contribuente/aggiungi.jsp";
		} else {
			try {
				Contribuente contribuenteDaInserire = new Contribuente(nomeInput, cognomeInput, codiceFiscaleInput,
						indirizzoInput);
				contribuenteService.inserisciNuovo(contribuenteDaInserire);

				request.setAttribute("listaContribuentiAttributeName", contribuenteService.listAllContribuenti());
				destinazione = "/contribuente/result.jsp";
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		RequestDispatcher rd = request.getRequestDispatcher(destinazione);
		rd.forward(request, response);
	}

}
