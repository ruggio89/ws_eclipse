<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Conferma Eliminazione</title>
</head>
<body>	

	<div class="container">
	
	<%@ include file="../header.jsp" %>

		<div class="page-header">
		<br>
			<h3>Dettagli Annuncio da Eliminare</h3>
		</div>
		<br>
		<div class="container-fluid">
			<dl class="row">
				<dt class="col-sm-3 text-right">Id</dt>
				<dd class="col-sm-9">${annuncioutentedaeliminare_attribute.id}</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Testo Annuncio</dt>
				<dd class="col-sm-9">${annuncioutentedaeliminare_attribute.testoAnnuncio}</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Data pubblicazione</dt>
				<dd class="col-sm-9">${annuncioutentedaeliminare_attribute.dataAnnuncio}</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Prezzo</dt>
				<dd class="col-sm-9">${annuncioutentedaeliminare_attribute.prezzo}</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Categoria</dt>
				<dd class="col-sm-9">
					<c:forEach items="${annuncioutentedaeliminare_attribute.categorie }" var="categoriaItem">
						<option value="${categoriaItem.id }"> ${categoriaItem.descrizione }</option>
					</c:forEach>
				</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Pubblicato da utente</dt>
				<dd class="col-sm-9">${annuncioutentedaeliminare_attribute.utente.nome}</dd>
			</dl>
<!-- 			<dl class="row"> -->
<!-- 				<dt class="col-sm-3 text-right">Utente</dt> -->
<%-- 				<dd class="col-sm-9">${AnnuncioSingoloAttributeName.utente.id}</dd> --%>
<!-- 			</dl> -->
		</div>
		<a href="${pageContext.request.contextPath}/utente/ExecuteDeleteAnnuncioUtenteServlet?idInput=${annuncioutentedaeliminare_attribute.id}" class="btn btn-outline-danger">Conferma Eliminazione</a>
	</div>
</body>
</html>