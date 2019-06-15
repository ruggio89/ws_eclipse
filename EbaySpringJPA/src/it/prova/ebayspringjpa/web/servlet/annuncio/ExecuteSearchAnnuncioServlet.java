package it.prova.ebayspringjpa.web.servlet.annuncio;

import java.io.IOException;
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
import it.prova.ebayspringjpa.model.dto.AnnuncioDTO;
import it.prova.ebayspringjpa.service.annuncio.AnnuncioService;
import it.prova.ebayspringjpa.service.categoria.CategoriaService;
import it.prova.ebayspringjpa.utility.Utility;

@WebServlet("/ExecuteSearchAnnuncioServlet")
public class ExecuteSearchAnnuncioServlet extends HttpServlet {
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

	public ExecuteSearchAnnuncioServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		AnnuncioDTO annuncioDTO = new AnnuncioDTO();
		annuncioDTO.setTestoAnnuncio(request.getParameter("testoAnnuncioInput"));

		try {
			annuncioDTO.setPrezzo(Double.parseDouble(request.getParameter("prezzoInput")));
		} catch (Exception e) {
			annuncioDTO.setPrezzo(-1);
		}

		Annuncio annuncioDaCercare = AnnuncioDTO.buildAnnuncioIntance(annuncioDTO);

		String[] categorie = request.getParameterValues("categoriaId");
		if(categorie == null) {
			request.setAttribute("listaCategorieAttributeName", categoriaService.listAllCategorie());
			String messaggio_errore = "Inserisci correttamente Categorie";
			request.setAttribute("messaggio_errore", messaggio_errore);
			
			RequestDispatcher rd = request.getRequestDispatcher("/search.jsp");
			rd.forward(request, response);
			return;
		}
		Set<Categoria> listaCategorie = new HashSet<Categoria>();
		for (int i = 0; i < categorie.length; i++) {
			listaCategorie.add(categoriaService.caricaSingolaCategoria(Long.parseLong(categorie[i])));
		}

		if (annuncioDaCercare.getPrezzo() == -1) {
			request.setAttribute("listaAnnunciAttributeName",
					annuncioService.findByNomeECategoria(annuncioDaCercare.getTestoAnnuncio(), listaCategorie));
		} else {
			request.setAttribute("listaAnnunciAttributeName", annuncioService.findByNomeCategoriaEPrezzo(
					annuncioDaCercare.getTestoAnnuncio(), listaCategorie, annuncioDTO.getPrezzo()));
		}

		RequestDispatcher rd = request.getRequestDispatcher("/annuncio/result.jsp");
		rd.forward(request, response);
	}

}
