<%@page import="it.prova.gestionemunicipiospringjpa.model.Municipio"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modifica Municipio</title>
</head>
<body>
<%if(request.getAttribute("messaggio_errore") != null){ %>
		<%=request.getAttribute("messaggio_errore") %>
	<% }else{ %>
		Inserire dati<br>
	<%} %>

	<%
		Municipio municipioDaModificare = (Municipio) request.getAttribute("municipiodamodificare_attribute");
	%>

	<div class="container">
	
	<%@ include file="../header.jsp" %>
      
    <div class="page-header">
	  <h3>Pagina di Modifica</h3>
	</div>

      	<form class="form-horizontal" action="ExecuteUpdateMunicipioServlet" method="get">
      		<div class="form-group">
      			<label class="control-label col-sm-2" for="descrizioneInputId">Descrizione:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="descrizioneInputId" name="descrizioneInput" value="<%=municipioDaModificare.getDescrizione() %>">
			 	</div>
  			</div>
  			<div class="form-group">
      			<label class="control-label col-sm-2" for="codiceInputId">Codice:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="codiceInputId" name="codiceInput" value="<%=municipioDaModificare.getCodice() %>">
			 	</div>
  			</div>
			<div class="form-group">
      			<label class="control-label col-sm-2" for="ubicazioneInputId">Ubicazione:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="ubicazioneInputId" name="ubicazioneInput" value="<%=municipioDaModificare.getUbicazione() %>">
			 	</div>
  			</div>
  			
  			<div class="form-group">        
		      <div class="col-sm-offset-2 col-sm-10">
		        <button type="submit" class="btn btn-outline-danger btn-md">Modifica</button>
		      </div>
		    </div>
		    <input class="form-control" type="hidden" id="idMunicipio" name="idInput" value="<%=municipioDaModificare.getId()%>" >
		</form>
		</div>
</body>
</html>