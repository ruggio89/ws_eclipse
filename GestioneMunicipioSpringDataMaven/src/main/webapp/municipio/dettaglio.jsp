<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dettaglio Municipio</title>
</head>
<body>	

	<div class="container">
	
	<%@ include file="../header.jsp" %>

		<div class="page-header">
		<br>
			<h3>Dettaglio Municipio</h3>
		</div>
		<br>
		<div class="container-fluid">
			<dl class="row">
				<dt class="col-sm-3 text-right">Id</dt>
				<dd class="col-sm-9">${MunicipioSingolaAttributeName.id}</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Descrizione</dt>
				<dd class="col-sm-9">${MunicipioSingolaAttributeName.descrizione}</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Codice</dt>
				<dd class="col-sm-9">${MunicipioSingolaAttributeName.codice}</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Ubicazione</dt>
				<dd class="col-sm-9">${MunicipioSingolaAttributeName.ubicazione}</dd>
			</dl>
		</div>
		<a href="${pageContext.request.contextPath}/PrepareSearchMunicipioServlet" class="btn btn-outline-danger btn-md">Torna Indietro</a>

	</div>
</body>
</html>