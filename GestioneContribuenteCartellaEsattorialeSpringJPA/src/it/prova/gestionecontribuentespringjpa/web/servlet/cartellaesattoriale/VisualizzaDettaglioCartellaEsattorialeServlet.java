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
import it.prova.gestionecontribuentespringjpa.service.cartellaesattoriale.CartellaEsattorialeService;
import it.prova.gestionecontribuentespringjpa.utility.Utility;

@WebServlet("/VisualizzaDettaglioCartellaEsattorialeServlet")
public class VisualizzaDettaglioCartellaEsattorialeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private CartellaEsattorialeService cartellaEsattorialeService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	public VisualizzaDettaglioCartellaEsattorialeServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getSession().getAttribute("userInfo") == null) {
			response.sendRedirect(request.getContextPath());
			return;
		}

		Long idCartellaEsattorialeDaPagina = Utility
				.parseFromStrinToLong(request.getParameter("idCartellaEsattoriale"));
		CartellaEsattoriale cartellaEsattorialeDaPagina = cartellaEsattorialeService
				.caricaSingolaCartellaEsattoriale(idCartellaEsattorialeDaPagina);

		request.setAttribute("CartellaEsattorialeSingolaAttributeName", cartellaEsattorialeDaPagina);

		RequestDispatcher rd = request.getRequestDispatcher("/cartellaEsattoriale/dettaglio.jsp");
		rd.forward(request, response);
	}

}
