<%@page import="it.prova.model.Persona"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>I tuoi dati</title>
</head>
<body>
<h3>Ecco i tuoi dati</h3>
<% Persona localPersona = (Persona)request.getAttribute("persona_attribute"); %>
Il tuo nome è: <%= localPersona.getNome() %> <br><br>
I tuo cognome è: <%= localPersona.getCognome() %> <br><br>
<a href="registra.jsp"> TORNA INDIETRO</a> <br><br>
<input type="button" onclick="alert('Ma fatti i cavoli tuoi!')" value="NON PREMERE">
</body>
</html>