<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
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
		<br>
			<h3>Modifica Utente</h3>
		</div>
		<br>
		<div class="alert alert-danger alert-dismissible fade show ${messaggio_errore != null?'':'d-none'} " role="alert">
			${messaggio_errore }
			 <button type="button" class="close" data-dismiss="alert" aria-label="Close">
			    <span aria-hidden="true">&times;</span>
			  </button>
		</div>
		<form class="form-horizontal" name="myForm" action="${pageContext.request.contextPath}/admin/ExecuteUpdateUtenteServlet"
			method="post" onsubmit="return validateForm()">
			<div class="form-group">
				<label class="control-label col-sm-2" for="nomeInputId">Nome:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="nomeInputId"
						name="nomeInput" value="${utentedamodificare_attribute.nome}">
					<div id="messaggioNome" style="color:Red;display:none;">Allarme! Inserisci Nome!</div>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="cognomeInputId">Cognome:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="cognomeInputId"
						name="cognomeInput" value="${utentedamodificare_attribute.cognome}">
					<div id="messaggioCognome" style="color:Red;display:none;">Allarme! Inserisci Cognome!</div>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="usernameInputId">Username:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="usernameInputId"
						name="usernameInput" value="${utentedamodificare_attribute.username}">
					<div id="messaggioUsername" style="color:Red;display:none;">Allarme! Inserisci Username!</div>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="passwordInputId">Password:</label>
				<div class="col-sm-4">
					<input class="form-control" type="password" id="passwordInputId"
						name="passwordInput" value="${utentedamodificare_attribute.password}">
					<div id="messaggioPassword" style="color:Red;display:none;">Allarme! Inserisci Password!</div>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="creditoInputId">Credito Residuo:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="creditoInputId"
						name="creditoInput" value="${utentedamodificare_attribute.creditoResiduo}">
					<div id="messaggioCredito" style="color:Red;display:none;">Allarme! Inserisci Credito!</div>
				</div>
			</div>
			<c:forEach items="${listaRuoliAttributeName}" var="ruoloItem">
				<div class="custom-control custom-checkbox">
					<input type="checkbox" class="custom-control-input" id="${ruoloItem.id}" name="ruoliId" value="${ruoloItem.id}"/>
					<label class="custom-control-label" for="${ruoloItem.id}">${ruoloItem.descrizione}</label><br>
				</div>
			</c:forEach>
			<div id="messaggioRuolo" style="color:Red;display:none;">Allarme! Inserisci un Ruolo!</div>
			
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
	
<script type="text/javascript">
function validateForm() {
    var textNome = document.forms["myForm"]["nomeInput"].value;
    var textCognome = document.forms["myForm"]["cognomeInput"].value;
    var textUsername = document.forms["myForm"]["usernameInput"].value;
    var textPassword = document.forms["myForm"]["passwordInput"].value;
    var textCredito = document.forms["myForm"]["creditoInput"].value;
	var allCheckBoxes = document.querySelectorAll("[name='ruoliId']:checked");
	
	if(textNome == "" || textNome == null) {
	    document.getElementById("messaggioNome").style.display = "";
	    document.myForm.nomeInput.focus();
	    return false;
	} 
	if(textCognome == "" || textCognome == null) {
	    document.getElementById("messaggioCognome").style.display = "";
	    document.myForm.cognomeInput.focus();
	    return false;
	}
	if(textUsername == "" || textUsername == null) {
	    document.getElementById("messaggioUsername").style.display = "";
	    document.myForm.usernameInput.focus();
	    return false;
	}
	if(textPassword == "" || textPassword == null) {
	    document.getElementById("messaggioPassword").style.display = "";
	    document.myForm.passwordInput.focus();
	    return false;
	}
	if(textCredito == "" || textCredito == null) {
	    document.getElementById("messaggioCredito").style.display = "";
	    document.myForm.creditoInput.focus();
	    return false;
	}
	if(allCheckBoxes.length == 0){
		document.getElementById("messaggioRuolo").style.display="";
		return false;
	}

    return true;
}
</script>
	
</body>
</html>