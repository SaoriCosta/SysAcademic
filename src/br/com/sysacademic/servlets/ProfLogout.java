package br.com.sysacademic.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/profLogout")
public class ProfLogout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().removeAttribute("professor");
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
