<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page import="it.prova.gestionecontribuentespringjpa.model.Contribuente"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Risultati ricerca Contribuenti</title>
</head>
<body>

<div class="container">
	
	<%@ include file="../header.jsp" %>
  	
  	<div class="page-header">
	  <h3>Risultati Ricerca Contribuenti</h3>
	</div>
  	
	<table class="table table-hover">
		<thead>
			<tr>
				<th>Nome</th>
				<th>Cognome</th>
				<th>Codice Fiscale</th>
				<th>Action</th>
			</tr>
		</thead>
		<c:forEach items="${listaContribuentiAttributeName}" var="item">
			<tr>
				<td>${item.nome}</td>
				<td>${item.cognome}</td>
				<td>${item.codiceFiscale}</td>
				<td>
					<a href="Visualizza	DettaglioContribuenteServlet?idContribuente=${item.id }" class="btn btn-outline-danger">Dettaglio</a>
					<a href="PrepareUpdateContribuenteServlet?idContribuente=${item.id }" class="btn btn-outline-danger">Modifica</a>
					<a href="PrepareDeleteContribuenteServlet?idContribuente=${item.id }" class="btn btn-outline-danger">Elimina</a>
				</td>
			</tr>
		</c:forEach>
				
	</table>
	<a href="PrepareInsertContribuenteServlet" class="btn btn-outline-danger btn-md">Inserisci Nuovo Elemento</a>

	</div>

</body>
</html>