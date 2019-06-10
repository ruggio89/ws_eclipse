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

@WebServlet("/PreparaModificaPersonaServlet")
public class PreparaModificaPersonaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private PersonaService personaService;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
       
    public PreparaModificaPersonaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long idTemp = Long.parseLong((String)request.getParameter("idPersona"));
		Persona personaDaInserirePerModifica = personaService.caricaSingolaPersona(idTemp);
		request.setAttribute("personadamodificare_attribute", personaDaInserirePerModifica);
		
		RequestDispatcher rd = request.getRequestDispatcher("modificapersona.jsp");
		rd.forward(request, response);
	}


}
