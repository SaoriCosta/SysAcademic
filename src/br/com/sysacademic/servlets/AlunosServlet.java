package br.com.sysacademic.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import br.com.sysacademic.entidades.Alunos;
import br.com.sysacademic.persistence.AlunosManager;


@WebServlet("/alunos")
public class AlunosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AlunosServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter  out = response.getWriter();
		
		out.println("<html>"
				+ "<head> "
				+ "<link rel='stylesheet' href='materialize/css/materialize.css'>" 
				+ "<title>Alunos</title>"
				+ "</head>"
				+ "<body>"			
				+ "<h4 class='center'>Listagem de Alunos!</h4>"
				+ "<table class='striped'>"
				+ "<tr>"
				+ "<th>Id</th>"
				+ "<th>Nome</th>"
				+ "<th>Telefone</th>"
				+ "<th>Email</th>"
				+ "<th>Cpf</th>"
				+ "</tr>"
				+ " <a style='margin:2%;' class='btn black white-text' href = 'cadastro-aluno.html'>+ Cadastrar Aluno</a>"
				+ "<a class='btn black white-text' href = 'index.html'> Início</a>");
		
				for (String i : AlunosManager.getAlunos().keySet()) {
					
					out.println(""
							+ "<tr>"
							+ "<td>"+AlunosManager.getAlunos().get(i).getId()+"</td>"
							+ "<td>"+AlunosManager.getAlunos().get(i).getNome()+"</td>"
							+ "<td>"+AlunosManager.getAlunos().get(i).getTelefone()+"</td>"	
							+ "<td>"+AlunosManager.getAlunos().get(i).getEmail()+"</td>"
							+ "<td>"+AlunosManager.getAlunos().get(i).getCpf()+"</td>"
							+ "</tr>"
							+ "");
				}
				
				out.println("</table>"
				
				+ "</body>"
				+ "</html>");
		
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome, email, telefone, cpf;
		
		nome = request.getParameter("nome");
		email = request.getParameter("email");
		telefone = request.getParameter("telefone");
		cpf = request.getParameter("cpf");
		
		Alunos a = new Alunos();
		
		if(nome.equals("") || email.equals("") || telefone.equals("") || cpf.equals("")){
			throw new CadastroException();
			
		}else{
		a.setNome(nome);
		a.setCpf(cpf);
		a.setEmail(email);
		a.setTelefone(telefone);
	
		AlunosManager.addAluno(a);
		
		doGet(request, response);
		}
	}

}
