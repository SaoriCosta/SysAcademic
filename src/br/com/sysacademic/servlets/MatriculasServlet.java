package br.com.sysacademic.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import br.com.sysacademic.entidades.Alunos;
import br.com.sysacademic.entidades.Matriculas;
import br.com.sysacademic.entidades.Turmas;
import br.com.sysacademic.persistence.AlunosManager;
import br.com.sysacademic.persistence.MatriculasManager;
import br.com.sysacademic.persistence.TurmasManager;

@WebServlet("/matriculas")
public class MatriculasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String cpf = null;
	private static String cod_turma = null;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		
		if (request.getParameter("cpf_aluno") != null && request.getParameter("cod_turma") != null) {

			cpf = request.getParameter("cpf_aluno");
			 cod_turma = request.getParameter("cod_turma");
			 
			if (AlunosManager.getAlunos().get(cpf) == null || TurmasManager.getTurmas().get(cod_turma) == null) {
				throw new InexistenteException();
			}

			if (!MatriculasManager.lista.isEmpty() && MatriculasManager.getMatriculas().get(cod_turma) != null)
				for (int j = 0; j < MatriculasManager.getMatriculas().get(cod_turma).size(); j++)
					if (MatriculasManager.getMatriculas().get(cod_turma).get(j).getAluno().getCpf().equals(cpf))
						throw new MatriculaException();

			Alunos a = AlunosManager.getAlunos().get(request.getParameter("cpf_aluno"));
			Turmas t = TurmasManager.getTurmas().get(request.getParameter("cod_turma"));

			Matriculas m = new Matriculas();
			m.setTurma(t);
			m.setAluno(a);
			
			MatriculasManager.addMatricula(m);

		
		}
		out.println("<html>" 
				+ "<head> "
				+ "<link rel='stylesheet' href='materialize/css/materialize.css'>" 
				+ "<title>Matrículas</title>" 
				+ "</head>" + "<body>"
				+ "<h4 class='center'>Listagem de Matrículas!</h4>" 
				+ "<table class='striped'>" 
				+ "<tr>" 
				+ "<th>Código da Disciplina</th>"
				+ "<th>Nome da Disciplina</th>" 
				+ "<th>Nome do Aluno</th>" 
				+ "<th>Cpf do Aluno</th>"
				+ "<th>Período</th>" 
				+ "</tr>"
				+ "<a style='margin:2%;' class='btn black white-text' href = 'cadastro-matricula.html'> +Cadastrar Matricula</a>"
				+ "<a class='btn black white-text' href = 'index.html'> Início</a>");

			for (int j = 0; j < MatriculasManager.getMatriculas().get(cod_turma).size(); j++) {
				out.println("<tr>" + "<td>" + MatriculasManager.getMatriculas().get(cod_turma).get(j).getTurma().getCodigo()
						+ "</td>" + "<td>" + MatriculasManager.getMatriculas().get(cod_turma).get(j).getTurma().getDisciplina() + "</td>"
						+ "<td>" + MatriculasManager.getMatriculas().get(cod_turma).get(j).getAluno().getNome() + "</td>" + "<td>"
						+ MatriculasManager.getMatriculas().get(cod_turma).get(j).getAluno().getCpf() + "</td>" + "<td>"
						+ MatriculasManager.getMatriculas().get(cod_turma).get(j).getTurma().getPeriodo() + "</td>" + "</tr>");
			}
			
			out.println("</table>" );
			
			out.println("</body>" + "</html>");
	
	}
	
}
