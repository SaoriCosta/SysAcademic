<%@page import="br.com.sysacademic.persistence.MatriculaManager"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="../materialize/css/materialize.min.css">
<link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
 <%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%> 
<title>Aluno</title>
</head>
<body>
<h3>Bem vindo,${aluno.getNome()}</h3>
<a class="btn blue" href="../matriculas.jsp">Cadastrar matrícula</a>
<a class="btn gren" href="index.jsp?ver=1" >Ver Matriculas Realizadas</a>


<c:url value="/alunoLogout" var="alunoLogout"></c:url>
<a class="btn red" href="${alunoLogout}">Logout</a>
	<hr>
	<%if(request.getParameter("ver")!=null && request.getParameter("ver").equals("1")){%>
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
				<c:if test="${MatriculaManager.getMatriculas().get(i).get(j).getAluno().getCpf().equals(aluno.getCpf())}">
				<tr>
				<td>${MatriculaManager.getMatriculas().get(i).get(j).getTurma().getCodigo()}</td>
				<td>${MatriculaManager.getMatriculas().get(i).get(j).getTurma().getDisciplina()}</td>
				<td>${MatriculaManager.getMatriculas().get(i).get(j).getAluno().getNome()}</td>
				<td>${MatriculaManager.getMatriculas().get(i).get(j).getAluno().getCpf()}</td>
				<td>${MatriculaManager.getMatriculas().get(i).get(j).getTurma().getPeriodo()}</td>	
				
				</tr>
				</c:if>
			</c:forEach>
			</c:forEach>
	
		</table>
	<%} %>	
</body>
</html>