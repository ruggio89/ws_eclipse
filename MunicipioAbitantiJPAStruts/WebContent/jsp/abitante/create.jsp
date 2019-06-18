<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inserisci Abitante</title>
</head>
<body>

<div class="container">
	<%@ include file="../header.jsp" %>

	<div class="page-header">
			<h3>Inserisci Abitante</h3>
		</div>

	<form class="form-horizontal" name="myForm" action="${pageContext.request.contextPath }/abitante.do" method="post" onsubmit="return validateForm()">
		<div class="form-group">
				<label class="control-label col-sm-2" for="nomeInputId">Nome:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="nomeInputId"
						name="nome">
					<div id="messaggioNome" style="color:Red;display:none;">Allarme! Inserisci Nome!</div>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="cognomeInputId">Cognome:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="cognomeInputId"
						name="cognome">
				<div id="messaggioCognome" style="color:Red;display:none;">Allarme! Inserisci Cognome!</div>		
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="etaInputId">Eta:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="etaInputId"
						name="eta">
				<div id="messaggioEta" style="color:Red;display:none;">Allarme! Inserisci Età!</div>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="residenzaInputId">Residenza:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="residenzaInputId"
						name="residenza">
					<div id="messaggioResidenza" style="color:Red;display:none;">Allarme! Inserisci Residenza!</div>
				</div>
			</div>
			<c:forEach items="${municipiList}" var="municipioItem">
				<div class="custom-control custom-checkbox">
					<input type="checkbox" class="custom-control-input" id="${municipioItem.id}" name="municipioId" value="${municipioItem.id}"/>
					<label class="custom-control-label" for="${municipioItem.id}">${municipioItem.descrizione}</label><br>
				</div>
			</c:forEach>
			<div id="messaggioMunicipio" style="color:Red;display:none">Allarme! Inserisci un Municipio!</div>
			<br>
			
		<input type="hidden" name="codop" value="save"> 
		<input type="submit" class="btn btn-outline-danger btn-md" value="Inserisci">
	</form>
</div>

<script type="text/javascript">
function validateForm() {
    var textNome = document.getElementById("nomeInputId").value;
    var textCognome = document.getElementById("cognomeInputId").value;
    var textEta = document.getElementById("etaInputId").value;
    var textResidenza = document.getElementById("residenzaInputId").value;
    var allCheckBoxes = document.querySelectorAll("[name='municipioId']:checked");
	
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
	if(textEta <= 0 || textEta == null || isNaN(textEta)) {
	    document.getElementById("messaggioEta").style.display = "";
	    document.myForm.etaInput.focus();
	    return false;
	}
	if(textResidenza == "" || textResidenza == null) {
	    document.getElementById("messaggioResidenza").style.display = "";
	    document.myForm.residenzaInput.focus();
	    return false;
	}
	if(allCheckBoxes.length == 0){
		document.getElementById("messaggioMunicipio").style.display="";
		return false;
	}

    return true;
}
</script>

</body>
</html>
