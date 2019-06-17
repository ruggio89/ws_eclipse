package it.prova.ebayspringjpa.web.servlet.categoria;

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

import it.prova.ebayspringjpa.model.Categoria;
import it.prova.ebayspringjpa.model.dto.CategoriaDTO;
import it.prova.ebayspringjpa.service.categoria.CategoriaService;
import it.prova.ebayspringjpa.utility.Utility;

@WebServlet("/admin/ExecuteUpdateCategoriaServlet")
public class ExecuteUpdateCategoriaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private CategoriaService categoriaService;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
	
    public ExecuteUpdateCategoriaServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Long idInput = Long.parseLong(request.getParameter("idInput"));
		
		Categoria categoriaInput = categoriaService.caricaEager(idInput);
		
		CategoriaDTO categoriaDTO = new CategoriaDTO();
		categoriaDTO.setDescrizione(request.getParameter("descrizioneInput"));
		categoriaDTO.setCodice(request.getParameter("codiceInput"));
		categoriaDTO.setAnnunci(categoriaInput.getAnnunci());
		
		if(!categoriaDTO.validate().isEmpty()) {
			request.setAttribute("messaggio_errore", categoriaDTO.validate());
			request.setAttribute("categoriadamodificare_attribute", categoriaService.caricaEager(idInput));
			
			RequestDispatcher rd = request.getRequestDispatcher("/admin/categoria/aggiungi.jsp");
			rd.forward(request, response);
		}
		
		Categoria categoriaDaModificare = CategoriaDTO.buildCategoriaInstance(categoriaDTO);
		categoriaDaModificare.setId(idInput);
		categoriaService.aggiorna(categoriaDaModificare);
		
		request.setAttribute("listaCategorieAttributeName", categoriaService.listAllCategorie());
		
		RequestDispatcher rd = request.getRequestDispatcher("/admin/categoria/result.jsp");
		rd.forward(request, response);
	}

}
