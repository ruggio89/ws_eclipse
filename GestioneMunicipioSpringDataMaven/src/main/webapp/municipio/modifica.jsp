<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modifica Municipio</title>
</head>
<body>

	<div class="container">
	
	<%@ include file="../header.jsp" %>
      
    <div class="page-header">
	  <h3>Pagina di Modifica</h3>
	</div>

      	<form class="form-horizontal" name="myForm" action="${pageContext.request.contextPath}/ExecuteUpdateMunicipioServlet" method="post" onsubmit="return validateForm()">
      		<div class="form-group" onsubmit="return validateForm()">
      			<label class="control-label col-sm-2" for="descrizioneInputId">Descrizione:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="descrizioneInputId" name="descrizioneInput" value="${municipiodamodificare_attribute.descrizione}">
					<div id="messaggioDescrizione" style="color:Red;display:none;">Allarme! Inserisci Descrizione!</div>
			 	</div>
  			</div>
  			<div class="form-group">
      			<label class="control-label col-sm-2" for="codiceInputId">Codice:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="codiceInputId" name="codiceInput" value="${municipiodamodificare_attribute.codice}">
					<div id="messaggioCodice" style="color:Red;display:none;">Allarme! Inserisci Codice!</div>
			 	</div>
  			</div>
			<div class="form-group">
      			<label class="control-label col-sm-2" for="ubicazioneInputId">Ubicazione:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="ubicazioneInputId" name="ubicazioneInput" value="${municipiodamodificare_attribute.ubicazione}">
					<div id="messaggioUbicazione" style="color:Red;display:none;">Allarme! Inserisci Ubicazione!</div>
			 	</div>
  			</div>
  			
  			<div class="form-group">        
		      <div class="col-sm-offset-2 col-sm-10">
		        <button type="submit" class="btn btn-outline-danger btn-md">Modifica</button>
		        <a href="${pageContext.request.contextPath}/PrepareSearchMunicipioServlet" class="btn btn-outline-danger btn-md">Torna Indietro</a>
		      </div>
		    </div>
		    
		    <input class="form-control" type="hidden" id="idMunicipio" name="idInput" value="${municipiodamodificare_attribute.id}" >
		</form>
		</div>
		
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