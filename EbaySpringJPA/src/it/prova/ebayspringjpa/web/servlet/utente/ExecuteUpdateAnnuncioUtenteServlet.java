package it.prova.ebayspringjpa.web.servlet.utente;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

@WebServlet("/utente/ExecuteUpdateAnnuncioUtenteServlet")
public class ExecuteUpdateAnnuncioUtenteServlet extends HttpServlet {
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

	public ExecuteUpdateAnnuncioUtenteServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		Utente utente = (Utente) httpRequest.getSession().getAttribute("userInfo");

		Long idInputAnnuncio = Utility.parseFromStrinToLong(request.getParameter("idInput"));
		AnnuncioDTO annuncioDTO = new AnnuncioDTO();

		String[] categorie = request.getParameterValues("categoriaId");
		if(categorie == null) {
			request.setAttribute("listaCategorieAttributeName", categoriaService.listAllCategorie());
			Annuncio annuncio = annuncioService.getEagerCategorieEUtente(idInputAnnuncio);
			request.setAttribute("annunciodamodificare_attribute", annuncio);
			String messaggio_errore = "Inserisci correttamente Categorie";
			request.setAttribute("messaggio_errore", messaggio_errore);
			
			RequestDispatcher rd = request.getRequestDispatcher("/utente/modificaAnnuncio.jsp");
			rd.forward(request, response);
			return;
		}
		
		Set<Categoria> listaCategorie = new HashSet<Categoria>();
		for (int i = 0; i < categorie.length; i++) {
			listaCategorie.add(categoriaService.caricaSingolaCategoria(Long.parseLong(categorie[i])));
		}
		
		
		
		Date dataInput = null;
		try {
			dataInput = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dataAnnuncioInput"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		annuncioDTO.setTestoAnnuncio(request.getParameter("testoAnnuncioInput"));
		annuncioDTO.setApertoChiuso(true);
		annuncioDTO.setCategorie(listaCategorie);
		annuncioDTO.setDataAnnuncio(dataInput);
		try {
			annuncioDTO.setPrezzo(Double.parseDouble(request.getParameter("prezzoInput")));
		} catch (Exception e) {
			annuncioDTO.setPrezzo(-1);
		}

		if (!annuncioDTO.validate().isEmpty()) {

			request.setAttribute("listaCategorieAttributeName", categoriaService.listAllCategorie());
			request.setAttribute("messaggio_errore", annuncioDTO.validate());
			
			Long idTemp = Utility.parseFromStrinToLong(request.getParameter("idInput"));
			Annuncio annuncioDaInserirePerModifica = annuncioService 
					.caricaSingoloAnnuncio(idTemp);
			request.setAttribute("annunciodamodificare_attribute", annuncioDaInserirePerModifica);
			
			RequestDispatcher rd = request.getRequestDispatcher("/utente/aggiungiAnnuncioUtente.jsp");
			rd.forward(request, response);
			return;
		}

		Annuncio annuncioDaModificare = AnnuncioDTO.buildAnnuncioIntance(annuncioDTO);
		annuncioDaModificare.setId(idInputAnnuncio);
		annuncioDaModificare.setUtente(utente);

		annuncioService.aggiorna(annuncioDaModificare);

		request.setAttribute("listaAnnunciAttributeName", annuncioService.listAllAnnunci());

		RequestDispatcher rd = request.getRequestDispatcher("/utente/result.jsp");
		rd.forward(request, response);

	}

}
