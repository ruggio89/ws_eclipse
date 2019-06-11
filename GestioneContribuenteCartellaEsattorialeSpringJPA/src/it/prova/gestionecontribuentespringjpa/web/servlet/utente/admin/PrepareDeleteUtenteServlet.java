package it.prova.gestionecontribuentespringjpa.web.servlet.utente.admin;

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

import it.prova.gestionecontribuentespringjpa.model.Utente;
import it.prova.gestionecontribuentespringjpa.service.utente.UtenteService;
import it.prova.gestionecontribuentespringjpa.utility.Utility;

@WebServlet("/admin/PrepareDeleteUtenteServlet")
public class PrepareDeleteUtenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private UtenteService utenteService;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
       
    public PrepareDeleteUtenteServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long idTemp = Utility.parseFromStrinToLong(request.getParameter("idUtente"));
		Utente utenteDaEliminare = utenteService.getEager(idTemp);
		request.setAttribute("utentedaeliminare_attribute", utenteDaEliminare);
		
		RequestDispatcher rd = request.getRequestDispatcher("/admin/confermaElimina.jsp");
		rd.forward(request, response);
	}

}
