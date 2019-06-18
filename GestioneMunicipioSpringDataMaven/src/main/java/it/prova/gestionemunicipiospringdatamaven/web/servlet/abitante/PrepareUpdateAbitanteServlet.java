package it.prova.gestionemunicipiospringdatamaven.web.servlet.abitante;

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

import it.prova.gestionemunicipiospringdatamaven.model.Abitante;
import it.prova.gestionemunicipiospringdatamaven.service.abitante.AbitanteService;
import it.prova.gestionemunicipiospringdatamaven.service.municipio.MunicipioService;
import it.prova.gestionemunicipiospringdatamaven.utility.Utility;

@WebServlet("/PrepareUpdateAbitanteServlet")
public class PrepareUpdateAbitanteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Autowired
	private MunicipioService municipioService;
	
	@Autowired
	private AbitanteService abitanteService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
	
    public PrepareUpdateAbitanteServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Long idTemp = Utility.parseFromStrinToLong(request.getParameter("idAbitante"));
		Abitante abitanteDaInserirePerModifica = abitanteService.caricaEager(idTemp);
		
		request.setAttribute("abitantedamodificare_attribute", abitanteDaInserirePerModifica);
		request.setAttribute("listaMunicipiAttributeName", municipioService.listAllMunicipi());

		RequestDispatcher rd = request.getRequestDispatcher("/abitante/modifica.jsp");
		rd.forward(request, response);
	}

}
