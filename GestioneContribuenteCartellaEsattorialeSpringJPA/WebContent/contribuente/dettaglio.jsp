<%@page import="it.prova.gestionecontribuentespringjpa.model.Contribuente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dettaglio Contribuente</title>
</head>
<body>
<%
		Contribuente contribuenteInPagina = (Contribuente) request.getAttribute("ContribuenteSingoloAttributeName");
	%>
	
	

	<div class="container">
	
	<%@ include file="../header.jsp" %>

		<div class="page-header">
			<h3>Dettaglio Contribuente</h3>
		</div>
		<div class="container-fluid">
			<dl class="row">
				<dt class="col-sm-3 text-right">Id</dt>
				<dd class="col-sm-9"><%=contribuenteInPagina.getId()%></dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Nome</dt>
				<dd class="col-sm-9"><%=contribuenteInPagina.getNome()%></dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Cognome</dt>
				<dd class="col-sm-9"><%=contribuenteInPagina.getCognome()%></dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Codice Fiscale</dt>
				<dd class="col-sm-9"><%=contribuenteInPagina.getCodiceFiscale()%></dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Indirizzo</dt>
				<dd class="col-sm-9"><%=contribuenteInPagina.getIndirizzo()%></dd>
			</dl>
		</div>
		<a href="PrepareSearchContribuenteServlet" class="btn btn-outline-danger btn-md">Torna Indietro</a>

	</div>
</body>
</html>