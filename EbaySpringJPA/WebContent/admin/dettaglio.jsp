<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dettaglio Utente</title>
</head>
<body>	

	<div class="container">
	
	<%@ include file="../header.jsp" %>

		<div class="page-header">
		<br>
			<h3>Dettaglio Utente</h3>
		</div>
		<br>
		<div class="container-fluid">
			<dl class="row">
				<dt class="col-sm-3 text-right">Id</dt>
				<dd class="col-sm-9">${UtenteSingolaAttributeName.id}</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Nome</dt>
				<dd class="col-sm-9">${UtenteSingolaAttributeName.nome}</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Cognome</dt>
				<dd class="col-sm-9">${UtenteSingolaAttributeName.cognome}</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Username</dt>
				<dd class="col-sm-9">${UtenteSingolaAttributeName.username}</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Password</dt>
				<dd class="col-sm-9">${UtenteSingolaAttributeName.password}</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Data Registrazione</dt>
				<dd class="col-sm-9">${UtenteSingolaAttributeName.dataRegistrazione}</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Credito Residuo</dt>
				<dd class="col-sm-9">${UtenteSingolaAttributeName.creditoResiduo}</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Ruolo</dt>
				<dd class="col-sm-9"><c:forEach items="${UtenteSingolaAttributeName.ruoli}" var="item">${item.descrizione}<br></c:forEach></dd>
				
			</dl>
		</div>
		<a href="${pageContext.request.contextPath}/admin/PrepareSearchUtenteServlet" class="btn btn-outline-danger btn-md">Torna Indietro</a>

	</div>
</body>
</html>