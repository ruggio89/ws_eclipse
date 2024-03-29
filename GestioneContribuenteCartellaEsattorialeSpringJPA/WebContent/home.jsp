<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Accedi</title>
</head>
<body>

<div class="container">
 <%@ include file="header.jsp" %>

	<div class="jumbotron">
      <div class="container">
        <h1 class="display-4">Gestione Contribuente</h1>
        <p><a class="btn btn-danger btn-lg" href="<%= request.getContextPath() +"/PrepareSearchContribuenteServlet" %>" role="button">Vai alla Gestione &raquo;</a></p>
      </div>
    </div>
    
    <div class="jumbotron">
      <div class="container">
        <h1 class="display-4">Gestione Cartella Esattoriale</h1>
        <p><a class="btn btn-danger btn-lg" href="<%= request.getContextPath() +"/PrepareSearchCartellaEsattorialeServlet" %>" role="button">Vai alla Gestione &raquo;</a></p>
      </div>
    </div>
	
	<c:if test="${userInfo.isAdmin()}">
	<div class="jumbotron">
      <div class="container">
        <h1 class="display-4">Gestione Utenti</h1>
        <p><a class="btn btn-danger btn-lg" href="<%= request.getContextPath() +"/admin/PrepareSearchUtenteServlet" %>" role="button">Vai alla Gestione &raquo;</a></p>
      </div>
    </div>
    </c:if>


	 <%@ include file="footer.jsp" %>
</div>

</body>
</html>