<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%> 


<link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Josefin+Sans" rel="stylesheet"> 
	<link rel="stylesheet" href="css/style.css">
<title>Insert title here</title>
</head>
<body>

<table>

<h2>Login</h2>
<form action="login" method="post">
	<!-- ${erro-login} -->
	<tr>
		<td><label>CPF: </label></td>
		<td><input id="login" type="text" name="login" placeholder="CPF" /></td>
	</tr>
	
	<tr>
		<td><label>Senha: </label></td>
		<td><input id="senha" type="password" name="senha" placeholder="Password" /></td>
	</tr>
	<tr>
		<td><label> </label></td>
		<td><input id="submit" type="submit" value="Login"></td>
	</tr>
	
</form>
</table>

</body>
</html>