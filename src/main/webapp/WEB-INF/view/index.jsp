<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/css/bootstrap.min.css'/>" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Connexion</title>
</head>


<body class="container-fluid" style="text-align: center">
	<nav class="navbar navbar-default navbar-fixed-top">
		<div class="container"></div>
	</nav>
	<div class="container">
		
		<div class="page-header" style="margin-top: 100px">
			<div class="container">
				<div class="row-fluid">
					<h1>Connexion</h1>
				</div>
			</div>
		</div>

		<c:if test="${not empty echec}">
			<div class="alert alert-danger" id="succes" role="alert">${echec}</div>
		</c:if>

		<div style="width: 350px; margin-top: 55px" class="container">

			<form class="form-signin" action="/primaveraServeur/accueil"
				method="POST">

				<label for="identifiant" class="sr-only">identifiant</label> <input
					type="text" name="identifiant" id="identifiant"
					class="form-control" placeholder="Identifiant"> <label
					for="inputPassword" class="sr-only">Password</label> <input
					type="password" id="inputPassword" name="password"
					class="form-control" placeholder="Password">
				<br>
				<button class="btn btn-lg btn-primary btn-block" type="submit">Connexion</button>
			</form>

		</div>
	</div>
	<nav class="navbar navbar-default navbar-fixed-bottom">
		<div class="container"></div>
	</nav>
</body>
</html>