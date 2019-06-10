package it.prova.gestionecontribuentespringjpa.web.servlet.cartellaesattoriale;

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

import it.prova.gestionecontribuentespringjpa.model.CartellaEsattoriale;
import it.prova.gestionecontribuentespringjpa.model.dto.CartellaEsattorialeDTO;
import it.prova.gestionecontribuentespringjpa.service.cartellaesattoriale.CartellaEsattorialeService;
import it.prova.gestionecontribuentespringjpa.service.contribuente.ContribuenteService;
import it.prova.gestionecontribuentespringjpa.utility.Utility;


@WebServlet("/PrepareUpdateCartellaEsattorialeServlet")
public class PrepareUpdateCartellaEsattorialeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Autowired
	private CartellaEsattorialeService cartellaEsattorialeService;
	
	@Autowired
	private ContribuenteService contribuenteService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
	
    public PrepareUpdateCartellaEsattorialeServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("userInfo") == null) {
			response.sendRedirect(request.getContextPath());
			return;
		}
		
		Long idTemp = Utility.parseFromStrinToLong(request.getParameter("idCartellaEsattoriale"));
		CartellaEsattoriale cartellaEsattorialeDaInserirePerModifica = cartellaEsattorialeService.caricaSingolaCartellaEsattoriale(idTemp);
		request.setAttribute("cartellaesattorialedamodificare_attribute", cartellaEsattorialeDaInserirePerModifica);
		request.setAttribute("listaContribuentiAttributeName", contribuenteService.listAllContribuenti());

		RequestDispatcher rd = request.getRequestDispatcher("/cartellaEsattoriale/modifica.jsp");
		rd.forward(request, response);
	}


}
