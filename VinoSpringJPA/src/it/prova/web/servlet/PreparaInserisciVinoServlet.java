package it.prova.web.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PreparaInserisciVinoServlet")
public class PreparaInserisciVinoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PreparaInserisciVinoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("aggiungivino.jsp");
		rd.forward(request, response);
	}

}
