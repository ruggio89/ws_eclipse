<%@page import="it.prova.model.Persona"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Elimina Persona</title>
</head>
<body>
<%
		Persona personaInPagina = (Persona) request.getAttribute("personadaeliminare_attribute");
	%>

	<div class="container">

		<%@ include file="header.jsp"%>

		<div class="page-header">
			<h3>Pagina di Dettaglio</h3>
		</div>
		<div class="container-fluid">
			<dl class="row">
				<dt class="col-sm-3 text-right">Id</dt>
				<dd class="col-sm-9"><%=personaInPagina.getId()%></dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Nome</dt>
				<dd class="col-sm-9"><%=personaInPagina.getNome()%></dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Cognome</dt>
				<dd class="col-sm-9"><%=personaInPagina.getCognome()%></dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Codice Fiscale</dt>
				<dd class="col-sm-9"><%=personaInPagina.getCf()%></dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Indirizzo</dt>
				<dd class="col-sm-9"><%=personaInPagina.getIndirizzo()%></dd>
			</dl>
			
			<a href="ExecuteEliminaPersonaServlet?idInput=<%=personaInPagina.getId() %>" class="btn btn-info">Conferma Eliminazione</a>
			<a href="search.jsp" class="btn btn-info">Torna Indietro</a>
			
			
		</div>

	</div>
</body>
</html>