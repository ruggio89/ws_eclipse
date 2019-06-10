<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ricerca Abitanti</title>
</head>
<body>
<div class="container">

   <%@ include file="../header.jsp" %>
      
    <div class="page-header">
	  <h3>Pagina di Ricerca Abitanti</h3>
	</div>

      	<form class="form-horizontal" action="ExecuteSearchAbitanteServlet" method="post">
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
      			<label class="control-label col-sm-2" for="etaInputId">Età:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="etaInputId" name="etaInput" >
			 	</div>
  			</div>
  			<div class="form-group">
      			<label class="control-label col-sm-2" for="residenzaInputId">Residenza:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="residenzaInputId" name="residenzaInput" >
			 	</div>
  			</div>
  			
  			<div class="form-group">        
		      <div class="col-sm-offset-2 col-sm-10">
		        <button type="submit" class="btn btn-outline-danger btn-md">Effettua Ricerca</button>
		        <a href="PrepareInsertAbitanteServlet" class="btn btn-outline-danger btn-md">Inserisci Nuovo Elemento</a>
		      </div>
		    </div>
		</form>
		
    </div><!-- /.container -->
</body>
</html>