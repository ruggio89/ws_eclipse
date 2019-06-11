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

@WebServlet("/admin/ExecuteDeleteUtenteServlet")
public class ExecuteDeleteUtenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private UtenteService utenteService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
       
    public ExecuteDeleteUtenteServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long idInput = Utility.parseFromStrinToLong(request.getParameter("idInput"));

		Utente utenteDaEliminare = utenteService
				.getEager(idInput);
		utenteService.rimuovi(utenteDaEliminare);
		request.setAttribute("listaUtentiAttributeName",
				utenteService.listAllUtenti());

		RequestDispatcher rd = request.getRequestDispatcher("/admin/result.jsp");
		rd.forward(request, response);
	}
}
