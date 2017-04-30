<%@page import="br.com.sysacademic.persistence.TurmasManager"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
   <link rel='stylesheet' href='materialize/css/materialize.css'>
   <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
 <%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%> 
<title>Insert title here</title>
</head>
<body>

		<table class='striped'> 
			<tr>
			<th>Código da Disciplina</th>
			<th>Nome da Disciplina</th> 
			<th>Período</th> 
			<th>Crédito</th>
			</tr>
			
			
			<c:forEach var="i" items="${TurmasManager.getTurmas().keySet()}">
				
				<tr>
				<td>${TurmasManager.getTurmas().get(i).getCodigo()}</td>
				<td>${TurmasManager.getTurmas().get(i).getDisciplina()}</td>
				<td>${TurmasManager.getTurmas().get(i).getPeriodo()}</td>
				<td>${TurmasManager.getTurmas().get(i).getCredito()}</td>

				</tr>
			</c:forEach>
	
		</table>


</body>
</html>