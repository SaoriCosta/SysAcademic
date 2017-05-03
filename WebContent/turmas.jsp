<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="br.com.sysacademic.servlets.InsertException"%>
<%@page import="br.com.sysacademic.servlets.CadastroException"%>
<%@page import="br.com.sysacademic.entidades.Turma"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="br.com.sysacademic.persistence.TurmasManager"%>
 <%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel='stylesheet' href='materialize/css/materialize.css'>
<title>Insert title here</title>
</head>
<body>

<jsp:useBean id="bean" class="br.com.sysacademic.persistence.TurmasManager"></jsp:useBean>

<h4 class='center'>Listagem de Turmas!</h4>
				<table class='striped'>
				<tr> 
				<th>Código</th> 
				<th>Disciplina</th>
				<th>Período</th>
				<th>Créditos</th> 
				</tr>
				 <a style='margin:2%;' class='btn black white-text' href = 'cadastro-turmas.html'>+ Cadastrar Turmas</a>
				<a class='btn black white-text' href = 'index.html'> Início</a>
				
				<%// request.setAttribute("turma", TurmasManager.getTurmas()); %>
				
				<c:forEach var="i" items="${bean.getTurmas()}">
							<tr>
							<td>${i.value.getCodigo()}</td>
							<td>${i.value.getDisciplina()}</td>
							<td>${i.value.getPeriodo()}</td>
							<td>${i.value.getCredito()}</td>
							<td><a href="removerTurma?codigo=${i.value.getCodigo()}">Remover</a></td>
							</tr>
				</c:forEach>
				
				
				
					</table> 
</body>
</html>