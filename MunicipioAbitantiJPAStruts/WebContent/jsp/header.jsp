<!-- Bootstrap -->

<link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet" type="text/css" />
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!-- Static navbar -->
<nav class="navbar navbar-expand-lg navbar-light " style="background-color: #EAF4F4;">
	<a class="navbar-brand" href="${pageContext.request.contextPath}/ReturnHomeServlet">
		<img src="${pageContext.request.contextPath}/img/scimmia.png" width="50" height="50" alt="">
	</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active">
			<p class="navbar-text"><strong>Municipio & Abitante Struts</strong></p>
			</li>
		</ul>
		 <ul class="nav navbar-nav navbar-right">
            <li><p class="navbar-text">Gestiamo i municipi e gli abitanti con Struts</p>
            </li>
          </ul>
         
         
	</div>
</nav>

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="<%= request.getContextPath() %>/js/jquery-1.10.2.min.js"></script>
<script src="<%= request.getContextPath() %>/js/bootstrap.min.js"></script>
<script src="<%= request.getContextPath() %>/js/bootstrap.bundle.js"></script>
<script	src="<%=request.getContextPath()%>/js/jqueryUI/jquery-ui.min.js"></script>