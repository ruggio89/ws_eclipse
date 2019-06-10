package it.helloabitante.web.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.helloabitante.model.Abitante;
import it.helloabitante.service.MyServiceFactory;
import it.helloabitante.utility.Utility;

@WebServlet("/ExecuteInsertAbitanteServlet")
public class ExecuteInsertAbitanteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ExecuteInsertAbitanteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String destinazione = null;

		Integer etaInputParsed = Utility.parseFromStrinToInt(request.getParameter("tuaEtaInput"));
		String nomeInput = request.getParameter("tuoNomeInput");
		String cognomeInput = request.getParameter("tuoCognomeInput");
		String codiceFiscaleInput = request.getParameter("tuoCodiceFiscaleInput");
		String mottoInput = request.getParameter("tuoMottoInput");

		if (nomeInput.equals("") || cognomeInput.equals("") || codiceFiscaleInput.equals("") || mottoInput.equals("")
				|| etaInputParsed == null || etaInputParsed <=0 ) {
			String messaggioDaInviarePagina = "Attenzione, è necessario valorizzare!";
			request.setAttribute("messaggio_errore", messaggioDaInviarePagina);
			destinazione = "aggiunginuovo.jsp";
		} else {
			Abitante nuovoAbitante = new Abitante(nomeInput, cognomeInput, codiceFiscaleInput, etaInputParsed,
					mottoInput);
			try {
				MyServiceFactory.getAbitanteServiceInstance().inserisciAbitante(nuovoAbitante);
				request.setAttribute("listAbitantiAttributeName",
						MyServiceFactory.getAbitanteServiceInstance().listaAbitanti());
				destinazione = "results.jsp";
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		RequestDispatcher rd = request.getRequestDispatcher(destinazione);
		rd.forward(request, response);
	}

}
