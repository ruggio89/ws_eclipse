<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inserisci Municipio</title>
</head>
<body>

<div class="container">
	<%@ include file="../header.jsp" %>

	<div class="page-header">
			<h3>Inserisci Municipio</h3>
		</div>

	<form class="form-horizontal" name="myForm" action="${pageContext.request.contextPath }/municipio.do" method="post" onsubmit="return validateForm()">
		<div class="form-group">
			<label class="control-label col-sm-2" for="descrizioneInputId">Descrizione:</label>
			<div class="col-sm-4">
				<input class="form-control" type="text" id="descrizioneInputId" name="descrizione" value="${MunicipioForm.descrizione }">
				<div id="messaggioDescrizione" style="color:Red;display:none">Allarme! Inserisci descrizione!</div>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="codiceInputId">Codice:</label>
			<div class="col-sm-4">
				<input class="form-control" type="text" id="codiceInputId" name="codice" value="${MunicipioForm.codice }">
				<div id="messaggioCodice" style="color:Red;display:none">Allarme! Inserisci codice!</div>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="ubicazioneInputId">Ubicazione:</label>
			<div class="col-sm-4">
				<input class="form-control" type="text" id="ubicazioneInputId" name="ubicazione" value="${MunicipioForm.ubicazione }">
				<div id="messaggioUbicazione" style="color:Red;display:none">Allarme! Inserisci ubicazione!</div>
			</div>
		</div>
		<input type="hidden" name="codop" value="save"> 
		<input type="submit" class="btn btn-outline-danger btn-md" value="Inserisci">
	</form>
</div>

<script type="text/javascript">
function validateForm() {
    var textDescrizione = document.getElementById("descrizioneInputId").value;
    var textCodice = document.getElementById("codiceInputId").value;
    var textUbicazione = document.getElementById("ubicazioneInputId").value;
	
	if(textDescrizione == "" || textDescrizione == null) {
	    document.getElementById("messaggioDescrizione").style.display = "";
	    document.myForm.descrizione.focus();
	    return false;
	} 
	if(textCodice == "" || textCodice == null) {
	    document.getElementById("messaggioCodice").style.display = "";
	    document.myForm.codice.focus();
	    return false;
	}
	if(textUbicazione == "" || textUbicazione == null) {
	    document.getElementById("messaggioUbicazione").style.display = "";
	    document.myForm.ubicazione.focus();
	    return false;
	}

    return true;
}
</script>

</body>
</html>
