package it.prova.gestionemunicipiospringjpa.web.servlet.abitante;

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

import it.prova.gestionemunicipiospringjpa.model.Abitante;
import it.prova.gestionemunicipiospringjpa.service.abitante.AbitanteService;

@WebServlet("/ExecuteSearchAbitanteServlet")
public class ExecuteSearchAbitanteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private AbitanteService abitanteService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
       
    public ExecuteSearchAbitanteServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		Integer etaInput = Utility.parseFromStrinToInt(request.getParameter("etaInput"));
		String residenzaInput = request.getParameter("residenzaInput");
		String nomeInput = request.getParameter("nomeInput");
		String cognomeInput = request.getParameter("cognomeInput");
		
		Abitante example = new Abitante(nomeInput, cognomeInput, residenzaInput);
		
		try {
			example.setEta(Integer.parseInt(request.getParameter("etaInput")));
		} catch(Exception e){
		}
		
	
		request.setAttribute("listaAbitantiAttributeName", abitanteService.findByExample(example));
	
		RequestDispatcher rd = request.getRequestDispatcher("/abitante/result.jsp");
		rd.forward(request, response);
		
	}

}
