<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="javax.swing.JOptionPane"%>
<%@page import="br.com.sysacademic.servlets.MatriculaException"%>
<%@page import="br.com.sysacademic.entidades.Alunos"%>
<%@page import="br.com.sysacademic.entidades.Turmas"%>
<%@page import="br.com.sysacademic.entidades.Matriculas"%>
<%@page import="br.com.sysacademic.persistence.MatriculasManager"%>
<%@page import="br.com.sysacademic.persistence.TurmasManager"%>
<%@page import="br.com.sysacademic.servlets.InexistenteException"%>
<%@page import="br.com.sysacademic.persistence.AlunosManager"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<!--   <link rel='stylesheet' href='materialize/css/materialize.css'> -->

<script src="js/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
    $('select').material_select();
});
</script>


</head>
<body>

<h4 class="center">Realizar Matricula</h4>
<div class="container">
<form action="matriculas.jsp" method = "GET">
	
	
	
	<select name = "cpf_aluno">
	<option> Selecione um aluno </option>
	<% for(String i : AlunosManager.getAlunos().keySet()){%>
	<option value= "<%=AlunosManager.getAlunos().get(i).getCpf()%>">
		<%=AlunosManager.getAlunos().get(i).getNome()%>
	</option>
	<%} %>
	</select>
	
	<select name="cod_turma">
		<option> Selecione a turma </option>
		<%for(String i : TurmasManager.getTurmas().keySet()){%>
	<option value= "<%=TurmasManager.getTurmas().get(i).getCodigo()%>">
	<%=TurmasManager.getTurmas().get(i).getDisciplina()%> - 
	<%=TurmasManager.getTurmas().get(i).getPeriodo()%>
	
	</option>
	<%} %>
	</select>
<button class="btn" type = "submit" >Cadastrar</button>
</form>
</div>
<%! 
 static String cpf = null;
 static String cod_turma = null;
%>
<%
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
	
%>

			<h4 class='center'>Listagem de Matrículas!</h4> 
			<table class='striped'> 
			<tr>
			<th>Código da Disciplina</th>
			<th>Nome da Disciplina</th> 
			<th>Nome do Aluno</th> 
			<th>Cpf do Aluno</th>
			<th>Período</th> 
			</tr>
			<a style='margin:2%;' class='btn black white-text' href = 'cadastro-matricula.html'> +Cadastrar Matricula</a>
			<a class='btn black white-text' href = 'index.html'> Início</a>
	
		<%if(cod_turma != null && cpf!=null){ %>
		<c:forEach var="i" items="${MatriculasManager.getMatriculas()}">
		<tr>
		<td>${i.value.get(cod_turma).get(j).getTurma().getCodigo()}</td>
		<td>${i.value.get(cod_turma).get(j).getTurma().getDisciplina()}</td>
		<td>${i.value.get(cod_turma).get(j).getAluno().getNome()}</td>
		<td>${i.value.get(cod_turma).get(j).getAluno().getCpf()}</td>
		<td>${i.value.get(cod_turma).get(j).getTurma().getPeriodo()}</td>
		<td><a href="removerTurma?codigo=${i.value.getCodigo()}">Remover</a></td>
		</tr>
		</c:forEach>
		<%} 
		
		for (int j = 0; j < MatriculasManager.getMatriculas().get(cod_turma).size(); j++) {
			out.println("<tr>" + "<td>" + MatriculasManager.getMatriculas().get(cod_turma).get(j).getTurma().getCodigo()
					+ "</td>" + "<td>" + MatriculasManager.getMatriculas().get(cod_turma).get(j).getTurma().getDisciplina() + "</td>"
					+ "<td>" + MatriculasManager.getMatriculas().get(cod_turma).get(j).getAluno().getNome() + "</td>" + "<td>"
					+ MatriculasManager.getMatriculas().get(cod_turma).get(j).getAluno().getCpf() + "</td>" + "<td>"
					+ MatriculasManager.getMatriculas().get(cod_turma).get(j).getTurma().getPeriodo() + "</td>" + "</tr>");
		}
		%>
		
		</table>


</body>
</html>