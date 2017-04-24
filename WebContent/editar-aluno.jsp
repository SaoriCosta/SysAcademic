<%@page import="br.com.sysacademic.persistence.AlunosManager"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Editar Aluno</title>
</head>
<body>
<% 
	
	String nome = AlunosManager.getAlunos().get(request.getParameter("id")).getNome();
	String cpf = AlunosManager.getAlunos().get(request.getParameter("id")).getCpf();
	String tel = AlunosManager.getAlunos().get(request.getParameter("id")).getTelefone();
	String email = AlunosManager.getAlunos().get(request.getParameter("id")).getEmail();
	
%>

<form action="aluno.jsp" method="post">
	<input type = "text" name = "nome" placeholder = "Nome" value = "<%=nome %>" >
	<input type = "text" name = "cpf"  placeholder = "Cpf" value = "<%=cpf%>" >
	<input type = "tel" name = "telefone"  placeholder = "Telefone" value = "<%=tel %>">
	<input type = "email" name = "email"  placeholder = "Email" value = "<%=email %>">
	<button class="btn" type = "submit" >Finalizar Edição</button>
</form>
</body>
</html>