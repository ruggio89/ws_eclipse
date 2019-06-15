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

import it.prova.ebayspringjpa.service.annuncio.AnnuncioService;
import it.prova.ebayspringjpa.utility.Utility;


@WebServlet("/VisualizzaDettaglioAnnuncioServlet")
public class VisualizzaDettaglioAnnuncioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Autowired
	private AnnuncioService annuncioService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
	
    public VisualizzaDettaglioAnnuncioServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Long idAnnuncioDaPagina = Utility
				.parseFromStrinToLong(request.getParameter("idAnnuncio"));

		request.setAttribute("AnnuncioSingoloAttributeName", annuncioService.getEagerCategorieEUtente(idAnnuncioDaPagina));

		RequestDispatcher rd = request.getRequestDispatcher("/annuncio/dettaglio.jsp");
		rd.forward(request, response);
	}

}
