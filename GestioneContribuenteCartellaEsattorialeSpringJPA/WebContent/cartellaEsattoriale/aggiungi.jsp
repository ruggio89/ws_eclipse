<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page import="it.prova.gestionecontribuentespringjpa.model.Contribuente"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inserisci Nuova Cartella Esattoriale</title>
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
			<h3>Inserisci Cartella Esattoriale</h3>
		</div>
		<div class="alert alert-danger alert-dismissible fade show ${messaggio_errore != null?'':'d-none'} " role="alert">
			${messaggio_errore }
			 <button type="button" class="close" data-dismiss="alert" aria-label="Close">
			    <span aria-hidden="true">&times;</span>
			  </button>
		</div>
		<form class="form-horizontal" action="ExecuteInsertCartellaEsattorialeServlet"
			method="post">
			<div class="form-group">
				<label class="control-label col-sm-2" for="denominazioneInputId">Denominazione:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="denominazioneInputId"
						name="denominazioneInput">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="descrizioneInputId">Descrizione:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="descrizioneInputId"
						name="descrizioneInput">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="importoInputId">Importo:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="importoInputId"
						name="importoInput">
				</div>
			</div>
			
			<div class="form-group">
				<label class="control-label col-sm-2" for="contribuenteInputId">Contribuente:</label>
				<select name="contribuenteId">
					<option value="-1"> ---Seleziona--- </option>
					<c:forEach items="${listaContribuentiAttributeName }" var="contribuenteItem">
						<option value="${contribuenteItem.id }"> ${contribuenteItem.codiceFiscale }</option> --%>
					
					</c:forEach>
<%-- 					<%List<Contribuente> listaContribuenti = (List<Contribuente>)request.getAttribute("listaContribuentiAttributeName"); --%>
<%--  					for(Contribuente contribuenteItem : listaContribuenti){ %> --%>
<%-- 						<option value="<%=contribuenteItem.getId() %>"> <%=contribuenteItem.getCodiceFiscale() %></option> --%>
<%-- 					<% }%> --%>
				
				</select>
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


