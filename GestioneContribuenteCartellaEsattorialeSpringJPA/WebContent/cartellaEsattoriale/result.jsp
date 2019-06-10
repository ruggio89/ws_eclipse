<%@page import="it.prova.gestionecontribuentespringjpa.model.CartellaEsattoriale"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Risultati Ricerca Cartelle Esattoriali</title>
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
				<th>Denominazione</th>
				<th>Descrizione</th>
				<th>Action</th>
			</tr>
		</thead>
		<% List<CartellaEsattoriale> listaCartelleEsattoriali = (List<CartellaEsattoriale>)request.getAttribute("listaCartelleEsattorialiAttributeName"); 
			for(CartellaEsattoriale cartellaEsattorialeItem: listaCartelleEsattoriali){ %>
			<tr>
				<td><%=cartellaEsattorialeItem.getDenominazione() %></td>
				<td><%=cartellaEsattorialeItem.getDescrizione() %></td>
				<td>
					<a href="VisualizzaDettaglioCartellaEsattorialeServlet?idCartellaEsattoriale=<%=cartellaEsattorialeItem.getId() %>" class="btn btn-outline-danger">Dettaglio</a>
					<a href="PrepareUpdateCartellaEsattorialeServlet?idCartellaEsattoriale=<%=cartellaEsattorialeItem.getId() %>" class="btn btn-outline-danger">Modifica</a>
					<a href="PrepareDeleteCartellaEsattorialeServlet?idCartellaEsattoriale=<%=cartellaEsattorialeItem.getId() %>" class="btn btn-outline-danger">Elimina</a>
				</td>
			</tr>
				
		<%	}
		
		%>
	
	</table>
	<a href="PrepareInsertCartellaEsattorialeServlet" class="btn btn-outline-danger btn-md">Inserisci Nuovo Elemento</a>

	</div>
</body>
</html>