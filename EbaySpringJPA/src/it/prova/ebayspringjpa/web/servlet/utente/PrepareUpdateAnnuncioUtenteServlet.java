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
import it.prova.ebayspringjpa.service.categoria.CategoriaService;
import it.prova.ebayspringjpa.utility.Utility;

@WebServlet("/utente/PrepareUpdateAnnuncioUtenteServlet")
public class PrepareUpdateAnnuncioUtenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private AnnuncioService annuncioService;
	
	@Autowired
	private CategoriaService categoriaService;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
       
    public PrepareUpdateAnnuncioUtenteServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Long idTemp = Utility.parseFromStrinToLong(request.getParameter("idAnnuncio"));
		Annuncio annuncioDaInserirePerModifica = annuncioService.caricaSingoloAnnuncio(idTemp);
		request.setAttribute("annunciodamodificare_attribute", annuncioDaInserirePerModifica);
		request.setAttribute("listaCategorieAttributeName", categoriaService.listAllCategorie());

		RequestDispatcher rd = request.getRequestDispatcher("/utente/modificaAnnuncio.jsp");
		rd.forward(request, response);
	}

}
