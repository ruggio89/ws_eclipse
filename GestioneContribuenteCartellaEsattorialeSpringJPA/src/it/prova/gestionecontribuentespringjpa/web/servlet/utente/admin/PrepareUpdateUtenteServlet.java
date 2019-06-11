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
import it.prova.gestionecontribuentespringjpa.service.ruolo.RuoloService;
import it.prova.gestionecontribuentespringjpa.service.utente.UtenteService;
import it.prova.gestionecontribuentespringjpa.utility.Utility;

@WebServlet("/admin/PrepareUpdateUtenteServlet")
public class PrepareUpdateUtenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Autowired
	private UtenteService utenteService;
	
	@Autowired
	private RuoloService ruoloService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
	
    public PrepareUpdateUtenteServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long idTemp = Utility.parseFromStrinToLong(request.getParameter("idUtente"));
		Utente utenteDaInserirePerModifica = utenteService.caricaSingoloUtente(idTemp);
		request.setAttribute("utentedamodificare_attribute", utenteDaInserirePerModifica);
		request.setAttribute("listaRuoliAttributeName", ruoloService.listAllRuoli());

		RequestDispatcher rd = request.getRequestDispatcher("/admin/modifica.jsp");
		rd.forward(request, response);
	}


}
