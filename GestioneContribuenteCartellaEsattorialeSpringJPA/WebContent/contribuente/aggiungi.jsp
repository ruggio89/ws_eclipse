<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Aggiungi Contribuente</title>
</head>
<body>
<%if(request.getAttribute("messaggio_errore") != null){ %>
		<%=request.getAttribute("messaggio_errore") %>
	<% }else{ %>
		Inserire dati<br>
	<%} %>
	
	
	
	<div class="container">
	
	<%@ include file="../header.jsp" %>
      
    <div class="page-header">
	  <h3>Aggiungi Contribuente</h3>
	</div>

      	<form class="form-horizontal" action="ExecuteInsertContribuenteServlet" method="post">
      		<div class="form-group">
      			<label class="control-label col-sm-2" for="nomeInputId">Nome:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="nomeInputId" name="nomeInput" >
			 	</div>
  			</div>
  			<div class="form-group">
      			<label class="control-label col-sm-2" for="cognomeInputId">Cognome:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="cognomeInputId" name="cognomeInput" >
			 	</div>
  			</div>
			<div class="form-group">
      			<label class="control-label col-sm-2" for="codiceFiscaleInputId">Codice Fiscale:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="codiceFiscaleInputId" name="codiceFiscaleInput" >
			 	</div>
  			</div>
  			<div class="form-group">
      			<label class="control-label col-sm-2" for="indirizzoInputId">Indirizzo:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="indirizzoInputId" name="indirizzoInput" >
			 	</div>
  			</div>
  			
  			<div class="form-group">        
		      <div class="col-sm-offset-2 col-sm-10">
		        <button type="submit" class="btn btn-outline-danger btn-md">Inserisci</button>
		      </div>
		    </div>
		</form>
		
	</div>
</body>
</html>