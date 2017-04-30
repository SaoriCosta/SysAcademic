package br.com.sysacademic.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import br.com.sysacademic.entidades.Aluno;
import br.com.sysacademic.entidades.Professor;
import br.com.sysacademic.entidades.Usuario;
import br.com.sysacademic.persistence.AlunoManager;
import br.com.sysacademic.persistence.ProfessorManager;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		if(AlunoManager.getAlunos().containsKey(login)){
			if(senha.equals(AlunoManager.getAlunos().get(login).getSenha())){
				request.getSession().setAttribute("aluno",AlunoManager.getAlunos().get(login));
				request.getRequestDispatcher("/aluno").forward(request, response);
			}
			else{
				request.setAttribute("erro-login", "Login ou Senha Inexistentes no Sistema");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
		}else if(ProfessorManager.getProfessor().containsKey(login)){
			
			if(senha.equals(ProfessorManager.getProfessor().get(login).getSenha())){
				request.getSession().setAttribute("professor",ProfessorManager.getProfessor().get(login));
				request.getRequestDispatcher("/professor").forward(request, response);
			}
			else{
				request.setAttribute("erro-login", "Login ou Senha Inexistentes no Sistema");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
		}else{
			request.setAttribute("erro-login", "Login ou Senha Inexistentes no Sistema");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		
		
	}

}
