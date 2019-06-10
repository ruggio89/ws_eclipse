<%@page import="it.prova.gestionecontribuentespringjpa.model.Contribuente"%>
<%@page
	import="it.prova.gestionecontribuentespringjpa.model.CartellaEsattoriale"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modifica Cartella Esattoriale</title>
</head>
<body>

	<%if(request.getAttribute("messaggio_errore") != null){ %>
	<%=request.getAttribute("messaggio_errore") %>
	<% }else{ %>
	Inserire dati
	<br>
	<%} %>

	<%
		CartellaEsattoriale cartellaEsattorialeDaModificare = (CartellaEsattoriale) request.getAttribute("cartellaesattorialedamodificare_attribute");
	%>

	<div class="container">

		<%@ include file="../header.jsp"%>


		<div class="page-header">
			<h3>Modifica Cartella Esattoriale</h3>
		</div>

		<form class="form-horizontal" action="ExecuteUpdateCartellaEsattorialeServlet"
			method="post">
			<div class="form-group">
				<label class="control-label col-sm-2" for="denominazioneInputId">Denominazione:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="denominazioneInputId"
						name="denominazioneInput" value="<%=cartellaEsattorialeDaModificare.getDenominazione() %>">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="descrizioneInputId">Descrizione:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="descrizioneInputId"
						name="descrizioneInput" value="<%=cartellaEsattorialeDaModificare.getDescrizione() %>">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="importoInputId">Importo:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="importoInputId"
						name="importoInput" value="<%=cartellaEsattorialeDaModificare.getImporto() %>">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="contribuenteInputId">Contribuente:</label>
				<select name="contribuenteId">
					<option value="<%=cartellaEsattorialeDaModificare.getContribuente().getId()%>">
						<%=cartellaEsattorialeDaModificare.getContribuente().getCodiceFiscale() %></option>
					<%List<Contribuente> listaContribuenti = (List<Contribuente>)request.getAttribute("listaContribuentiAttributeName");
					for(Contribuente contribuenteItem : listaContribuenti){
						if(contribuenteItem.getId() != cartellaEsattorialeDaModificare.getContribuente().getId()){
						%>
					<option value="<%=contribuenteItem.getId() %>">
						<%=contribuenteItem.getCodiceFiscale() %></option>
					<% }}%>

				</select>
			</div>


			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-outline-danger btn-md">Modifica</button>
				</div>
			</div>
			<input class="form-control" type="hidden" id="idCartellaEsattoriale"
				name="idInput" value="<%=cartellaEsattorialeDaModificare.getId()%>">


		</form>

	</div>
	<!-- /.container -->
</body>
</html>