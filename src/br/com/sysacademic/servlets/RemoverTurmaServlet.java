package br.com.sysacademic.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sysacademic.persistence.TurmasManager;

/**
 * Servlet implementation class RemoverTurmaServlet
 */
@WebServlet("/removerTurma")
public class RemoverTurmaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
     public RemoverTurmaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cod = request.getParameter("codigo");
		
		    if(TurmasManager.getTurmas().containsKey(cod)){
				TurmasManager.getTurmas().remove(cod);
				getServletContext().getRequestDispatcher("/turmas.jsp").forward(request, response);
			}else{
				throw new InexistenteException();
			}
		
			
	}
	
}
