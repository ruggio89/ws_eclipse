package it.prova.gestionecontribuentespringjpa.web.servlet.contribuente;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PrepareInsertContribuenteServlet")
public class PrepareInsertContribuenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PrepareInsertContribuenteServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getSession().getAttribute("userInfo") == null) {
			response.sendRedirect(request.getContextPath());
			return;
		}

		RequestDispatcher rd = request.getRequestDispatcher("/contribuente/aggiungi.jsp");
		rd.forward(request, response);
	}

}
