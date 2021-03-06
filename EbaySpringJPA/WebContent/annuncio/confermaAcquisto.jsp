<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Conferma Acquisto</title>
</head>
<body>	

	<div class="container">
	
	<%@ include file="../header.jsp" %>

		<div class="page-header">
		<br>
			<h3>Dettagli Annuncio da Acquistare</h3>
		</div>
		<br>
		<div class="container-fluid">
			<dl class="row">
				<dt class="col-sm-3 text-right">Id</dt>
				<dd class="col-sm-9">${annunciodacomprare_attribute.id}</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Testo Annuncio</dt>
				<dd class="col-sm-9">${annunciodacomprare_attribute.testoAnnuncio}</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Data pubblicazione</dt>
				<dd class="col-sm-9">${annunciodacomprare_attribute.dataAnnuncio}</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Prezzo</dt>
				<dd class="col-sm-9">${annunciodacomprare_attribute.prezzo}</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Categoria</dt>
				<dd class="col-sm-9">
					<c:forEach items="${annunciodacomprare_attribute.categorie }" var="categoriaItem">
						<option value="${categoriaItem.id }"> ${categoriaItem.descrizione }</option>
					</c:forEach>
				</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Pubblicato da utente</dt>
				<dd class="col-sm-9">${annunciodacomprare_attribute.utente.nome}</dd>
			</dl>
<!-- 			<dl class="row"> -->
<!-- 				<dt class="col-sm-3 text-right">Utente</dt> -->
<%-- 				<dd class="col-sm-9">${AnnuncioSingoloAttributeName.utente.id}</dd> --%>
<!-- 			</dl> -->
		</div>
		<a href="${pageContext.request.contextPath}/ExecuteBuyAnnuncioServlet?idInput=${annunciodacomprare_attribute.id}" class="btn btn-outline-danger">Conferma Acquisto</a>
		<a href="${pageContext.request.contextPath}/ReturnHomeServlet" class="btn btn-outline-danger">Torna Indietro</a>
	</div>
</body>
</html>