package it.prova.gestionemunicipiospringdatamaven.web.servlet.municipio;

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

import it.prova.gestionemunicipiospringdatamaven.model.Municipio;
import it.prova.gestionemunicipiospringdatamaven.service.municipio.MunicipioService;

@WebServlet("/ExecuteDeleteMunicipioServlet")
public class ExecuteDeleteMunicipioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Autowired
	private MunicipioService municipioService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
	
    public ExecuteDeleteMunicipioServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Long idTemp = Long.parseLong(request.getParameter("idInput"));
		
		Municipio municipioDaEliminare = municipioService.caricaSingoloMunicipio(idTemp);
		municipioService.rimuovi(municipioDaEliminare);
		
		request.setAttribute("listaMunicipiAttributeName", municipioService.listAllMunicipi());
		
		RequestDispatcher rd = request.getRequestDispatcher("/municipio/results.jsp");
		rd.forward(request, response);
	}

}
