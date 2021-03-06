<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
 #body-color{ 
 	background-color:#F6FFF8; 
 } 
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Pagina di Accesso</title>

<!-- Bootstrap -->
<link href="<%= request.getContextPath() %>/css/bootstrap.min.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="<%= request.getContextPath() %>/css/signin.css" rel="stylesheet">
</head>
<body  id="body-color" class="text-center">
    <form class="form-signin" action="LoginServlet" method="post">
	  <img src="${pageContext.request.contextPath}/img/scimmia.png" width="150	 height="150" alt=""><br><br>
      <h1 class="h3 mb-3 font-weight-normal">Accedi al Sistema</h1>
      <label for="inputUsername" class="sr-only">Username</label>
      <input type="text" name="inputUsername" id="inputUsername" class="form-control" placeholder="Login" required autofocus>
      <label for="inputPassword" class="sr-only">Password</label>
      <input type="password" name="inputPassword" id="inputPassword" class="form-control" placeholder="Password" required>
      <button class="btn btn-lg btn-primary btn-block" type="submit">Esegui Accesso</button>
      <br>
      <p>Non sei registrato? Clicca <a href="${pageContext.request.contextPath}/PrepareSignUpServlet">qui</a></p>
      <p class="mt-5 mb-3 text-muted">&copy; 2017-2018</p>
    </form>
  </body>
</html>

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="<%= request.getContextPath() %>/js/jquery-1.10.2.min.js"></script>
<script src="<%= request.getContextPath() %>/js/bootstrap.min.js"></script>
<script src="<%= request.getContextPath() %>/js/bootstrap.bundle.js"></script>