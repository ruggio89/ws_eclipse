<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Elimina Categoria</title>
</head>
<body>

	<div class="container">
	
	<%@ include file="/header.jsp" %>

		<div class="page-header">
		<br>
			<h3>Dettaglio Categoria da eliminare</h3>
		</div>
		<br>
		<div class="container-fluid">
			<dl class="row">
				<dt class="col-sm-3 text-right">Id</dt>
				<dd class="col-sm-9" id="inputIdd">${categoriadaeliminare_attribute.id}</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Descrizione</dt>
				<dd class="col-sm-9">${categoriadaeliminare_attribute.descrizione}</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Codice</dt>
				<dd class="col-sm-9">${categoriadaeliminare_attribute.codice}</dd>
			</dl>
		</div>
		<c:forEach items="${listaAnnunciAttributeName}" var="annuncioItem">
			<input type="hidden" id="${annuncioItem.id}" name="annuncioId" value="${annuncioItem.id}"/>
		</c:forEach>
		
		<a href="${pageContext.request.contextPath}/admin/ExecuteDeleteCategoriaServlet?idInput=${categoriadaeliminare_attribute.id}" class="btn btn-outline-danger btn-md">Conferma Eliminazione</a>
		<a href="${pageContext.request.contextPath}/admin/PrepareSearchCategoriaServlet" class="btn btn-outline-danger btn-md">Torna Indietro</a>

	</div>	
	
</body>
</html>