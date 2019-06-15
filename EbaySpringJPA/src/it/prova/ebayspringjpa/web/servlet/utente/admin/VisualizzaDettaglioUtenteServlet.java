package it.prova.ebayspringjpa.web.servlet.utente.admin;

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

import it.prova.ebayspringjpa.model.Utente;
import it.prova.ebayspringjpa.service.utente.UtenteService;
import it.prova.ebayspringjpa.utility.Utility;

@WebServlet("/admin/VisualizzaDettaglioUtenteServlet")
public class VisualizzaDettaglioUtenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Autowired
	private UtenteService utenteService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
       
    public VisualizzaDettaglioUtenteServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long idUtenteDaPagina = Utility
				.parseFromStrinToLong(request.getParameter("idUtente"));
		Utente utenteDaPagina = utenteService
				.caricaEager(idUtenteDaPagina);

		request.setAttribute("UtenteSingolaAttributeName", utenteDaPagina);

		RequestDispatcher rd = request.getRequestDispatcher("/admin/dettaglio.jsp");
		rd.forward(request, response);
	}

}
