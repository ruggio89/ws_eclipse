<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Risultati Ricerca Acquisti Effettuati</title>
</head>
<body>
<div class="container">
	
	<%@ include file="../header.jsp" %>
  	
  	<div class="page-header">
  	<br>
	  <h3>Acquisti Effettuati</h3>
	</div>
	<br>
  	
	<table class="table table-hover">
		<thead>
			<tr>
				<th>Descrizione</th>
				<th>Prezzo</th>
				<th>Anno di Acquisto</th>
			</tr>
		</thead>
		<c:forEach items="${listaAcquistiAttributeName}" var="item">
			<tr>
				<td>${item.descrizione}</td>
				<td>${item.prezzo} &#8364;</td>
				<td>${item.anno}</td>
				<td>
<%-- 					<a href="VisualizzaDettaglioAcquistoUtenteServlet?idAcquisto=${item.id}" class="btn btn-outline-danger">Dettaglio</a> --%>
				</td>
			</tr>
		</c:forEach>
		
	
	</table>
			<a href="${pageContext.request.contextPath}/utente/areaRiservata.jsp" class="btn btn-outline-danger">Torna Indietro</a>
	

	</div>
</body>
</html>