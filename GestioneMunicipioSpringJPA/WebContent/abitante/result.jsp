<%@page import="it.prova.gestionemunicipiospringjpa.model.Abitante"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Risultati ricerca Abitanti</title>
</head>
<body>
<div class="container">
	
	<%@ include file="../header.jsp" %>
  	
  	<div class="page-header">
	  <h3>Pagina dei Risultati</h3>
	</div>
  	
	<table class="table table-hover">
		<thead>
			<tr>
				<th>Nome</th>
				<th>Cognome</th>
				<th>Età</th>
				<th>Action</th>
			</tr>
		</thead>
		<% List<Abitante> listaAbitanti = (List<Abitante>)request.getAttribute("listaAbitantiAttributeName"); 
			for(Abitante abitanteItem: listaAbitanti){ %>
			<tr>
				<td><%=abitanteItem.getNome() %></td>
				<td><%=abitanteItem.getCognome() %></td>
				<td><%=abitanteItem.getEta() %></td>
				<td>
					<a href="VisualizzaDettaglioAbitanteServlet?idAbitante=<%=abitanteItem.getId() %>" class="btn btn-outline-danger">Dettaglio</a>
					<a href="PrepareUpdateAbitanteServlet?idAbitante=<%=abitanteItem.getId() %>" class="btn btn-outline-danger">Modifica</a>
					<a href="PrepareDeleteAbitanteServlet?idAbitante=<%=abitanteItem.getId() %>" class="btn btn-outline-danger">Elimina</a>
				</td>
			</tr>
				
		<%	}
		
		%>
	
	</table>
	<a href="PrepareInsertAbitanteServlet" class="btn btn-outline-danger btn-md">Inserisci Nuovo Elemento</a>

	</div>
</body>
</html>