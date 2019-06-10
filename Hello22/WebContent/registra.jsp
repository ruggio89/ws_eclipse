<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Il tuo nome e cognome</title>
</head>
<body>
	<h3>Dimmi come ti chiami</h3>
	<form action="HelloPersonaServlet" method="post">
		<input type="text" name="tuoNomeInput"> Nome <br><br> 
		<input type="text" name="tuoCognomeInput"> Cognome <br><br> 
		<input type="submit" value="VAI">
	</form>
</body>
</html>