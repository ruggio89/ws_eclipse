package it.prova.ebayspringjpa.web.servlet.utente;

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

import it.prova.ebayspringjpa.model.Annuncio;
import it.prova.ebayspringjpa.model.Categoria;
import it.prova.ebayspringjpa.model.Utente;
import it.prova.ebayspringjpa.model.dto.AnnuncioDTO;
import it.prova.ebayspringjpa.service.annuncio.AnnuncioService;
import it.prova.ebayspringjpa.service.categoria.CategoriaService;
import it.prova.ebayspringjpa.utility.Utility;

@WebServlet("/utente/ExecuteInsertAnnuncioUtenteServlet")
public class ExecuteInsertAnnuncioUtenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private AnnuncioService annuncioService;

	@Autowired
	private CategoriaService categoriaService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	public ExecuteInsertAnnuncioUtenteServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		Utente utente = (Utente) httpRequest.getSession().getAttribute("userInfo");
		
		AnnuncioDTO annuncioDTO = new AnnuncioDTO();

		String[] categorie = request.getParameterValues("categoriaId");
//		if(categorie == null) {
//			request.setAttribute("listaCategorieAttributeName", categoriaService.listAllCategorie());
//			String messaggio_errore = "Inserisci correttamente Categorie";
//			request.setAttribute("messaggio_errore", messaggio_errore);
			
//			RequestDispatcher rd = request.getRequestDispatcher("/utente/aggiungiAnnuncioUtente.jsp");
//			rd.forward(request, response);
//			return;
//		}
		Set<Categoria> listaCategorie = new HashSet<Categoria>();
		for (int i = 0; i < categorie.length; i++) {
			listaCategorie.add(categoriaService.caricaSingolaCategoria(Long.parseLong(categorie[i])));
		}

		Date dataInput = new Date();
		annuncioDTO.setApertoChiuso(true);
		annuncioDTO.setTestoAnnuncio(request.getParameter("testoAnnuncioInput"));
		annuncioDTO.setCategorie(listaCategorie);
		annuncioDTO.setDataAnnuncio(dataInput);
		try {
			annuncioDTO.setPrezzo(Double.parseDouble(request.getParameter("prezzoInput")));
		} catch (Exception e) {
			annuncioDTO.setPrezzo(-1);
		}

//		if (!annuncioDTO.validate().isEmpty()) {
//
//			request.setAttribute("listaCategorieAttributeName", categoriaService.listAllCategorie());
//			request.setAttribute("messaggio_errore", annuncioDTO.validate());
//
//			RequestDispatcher rd = request.getRequestDispatcher("/utente/aggiungiAnnuncioUtente.jsp");
//			rd.forward(request, response);
//			return;
//		}

		Annuncio annuncioDaInserire = AnnuncioDTO.buildAnnuncioIntance(annuncioDTO);
		annuncioDaInserire.setUtente(utente);

		annuncioService.inserisciNuovo(annuncioDaInserire);

		request.setAttribute("listaAnnunciAttributeName", annuncioService.findByUtenteECategoria(utente));

		RequestDispatcher rd = request.getRequestDispatcher("/utente/result.jsp");
		rd.forward(request, response);

	}

}
