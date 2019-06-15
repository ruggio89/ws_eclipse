<!-- Bootstrap -->
<link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet" type="text/css" />

<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!-- Static navbar -->
<nav class="navbar navbar-expand-lg navbar-light " style="background-color: #EAF4F4;">
	<a class="navbar-brand" href="${pageContext.request.contextPath}/ReturnHomeServlet">Ebay</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active"><a class="nav-link" href="${pageContext.request.contextPath}/ReturnHomeServlet">Home
					<span class="sr-only">(current)</span>
			</a></li>
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
				role="button" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false"> Dropdown </a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdown">
					<a class="dropdown-item" href="#">Action</a> <a
						class="dropdown-item" href="#">Another action</a>
					<div class="dropdown-divider"></div>
					<a class="dropdown-item" href="#">Something else here</a>
				</div></li>
		</ul>
		<c:if test="${userInfo.username == null}">
		 <ul class="nav navbar-nav navbar-right">
            <li><p class="navbar-text">Utente: <em>${userInfo.username}</em> (${userInfo.nome } ${userInfo.cognome })
            
            <a href="${pageContext.request.contextPath}/login.jsp">Accedi</a></p>
            </li>
          </ul>
         </c:if>
         
         <c:if test="${userInfo.username != null}">
		 <ul class="nav navbar-nav navbar-right">
            <li><p class="navbar-text">Utente: ${userInfo.username}(${userInfo.nome} ${userInfo.cognome})
            <a href="${pageContext.request.contextPath}/LogoutServlet">Disconnetti</a>
            <a href="${pageContext.request.contextPath}/utente/areaRiservata.jsp">Area Riservata</a></p> 
            
            </li>
          </ul>
         </c:if>
         
	</div>
</nav>

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="<%= request.getContextPath() %>/js/jquery-1.10.2.min.js"></script>
<script src="<%= request.getContextPath() %>/js/bootstrap.min.js"></script>
<script src="<%= request.getContextPath() %>/js/bootstrap.bundle.js"></script>
<script	src="<%=request.getContextPath()%>/js/jqueryUI/jquery-ui.min.js"></script>