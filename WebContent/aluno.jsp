<%@page import="javax.swing.JOptionPane"%>
<%@page import="br.com.sysacademic.servlets.CadastroException"%>
<%@page import="br.com.sysacademic.entidades.Aluno"%>
<%@page import="br.com.sysacademic.persistence.AlunoManager"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="materialize/css/materialize.min.css">
<link href="http://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<title>Aluno</title>
</head>

<body>

	<h4 class='center'>Listagem de Alunos!</h4>
	<table class='striped'>
		<tr>
			<th>Id</th>
			<th>Nome</th>
			<th>Telefone</th>
			<th>Email</th>
			<th>Cpf</th>
		</tr>
		<a style='margin: 2%;' class='btn black white-text'
			href='cadastro-aluno.html'>+ Cadastrar Aluno</a>
		<a class='btn black white-text' href='index.html'> Início</a>

		<%
			for (String i : AlunoManager.getAlunos().keySet()) {
		%>

		<tr>
			<td><%=AlunoManager.getAlunos().get(i).getId()%></td>
			<td><%=AlunoManager.getAlunos().get(i).getNome()%></td>
			<td><%=AlunoManager.getAlunos().get(i).getTelefone()%></td>
			<td><%=AlunoManager.getAlunos().get(i).getEmail()%></td>
			<td><%=AlunoManager.getAlunos().get(i).getCpf()%></td>
			<td><i class="material-icons black-text left">mode_edit</i><a
				href="editar-aluno.jsp?id=<%=AlunoManager.getAlunos().get(i).getCpf()%>">Editar</a></td>
		</tr>

		<%
			}
		%>
	</table>


</body>
</html>