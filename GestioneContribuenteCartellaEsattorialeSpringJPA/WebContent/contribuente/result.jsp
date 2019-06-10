<%@page import="it.prova.gestionecontribuentespringjpa.model.Contribuente"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Risultati ricerca Contribuenti</title>
</head>
<body>

<div class="container">
	
	<%@ include file="../header.jsp" %>
  	
  	<div class="page-header">
	  <h3>Risultati Ricerca Contribuenti</h3>
	</div>
  	
	<table class="table table-hover">
		<thead>
			<tr>
				<th>Nome</th>
				<th>Cognome</th>
				<th>Codice Fiscale</th>
				<th>Action</th>
			</tr>
		</thead>
		<% List<Contribuente> listaContribuenti = (List<Contribuente>)request.getAttribute("listaContribuentiAttributeName"); 
			for(Contribuente contribuenteItem: listaContribuenti){ %>
			<tr>
				<td><%=contribuenteItem.getNome() %></td>
				<td><%=contribuenteItem.getCognome() %></td>
				<td><%=contribuenteItem.getCodiceFiscale() %></td>
				<td>
					<a href="VisualizzaDettaglioContribuenteServlet?idContribuente=<%=contribuenteItem.getId() %>" class="btn btn-outline-danger">Dettaglio</a>
					<a href="PrepareUpdateContribuenteServlet?idContribuente=<%=contribuenteItem.getId() %>" class="btn btn-outline-danger">Modifica</a>
					<a href="PrepareDeleteContribuenteServlet?idContribuente=<%=contribuenteItem.getId() %>" class="btn btn-outline-danger">Elimina</a>
				</td>
			</tr>
				
		<%	}
		
		%>
	
	</table>
	<a href="PrepareInsertContribuenteServlet" class="btn btn-outline-danger btn-md">Inserisci Nuovo Elemento</a>

	</div>

</body>
</html>