package it.prova.gestionecontribuentespringjpa.web.servlet.utente.admin;

import java.io.IOException;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import it.prova.gestionecontribuentespringjpa.model.Ruolo;
import it.prova.gestionecontribuentespringjpa.model.Utente;
import it.prova.gestionecontribuentespringjpa.model.dto.UtenteDTO;
import it.prova.gestionecontribuentespringjpa.service.ruolo.RuoloService;
import it.prova.gestionecontribuentespringjpa.service.utente.UtenteService;
import it.prova.gestionecontribuentespringjpa.utility.Utility;

@WebServlet("/admin/ExecuteUpdateUtenteServlet")
public class ExecuteUpdateUtenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private UtenteService utenteService;

	@Autowired
	private RuoloService ruoloService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
       
    public ExecuteUpdateUtenteServlet() {
        super();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String destinazione = null;
		
		String nomeInput = request.getParameter("nomeInput");
		String cognomeInput = request.getParameter("cognomeInput");
		String usernameInput = request.getParameter("usernameInput");
		String passwordInput = request.getParameter("passwordInput");
		Date dataReg = new Date();

		Long idInputUtente = Utility.parseFromStrinToLong(request.getParameter("idInput"));
//		Long idInputContribuente = Long.parseLong((String) request.getParameter("contribuenteId"));
		
		UtenteDTO utenteDTO = new UtenteDTO(nomeInput, cognomeInput, usernameInput, passwordInput, dataReg);
		
		if (!utenteDTO.validate().isEmpty()) {

			request.setAttribute("messaggio_errore", utenteDTO.validate());
			request.setAttribute("listaRuoliAttributeName", ruoloService.listAllRuoli());
			Long idTemp = Utility.parseFromStrinToLong(request.getParameter("idInput"));
			Utente utenteDaInserirePerModifica = utenteService
					.caricaSingoloUtente(idTemp);
			request.setAttribute("utentedamodificare_attribute", utenteDaInserirePerModifica);
			destinazione = "/admin/modifica.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(destinazione);
			rd.forward(request, response);
			return;
		}

		Utente utenteDaInserire = UtenteDTO
				.buildUtenteInstance(utenteDTO);
		utenteDaInserire.setId(idInputUtente);
		
		String[] ruoli = request.getParameterValues("ruoliId");
		
		Set<Ruolo> listaRuoli = new HashSet<Ruolo>();
		for (int i = 0; i < ruoli.length; i++) {
			listaRuoli.add(ruoloService.caricaSingoloRuolo(Long.parseLong(ruoli[i])));
		}
		
		utenteDaInserire.setRuoli(listaRuoli);

		utenteService.aggiorna(utenteDaInserire);
		request.setAttribute("listaUtentiAttributeName",
				utenteService.listAllUtenti());

		destinazione = "/admin/result.jsp";

		RequestDispatcher rd = request.getRequestDispatcher(destinazione);
		rd.forward(request, response);
	}

}
