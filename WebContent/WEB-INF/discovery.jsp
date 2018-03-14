<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
  <head>
    <title>Woukop</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" type="text/css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/styles.css" type="text/css" rel="stylesheet">
  </head>
 
  <body>
     
    <jsp:include page="fragment/navbar.jspf" />
     
     <div class="container">
      
     
<h1>${requestScope.discovery.name}<h1>
<h5>${requestScope.discovery.url}<h5>
	<div class="col-md-6">
		<h4>${requestScope.discovery.description}<h4>
	</div>
<div class="row">
<div class="col-sm-8">
  <br>
  <h3>Komentarze:</h3>
  
  <br>
            </div>
</div>
<div class="row">
<div class=comments>
<c:if test="${not empty requestScope.comments}">
	<c:forEach var="comment" items="${requestScope.comments}">

<div class="col-sm-1">
<div class="thumbnail">
<img class="img-responsive user-photo" src="https://ssl.gstatic.com/accounts/ui/avatar_2x.png">
</div><!-- /thumbnail -->
</div><!-- /col-sm-1 -->



		<div class="panel panel-default">
			<div class="panel-heading">
				<strong>${comment.user.username}</strong> 
			</div>
			<div class="panel-body">
			${comment.content}
			</div><!-- /panel-body -->
		</div><!-- /panel panel-default -->
	</c:forEach>
</c:if>
</div><!-- comments -->
<div class="row">

<div class="col-md-12"><br></div>      

<div class="col-md-6">
    	<div class="widget-area no-padding blank">
			<div class="status-upload">
				<form class="form-signin" method="post" action="addcomment">
					<input name="content" type="text" class="form-control" placeholder="pole na Twój komentarz?" />
					<br>
					<button type="submit" class="btn btn-success green"><i class="fa fa-share"></i> Dodaj komentarz</button>
				</form>
			</div>
		</div>
</div>
     
     
<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
<script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<script src="resources/js/bootstrap.js"></script>
</body>
</html>