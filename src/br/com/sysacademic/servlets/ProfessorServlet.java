package br.com.sysacademic.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import br.com.sysacademic.entidades.Professor;
import br.com.sysacademic.entidades.Turma;
import br.com.sysacademic.persistence.ProfessorManager;

/**
 * Servlet implementation class ProfessorServlet
 */
@WebServlet("/professores")
public class ProfessorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfessorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 String nome = request.getParameter("nome");
		 String cpf = request.getParameter("login");
		 String senha = request.getParameter("senha");
		 String confsenha = request.getParameter("confsenha");
		 
		 if((senha.equals(confsenha))){
			 
			 Professor professor = new Professor();
			 professor.setCpf(cpf);
			 professor.setNome(nome);
			 professor.setSenha(senha);
			 
			 ProfessorManager.addProfessor(professor);
			
			 request.getRequestDispatcher("/professor.jsp").forward(request, response);
		 }else{
		
			 request.setAttribute("warning", "Não foi possivel cadastrar o professor. Tente Novamente!");
			 request.getRequestDispatcher("/cadastro-professor.jsp").forward(request, response);
		 }
		 
		 
		
		 //doGet(request, response);
	}

}
