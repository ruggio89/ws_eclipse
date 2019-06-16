<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ricerca Categoria</title>
</head>
<body>

<div class="container">

   <%@ include file="/header.jsp" %>
      
    <div class="page-header">
    <br>
	  <h3>Ricerca Categoria</h3>
	</div>
	<br>

      	<form class="form-horizontal" action="${pageContext.request.contextPath}/admin/ExecuteSearchCategoriaServlet" method="post">
      		<div class="form-group">
      			<label class="control-label col-sm-2" for="descrizioneInputId">Descrizione:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="descrizioneInputId" name="descrizioneInput" >
			 	</div>
  			</div>
  			<div class="form-group">
      			<label class="control-label col-sm-2" for="codiceInputId">Codice:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="codiceInputId" name="codiceInput" >
			 	</div>
  			</div>
  			
  			<div class="form-group">        
		      <div class="col-sm-offset-2 col-sm-10">
		        <button type="submit" class="btn btn-outline-danger btn-md">Effettua Ricerca</button>
		        <a href="${pageContext.request.contextPath}/admin/PrepareInsertCategoriaServlet" class="btn btn-outline-danger btn-md">Inserisci Nuovo Elemento</a>
		      </div>
		    </div>
		</form>
		
    </div><!-- /.container -->



</body>
</html>