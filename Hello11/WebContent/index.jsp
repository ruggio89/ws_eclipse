<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Benvenuto in hello11</title>
</head>
<body>
<h3>Immetti un Motto</h3>
<form action="MottoDelGiornoServlet" method="post">
	<input type="text" name="messaggioDelGiornoInput">
	<input type="submit" value="VAI">
</form>
</body>
</html>