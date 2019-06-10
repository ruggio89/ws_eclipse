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

/**
 * Servlet implementation class ExecuteEliminaPersonaServlet
 */
@WebServlet("/ExecuteEliminaPersonaServlet")
public class ExecuteEliminaPersonaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private PersonaService personaService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	public ExecuteEliminaPersonaServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Long idInput = Utility.parseFromStrinToLong(request.getParameter("idInput"));
		
		try {
			Persona personaDaEliminare = personaService.caricaSingolaPersona(idInput);
			personaService.rimuovi(personaDaEliminare);
			request.setAttribute("listaPersoneAttributeName", personaService.listPersone());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
		rd.forward(request, response);

	}

	
}



