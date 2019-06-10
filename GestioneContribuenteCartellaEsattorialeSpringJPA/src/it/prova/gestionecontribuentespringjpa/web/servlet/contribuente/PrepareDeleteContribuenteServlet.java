package it.prova.gestionecontribuentespringjpa.web.servlet.contribuente;

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

import it.prova.gestionecontribuentespringjpa.model.Contribuente;
import it.prova.gestionecontribuentespringjpa.service.contribuente.ContribuenteService;
import it.prova.gestionecontribuentespringjpa.utility.Utility;


@WebServlet("/PrepareDeleteContribuenteServlet")
public class PrepareDeleteContribuenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Autowired
	private ContribuenteService contribuenteService;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
	
    public PrepareDeleteContribuenteServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("userInfo") == null) {
			response.sendRedirect(request.getContextPath());
			return;
		}
		
		Long idTemp = Utility.parseFromStrinToLong(request.getParameter("idContribuente"));
		Contribuente contribuenteDaEliminare = contribuenteService.caricaSingoloContribuente(idTemp);
		request.setAttribute("contribuentedaeliminare_attribute", contribuenteDaEliminare);
		
		RequestDispatcher rd = request.getRequestDispatcher("/contribuente/confermaElimina.jsp");
		rd.forward(request, response);
	}

}
