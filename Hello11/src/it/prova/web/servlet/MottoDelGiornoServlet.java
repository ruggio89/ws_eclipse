package it.prova.web.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/MottoDelGiornoServlet")
public class MottoDelGiornoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MottoDelGiornoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String parametroInput = request.getParameter("messaggioDelGiornoInput");
		
		request.setAttribute("messaggiodelgiorno_attribute", parametroInput);
		
		RequestDispatcher rd = request.getRequestDispatcher("mostramotto.jsp");
		rd.forward(request, response);
		
	}

}
