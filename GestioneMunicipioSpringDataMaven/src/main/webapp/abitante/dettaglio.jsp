<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dettaglio Abitante</title>
</head>
<body>

	<div class="container">
	
	<%@ include file="../header.jsp" %>

		<div class="page-header">
			<h3>Dettaglio Abitante</h3>
		</div>
		<div class="container-fluid">
			<dl class="row">
				<dt class="col-sm-3 text-right">Id</dt>
				<dd class="col-sm-9">${AbitanteSingoloAttributeName.id}</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Nome</dt>
				<dd class="col-sm-9">${AbitanteSingoloAttributeName.nome}</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Cognome</dt>
				<dd class="col-sm-9">${AbitanteSingoloAttributeName.cognome}</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Età</dt>
				<dd class="col-sm-9">${AbitanteSingoloAttributeName.eta}</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Residenza</dt>
				<dd class="col-sm-9">${AbitanteSingoloAttributeName.residenza}</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Municipio</dt>
				<dd class="col-sm-9">${AbitanteSingoloAttributeName.municipio.descrizione}</dd>
			</dl>
		</div>
		<a href="${pageContext.request.contextPath}/PrepareSearchAbitanteServlet" class="btn btn-outline-danger btn-md">Torna Indietro</a>

	</div>
</body>
</html>