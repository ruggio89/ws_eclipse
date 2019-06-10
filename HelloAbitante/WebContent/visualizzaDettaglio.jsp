<%@page import="it.helloabitante.model.Abitante"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dettaglio</title>
</head>
<body>
<h3>Dettagli abitante</h3>
<% Abitante localAbitante = (Abitante)request.getAttribute("abitanteDaInviareAPaginaDettaglio");  %>
Nome: <%= localAbitante.getNome() %> <br><br>
Cognome: <%= localAbitante.getCognome() %> <br><br>
Codice Fiscale: <%= localAbitante.getCodiceFiscale() %> <br><br>
Eta: <%= localAbitante.getEta() %> <br><br>
Motto di Vita: <%= localAbitante.getMottoDiVita() %> <br><br>
</body>
</html>