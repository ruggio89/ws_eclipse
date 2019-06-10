<%@page import="java.util.List"%>
<%@page import="it.helloabitante.model.Abitante"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pagina dei risultati</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
	<h2>Abitanti</h2>
	<p>Ecco una lista aggiornata di abitanti</p> 
	<table class="table table-hover">
		<thead>
			<tr>
				<td>Colonna Nome</td>
				<td>Colonna Cognome</td>
				<td>Azione</td>
			</tr>
		</thead>
		
		<%
					List<Abitante> listaDaServlet = (List<Abitante>)request.getAttribute("listAbitantiAttributeName");
							for(Abitante abitanteItem : listaDaServlet){
				%>
				<tr>
					<td><%=abitanteItem.getNome() %></td>
					<td><%=abitanteItem.getCognome() %></td>
					<td><a href="VisualizzaDettaglioServlet?idDaInviareComeParametro=<%=abitanteItem.getIdAbitante() %>">Dettaglio</a></td>
				</tr>
		<%	}%>
		 
	
	
	</table>
	<a href="PassaggioServlet">Aggiungi nuovo</a>
</div>
</body>
</html>