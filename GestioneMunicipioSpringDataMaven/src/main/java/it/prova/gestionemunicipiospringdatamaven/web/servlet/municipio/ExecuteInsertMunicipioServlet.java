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
import it.prova.gestionemunicipiospringdatamaven.model.dto.MunicipioDTO;
import it.prova.gestionemunicipiospringdatamaven.service.municipio.MunicipioService;

@WebServlet("/ExecuteInsertMunicipioServlet")
public class ExecuteInsertMunicipioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private MunicipioService municipioService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
       
    public ExecuteInsertMunicipioServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MunicipioDTO municipioDTO = new MunicipioDTO();
		municipioDTO.setDescrizione(request.getParameter("descrizioneInput"));
		municipioDTO.setCodice(request.getParameter("codiceInput"));
		municipioDTO.setUbicazione(request.getParameter("ubicazioneInput"));
		
		if(!municipioDTO.validate().isEmpty()) {
			request.setAttribute("messaggio_errore", municipioDTO.validate());
			
			RequestDispatcher rd = request.getRequestDispatcher("/municipio/inserisciNuovo.jsp");
			rd.forward(request, response);
		}
		
		Municipio municipioDaInserire = MunicipioDTO.buildMunicipioInstance(municipioDTO);
		municipioService.inserisciNuovo(municipioDaInserire);
		
		request.setAttribute("listaMunicipiAttributeName", municipioService.listAllMunicipi());
		
		RequestDispatcher rd = request.getRequestDispatcher("/municipio/results.jsp");
		rd.forward(request, response);
	}

}
