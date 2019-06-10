<%@page import="java.util.ArrayList"%>
<%@page import="it.prova.gestionemunicipiospringjpa.model.Municipio"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inserisci Nuovo Abitante</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/jqueryUI/jquery-ui.min.css" />
<style>
.ui-autocomplete-loading {
	background: white url("../img/anim_16x16.gif") right center no-repeat;
}
</style>
</head>
<body>
<%if(request.getAttribute("messaggio_errore") != null){ %>
		<%=request.getAttribute("messaggio_errore") %>
	<% }else{ %>
		Inserire dati<br>
	<%} %>

	<div class="container">

		<%@ include file="../header.jsp"%>
		

		<div class="page-header">
			<h3>Pagina di Inserimento Abitante</h3>
		</div>

		<form class="form-horizontal" action="ExecuteInsertAbitanteServlet"
			method="post">
			<div class="form-group">
				<label class="control-label col-sm-2" for="nomeInputId">Nome:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="nomeInputId"
						name="nomeInput">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="cognomeInputId">Cognome:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="cognomeInputId"
						name="cognomeInput">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="etaInputId">Eta:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="etaInputId"
						name="etaInput">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="residenzaInputId">Residenza:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="residenzaInputId"
						name="residenzaInput">
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2" for="municipioId">Municipio:</label>
				<select name="municipioId">
					<option value="-1"> ---Seleziona--- </option>
					<%List<Municipio> listaMunicipi = (List<Municipio>)request.getAttribute("listaMunicipiAttributeName");
					for(Municipio m : listaMunicipi){ %>
						<option value="<%=m.getId() %>"> <%=m.getDescrizione() %></option>
					<% }%>
				
				</select>
<!-- 				<div class="col-sm-4"> -->
<!-- 					<input class="form-control" type="text" id="municipioInputId" -->
<!-- 						name="municipioInput"> -->
<!-- 					<input type="hidden" name="municipioId" id="municipioId"> -->
<!-- 				</div> -->
			</div>


			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-outline-danger btn-md">Effettua
						Inserimento</button>
				</div>
			</div>
			
			<%-- FUNZIONE JQUERY UI CON AJAX PER AUTOCOMPLETE --%>
<!-- 			<script> -->
<!-- 				$( "#municipioInputId" ).autocomplete({ -->
<!-- 					 source: function(request, response) { -->
<!-- 					        $.ajax({ -->
<!-- 					            url: "../SearchMunicipioAjaxServlet", -->
<!-- 					            datatype: "json", -->
<!-- 					            data: { -->
<!-- 					                term: request.term,    -->
<!-- 					            }, -->
<!-- 					            success: function(data) { -->
<!-- 					                response($.map(data, function(item) { -->
<!-- 					                    return { -->
<!-- 						                    label: item.label, -->
<!-- 						                    value: item.value -->
<!-- 					                    } -->
<!-- 					                })) -->
<!-- 					            } -->
<!-- 					        }) -->
<!-- 					    }, -->
<!-- 					//quando seleziono la voce nel campo deve valorizzarsi la descrizione -->
<!-- 				    focus: function(event, ui) { -->
<!-- 				        $("#municipioInputId").val(ui.item.label) -->
<!-- 				        return false -->
<!-- 				    }, -->
<!-- 				    minLength: 2, -->
<!-- 				    //quando seleziono la voce nel campo hidden deve valorizzarsi l'id -->
<!-- 				    select: function( event, ui ) { -->
<!-- 				    	$('#municipioId').val(ui.item.value); -->
<!-- 				    	console.log($('#municipioId').val()) -->
<!-- 				        return false; -->
<!-- 				    }, -->
<!-- 				}); -->
<!-- 			</script> -->
			
			
		</form>

	</div>
	<!-- /.container -->



</body>


</html>