package br.com.sysacademic.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import br.com.sysacademic.entidades.Aluno;
import br.com.sysacademic.persistence.AlunoManager;


@WebServlet("/alunos")
public class AlunosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AlunosServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome, email, telefone, cpf, senha, confsenha;

		nome = request.getParameter("nome");
		email = request.getParameter("email");
		telefone = request.getParameter("telefone");
		cpf = request.getParameter("cpf");
		senha = request.getParameter("senha");
		confsenha = request.getParameter("confsenha");

		if (!senha.equals(confsenha)) {
			response.getWriter().println("<script>alert('senhas nao correspondem')</script>");
			
		} else {
			Aluno a = new Aluno();
			if (nome != null && email != null && telefone != null && cpf != null)
				if (nome.equals("") || email.equals("") || telefone.equals("") || cpf.equals("")) {
					throw new CadastroException();

				} else {

					a.setNome(nome);
					a.setCpf(cpf);
					a.setEmail(email);
					a.setTelefone(telefone);
					a.setSenha(senha);
					AlunoManager.addAluno(a);
						
					request.getRequestDispatcher("/aluno.jsp").forward(request, response);
				}
		}
		
		}
}
