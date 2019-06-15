package it.prova.ebayspringjpa.web.servlet.login;

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

import it.prova.ebayspringjpa.model.Ruolo;
import it.prova.ebayspringjpa.model.Utente;
import it.prova.ebayspringjpa.model.dto.UtenteDTO;
import it.prova.ebayspringjpa.service.ruolo.RuoloService;
import it.prova.ebayspringjpa.service.utente.UtenteService;
import it.prova.ebayspringjpa.utility.Utility;

@WebServlet("/ExecuteSignUpServlet")
public class ExecuteSignUpServlet extends HttpServlet {
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
	
    public ExecuteSignUpServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String destinazione = null;
		
		
		String nomeInput = request.getParameter("nomeInput");
		String cognomeInput = request.getParameter("cognomeInput");
		String usernameInput = request.getParameter("usernameInput");
		String passwordInput = request.getParameter("passwordInput");
		Date dataReg = new Date();
		System.out.println(dataReg);
		Double credito = 0.0;

		UtenteDTO utenteDTO = new UtenteDTO(nomeInput, cognomeInput, usernameInput, passwordInput, credito, dataReg);
		
		if(!utenteDTO.validate().isEmpty()) {
			request.setAttribute("listaRuoliAttributeName", ruoloService.listAllRuoli());
			request.setAttribute("messaggio_errore", utenteDTO.validate());
			destinazione = "/signup/aggiungi.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(destinazione);
			rd.forward(request, response);
		}
		
		String[] ruoli = request.getParameterValues("ruoliId");
		if(ruoli == null) {
			request.setAttribute("listaRuoliAttributeName", ruoloService.listAllRuoli());
			String messaggio_errore = "Inserisci correttamente Ruoli";
			request.setAttribute("messaggio_errore", messaggio_errore);
			
			RequestDispatcher rd = request.getRequestDispatcher("/signup/aggiungi.jsp");
			rd.forward(request, response);
			return;
		}
		
		Set<Ruolo> listaRuoli = new HashSet<Ruolo>();
		for (int i = 0; i < ruoli.length; i++) {
			listaRuoli.add(ruoloService.caricaSingoloRuolo(Long.parseLong(ruoli[i])));
		}
		
		Utente utenteDaInserire = UtenteDTO.buildUtenteInstance(utenteDTO);
		utenteDaInserire.setRuoli(listaRuoli);
		utenteService.inserisciNuovo(utenteDaInserire);

		destinazione = "/login.jsp";

		RequestDispatcher rd = request.getRequestDispatcher(destinazione);
		rd.forward(request, response);
	}

}
