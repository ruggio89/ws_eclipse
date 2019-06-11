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
<title>Modifica Utente</title>
</head>
<body>

	<div class="container">

		<%@ include file="../header.jsp"%>


		<div class="page-header">
			<h3>Modifica Utente</h3>
		</div>
		<div class="alert alert-danger alert-dismissible fade show ${messaggio_errore != null?'':'d-none'} " role="alert">
			${messaggio_errore }
			 <button type="button" class="close" data-dismiss="alert" aria-label="Close">
			    <span aria-hidden="true">&times;</span>
			  </button>
		</div>
		<form class="form-horizontal" action="${pageContext.request.contextPath}/admin/ExecuteUpdateUtenteServlet"
			method="post">
			<div class="form-group">
				<label class="control-label col-sm-2" for="nomeInputId">Nome:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="nomeInputId"
						name="nomeInput" value="${utentedamodificare_attribute.nome}">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="cognomeInputId">Cognome:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="cognomeInputId"
						name="cognomeInput" value="${utentedamodificare_attribute.cognome}">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="usernameInputId">Username:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="usernameInputId"
						name="usernameInput" value="${utentedamodificare_attribute.username}">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="passwordInputId">Password:</label>
				<div class="col-sm-4">
					<input class="form-control" type="password" id="passwordInputId"
						name="passwordInput" value="${utentedamodificare_attribute.password}">
				</div>
			</div>
			<c:forEach items="${listaRuoliAttributeName}" var="ruoloItem">
				<label class="control-label col-sm-2" for="ruoloInputId">Ruolo:</label>
				<input type="checkbox" name="ruoliId" value="${ruoloItem.id}"/>${ruoloItem.descrizione}<br>
			</c:forEach>
			
<!-- 			<div class="form-group"> -->
<!-- 				<label class="control-label col-sm-2" for="contribuenteInputId">Contribuente:</label> -->
<!-- 				<select name="contribuenteId"> -->
<!-- 					<option value="-1">---Seleziona CF contribuente---</option> -->
<%-- 					<c:forEach items="${listaContribuentiAttributeName}" var="item"> --%>
<%-- 						<option value="${item.id}"> --%>
<%-- 						${item.codiceFiscale}</option> --%>
<%-- 					</c:forEach> --%>
<%-- 					<%List<Contribuente> listaContribuenti = (List<Contribuente>)request.getAttribute("listaContribuentiAttributeName"); --%>
<!-- // 					for(Contribuente contribuenteItem : listaContribuenti){ -->
<!-- // 						if(contribuenteItem.getId() != cartellaEsattorialeDaModificare.getContribuente().getId()){ -->
<%-- 						%> --%>
					
<%-- 					<% }}%> --%>

<!-- 				</select> -->
<!-- 			</div> -->


			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-outline-danger btn-md">Modifica</button>
				</div>
			</div>
			<input class="form-control" type="hidden" id="idUtente"
				name="idInput" value="${utentedamodificare_attribute.id}">


		</form>

	</div>
	<!-- /.container -->
</body>
</html>