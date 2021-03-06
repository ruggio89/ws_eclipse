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
import it.prova.gestionemunicipiospringdatamaven.utility.Utility;

@WebServlet("/ExecuteDeleteAbitanteServlet")
public class ExecuteDeleteAbitanteServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
	
	@Autowired
	private AbitanteService abitanteService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
       
    public ExecuteDeleteAbitanteServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Long idAbitanteInput = Utility.parseFromStrinToLong(request.getParameter("idInput"));
		
		Abitante abitanteDaEliminare = abitanteService.caricaEager(idAbitanteInput);
		abitanteService.rimuovi(abitanteDaEliminare);
		
		request.setAttribute("listaAbitantiAttributeName", abitanteService.listAllAbitanti());
		
		RequestDispatcher rd = request.getRequestDispatcher("/abitante/results.jsp");
		rd.forward(request, response);
		
	}

}
