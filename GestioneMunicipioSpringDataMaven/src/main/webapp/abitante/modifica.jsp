<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modifica Abitante</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/jqueryUI/jquery-ui.min.css" />
<style>
.ui-autocomplete-loading {
	background: white url("img/anim_16x16.gif") right center no-repeat;
}
</style>
</head>
<body>

	<div class="container">

		<%@ include file="../header.jsp"%>
		

		<div class="page-header">
			<h3>Modifica Abitante</h3>
		</div>

		<form class="form-horizontal" name="myForm" action="${pageContext.request.contextPath}/ExecuteUpdateAbitanteServlet"
			method="get" onsubmit="return validateForm()">
			<div class="form-group">
				<label class="control-label col-sm-2" for="nomeInputId">Nome:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="nomeInputId"
						name="nomeInput" value="${abitantedamodificare_attribute.nome}">
					<div id="messaggioNome" style="color:Red;display:none;">Allarme! Inserisci Nome!</div>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="cognomeInputId">Cognome:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="cognomeInputId"
						name="cognomeInput" value="${abitantedamodificare_attribute.cognome}">
				<div id="messaggioCognome" style="color:Red;display:none;">Allarme! Inserisci Cognome!</div>		
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="etaInputId">Eta:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="etaInputId"
						name="etaInput" value="${abitantedamodificare_attribute.eta}">
				<div id="messaggioEta" style="color:Red;display:none;">Allarme! Inserisci Età!</div>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="residenzaInputId">Residenza:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="residenzaInputId"
						name="residenzaInput" value="${abitantedamodificare_attribute.residenza}">
					<div id="messaggioResidenza" style="color:Red;display:none;">Allarme! Inserisci Residenza!</div>
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2" for="municipioInputId">Municipio:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="municipioInputId"
						name="municipioInput" value="${abitantedamodificare_attribute.municipio.descrizione}">
					<input type="hidden" name="municipioId" id="municipioId">
					<div id="messaggioMunicipio" style="color:Red;display:none;">Allarme! Inserisci Municipio!</div>
				</div>
			</div>


			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-primary btn-md">Effettua
						Inserimento</button>
				</div>
			</div>
			
			<%-- FUNZIONE JQUERY UI CON AJAX PER AUTOCOMPLETE --%>
			<script>
				$( "#municipioInputId" ).autocomplete({
					 source: function(request, response) {
					        $.ajax({
					            url: "SearchMunicipioAjaxServlet",
					            datatype: "json",
					            data: {
					                term: request.term,   
					            },
					            success: function(data) {
					                response($.map(data, function(item) {
					                    return {
						                    label: item.label,
						                    value: item.value
					                    }
					                }))
					            }
					        })
					    },
					//quando seleziono la voce nel campo deve valorizzarsi la descrizione
				    focus: function(event, ui) {
				        $("#municipioInputId").val(ui.item.label)
				        return false
				    },
				    minLength: 2,
				    //quando seleziono la voce nel campo hidden deve valorizzarsi l'id
				    select: function( event, ui ) {
				    	$('#municipioId').val(ui.item.value);
				    	console.log($('#municipioId').val())
				        return false;
				    },
				});
			</script>
			
			<input class="form-control" type="hidden" id="idAbitante" name="idInput" value="${abitantedamodificare_attribute.id}" >
			
		</form>

	</div>
	<!-- /.container -->

<script type="text/javascript">
function validateForm() {
    var textNome = document.getElementById("nomeInputId").value;
    var textCognome = document.getElementById("cognomeInputId").value;
    var textEta = document.getElementById("etaInputId").value;
    var textResidenza = document.getElementById("residenzaInputId").value;
	var municipio = document.getElementById("municipioInputId").value;
	
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
	if(textEta <= 0 || textEta == null) {
	    document.getElementById("messaggioEta").style.display = "";
	    document.myForm.etaInput.focus();
	    return false;
	}
	if(textResidenza == "" || textResidenza == null) {
	    document.getElementById("messaggioResidenza").style.display = "";
	    document.myForm.residenzaInput.focus();
	    return false;
	}
	if(municipio == "" || municipio == null){
		document.getElementById("messaggioMunicipio").style.display="";
		document.myForm.municipioInput.focus();
		return false;
	}

    return true;
}
</script>

</body>


</html>