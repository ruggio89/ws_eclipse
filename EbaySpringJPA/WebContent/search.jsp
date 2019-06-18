<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
 #body-color{ 
 	background-color:#F6FFF8; 
 } 
</style>
<title>Ricerca Annunci</title>
</head>
<body id="body-color">

<div class="container">
	

<%@ include file="../header.jsp" %>
<div class="jumbotron" style="background-color:#CCE3DE">
    <div class="page-header">
	  <h3>Ebay Annunci Searcher</h3><br>
	</div>

		<div class="alert alert-danger alert-dismissible fade show ${messaggio_errore != null?'':'d-none'} " role="alert">
				${messaggio_errore }
			 <button type="button" class="close" data-dismiss="alert" aria-label="Close">
			    <span aria-hidden="true">&times;</span>
			  </button>
		</div>
      	<form class="form-horizontal" name="myForm" action="ExecuteSearchAnnuncioServlet" method="post" onsubmit="return validateCategorie()">
      		<div class="form-group">
      			<label class="control-label col-sm-2" for="testoAnnuncioInputId">Ricerca Annuncio:</label>
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

			<c:forEach items="${listaCategorieAttributeName}" var="categoriaItem">
				<div class="custom-control custom-checkbox">
					<input type="checkbox" class="custom-control-input" id="${categoriaItem.id}" name="categoriaId" value="${categoriaItem.id}"/>
					<label class="custom-control-label" for="${categoriaItem.id}">${categoriaItem.descrizione}</label><br>
				</div>
			</c:forEach>
			<div id="messaggioCategoria" style="color:Red;display:none">Per favore, inserisci almeno una Categoria!</div>
  			<br>
  			<div class="form-group">        
		      <div class="col-sm-offset-2 col-sm-10">
		        <button type="submit" class="btn btn-outline-danger btn-md">Effettua Ricerca</button>
		      </div>
		    </div>
		</form>
		</div>
		
    </div><!-- /.container -->
    
<script type="text/javascript">
function validateCategorie() {
	var allCheckBoxes = document.querySelectorAll("[name='categoriaId']:checked");

	if(allCheckBoxes.length == 0){
		document.getElementById("messaggioCategoria").style.display="";
		return false;
	}
	return true;
}
</script>
        
</body>
</html>


