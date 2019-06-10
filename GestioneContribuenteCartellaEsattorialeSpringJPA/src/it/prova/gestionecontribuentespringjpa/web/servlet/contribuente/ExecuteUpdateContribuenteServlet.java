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
import it.prova.gestionecontribuentespringjpa.utility.Utility;

@WebServlet("/ExecuteUpdateContribuenteServlet")
public class ExecuteUpdateContribuenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private ContribuenteService contribuenteService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	public ExecuteUpdateContribuenteServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String destinazione = null;

		Long idInput = Utility.parseFromStrinToLong(request.getParameter("idInput"));
		String nomeInput = request.getParameter("nomeInput");
		String cognomeInput = request.getParameter("cognomeInput");
		String codiceFiscaleInput = request.getParameter("codiceFiscaleInput");
		String indirizzoInput = request.getParameter("indirizzoInput");

		if (nomeInput.equals("") || cognomeInput.equals("") || codiceFiscaleInput.equals("")
				|| indirizzoInput.equals("")) {
			String messaggioDaInviarePagina = "Attenzione, è necessario valorizzare!";
			request.setAttribute("messaggio_errore", messaggioDaInviarePagina);

			Long idTemp = Utility.parseFromStrinToLong(request.getParameter("idInput"));
			Contribuente contribuenteDaInserirePerModifica = contribuenteService.caricaSingoloContribuente(idTemp);
			request.setAttribute("contribuentedamodificare_attribute", contribuenteDaInserirePerModifica);
			destinazione = "/contribuente/modifica.jsp";
		} else {
			try {
				Contribuente contribuenteDaModificare = new Contribuente(idInput, nomeInput, cognomeInput,
						codiceFiscaleInput, indirizzoInput);
				contribuenteService.aggiorna(contribuenteDaModificare);

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
