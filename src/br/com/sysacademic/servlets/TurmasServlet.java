package br.com.sysacademic.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import br.com.sysacademic.entidades.Turma;
import br.com.sysacademic.persistence.AlunoManager;
import br.com.sysacademic.persistence.TurmasManager;

@WebServlet("/turmas")
public class TurmasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public TurmasServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

			doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String codigo, disciplina, periodo;
		int credito = 0;

		codigo = request.getParameter("codigo");
		disciplina = request.getParameter("disciplina");
		periodo = request.getParameter("periodo");

		if (request.getParameter("creditos") != null && !request.getParameter("creditos").equals(""))
			credito = Integer.parseInt(request.getParameter("creditos"));

		Turma t = new Turma();
		if (codigo != null && disciplina != null && periodo != null){
			if (codigo.equals("") || disciplina.equals("") || periodo.equals("") || credito == 0) {
				throw new CadastroException();

			} else {

				if (TurmasManager.getTurmas().containsKey(codigo)) {
					throw new InsertException();
				} else {

					JOptionPane.showMessageDialog(null, "opa, chegou");

					t.setCodigo(codigo);
					t.setCredito(credito);
					t.setDisciplina(disciplina);
					t.setPeriodo(periodo);

					TurmasManager.addTurma(t);
					request.getRequestDispatcher("/turmas.jsp").forward(request, response);
				}
			}
	}
	}
}
