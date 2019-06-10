<%@page import="it.prova.model.Persona"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modifica Persona</title>
</head>
<body>
<%if(request.getAttribute("messaggio_errore") != null){ %>
		<%=request.getAttribute("messaggio_errore") %>
	<% }else{ %>
		Inserire dati<br>
	<%} %>

	<%
		Persona personaDaModificare = (Persona) request.getAttribute("personadamodificare_attribute");
	%>

	<div class="container">

	   <%@ include file="header.jsp" %>
	      
	    <div class="page-header">
		  <h3>Modifica i dati di Persona</h3>
		</div>

      	<form class="form-horizontal" action="ExecuteModificaPersonaServlet" method="get">
      		<div class="form-group">
      			<label class="control-label col-sm-2" for="nomeInputId">Nome: </label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="nomeInputId" name="nomeInput" value="<%=personaDaModificare.getNome()%>" >
			 	</div>
  			</div>
  			<div class="form-group">
      			<label class="control-label col-sm-2" for="cognomeInputId">Cognome: </label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="cognomeInputId" name="cognomeInput" value="<%=personaDaModificare.getCognome()%>" >
			 	</div>
  			</div>
  			<div class="form-group">
      			<label class="control-label col-sm-2" for="etaInputId">Eta: </label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="etaInputId" name="etaInput" value="<%=personaDaModificare.getEta()%>" > 
			 	</div>
  			</div>
			<div class="form-group">
      			<label class="control-label col-sm-2" for="cfInputId">CF: </label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="cfInputId" name="cfInput" value="<%=personaDaModificare.getCf()%>" > 
			 	</div>
  			</div>
			<div class="form-group">
      			<label class="control-label col-sm-2" for="indirizzoInputId">Indirizzo: </label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="indirizzoInputId" name="indirizzoInput" value="<%=personaDaModificare.getIndirizzo()%>">
			 	</div>
  			</div>
  			
  			<div class="form-group">        
		      <div class="col-sm-offset-2 col-sm-10">
		        <button type="submit" class="btn btn-primary btn-md">Modifica</button>
		      </div>
		    </div>
		    <input class="form-control" type="hidden" id="idPersona" name="idInput" value="<%=personaDaModificare.getId()%>" >
		</form>

    </div><!-- /.container -->
</body>
</html>