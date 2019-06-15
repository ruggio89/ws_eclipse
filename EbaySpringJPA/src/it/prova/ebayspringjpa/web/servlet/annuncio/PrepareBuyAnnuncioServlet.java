package it.prova.ebayspringjpa.web.servlet.annuncio;

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
import it.prova.ebayspringjpa.service.annuncio.AnnuncioService;
import it.prova.ebayspringjpa.utility.Utility;

@WebServlet("/PrepareBuyAnnuncioServlet")
public class PrepareBuyAnnuncioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Autowired
	private AnnuncioService annuncioService;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
	
    public PrepareBuyAnnuncioServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		Utente utente = (Utente) httpRequest.getSession().getAttribute("userInfo");
		
		if(utente == null) {
			RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
			rd.forward(request, response);
		} else {
			Long idAnnuncioDaPagina = Utility
					.parseFromStrinToLong(request.getParameter("idAnnuncio"));
			request.setAttribute("annunciodacomprare_attribute", annuncioService.getEagerCategorieEUtente(idAnnuncioDaPagina));
			
			RequestDispatcher rd = request.getRequestDispatcher("/annuncio/confermaAcquisto.jsp");
			rd.forward(request, response);
		}
	}

}
