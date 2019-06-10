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
import it.prova.gestionecontribuentespringjpa.model.dto.CartellaEsattorialeDTO;
import it.prova.gestionecontribuentespringjpa.service.cartellaesattoriale.CartellaEsattorialeService;

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
		CartellaEsattorialeDTO cartellaEsattorialeDTO = new CartellaEsattorialeDTO();
		request.getParameter("denominazioneInput"); 
		request.getParameter("descrizioneInput");
		CartellaEsattoriale cartellaDaCercare = CartellaEsattorialeDTO.buildCartellaEsattorialeInstance(cartellaEsattorialeDTO);

		request.setAttribute("listaCartelleEsattorialiAttributeName", cartellaEsattorialeService
				.findByExample(cartellaDaCercare));

		RequestDispatcher rd = request.getRequestDispatcher("/cartellaEsattoriale/result.jsp");
		rd.forward(request, response);
		
	}

}
