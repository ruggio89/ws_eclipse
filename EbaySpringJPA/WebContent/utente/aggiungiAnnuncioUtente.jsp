<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inserisci Nuovo Annuncio</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/jqueryUI/jquery-ui.min.css" />
<style>
.ui-autocomplete-loading {
	background: white url("../img/anim_16x16.gif") right center no-repeat;
}
</style>
</head>
<body>

	<div class="container">

		<%@ include file="../header.jsp"%>
		

		<div class="page-header">
			<h3>Inserisci Annuncio</h3>
		</div>
		<div class="alert alert-danger alert-dismissible fade show ${messaggio_errore != null?'':'d-none'} " role="alert">
			${messaggio_errore }
			 <button type="button" class="close" data-dismiss="alert" aria-label="Close">
			    <span aria-hidden="true">&times;</span>
			  </button>
		</div>
		<form class="form-horizontal" action="ExecuteInsertAnnuncioUtenteServlet"
			method="post">
			<div class="form-group">
      			<label class="control-label col-sm-2" for="testoAnnuncioInputId">Testo Annuncio:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="testoAnnuncioInputId" name="testoAnnuncioInput" >
			 	</div>
  			</div>
  			<div class="form-group">
      			<label class="control-label col-sm-2" for="prezzoInputId">Prezzo:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="prezzoInputId" name="prezzoInput" >
			 	</div>
  			</div>
  			<div class="form-group">
<!--   				<label class="control-label col-sm-2" for="categoriaInputId">Categoria:</label> -->
				<c:forEach items="${listaCategorieAttributeName}" var="categoriaItem">
					<input type="checkbox" name="categoriaId" value="${categoriaItem.id}"/>-->  ${categoriaItem.descrizione}<br>
				</c:forEach>
			</div>
			
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-outline-danger btn-md">Effettua
						Inserimento</button>
				</div>
			</div>
			
		</form>

	</div>
	<!-- /.container -->



</body>


</html>


