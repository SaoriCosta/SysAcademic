<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="javax.swing.JOptionPane"%>
<%@page import="br.com.sysacademic.servlets.MatriculaException"%>
<%@page import="br.com.sysacademic.entidades.Aluno"%>
<%@page import="br.com.sysacademic.entidades.Turma"%>
<%@page import="br.com.sysacademic.entidades.Matricula"%>
<%@page import="br.com.sysacademic.persistence.MatriculaManager"%>
<%@page import="br.com.sysacademic.persistence.TurmasManager"%>
<%@page import="br.com.sysacademic.servlets.InexistenteException"%>
<%@page import="br.com.sysacademic.persistence.AlunoManager"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
   <link rel='stylesheet' href='materialize/css/materialize.css'>

<script src="js/jquery.min.js"></script>
<script src="materialize/js/materialize.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
    $('select').material_select();
});
</script>


</head>
<body>

<h4 class="center">Realizar Matricula</h4>
<div class="container">
<form action="matriculas" method = "GET">
	
	
	
	<select name = "cpf_aluno">
	<option> Selecione um aluno </option>
	<% for(String i : AlunoManager.getAlunos().keySet()){%>
	<option value= "<%=AlunoManager.getAlunos().get(i).getCpf()%>">
		<%=AlunoManager.getAlunos().get(i).getNome()%>
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
<button class="btn black" type = "submit" >Cadastrar</button>
</form>
</div>
<%! 
 static String cod_turma;
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
			
		
			
			<c:forEach var="i" items="${MatriculaManager.getMatriculas().keySet()}">
			<c:forEach var="j" begin="0" end="${MatriculaManager.getMatriculas().get(i).size()-1}">
				
				<tr>
				<td>${MatriculaManager.getMatriculas().get(i).get(j).getTurma().getCodigo()}</td>
				<td>${MatriculaManager.getMatriculas().get(i).get(j).getTurma().getDisciplina()}</td>
				<td>${MatriculaManager.getMatriculas().get(i).get(j).getAluno().getNome()}</td>
				<td>${MatriculaManager.getMatriculas().get(i).get(j).getAluno().getCpf()}</td>
				<td>${MatriculaManager.getMatriculas().get(i).get(j).getTurma().getPeriodo()}</td>	
				
				</tr>
			</c:forEach>
			</c:forEach>
	
		</table>

		<a class='btn black white-text' href = 'index.html'> Início</a>
</body>
</html>