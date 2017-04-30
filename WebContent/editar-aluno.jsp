<%@page import="br.com.sysacademic.persistence.AlunoManager"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="materialize/css/materialize.min.css">
<link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<title>Editar Aluno</title>
</head>
<body>
	<%
		
		String nome = AlunoManager.getAlunos().get(request.getParameter("id")).getNome();
		String cpf = AlunoManager.getAlunos().get(request.getParameter("id")).getCpf();
		String tel = AlunoManager.getAlunos().get(request.getParameter("id")).getTelefone();
		String email = AlunoManager.getAlunos().get(request.getParameter("id")).getEmail();
	%>
<h2 class="center">Editar</h2>	
<div class="container">
	<form action="aluno.jsp" method="post">
		<input type="text" name="nome" placeholder="Nome" value="<%=nome%>">
		<input type="hidden" name="cpf" placeholder="Cpf" value="<%=cpf%>">
		<input type="tel" name="telefone" placeholder="Telefone"
			value="<%=tel%>"> <input type="email" name="email"
			placeholder="Email" value="<%=email%>">
		<button class="btn black white-text" type="submit">Finalizar Edição</button>
	</form>
</div>	
</body>
</html>