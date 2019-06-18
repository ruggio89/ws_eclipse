<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista Abitanti</title>
</head>
<body>

<div class="container">
	
	<%@ include file="../header.jsp" %>
	
	<div class="page-header">
	  	<br>
		  <h3>Lista di Abitanti</h3>
		</div>
		<br>
	<table border="2" class="table table-hover" style="border-color:#EAF4F4">
		<thead>
			<th>Nome</th>
			<th>Cognome</th>
			<th>Azioni</th>
		</thead>
		<c:forEach var="abitanteItem" items="${listaAbitanti}">
			<tbody>
				<tr>
					<td>${abitanteItem.nome }</td>
					<td>${abitanteItem.cognome }</td>
					<td><a href="${pageContext.request.contextPath }/abitante.do?idAbitante=${abitanteItem.id}&codop=show" class="btn btn-outline-danger btn-md">Dettaglio</a></td>
				</tr>
			</tbody>
		</c:forEach>
	</table>
	<a href="${pageContext.request.contextPath }/abitante.do?codop=create" class="btn btn-outline-danger btn-md">Nuovo Abitante</a>
	<a href="${pageContext.request.contextPath }/home.do" class="btn btn-outline-danger btn-md">Torna alla Home</a>

</div>
</body>
</html>