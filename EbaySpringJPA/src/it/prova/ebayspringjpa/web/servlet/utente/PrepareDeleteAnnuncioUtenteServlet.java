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

import it.prova.ebayspringjpa.service.annuncio.AnnuncioService;
import it.prova.ebayspringjpa.utility.Utility;

@WebServlet("/utente/PrepareDeleteAnnuncioUtenteServlet")
public class PrepareDeleteAnnuncioUtenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Autowired
	private AnnuncioService annuncioService;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
    
    public PrepareDeleteAnnuncioUtenteServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long idAnnuncioDaPagina = Utility
				.parseFromStrinToLong(request.getParameter("idAnnuncio"));
		request.setAttribute("annuncioutentedaeliminare_attribute", annuncioService.getEagerCategorieEUtente(idAnnuncioDaPagina));

		RequestDispatcher rd = request.getRequestDispatcher("/utente/confermaEliminaAnnuncio.jsp");
		rd.forward(request, response);
	}

}
