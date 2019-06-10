<%@page import="it.prova.gestionecontribuentespringjpa.model.CartellaEsattoriale"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dettaglio Cartella Esattoriale</title>
</head>
<body>	

	<div class="container">
	
	<%@ include file="../header.jsp" %>

		<div class="page-header">
			<h3>Dettaglio Cartella Esattoriale</h3>
		</div>
		<div class="container-fluid">
			<dl class="row">
				<dt class="col-sm-3 text-right">Id</dt>
				<dd class="col-sm-9">${CartellaEsattorialeSingolaAttributeName.id}</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Denominazione</dt>
				<dd class="col-sm-9">${CartellaEsattorialeSingolaAttributeName.denominazione}</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Descrizione</dt>
				<dd class="col-sm-9">${CartellaEsattorialeSingolaAttributeName.descrizione}</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Importo</dt>
				<dd class="col-sm-9">${CartellaEsattorialeSingolaAttributeName.importo}</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Contribuente</dt>
				<dd class="col-sm-9">${CartellaEsattorialeSingolaAttributeName.contribuente.id}</dd>
			</dl>
		</div>
		<a href="PrepareSearchCartellaEsattorialeServlet" class="btn btn-outline-danger btn-md">Torna Indietro</a>

	</div>
</body>
</html>