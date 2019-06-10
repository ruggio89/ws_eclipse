<%@page import="it.prova.model.Vino"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style type="text/css">
.alabaster{background-color:#F3EEE4}
</style>
<title>Elimina Vino</title>
</head>
<body class="alabaster">
<%
		Vino vinoInPagina = (Vino) request.getAttribute("vinodaeliminare_attribute");
	%>
	
	

	<div class="container">
	
	<%@ include file="header.jsp" %>

		<div class="page-header">
			<h3>Pagina di Dettaglio</h3>
		</div>
		<div class="container-fluid">
			<dl class="row">
				<dt class="col-sm-3 text-right">Id</dt>
				<dd class="col-sm-9"><%=vinoInPagina.getId()%></dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Nome</dt>
				<dd class="col-sm-9"><%=vinoInPagina.getNome()%></dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Cantina</dt>
				<dd class="col-sm-9"><%=vinoInPagina.getCantina()%></dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Uva</dt>
				<dd class="col-sm-9"><%=vinoInPagina.getUva()%></dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Localita</dt>
				<dd class="col-sm-9"><%=vinoInPagina.getLocalita()%></dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Annata</dt>
				<dd class="col-sm-9"><%=vinoInPagina.getAnnata()%></dd>
			</dl>
			
			<a href="ExecuteEliminaVinoServlet?idInput=<%=vinoInPagina.getId() %>" class="btn btn-danger">Conferma Eliminazione</a>
			<a href="search.jsp" class="btn btn-danger">Torna Indietro</a>
			
		</div>

	</div>
</body>
</html>