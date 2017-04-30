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

import br.com.sysacademic.entidades.Aluno;
import br.com.sysacademic.entidades.Matricula;
import br.com.sysacademic.entidades.Turma;
import br.com.sysacademic.persistence.AlunoManager;
import br.com.sysacademic.persistence.MatriculaManager;
import br.com.sysacademic.persistence.TurmasManager;

@WebServlet("/matriculas")
public class MatriculasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String cpf = null;
	private static String cod_turma = null;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		if (request.getParameter("cpf_aluno") != null && request.getParameter("cod_turma") != null) {

			cpf = request.getParameter("cpf_aluno");
			 cod_turma = request.getParameter("cod_turma");
			 
			if (AlunoManager.getAlunos().get(cpf) == null || TurmasManager.getTurmas().get(cod_turma) == null) {
		throw new InexistenteException();
			}
		
			if (MatriculaManager.getMatriculas().get(cod_turma) != null)
				for (int j = 0; j < MatriculaManager.getMatriculas().get(cod_turma).size(); j++)
					if (MatriculaManager.getMatriculas().get(cod_turma).get(j).getAluno().getCpf().equals(cpf))
						throw new MatriculaException();

			Aluno a = AlunoManager.getAlunos().get(request.getParameter("cpf_aluno"));
			Turma t = TurmasManager.getTurmas().get(request.getParameter("cod_turma"));

			Matricula m = new Matricula();
			m.setTurma(t);
			m.setAluno(a);
			
			MatriculaManager.addMatricula(m);
		
		}
		
			request.getRequestDispatcher("/matriculas.jsp?cod_turma="+cod_turma).forward(request, response);
			
		
	}
	
}
