package it.prova.gestionemunicipiospringjpa.web.servlet.abitante;

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

import it.prova.gestionemunicipiospringjpa.model.Abitante;
import it.prova.gestionemunicipiospringjpa.service.abitante.AbitanteService;
import it.prova.gestionemunicipiospringjpa.utility.Utility;

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
		Long idInput = Utility.parseFromStrinToLong(request.getParameter("idInput"));

		try {
			Abitante abitanteDaEliminare = abitanteService.caricaSingoloAbitante(idInput);
			abitanteService.rimuovi(abitanteDaEliminare);
			request.setAttribute("listaAbitantiAttributeName", abitanteService.listAllAbitanti());
		} catch (Exception e) {
			e.printStackTrace();
		}

		RequestDispatcher rd = request.getRequestDispatcher("/abitante/result.jsp");
		rd.forward(request, response);
	}

}
