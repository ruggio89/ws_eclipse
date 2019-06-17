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

import it.prova.ebayspringjpa.service.annuncio.AnnuncioService;
import it.prova.ebayspringjpa.service.categoria.CategoriaService;
import it.prova.ebayspringjpa.utility.Utility;


@WebServlet("/admin/PrepareUpdateCategoriaServlet")
public class PrepareUpdateCategoriaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private CategoriaService categoriaservice;
	
	@Autowired
	private AnnuncioService annuncioService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
       
    public PrepareUpdateCategoriaServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long idTemp = Utility.parseFromStrinToLong(request.getParameter("idCategoria"));
		
		request.setAttribute("categoriadamodificare_attribute", categoriaservice.caricaEager(idTemp));
		
		RequestDispatcher rd = request.getRequestDispatcher("/admin/categoria/modifica.jsp");
		rd.forward(request, response);
	}

}
