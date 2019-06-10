<%@page import="java.util.List"%>
<%@page import="it.prova.gestionemunicipiospringjpa.model.Municipio"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Risultati ricerca Municipi</title>
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
				<th>Descrizione</th>
				<th>Codice</th>
				<th>Action</th>
			</tr>
		</thead>
		<% List<Municipio> listaMunicipi = (List<Municipio>)request.getAttribute("listaMunicipiAttributeName"); 
			for(Municipio municipioItem: listaMunicipi){ %>
			<tr>
				<td><%=municipioItem.getDescrizione() %></td>
				<td><%=municipioItem.getCodice() %></td>
				<td>
					<a href="VisualizzaDettaglioMunicipioServlet?idMunicipio=<%=municipioItem.getId() %>" class="btn btn-outline-danger">Dettaglio</a>
					<a href="PrepareUpdateMunicipioServlet?idMunicipio=<%=municipioItem.getId() %>" class="btn btn-outline-danger">Modifica</a>
					<a href="PrepareDeleteMunicipioServlet?idMunicipio=<%=municipioItem.getId() %>" class="btn btn-outline-danger">Elimina</a>
				</td>
			</tr>
				
		<%	}
		
		%>
	
	</table>
	<a href="PrepareInsertMunicipioServlet" class="btn btn-outline-danger btn-md">Inserisci Nuovo Elemento</a>

	</div>

</body>
</html>