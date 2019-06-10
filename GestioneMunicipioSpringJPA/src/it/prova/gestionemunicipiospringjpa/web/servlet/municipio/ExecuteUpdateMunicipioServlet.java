package it.prova.gestionemunicipiospringjpa.web.servlet.municipio;

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

import it.prova.gestionemunicipiospringjpa.model.Municipio;
import it.prova.gestionemunicipiospringjpa.service.municipio.MunicipioService;
import it.prova.gestionemunicipiospringjpa.utility.Utility;

@WebServlet("/ExecuteUpdateMunicipioServlet")
public class ExecuteUpdateMunicipioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private MunicipioService municipioService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	public ExecuteUpdateMunicipioServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String destinazione = null;

		Long idInput = Utility.parseFromStrinToLong(request.getParameter("idInput"));
		String descrizioneInput = request.getParameter("descrizioneInput");
		String codiceInput = request.getParameter("codiceInput");
		String ubicazioneInput = request.getParameter("ubicazioneInput");

		if (descrizioneInput.equals("") || codiceInput.equals("") || ubicazioneInput.equals("")) {
			String messaggioDaInviarePagina = "Attenzione, è necessario valorizzare!";
			request.setAttribute("messaggio_errore", messaggioDaInviarePagina);
			Long idTemp = Utility.parseFromStrinToLong(request.getParameter("idInput"));
			Municipio municipioDaInserirePerModifica = municipioService.caricaSingoloMunicipio(idTemp);
			request.setAttribute("municipiodamodificare_attribute", municipioDaInserirePerModifica);
			destinazione = "/municipio/modifica.jsp";
		} else {
			try {
				Municipio municipioDaModificare = new Municipio(idInput, descrizioneInput, codiceInput,
						ubicazioneInput);
				municipioService.aggiorna(municipioDaModificare);

				request.setAttribute("listaMunicipiAttributeName", municipioService.listAllMunicipi());
				destinazione = "/municipio/result.jsp";
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		RequestDispatcher rd = request.getRequestDispatcher(destinazione);
		rd.forward(request, response);
	}

}
