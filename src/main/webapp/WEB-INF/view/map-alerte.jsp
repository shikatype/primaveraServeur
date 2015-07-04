<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page import="java.util.*"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Vue d'ensemble des alertes</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/css/bootstrap.min.css'/>" />

<script type="text/javascript"
	src="http://maps.google.com/maps/api/js?sensor=true"></script>
<script type="text/javascript">

	var listmarker = [
			<c:forEach var="liste" items="${listeFiche}">[
					<c:out value="${liste.latitude}"/>,
					<c:out value="${liste.longitude}"/>,
					'<c:out value="${liste.titre}"/>'], </c:forEach> ];

	function initialiser() {
		var latlng = new google.maps.LatLng(48.8316194, 2.2652212);
		//objet contenant des propriétés avec des identificateurs prédéfinis dans Google Maps permettant
		//de définir des options d'affichage de notre carte
		var options = {
			center : latlng,
			zoom : 10,
			mapTypeId : google.maps.MapTypeId.ROADMAP
		};

		//constructeur de la carte qui prend en paramêtre le conteneur HTML
		//dans lequel la carte doit s'afficher et les options
		var carte = new google.maps.Map(document.getElementById("carte"),
				options);

		var infowindow = new google.maps.InfoWindow({
			  content:"Hello World!"
			  });

		var marker, i;
		for (i = 0; i < listmarker.length; i++) {
			marker = new google.maps.Marker({
				position : new google.maps.LatLng(listmarker[i][0],
						listmarker[i][1]),
				map : carte,
				title : listmarker[i][2]
			
			

			});
		}	
	}
</script>
</head>
<body class="container-fluid" onload="initialiser()"
	style="text-align: center">
	<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
		<div class="container">

			<div class="navbar-header">
				<a class="navbar-brand" href="#">Primavera</a>
				<button type="button" class="navbar-toggle" data-toggle="collapse" 
         data-target="#button-responsive">
         <span class="sr-only">Toggle navigation</span>
         <span class="icon-bar"></span>
         <span class="icon-bar"></span>
         <span class="icon-bar"></span>
         <span class="icon-bar"></span>

      </button>
			</div>
			<div class="collapse navbar-collapse" id="button-responsive">
				<form class="navbar-form navbar-left" role="search" method="POST">
					<div class="form-group">
						<input type="hidden" name="iduser" value="${user.iduser}">
						<c:if test="${creation}">
							<input class="form-control" value="Création alerte" name="identifiant"
								type="submit" formaction="/primaveraServeur/creationFiche">
						</c:if>
						<c:if test="${creationUser}">
							<input class="form-control" value="Création utilisateur"
								name="identifiant" type="submit"
								formaction="/primaveraServeur/creationUser">
						</c:if>
						<c:if test="${recupAllFiche}">
							<input class="form-control" value="Voir toute les alertes"
								name="identifiant" type="submit"
								formaction="/primaveraServeur/recupAllFiche">
						</c:if>
						
					</div>
				</form>
				<form class="navbar-form navbar-right" style="margin-right: 25px">
					
						<div class="form-group">
						
								<input class="form-control btn-danger" value="Déconnexion" type="submit"
									formaction="/primaveraServeur/bienvenue">
							
						</div>
				
				</form>
			</div>
		</div>
	</nav>
	<div class="page-header" style="margin-top: 100px">
		<div class="container">
			<div class="row-fluid">
				<h1>Carte</h1>
			</div>
		</div>
	</div>
	<div class="container">

		<div class="jumbotron">
			<div style="width: 100%; height: 600px" id="carte"></div>
			<form method="POST">
				<input type="hidden" name="iduser" value="${user.iduser}"> <input
					type="hidden" name="etatName" value="${etat}"> <input
					class="btn btn-primary" type="submit" value="Retour"
					formaction="/primaveraServeur/histo">
			</form>
		</div>
	</div>
	<nav class="navbar navbar-default navbar-fixed-bottom">
		<div class="container"></div>
	</nav>
	<script>
		
	</script>
</body>
</html>