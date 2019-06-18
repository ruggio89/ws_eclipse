<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Risultati Ricerca</title>
</head>
<body>

	<div class="container">

		<%@ include file="../header.jsp"%>

		<div class="page-header">
			<h3>Pagina dei Risultati</h3>
		</div>

		<table class="table table-striped">
			<thead>
				<tr>
<!-- 					<th>Id</th> -->
					<th>Descrizione</th>
					<th>Codice</th>
					<th>Ubicazione</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${listaMunicipiAttributeName}" var="municipioItem">
					<tr>
<%-- 						<td>${municipioItem.id }</td> --%>
						<td>${municipioItem.descrizione }</td>
						<td>${municipioItem.codice }</td>
						<td>${municipioItem.ubicazione }</td>
						<td><a
							href="ExecuteDettaglioMunicipioServlet?idMunicipio=${municipioItem.id }"
							class="btn btn-danger">Dettaglio</a> <a
							href="PrepareUpdateMunicipioServlet?idMunicipio=${municipioItem.id }"
							class="btn btn-info">Modifica</a>
							<a href="PrepareDeleteMunicipioServlet?idMunicipio=${municipioItem.id }"
							class="btn btn-primary">Elimina</a>
							</td>
					</tr>
				</c:forEach>

			
			</tbody>

		</table>
	<a href="${pageContext.request.contextPath}/PrepareInsertMunicipioServlet" class="btn btn-primary btn-md">Inserisci Nuovo Elemento</a>
	<a href="${pageContext.request.contextPath}/PrepareSearchMunicipioServlet" class="btn btn-outline-danger btn-md">Torna Indietro</a>
	</div>
</body>
</html>