package it.prova.web.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PreparaInserimentoPersonaServlet")
public class PreparaInserimentoPersonaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PreparaInserimentoPersonaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	RequestDispatcher rd = request.getRequestDispatcher("aggiungipersona.jsp");
		rd.forward(request, response);
    }

	

}
