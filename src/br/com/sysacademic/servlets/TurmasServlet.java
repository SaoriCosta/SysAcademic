package br.com.sysacademic.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sysacademic.entidades.Turmas;
import br.com.sysacademic.persistence.AlunosManager;
import br.com.sysacademic.persistence.TurmasManager;

@WebServlet("/turmas")
public class TurmasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public TurmasServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		out.println("<html>" 
				+ "<head> "
				+ "<link rel='stylesheet' href='materialize/css/materialize.css'>" 
				+ "<title>Turmas</title>" 
				+ "</head>" 
				+ "<body>"
				+ "<h4 class='center'>Listagem de Turmas!</h4>" 
				+ "<table class='striped'>" 
				+ "<tr>" 
				+ "<th>Código</th>" 
				+ "<th>Disciplina</th>"
				+ "<th>Período</th>" 
				+ "<th>Créditos</th>" 
				+ "</tr>"
				+ " <a style='margin:2%;' class='btn black white-text' href = 'cadastro-turmas.html'>+ Cadastrar Turmas</a>" 
				+ "<a class='btn black white-text' href = 'index.html'> Início</a>");

		for (String i : TurmasManager.getTurmas().keySet()) {

			out.println("" + "<tr>" + "<td>" + TurmasManager.getTurmas().get(i).getCodigo() + "</td>" + "<td>"
					+ TurmasManager.getTurmas().get(i).getDisciplina() + "</td>" + "<td>"
					+ TurmasManager.getTurmas().get(i).getPeriodo() + "</td>" + "<td>"
					+ TurmasManager.getTurmas().get(i).getCredito() + "</td>" + "</tr>" + "");
		}

		out.println("</table>" 
	
				+"</body>" 
				+ "</html>");

		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());

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

		Turmas t = new Turmas();

		if (codigo.equals("") || disciplina.equals("") || periodo.equals("") || credito == 0) {
			throw new CadastroException();

		} else {

			if (TurmasManager.getTurmas().containsKey(codigo)) {
				throw new InsertException();
			} else {

				t.setCodigo(codigo);
				t.setCredito(credito);
				t.setDisciplina(disciplina);
				t.setPeriodo(periodo);

				TurmasManager.addTurma(t);

				doGet(request, response);
			}
		}
	}

}
