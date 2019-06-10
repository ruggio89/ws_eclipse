package it.prova.web.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.model.Persona;

@WebServlet("/HelloPersonaServlet")
public class HelloPersonaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HelloPersonaServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String parametroNomeInput = request.getParameter("tuoNomeInput");
		String parametroCognomeInput = request.getParameter("tuoCognomeInput");
		
		request.setAttribute("persona_attribute", new Persona(parametroNomeInput, parametroCognomeInput));
		
		RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
		rd.forward(request, response);
		
//		response.sendRedirect("home.jsp");
	}

}
