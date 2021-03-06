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
import it.prova.ebayspringjpa.service.acquisto.AcquistoService;

@WebServlet("/ExecuteBuyAnnuncioServlet")
public class ExecuteBuyAnnuncioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private AcquistoService acquistoService;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
       
    public ExecuteBuyAnnuncioServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		Utente utenteCheAcquista = (Utente) httpRequest.getSession().getAttribute("userInfo");
		
		acquistoService.acquista(Long.parseLong(request.getParameter("idInput")), utenteCheAcquista.getId());
		
		request.setAttribute("listaAcquistiAttributeName", acquistoService.findByUtente(utenteCheAcquista));
		
		RequestDispatcher rd = request.getRequestDispatcher("/utente/resultAcquisti.jsp");
		rd.forward(request, response);
	}

}
