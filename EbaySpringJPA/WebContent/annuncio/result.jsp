<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Risultati Ricerca Annunci</title>
</head>
<body>
<div class="container">
	
	<%@ include file="../header.jsp" %>
  	
  	<div class="page-header">
	  <h3>Pagina dei Risultati</h3>
	</div>
  	
	<table class="table table-hover">
		<thead>
			<tr>
				<th>Testo Annuncio</th>
				<th>Data di Pubblicazione</th>
				<th>Prezzo</th>
				<th>Action</th>
			</tr>
		</thead>
		<c:forEach items="${listaAnnunciAttributeName}" var="item">
			<tr>
				<td>${item.testoAnnuncio}</td>
				<td>${item.dataAnnuncio}</td>
				<td>${item.prezzo}</td>
				<td>
					<a href="${pageContext.request.contextPath}/PrepareBuyAnnuncioServlet?idAnnuncio=${item.id}" class="btn btn-outline-danger">Compra</a>
					<a href="${pageContext.request.contextPath}/VisualizzaDettaglioAnnuncioServlet?idAnnuncio=${item.id}" class="btn btn-outline-danger">Dettaglio</a>
					<c:if test="${userInfo.username != null}">
					<a href="${pageContext.request.contextPath}/PrepareDeleteAnnuncioServlet?idAnnuncio=${item.id}" class="btn btn-outline-danger">Elimina</a>
					</c:if>
<%-- 					<c:if test="${userInfo.username == null}"> --%>
<%-- 					<a href="${pageContext.request.contextPath}/PrepareDeleteAnnuncioServlet?idAnnuncio=${item.id}" class="btn btn-outline-danger">Elimina</a> --%>
<%-- 					</c:if> --%>
				</td>
			</tr>
		</c:forEach>	
	
	</table>

	</div>
</body>
</html>