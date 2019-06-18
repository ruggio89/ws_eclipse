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
import it.prova.gestionemunicipiospringdatamaven.model.Municipio;
import it.prova.gestionemunicipiospringdatamaven.model.dto.AbitanteDTO;
import it.prova.gestionemunicipiospringdatamaven.service.abitante.AbitanteService;
import it.prova.gestionemunicipiospringdatamaven.service.municipio.MunicipioService;
import it.prova.gestionemunicipiospringdatamaven.utility.Utility;

@WebServlet("/ExecuteInsertAbitanteServlet")
public class ExecuteInsertAbitanteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private AbitanteService abitanteService;
	
	@Autowired
	private MunicipioService municipioService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	public ExecuteInsertAbitanteServlet() {
		super();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Long municipioId = Utility.parseFromStrinToLong(request.getParameter("municipioId"));
		
		AbitanteDTO abitanteDTO = new AbitanteDTO();
		abitanteDTO.setNome(request.getParameter("nomeInput"));
		abitanteDTO.setCognome(request.getParameter("cognomeInput"));
		abitanteDTO.setEta(Utility.parseFromStrinToInt(request.getParameter("etaInput")));
		abitanteDTO.setResidenza(request.getParameter("residenzaInput"));
		
		if (!abitanteDTO.validate().isEmpty()) {

			request.setAttribute("messaggio_errore", abitanteDTO.validate());

			RequestDispatcher rd = request.getRequestDispatcher("/abitante/inserisciNuovo.jsp");
			rd.forward(request, response);
			return;
		}
		
		Municipio municipioInput = municipioService.caricaSingoloMunicipio(municipioId);
		Abitante abitanteDaInserire = AbitanteDTO.buildAbitanteInstance(abitanteDTO);
		abitanteDaInserire.setMunicipio(municipioInput);
		
		abitanteService.inserisciNuovo(abitanteDaInserire);
		
		request.setAttribute("listaAbitantiAttributeName", abitanteService.listAllAbitanti());

		RequestDispatcher rd = request.getRequestDispatcher("/abitante/results.jsp");
		rd.forward(request, response);

		

	}

}
