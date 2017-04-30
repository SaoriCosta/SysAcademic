<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%> 
<title>Insert title here</title>
</head>
<body>

<form action="login" method="post">
	<label>${erro-login}</label>
	<label>CPF: </label>
	<input type="text" name="login" placeholder="CPF" /><br>
	<label>Senha: </label>
	<input type="password" name="senha" placeholder="Password" /><br>
	<input type="submit" value="Login">
	<label>Aluno?</label> <a href="cadastro-aluno.html">Cadastre-se</a>
</form>


</body>
</html>