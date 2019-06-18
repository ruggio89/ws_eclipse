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
<title>Inserisci Nuovo Annuncio</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/jqueryUI/jquery-ui.min.css" />
</head>
<body>

	<div class="container">

		<%@ include file="../header.jsp"%>
		

		<div class="page-header">
			<h3>Inserisci Annuncio</h3>
		</div>
		
		<div class="alert alert-danger alert-dismissible fade show ${messaggio_errore != null?'':'d-none'} " role="alert">
			${messaggio_errore }
			 <button type="button" class="close" data-dismiss="alert" aria-label="Close">
			    <span aria-hidden="true">&times;</span>
			  </button>
		</div>
		
		<form class="form-horizontal" name="myForm" action="ExecuteInsertAnnuncioUtenteServlet"
			method="post" onsubmit="return validateForm()">
			<div class="form-group">
      			<label class="control-label col-sm-2" for="testoAnnuncioInputId">Testo Annuncio:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="testoAnnuncioInputId" name="testoAnnuncioInput" >
					<div id="messaggioAnnuncio" style="color:Red;display:none">Allarme! Inserisci testo Annuncio!</div>
			 	</div>
  			</div>
  			<div class="form-group">
      			<label class="control-label col-sm-2" for="prezzoInputId">Prezzo:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="prezzoInputId" name="prezzoInput">
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
						Inserimento</button>
				</div>
			</div>
			
		</form>

	</div>
	<!-- /.container -->
	
<script type="text/javascript">
function validateForm() {
    var textDescrizione = document.getElementById("descrizioneInputId").value;
    var textCodice = document.getElementById("codiceInputId").value;
    var textUbicazione = document.getElementById("ubicazioneInputId").value;
	
	if(textDescrizione == "" || textDescrizione == null) {
	    document.getElementById("messaggioDescrizione").style.display = "";
	    document.myForm.descrizioneInput.focus();
	    return false;
	} 
	if(textCodice == "" || textCodice == null) {
	    document.getElementById("messaggioCodice").style.display = "";
	    document.myForm.codiceInput.focus();
	    return false;
	}
	if(textUbicazione == "" || textUbicazione == null) {
	    document.getElementById("messaggioUbicazione").style.display = "";
	    document.myForm.ubicazioneInput.focus();
	    return false;
	}

    return true;
}
</script>


</body>


</html>


