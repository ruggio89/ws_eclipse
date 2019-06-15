package it.prova.ebayspringjpa.web.servlet.utente;

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

import it.prova.ebayspringjpa.model.Annuncio;
import it.prova.ebayspringjpa.service.annuncio.AnnuncioService;
import it.prova.ebayspringjpa.utility.Utility;

@WebServlet("/utente/ExecuteDeleteAnnuncioUtenteServlet")
public class ExecuteDeleteAnnuncioUtenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private AnnuncioService annuncioService;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
       
    public ExecuteDeleteAnnuncioUtenteServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long idTemp = Utility.parseFromStrinToLong(request.getParameter("idInput"));
		Annuncio annuncioUtenteDaEliminare = annuncioService.getEagerCategorieEUtente(idTemp);
		
		annuncioService.rimuovi(annuncioUtenteDaEliminare);
		
		request.setAttribute("listaAnnunciAttributeName", annuncioService.listAllAnnunci());
		
		RequestDispatcher rd = request.getRequestDispatcher("/utente/result.jsp");
		rd.forward(request, response);
	}
	
}
