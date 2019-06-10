<%@page import="it.prova.gestionemunicipiospringjpa.model.Municipio"%>
<%@page import="java.util.List"%>
<%@page import="it.prova.gestionemunicipiospringjpa.model.Abitante"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modifica Abitante</title>
</head>
<body>

<%if(request.getAttribute("messaggio_errore") != null){ %>
		<%=request.getAttribute("messaggio_errore") %>
	<% }else{ %>
		Inserire dati<br>
	<%} %>

	<%
		Abitante abitanteDaModificare = (Abitante) request.getAttribute("abitantedamodificare_attribute");
	%>
	
<div class="container">

		<%@ include file="../header.jsp"%>
		

		<div class="page-header">
			<h3>Pagina di Modifica Abitante</h3>
		</div>

		<form class="form-horizontal" action="ExecuteUpdateAbitanteServlet"
			method="get">
			<div class="form-group">
				<label class="control-label col-sm-2" for="nomeInputId">Nome:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="nomeInputId"
						name="nomeInput" value="<%=abitanteDaModificare.getNome() %>">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="cognomeInputId">Cognome:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="cognomeInputId"
						name="cognomeInput" value="<%=abitanteDaModificare.getCognome() %>">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="etaInputId">Eta:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="etaInputId"
						name="etaInput" value="<%=abitanteDaModificare.getEta() %>">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="residenzaInputId">Residenza:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="residenzaInputId"
						name="residenzaInput" value="<%=abitanteDaModificare.getResidenza() %>">
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2" for="municipioId">Municipio:</label>
				<select name="municipioId">
					<option value="<%=abitanteDaModificare.getMunicipio().getId()%>"> <%=abitanteDaModificare.getMunicipio().getDescrizione() %></option>
					<%List<Municipio> listaMunicipi = (List<Municipio>)request.getAttribute("listaMunicipiAttributeName");
					for(Municipio m : listaMunicipi){
						if(m.getId() != abitanteDaModificare.getMunicipio().getId()){
							
						
						%>
						<option value="<%=m.getId() %>"> <%=m.getDescrizione() %></option>
					<% }}%>
				
				</select>
<!-- 				<div class="col-sm-4"> -->
<!-- 					<input class="form-control" type="text" id="municipioInputId" -->
<!-- 						name="municipioInput"> -->
<!-- 					<input type="hidden" name="municipioId" id="municipioId"> -->
<!-- 				</div> -->
			</div>


			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-outline-danger btn-md">Modifica</button>
				</div>
			</div>
			<input class="form-control" type="hidden" id="Abitante" name="idInput" value="<%=abitanteDaModificare.getId()%>" >
			
			
		</form>

	</div>
	<!-- /.container -->
</body>
</html>
