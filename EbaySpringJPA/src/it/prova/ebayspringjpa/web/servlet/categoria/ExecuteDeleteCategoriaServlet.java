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
import it.prova.ebayspringjpa.service.categoria.CategoriaService;
import it.prova.ebayspringjpa.utility.Utility;

@WebServlet("/admin/ExecuteDeleteCategoriaServlet")
public class ExecuteDeleteCategoriaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private CategoriaService categoriaService;
       
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
	
    public ExecuteDeleteCategoriaServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Long idInput = Utility.parseFromStrinToLong(request.getParameter("idInput"));
		
		Categoria categoriaDaEliminare = categoriaService.caricaEager(idInput);
		categoriaService.rimuovi(categoriaDaEliminare);
		
		request.setAttribute("listaCategorieAttributeName", categoriaService.listAllCategorie());
		
		RequestDispatcher rd = request.getRequestDispatcher("/admin/categoria/result.jsp");
		rd.forward(request, response);
		
	}

}
