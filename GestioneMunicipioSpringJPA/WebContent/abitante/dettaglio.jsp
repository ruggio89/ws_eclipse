<%@page import="it.prova.gestionemunicipiospringjpa.model.Abitante"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dettaglio Abitante</title>
</head>
<body>
<%
		Abitante abitanteInPagina = (Abitante) request.getAttribute("AbitanteSingoloAttributeName");
	%>
	
	

	<div class="container">
	
	<%@ include file="../header.jsp" %>

		<div class="page-header">
			<h3>Pagina di Dettaglio</h3>
		</div>
		<div class="container-fluid">
			<dl class="row">
				<dt class="col-sm-3 text-right">Id</dt>
				<dd class="col-sm-9"><%=abitanteInPagina.getId()%></dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Nome</dt>
				<dd class="col-sm-9"><%=abitanteInPagina.getNome()%></dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Cognome</dt>
				<dd class="col-sm-9"><%=abitanteInPagina.getCognome()%></dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Età</dt>
				<dd class="col-sm-9"><%=abitanteInPagina.getEta()%></dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Residenza</dt>
				<dd class="col-sm-9"><%=abitanteInPagina.getResidenza()%></dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Municipio</dt>
				<dd class="col-sm-9"><%=abitanteInPagina.getMunicipio().getDescrizione()%></dd>
			</dl>
		</div>
		<a href="<%= request.getContextPath()%>/home.jsp" class="btn btn-outline-danger btn-md">Torna Indietro</a>

	</div>
</body>
</html>