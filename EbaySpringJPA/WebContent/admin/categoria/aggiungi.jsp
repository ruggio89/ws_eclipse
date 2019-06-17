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
<title>Inserisci Categoria</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/jqueryUI/jquery-ui.min.css" />
</head>
<body>

	<div class="container">

		<%@ include file="/header.jsp"%>
		

		<div class="page-header">
		<br>
			<h3>Inserisci Categoria</h3>
		</div>
		<br>
<%-- 		<div class="alert alert-danger alert-dismissible fade show ${messaggio_errore != null?'':'d-none'} " role="alert"> --%>
<%-- 			${messaggio_errore } --%>
<!-- 			 <button type="button" class="close" data-dismiss="alert" aria-label="Close"> -->
<!-- 			    <span aria-hidden="true">&times;</span> -->
<!-- 			  </button> -->
<!-- 		</div> -->
		<form class="form-horizontal" name="myForm" action="${pageContext.request.contextPath}/admin/ExecuteInsertCategoriaServlet"
			method="post" onsubmit="return validateForm()">
			<div class="form-group">
				<label class="control-label col-sm-2" for="descrizioneInputId">Descrizione:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="descrizioneInputId"
						name="descrizioneInput">
					<div id="messaggioDescrizione" style="color:Red;display:none;">Allarme! Inserisci Descrizione!</div>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="codiceInputId">Codice:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="codiceInputId"
						name="codiceInput">
					<div id="messaggioCodice" style="color:Red;display:none;">Allarme! Inserisci Codice!</div>
				</div>
			</div>
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
    var textDescrizione = document.forms["myForm"]["descrizioneInput"].value;
    var textCodice = document.forms["myForm"]["codiceInput"].value;
	
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
    return true;
}
</script>

</body>


</html>