<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista Municipi</title>
</head>
<body>

<div class="container">
	
	<%@ include file="../header.jsp" %>
	<div class="page-header">
	  	<br>
		  <h3>Lista Municipi</h3>
		</div>
		<br>
	<table border="2" class="table table-hover" style="border-color:#EAF4F4">
		<thead>
			<th>Id</th>
			<th>Descrizione</th>
			<th>Azioni</th>
		</thead>
		<c:forEach var="municipioItem" items="${municipiList}">
			<tbody>
				<tr>
					<td>${municipioItem.id }</td>
					<td>${municipioItem.descrizione }</td>
					<td><a href="${pageContext.request.contextPath }/municipio.do?idMunicipio=${municipioItem.id}&codop=show" class="btn btn-outline-danger btn-md">Dettaglio</a>
				</tr>
			</tbody>
		</c:forEach>
	</table>
<a href="${pageContext.request.contextPath }/municipio.do?codop=create" class="btn btn-outline-danger btn-md">Nuovo Municipio</a>
<br><br>
	<div class="jumbotron" style="background-color:#EAF4F4">
    <div class="container">
       <h1 class="display-4">Lista Abitanti</h1>
       <p><a class="btn btn-outline-danger btn-lg" href="${pageContext.request.contextPath}/abitante.do?codop=showAll">Vai &raquo;</a></p>
    </div>
</div>
</div> 


</body>
</html>