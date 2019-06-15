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
					<a href="VisualizzaDettaglioAnnuncioUtenteServlet?idAnnuncio=${item.id}" class="btn btn-outline-danger">Dettaglio</a>
					<a href="PrepareUpdateAnnuncioUtenteServlet?idAnnuncio=${item.id}" class="btn btn-outline-danger">Modifica</a>
					<c:if test="${userInfo.username != null}">
					<a href="PrepareDeleteAnnuncioUtenteServlet?idAnnuncio=${item.id}" class="btn btn-outline-danger">Elimina</a>
					</c:if>
<%-- 					<c:if test="${userInfo.username == null}"> --%>
					
<%-- 					</c:if> --%>
				</td>
			</tr>
		</c:forEach>
		
	
	
	</table>
	<a href="PrepareInsertAnnuncioUtenteServlet" class="btn btn-outline-danger btn-md">Inserisci Nuovo Elemento</a>

	</div>
</body>
</html>