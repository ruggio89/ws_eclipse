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

@WebServlet("/admin/ExecuteInsertCategoriaServlet")
public class ExecuteInsertCategoriaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private CategoriaService categoriaService;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
       
    public ExecuteInsertCategoriaServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String descrizioneInput = request.getParameter("descrizioneInput");
		String codiceInput = request.getParameter("codiceInput");
		
		CategoriaDTO categoriaDTO = new CategoriaDTO(descrizioneInput, codiceInput);
		
		if(!categoriaDTO.validate().isEmpty()) {
			request.setAttribute("messaggio_errore", categoriaDTO.validate());
			
			RequestDispatcher rd = request.getRequestDispatcher("/admin/categoria/aggiungi.jsp");
			rd.forward(request, response);
		}
		
		Categoria categoriaDaInserire = CategoriaDTO.buildCategoriaInstance(categoriaDTO);
		categoriaService.inserisciNuova(categoriaDaInserire);
		
		request.setAttribute("listaCategorieAttributeName", categoriaService.listAllCategorie());
		
		RequestDispatcher rd = request.getRequestDispatcher("/admin/categoria/result.jsp");
		rd.forward(request, response);
	}

}
