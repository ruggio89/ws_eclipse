<%@page import="it.prova.model.Vino"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style type="text/css">
.alabaster{background-color:#F3EEE4}
</style>
<title>Modifica Persona</title>
</head>
<body class="alabaster">
<%if(request.getAttribute("messaggio_errore") != null){ %>
		<%=request.getAttribute("messaggio_errore") %>
	<% }else{ %>
		Inserire dati<br>
	<%} %>

	<%
		Vino vinoDaModificare = (Vino) request.getAttribute("vinodamodificare_attribute");
	%>
	
	

	<div class="container">
	
	<%@ include file="header.jsp" %>
      
    <div class="page-header">
	  <h3>Pagina di Inserimento</h3>
	</div>

      	<form class="form-horizontal" action="ExecuteModificaVinoServlet" method="get">
      		<div class="form-group">
      			<label class="control-label col-sm-2" for="nomeInputId">Nome:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="nomeInputId" name="nomeInput" value="<%=vinoDaModificare.getNome() %>">
			 	</div>
  			</div>
  			<div class="form-group">
      			<label class="control-label col-sm-2" for="cantinaInputId">Cantina:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="cantinaInputId" name="cantinaInput" value="<%=vinoDaModificare.getCantina() %>">
			 	</div>
  			</div>
  			<div class="form-group">
      			<label class="control-label col-sm-2" for="uvaInputId">Uva:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="uvaInputId" name="uvaInput" value="<%=vinoDaModificare.getUva() %>">
			 	</div>
  			</div>
			<div class="form-group">
      			<label class="control-label col-sm-2" for="localitaInputId">Località:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="localitaInputId" name="localitaInput" value="<%=vinoDaModificare.getLocalita() %>">
			 	</div>
  			</div>
			<div class="form-group">
      			<label class="control-label col-sm-2" for="annataInputId">Annata:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="annataInputId" name="annataInput" value="<%=vinoDaModificare.getAnnata() %>">
			 	</div>
  			</div>
  			
  			<div class="form-group">        
		      <div class="col-sm-offset-2 col-sm-10">
		        <button type="submit" class="btn btn-danger">Modifica</button>
		      </div>
		    </div>
		    <input class="form-control" type="hidden" id="idVino" name="idInput" value="<%=vinoDaModificare.getId()%>" >
		</form>

    </div><!-- /.container -->
</body>
</html>