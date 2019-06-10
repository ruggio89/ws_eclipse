package it.prova.web.servlet;

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

import it.prova.model.Vino;
import it.prova.service.VinoService;
import it.prova.utility.Utility;

@WebServlet("/PreparaEliminaVinoServlet")
public class PreparaEliminaVinoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Autowired
	private VinoService vinoService;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
	
    public PreparaEliminaVinoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long idTemp = Utility.parseFromStrinToLong(request.getParameter("idVino"));
		Vino vinoDaEliminare = vinoService.caricaSingoloVino(idTemp);
		request.setAttribute("vinodaeliminare_attribute", vinoDaEliminare);
		
		RequestDispatcher rd = request.getRequestDispatcher("confermaeliminavino.jsp");
		rd.forward(request, response);
	}

	
}
