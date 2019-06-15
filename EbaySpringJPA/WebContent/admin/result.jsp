<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Risultati Ricerca Utenti</title>
</head>
<body>
<div class="container">
	
	<%@ include file="../header.jsp" %>
  	
  	<div class="page-header">
	  <h3>Pagina dei Risultati</h3>
	</div>
  	
	<table class="table table-hover">
		<thead>
			<tr>
				<th>Nome</th>
				<th>Cognome</th>
				<th>Username</th>
				<th>Action</th>
			</tr>
		</thead>
		<c:forEach items="${listaUtentiAttributeName}" var="item">
			<tr>
				<td>${item.nome}</td>
				<td>${item.cognome}</td>
				<td>${item.username}</td>
				<td>
					<a href="${pageContext.request.contextPath}/admin/VisualizzaDettaglioUtenteServlet?idUtente=${item.id}" class="btn btn-outline-danger">Dettaglio</a>
					<a href="${pageContext.request.contextPath}/admin/PrepareUpdateUtenteServlet?idUtente=${item.id}" class="btn btn-outline-danger">Modifica</a>
					<a href="${pageContext.request.contextPath}/admin/PrepareDeleteUtenteServlet?idUtente=${item.id}" class="btn btn-outline-danger">Elimina</a>
				</td>
			</tr>
		</c:forEach>	
	
	</table>
	<a href="${pageContext.request.contextPath}/admin/PrepareInsertUtenteServlet" class="btn btn-outline-danger btn-md">Inserisci Nuovo Elemento</a>

	</div>
</body>
</html>