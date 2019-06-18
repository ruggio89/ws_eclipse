<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container">
	
	<%@ include file="../header.jsp" %>
	<div class="page-header">
  	<br>
	  <h3>Dettaglio Abitante</h3>
	</div>
	<br>
	
	<table border="2" class="table table-hover" style="border-color:#EAF4F4">
		<thead>
			<th>Id</th>
			<th>Nome</th>
			<th>Cognome</th>
			<th>Età</th>
			<th>Residenza</th>
			<th>Municipio</th>
		</thead>
		<tbody>
			<tr>
				<td>${AbitanteForm.id }</td>
				<td>${AbitanteForm.nome }</td> 
				<td>${AbitanteForm.cognome }</td>
				<td>${AbitanteForm.eta }</td>
				<td>${AbitanteForm.residenza }</td>
				<td>${AbitanteForm.municipio.descrizione }</td>
			</tr>
		</tbody>
	</table>
	<form action="${pageContext.request.contextPath }/abitante.do">
		<input type="hidden" name="codop" value="delete">
		<input type="hidden" name="idAbitante" value="${AbitanteForm.id }">
		<input type="submit" class="btn btn-outline-danger btn-md" value="Rimuovi">
		<a href="${pageContext.request.contextPath }/abitante.do?codop=showAll" class="btn btn-outline-danger btn-md">Torna Indietro</a>
	</form>
</div>
</body>
</html>