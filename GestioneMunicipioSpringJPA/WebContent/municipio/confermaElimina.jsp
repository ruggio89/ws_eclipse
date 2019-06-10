<%@page import="it.prova.gestionemunicipiospringjpa.model.Municipio"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Elimina Municipio</title>
</head>
<body>
<%
		Municipio municipioInPagina = (Municipio) request.getAttribute("municipiodaeliminare_attribute");
	%>
	
	

	<div class="container">
	
	<%@ include file="../header.jsp" %>

		<div class="page-header">
			<h3>Pagina di Dettaglio</h3>
		</div>
		<div class="container-fluid">
			<dl class="row">
				<dt class="col-sm-3 text-right">Id</dt>
				<dd class="col-sm-9"><%=municipioInPagina.getId()%></dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Descrizione</dt>
				<dd class="col-sm-9"><%=municipioInPagina.getDescrizione()%></dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Codice</dt>
				<dd class="col-sm-9"><%=municipioInPagina.getCodice()%></dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Ubicazione</dt>
				<dd class="col-sm-9"><%=municipioInPagina.getUbicazione()%></dd>
			</dl>
			
			<a href="ExecuteDeleteMunicipioServlet?idInput=<%=municipioInPagina.getId() %>" class="btn btn-outline-danger btn-md">Conferma Eliminazione</a>
			<a href="PrepareSearchMunicipioServlet" class="btn btn-outline-danger btn-md">Torna Indietro</a>
			
		</div>

	</div>
</body>
</html>