package it.prova.web.servlet;

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

import it.prova.model.Vino;
import it.prova.service.VinoService;
import it.prova.utility.Utility;

/**
 * Servlet implementation class ExecuteInserisciVinoServlet
 */
@WebServlet("/ExecuteInserisciVinoServlet")
public class ExecuteInserisciVinoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	@Autowired
	private VinoService vinoService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
	
    public ExecuteInserisciVinoServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String destinazione = null;

		Integer annataInputParsed = Utility.parseFromStrinToInt(request.getParameter("annataInput"));
		String nomeInput = request.getParameter("nomeInput");
		String cantinaInput = request.getParameter("cantinaInput");
		String uvaInput = request.getParameter("uvaInput");
		String localitaInput = request.getParameter("localitaInput");

		if (nomeInput.equals("") || cantinaInput.equals("") || uvaInput.equals("")
				|| localitaInput.equals("") || annataInputParsed == null || annataInputParsed <= 0) {
			String messaggioDaInviarePagina = "Attenzione, è necessario valorizzare!";
			request.setAttribute("messaggio_errore", messaggioDaInviarePagina);
			destinazione = "aggiungivino.jsp";
		} else {
			try  {
				Vino vinoDaInserire = new Vino(nomeInput, cantinaInput, uvaInput, localitaInput,
						annataInputParsed);
				vinoService.inserisciNuovo(vinoDaInserire);
				request.setAttribute("listaViniAttributeName", vinoService.listVini());
				destinazione = "result.jsp";
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		RequestDispatcher rd = request.getRequestDispatcher(destinazione);
		rd.forward(request, response);
	}

}
