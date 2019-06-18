<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
<h3 style="color: red;padding-bottom: 10px;">${loginNonAvvenuto }</h3>

<form action="${pageContext.request.contextPath }/login.do">
	USERNAME<input type="text" name="login"><br>
	PASSWORD<input type="text" name="password"><br>
	<input type="submit" value="Go"><br>

</form>
</body>
</html>