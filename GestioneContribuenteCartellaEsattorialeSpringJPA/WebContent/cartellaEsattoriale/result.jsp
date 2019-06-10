<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page import="it.prova.gestionecontribuentespringjpa.model.CartellaEsattoriale"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Risultati Ricerca Cartelle Esattoriali</title>
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
				<th>Denominazione</th>
				<th>Descrizione</th>
				<th>Action</th>
			</tr>
		</thead>
		<c:forEach items="${listaCartelleEsattorialiAttributeName}" var="item">
			<tr>
				<td>${item.denominazione}</td>
				<td>${item.descrizione}</td>
				<td>
					<a href="VisualizzaDettaglioCartellaEsattorialeServlet?idCartellaEsattoriale=${item.id}" class="btn btn-outline-danger">Dettaglio</a>
					<a href="PrepareUpdateCartellaEsattorialeServlet?idCartellaEsattoriale=${item.id}" class="btn btn-outline-danger">Modifica</a>
					<a href="PrepareDeleteCartellaEsattorialeServlet?idCartellaEsattoriale=${item.id}" class="btn btn-outline-danger">Elimina</a>
				</td>
			</tr>
		</c:forEach>	
	
	</table>
	<a href="PrepareInsertCartellaEsattorialeServlet" class="btn btn-outline-danger btn-md">Inserisci Nuovo Elemento</a>

	</div>
</body>
</html>