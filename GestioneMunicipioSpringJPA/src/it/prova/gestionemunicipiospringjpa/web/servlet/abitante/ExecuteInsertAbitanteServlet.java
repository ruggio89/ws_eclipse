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
import it.prova.gestionemunicipiospringjpa.model.Municipio;
import it.prova.gestionemunicipiospringjpa.service.abitante.AbitanteService;
import it.prova.gestionemunicipiospringjpa.service.municipio.MunicipioService;
import it.prova.gestionemunicipiospringjpa.utility.Utility;

@WebServlet("/ExecuteInsertAbitanteServlet")
public class ExecuteInsertAbitanteServlet extends HttpServlet {
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

	public ExecuteInsertAbitanteServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String destinazione = null;

		Integer etaInput = Utility.parseFromStrinToInt(request.getParameter("etaInput"));
		String residenzaInput = request.getParameter("residenzaInput");
		String nomeInput = request.getParameter("nomeInput");
		String cognomeInput = request.getParameter("cognomeInput");

		Long idInputMunicipio = Long.parseLong(request.getParameter("municipioId"));
		

		if (residenzaInput.equals("") || nomeInput.equals("") || cognomeInput.equals("")  || etaInput == null
				|| etaInput <= 0 || idInputMunicipio == null || idInputMunicipio <= 0L) {
			String messaggioDaInviarePagina = "Attenzione, è necessario valorizzare!";
			request.setAttribute("listaMunicipiAttributeName", municipioService.listAllMunicipi());
			request.setAttribute("messaggio_errore", messaggioDaInviarePagina);
			destinazione = "/abitante/aggiungi.jsp";
		} else {
			
				Municipio municipioInput = new Municipio(idInputMunicipio);
				Abitante abitanteDaInserire = new Abitante(nomeInput, cognomeInput, etaInput, residenzaInput,
						municipioInput);
				abitanteService.inserisciNuovo(abitanteDaInserire);
				request.setAttribute("listaAbitantiAttributeName", abitanteService.listAllAbitanti());
				
				destinazione = "/abitante/result.jsp";
		
		}

		

		RequestDispatcher rd = request.getRequestDispatcher(destinazione);
		rd.forward(request, response);
	}

}
