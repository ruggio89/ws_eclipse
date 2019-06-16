<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modifica Annuncio</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/jqueryUI/jquery-ui.min.css" />
<style>
.ui-autocomplete-loading {
	background: white url("../img/anim_16x16.gif") right center no-repeat;
}
</style>
</head>
<body>

	<div class="container">

		<%@ include file="../header.jsp"%>
		

		<div class="page-header">
		<br>
			<h3>Modifica Annuncio</h3>
		</div>
		<br>
<%-- 		<div class="alert alert-danger alert-dismissible fade show ${messaggio_errore != null?'':'d-none'} " role="alert"> --%>
<%-- 			${messaggio_errore } --%>
<!-- 			 <button type="button" class="close" data-dismiss="alert" aria-label="Close"> -->
<!-- 			    <span aria-hidden="true">&times;</span> -->
<!-- 			  </button> -->
<!-- 		</div> -->
		<form class="form-horizontal" name="myForm" action="ExecuteUpdateAnnuncioUtenteServlet"
			method="post" onsubmit="return validateForm()">
			<div class="form-group">
      			<label class="control-label col-sm-2" for="testoAnnuncioInputId">Testo Annuncio:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="testoAnnuncioInputId" name="testoAnnuncioInput" value="${annunciodamodificare_attribute.testoAnnuncio}">
					<div id="messaggioAnnuncio" style="color:Red;display:none">Allarme! Inserisci testo Annuncio!</div>
			 	</div>
  			</div>
  			<div class="form-group">
      			<label class="control-label col-sm-2" for="prezzoInputId">Prezzo:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="prezzoInputId" name="prezzoInput" value="${annunciodamodificare_attribute.prezzo}">
					<div id="messaggioPrezzo" style="color:Red;display:none;">Allarme! Inserisci prezzo!</div>
			 	</div>
  			</div>
  			<c:forEach items="${listaCategorieAttributeName}" var="categoriaItem">
				<div class="custom-control custom-checkbox">
					<input type="checkbox" class="custom-control-input" id="${categoriaItem.id}" name="categoriaId" value="${categoriaItem.id}"/>
					<label class="custom-control-label" for="${categoriaItem.id}">${categoriaItem.descrizione}</label><br>
				</div>
			</c:forEach>
			<div id="messaggioCategoria" style="color:Red;display:none">Allarme! Inserisci almeno una categoria!</div>
			<br>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-outline-danger btn-md">Effettua
						Modifica</button>
				</div>
			</div>
			<input class="form-control" type="hidden" id="idAnnuncio"
				name="idInput" value="${annunciodamodificare_attribute.id}">
			<input class="form-control" type="hidden" id="dataAnnuncioInputId"
				name="dataAnnuncioInput" value="${annunciodamodificare_attribute.dataAnnuncio}">
		</form>

	</div>
	<!-- /.container -->

<script type="text/javascript">
function validateForm() {
    var textTestoAnnuncio = document.forms["myForm"]["testoAnnuncioInput"].value;
    var textPrezzo = document.forms["myForm"]["prezzoInput"].value;
	var allCheckBoxes = document.querySelectorAll("[name='categoriaId']:checked");
	
	if(textTestoAnnuncio == "" || textTestoAnnuncio == null) {
	    document.getElementById("messaggioAnnuncio").style.display = "";
	    document.myForm.testoAnnuncioInput.focus();
	    return false;
	} 
	if(textPrezzo == "" || textPrezzo == null) {
	    document.getElementById("messaggioPrezzo").style.display = "";
	    document.myForm.prezzoInput.focus();
	    return false;
	}
	if(allCheckBoxes.length == 0){
		document.getElementById("messaggioCategoria").style.display="";
		return false;
	}

    return true;
}
</script>


</body>


</html>