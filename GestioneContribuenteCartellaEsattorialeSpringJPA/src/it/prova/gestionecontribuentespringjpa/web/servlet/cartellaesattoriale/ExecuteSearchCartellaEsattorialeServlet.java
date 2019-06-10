package it.prova.gestionecontribuentespringjpa.web.servlet.cartellaesattoriale;

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

import it.prova.gestionecontribuentespringjpa.model.CartellaEsattoriale;
import it.prova.gestionecontribuentespringjpa.service.cartellaesattoriale.CartellaEsattorialeService;
import it.prova.gestionecontribuentespringjpa.utility.Utility;

@WebServlet("/ExecuteSearchCartellaEsattorialeServlet")
public class ExecuteSearchCartellaEsattorialeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Autowired
	private CartellaEsattorialeService cartellaEsattorialeService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
	
    public ExecuteSearchCartellaEsattorialeServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String denominazioneInput = request.getParameter("denominazioneInput");
		String descrizioneInput = request.getParameter("descrizioneInput");
		Integer importoInput = Utility.parseFromStrinToInt(request.getParameter("importoInput"));
		
		CartellaEsattoriale example = new CartellaEsattoriale(denominazioneInput, descrizioneInput);
		
		try {
			example.setImporto(importoInput);
		} catch(Exception e){
		}
		
	
		request.setAttribute("listaCartelleEsattorialiAttributeName", cartellaEsattorialeService.findByExample(example));
	
		RequestDispatcher rd = request.getRequestDispatcher("/cartellaEsattoriale/result.jsp");
		rd.forward(request, response);
	}

}
