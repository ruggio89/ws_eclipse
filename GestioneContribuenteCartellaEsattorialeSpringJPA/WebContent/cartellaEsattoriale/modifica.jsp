<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page import="it.prova.gestionecontribuentespringjpa.model.Contribuente"%>
<%@page
	import="it.prova.gestionecontribuentespringjpa.model.CartellaEsattoriale"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modifica Cartella Esattoriale</title>
</head>
<body>

	<div class="container">

		<%@ include file="../header.jsp"%>


		<div class="page-header">
			<h3>Modifica Cartella Esattoriale</h3>
		</div>
		<div class="alert alert-danger alert-dismissible fade show ${messaggio_errore != null?'':'d-none'} " role="alert">
			${messaggio_errore }
			 <button type="button" class="close" data-dismiss="alert" aria-label="Close">
			    <span aria-hidden="true">&times;</span>
			  </button>
		</div>
		<form class="form-horizontal" action="ExecuteUpdateCartellaEsattorialeServlet"
			method="post">
			<div class="form-group">
				<label class="control-label col-sm-2" for="denominazioneInputId">Denominazione:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="denominazioneInputId"
						name="denominazioneInput" value="${cartellaesattorialedamodificare_attribute.denominazione}">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="descrizioneInputId">Descrizione:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="descrizioneInputId"
						name="descrizioneInput" value="${cartellaesattorialedamodificare_attribute.descrizione}">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="importoInputId">Importo:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="importoInputId"
						name="importoInput" value="${cartellaesattorialedamodificare_attribute.importo}">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="contribuenteInputId">Contribuente:</label>
				<select name="contribuenteId">
					<option value="-1">---Seleziona CF contribuente---</option>
					<c:forEach items="${listaContribuentiAttributeName}" var="item">
						<option value="${item.id}">
						${item.codiceFiscale}</option>
					</c:forEach>
<%-- 					<%List<Contribuente> listaContribuenti = (List<Contribuente>)request.getAttribute("listaContribuentiAttributeName"); --%>
<!-- // 					for(Contribuente contribuenteItem : listaContribuenti){ -->
<!-- // 						if(contribuenteItem.getId() != cartellaEsattorialeDaModificare.getContribuente().getId()){ -->
<%-- 						%> --%>
					
<%-- 					<% }}%> --%>

				</select>
			</div>


			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-outline-danger btn-md">Modifica</button>
				</div>
			</div>
			<input class="form-control" type="hidden" id="idCartellaEsattoriale"
				name="idInput" value="${cartellaesattorialedamodificare_attribute.id}">


		</form>

	</div>
	<!-- /.container -->
</body>
</html>