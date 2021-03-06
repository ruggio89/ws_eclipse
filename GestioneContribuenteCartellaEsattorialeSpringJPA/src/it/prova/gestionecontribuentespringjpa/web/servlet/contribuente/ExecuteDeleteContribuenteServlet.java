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

@WebServlet("/ExecuteDeleteContribuenteServlet")
public class ExecuteDeleteContribuenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private ContribuenteService contribuenteService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	public ExecuteDeleteContribuenteServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Long idInput = Utility.parseFromStrinToLong(request.getParameter("idInput"));

		try {
			Contribuente contribuenteDaEliminare = contribuenteService.caricaSingoloContribuente(idInput);
			contribuenteService.rimuovi(contribuenteDaEliminare);
			request.setAttribute("listaContribuentiAttributeName", contribuenteService.listAllContribuenti());
		} catch (Exception e) {
			e.printStackTrace();
		}

		RequestDispatcher rd = request.getRequestDispatcher("/contribuente/result.jsp");
		rd.forward(request, response);
	}

}
