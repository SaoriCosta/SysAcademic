<%@page import="br.com.sysacademic.entidades.Turma"%>
<%@page import="java.util.HashMap"%>
<%@page import="br.com.sysacademic.persistence.TurmasManager"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%> 
 <link rel='stylesheet' href='materialize/css/materialize.css'>
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
<div class="container center">
<h4> Cadastro de Professor </h4>

<form action="professores" method="post">
	<label>${warning}</label>
	
	<input type = "text" name = "nome" placeholder = "Nome" >
	<input type = "text" name = "login"  placeholder = "Cpf" >
	<input type="password" name="senha" placeholder="Senha: " >
	<input type="password" name="confsenha" placeholder="Confirma Senha: " >
	<button class="btn" type = "submit" >Cadastrar</button>
</form>
</div>
</body>
</html>