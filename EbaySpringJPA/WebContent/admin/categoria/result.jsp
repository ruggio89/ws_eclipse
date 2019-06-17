<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Risultati Ricerca Categorie</title>
</head>
<body>
<div class="container">
	
	<%@ include file="/header.jsp" %>
  	
  	<div class="page-header">
  	<br>
	  <h3>Pagina dei Risultati</h3>
	</div>
	<br>
  	
	<table class="table table-hover">
		<thead>
			<tr>
				<th>Descrizione</th>
				<th>Codice</th>
				<th>Action</th>
			</tr>
		</thead>
		<c:forEach items="${listaCategorieAttributeName}" var="item">
			<tr>
				<td>${item.descrizione}</td>
				<td>${item.codice}</td>
				<td>
					<a href="${pageContext.request.contextPath}/admin/PrepareUpdateCategoriaServlet?idCategoria=${item.id}" class="btn btn-outline-danger">Modifica</a>
					<a href="${pageContext.request.contextPath}/admin/PrepareDeleteCategoriaServlet?idCategoria=${item.id}" class="btn btn-outline-danger">Elimina</a>
				</td>
			</tr>
		</c:forEach>	
	
	</table>
	<a href="${pageContext.request.contextPath}/admin/PrepareInsertCategoriaServlet" class="btn btn-outline-danger btn-md">Inserisci Nuovo Elemento</a>

	</div>
</body>
</html>