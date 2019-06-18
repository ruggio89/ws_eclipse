<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Abitante da eliminare</title>
</head>
<body>

	<div class="container">
	
	<%@ include file="../header.jsp" %>

		<div class="page-header">
			<h3>Abitante da eliminare</h3>
		</div>
		<div class="container-fluid">
			<dl class="row">
				<dt class="col-sm-3 text-right">Id</dt>
				<dd class="col-sm-9">${abitantedaeliminare_attribute.id}</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Nome</dt>
				<dd class="col-sm-9">${abitantedaeliminare_attribute.nome}</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Cognome</dt>
				<dd class="col-sm-9">${abitantedaeliminare_attribute.cognome}</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Età</dt>
				<dd class="col-sm-9">${abitantedaeliminare_attribute.eta}</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Residenza</dt>
				<dd class="col-sm-9">${abitantedaeliminare_attribute.residenza}</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Municipio</dt>
				<dd class="col-sm-9">${abitantedaeliminare_attribute.municipio.descrizione}</dd>
			</dl>
		</div>
		<a href="${pageContext.request.contextPath}/ExecuteDeleteAbitanteServlet?idInput=${abitantedaeliminare_attribute.id}" class="btn btn-outline-danger btn-md">Conferma Eliminazione</a>
		<a href="${pageContext.request.contextPath}/PrepareSearchAbitanteServlet" class="btn btn-outline-danger btn-md">Torna Indietro</a>

	</div>
</body>
</html>