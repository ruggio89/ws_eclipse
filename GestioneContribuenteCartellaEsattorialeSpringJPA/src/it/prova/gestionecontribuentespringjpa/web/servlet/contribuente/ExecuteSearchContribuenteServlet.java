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

@WebServlet("/ExecuteSearchContribuenteServlet")
public class ExecuteSearchContribuenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private ContribuenteService contribuenteService;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	public ExecuteSearchContribuenteServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nomeInput = request.getParameter("nomeInput");
		String cognomeInput = request.getParameter("cognomeInput");
		String codiceFiscaleInput = request.getParameter("codiceFiscaleInput");

		Contribuente example = new Contribuente(nomeInput, cognomeInput, codiceFiscaleInput);

		request.setAttribute("listaContribuentiAttributeName", contribuenteService.findByExample(example));

		RequestDispatcher rd = request.getRequestDispatcher("/contribuente/result.jsp");
		rd.forward(request, response);
	}

}
