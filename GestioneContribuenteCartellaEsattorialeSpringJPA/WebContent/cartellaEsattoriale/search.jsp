<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ricerca Cartelle Esattoriali</title>
</head>
<body>
<div class="container">

   <%@ include file="../header.jsp" %>
      
    <div class="page-header">
	  <h3>Ricerca Cartelle Esattoriali</h3>
	</div>

      	<form class="form-horizontal" action="ExecuteSearchCartellaEsattorialeServlet" method="post">
      		<div class="form-group">
      			<label class="control-label col-sm-2" for="denominazioneInputId">Denominazione:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="denominazioneInputId" name="denominazioneInput" >
			 	</div>
  			</div>
  			<div class="form-group">
      			<label class="control-label col-sm-2" for="descrizioneInputId">Descrizione:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="descrizioneInputId" name="descrizioneInput" >
			 	</div>
  			</div>
  			<div class="form-group">
      			<label class="control-label col-sm-2" for="importoInputId">Importo:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="importoInputId" name="importoInput" >
			 	</div>
  			</div>
  			
  			<div class="form-group">        
		      <div class="col-sm-offset-2 col-sm-10">
		        <button type="submit" class="btn btn-outline-danger btn-md">Effettua Ricerca</button>
		        <a href="PrepareInsertCartellaEsattorialeServlet" class="btn btn-outline-danger btn-md">Inserisci Nuovo Elemento</a>
		      </div>
		    </div>
		</form>
		
    </div><!-- /.container -->
</body>
</html>