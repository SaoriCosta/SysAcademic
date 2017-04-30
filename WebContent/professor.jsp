<%@page import="br.com.sysacademic.persistence.ProfessorManager"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" href="materialize/css/materialize.min.css">
<link href="http://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
</head>
<body>

	<h4 class='center'>Listagem de Professor!</h4>
	<table class='striped'>
		<tr>
			<th>Id</th>
			<th>Nome</th>
			<th>Cpf</th>
		</tr>
		<a style='margin: 2%;' class='btn black white-text'
			href='cadastro-professor.jsp'>+ Cadastrar Professor</a>
		<a class='btn black white-text' href='index.html'> Início</a>

		<%
			for (String i : ProfessorManager.getProfessor().keySet()) {
		%>

		<tr>
			<td><%=ProfessorManager.getProfessor().get(i).getId()%></td>
			<td><%=ProfessorManager.getProfessor().get(i).getNome()%></td>
			<td><%=ProfessorManager.getProfessor().get(i).getCpf()%></td>
			<td><i class="material-icons black-text left">mode_edit</i><a
				href="editar-aluno.jsp?id=<%=ProfessorManager.getProfessor().get(i).getCpf()%>">Editar</a></td>
		</tr>

		<%
			}
		%>
	</table>



</body>
</html>