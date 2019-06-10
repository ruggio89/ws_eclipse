<%@page import="it.prova.gestionecontribuentespringjpa.model.Contribuente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Elimina Contribuente</title>
</head>
<body>

	<div class="container">
	
	<%@ include file="../header.jsp" %>

		<div class="page-header">
			<h3>Dettaglio Contribuente</h3>
		</div>
		<div class="container-fluid">
			<dl class="row">
				<dt class="col-sm-3 text-right">Id</dt>
				<dd class="col-sm-9">${contribuentedaeliminare_attribute.id}</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Nome</dt>
				<dd class="col-sm-9">${contribuentedaeliminare_attribute.nome}</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Cognome</dt>
				<dd class="col-sm-9">${contribuentedaeliminare_attribute.cognome}</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Codice Fiscale</dt>
				<dd class="col-sm-9">${contribuentedaeliminare_attribute.codiceFiscale}</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Indirizzo</dt>
				<dd class="col-sm-9">${contribuentedaeliminare_attribute.indirizzo}</dd>
			</dl>
		</div>
		
		<a href="ExecuteDeleteContribuenteServlet?idInput=${contribuentedaeliminare_attribute.id}" class="btn btn-outline-danger btn-md">Conferma Eliminazione</a>
		<a href="PrepareSearchContribuenteServlet" class="btn btn-outline-danger btn-md">Torna Indietro</a>

	</div>
</body>
</html>