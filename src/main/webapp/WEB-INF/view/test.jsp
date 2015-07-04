<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/screen.css" />" />
<script type="text/javascript" src="<c:url value="/resources/js/jquery-1.6.4.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery-1.6.4.min.js" />"></script>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/bootstrap.min.css'/>" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Connexion</title>
</head>
    

<body>
<c:if test="${not empty echec}" >
<div class="alert alert-danger" id="succes" role="alert">${echec}</div>
</c:if>


<div style="width:350px;margin-top:55px" class="container">


<form id="fileupload" method="post" enctype="multipart/form-data">
<input id="photo" name="photo" type="file" multiple=true class="file-loading">

<img  alt="${photo}">
<img src="/images/mouahahah.png" class="imageGauche" alt="Photo de mon gite" />

				<input class="btn btn-primary" type="submit" value="Retour"
					formaction="/primaveraServeur/test1">
					

</form>






    </div>
</body>
</html>