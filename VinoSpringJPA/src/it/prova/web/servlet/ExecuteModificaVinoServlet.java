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
 * Servlet implementation class ExecuteModificaVinoServlet
 */
@WebServlet("/ExecuteModificaVinoServlet")
public class ExecuteModificaVinoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Autowired
	private VinoService vinoService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
	
    public ExecuteModificaVinoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String destinazione = null;
		
		Long idInput = Utility.parseFromStrinToLong(request.getParameter("idInput"));
		Integer annataInputParsed = Utility.parseFromStrinToInt(request.getParameter("annataInput"));
		String nomeInput = request.getParameter("nomeInput");
		String cantinaInput = request.getParameter("cantinaInput");
		String uvaInput = request.getParameter("uvaInput");
		String localitaInput = request.getParameter("localitaInput");

		if (nomeInput.equals("") || cantinaInput.equals("") || uvaInput.equals("")
				|| localitaInput.equals("") || annataInputParsed == null || annataInputParsed <= 0) {
			String messaggioDaInviarePagina = "Attenzione, è necessario valorizzare!";
			request.setAttribute("messaggio_errore", messaggioDaInviarePagina);
			Long idTemp = Utility.parseFromStrinToLong(request.getParameter("idInput"));
			Vino personaDaInserirePerModifica = vinoService.caricaSingoloVino(idTemp);
			request.setAttribute("vinodamodificare_attribute", personaDaInserirePerModifica);
			destinazione = "modificavino.jsp";
		} else {
			try  {
				Vino vinoDaModificare = new Vino(idInput, nomeInput, cantinaInput, uvaInput, localitaInput,
						annataInputParsed);
				vinoService.aggiorna(vinoDaModificare);
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
