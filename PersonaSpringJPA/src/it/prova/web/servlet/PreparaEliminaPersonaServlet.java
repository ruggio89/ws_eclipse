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

@WebServlet("/PreparaEliminaPersonaServlet")
public class PreparaEliminaPersonaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private PersonaService personaService;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	public PreparaEliminaPersonaServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Long idTemp = Long.parseLong((String)request.getParameter("idPersona"));
		Persona personaDaEmilinare = personaService.caricaSingolaPersona(idTemp);
		request.setAttribute("personadaeliminare_attribute", personaDaEmilinare);
		
		RequestDispatcher rd = request.getRequestDispatcher("confermaeliminapersona.jsp");
		rd.forward(request, response);
	}

}
