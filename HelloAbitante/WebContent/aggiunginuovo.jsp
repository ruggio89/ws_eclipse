<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>aggiungi nuovo</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">

</head>
<body>
	<%if(request.getAttribute("messaggio_errore") != null){ %>
		<%=request.getAttribute("messaggio_errore") %>
	<% }else{ %>
		Inserire dati<br>
	<%} %>
	<div class="container">
		<div class="jumbotron">
			<h2>Aggiungi nuovo abitante</h2>
		</div>
		<form action="ExecuteInsertAbitanteServlet" method="post">
			<input type="text" name="tuoNomeInput"> Nome <br><br> 
			<input type="text" name="tuoCognomeInput"> Cognome <br><br> 
			<input type="text" name="tuoCodiceFiscaleInput"> Codice Fiscale <br><br> 
			<input type="text" name="tuaEtaInput"> Eta <br><br>
			<input type="text" name="tuoMottoInput"> Motto di Vita <br><br>  
			<input type="submit" value="INSERISCI">
		</form>
	</div>
	
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

</body>
</html>