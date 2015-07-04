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

<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/css/bootstrap.min.css'/>" />
<script type="text/javascript"
	src="<c:url value='/resources/js/jquery-2.1.3.min.js'/>"></script>
<script type="text/javascript"
	src="<c:url value='/resources/js/bootstrap.js'/>"></script>
<script type="text/javascript"
	src="<c:url value='/resources/js/bootstrap.min.js'/>"></script>
<script type="text/javascript"
	src="http://maps.google.com/maps/api/js?sensor=true"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Détails de l'alerte</title>
</head>

<script>
document.onkeydown = function(e) {
    // keycode for F5 function
    if (e.keyCode === 116) {
      return false;
    }
};


	function allowModify() {
		var modifier = document.getElementById("buttonModif");
		var submit = document.getElementById("modif");
		var textarea = document.getElementById("comment");
		textarea.readOnly = !textarea.readOnly;
		submit.disabled = !submit.disabled;
		if (modifier.value == "Modifier") {
			modifier.value = "Annuler";
		} else {
			modifier.value = "Modifier";
		}

	}
	var lat = '${fiche.latitude}';
	var longi = '${fiche.longitude}';
	function initialiser() {
		
		var latlng = new google.maps.LatLng(lat, longi);
		//objet contenant des propriétés avec des identificateurs prédéfinis dans Google Maps permettant
		//de définir des options d'affichage de notre carte
		var options = {
			center : latlng,
			zoom : 16,
			mapTypeId : google.maps.MapTypeId.ROADMAP
		};

		//constructeur de la carte qui prend en paramêtre le conteneur HTML
		//dans lequel la carte doit s'afficher et les options
		var carte = new google.maps.Map(document.getElementById("carteAlerte"),
				options);


		marker = new google.maps.Marker({
			position : new google.maps.LatLng(lat,
					longi),
			map : carte
			

		});
		
	}
</script>
<body onload="initialiser()" class="container-fluid" style="text-align: center">
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
						<c:if test="${fn:length(historique) > 0}">
						<span class="dropdown" data-dropdown="dropdown"> <a
							href="#" class="form-control dop">Historique</a>
							<ul class="dropdown-menu">
								<c:forEach items="${historique}" var="histo">
									<li><input class=" btn-primary btn-block"
										value="${histo.etat}" name="etatName" type="submit"
										formaction="/primaveraServeur/histo"></li>
								</c:forEach>
							</ul>
						</span>
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
				<h1>Remplir la fiche</h1>
			</div>
		</div>
	</div>
	<div class="container">
		<c:if test="${!empty errorMessage}">
			<div class="alert alert-dismissible alert-success">
				<button type="button" class="close" data-dismiss="alert">×</button>
				<h4>${errorMessage}</h4>
			</div>
		</c:if>
	</div>
	<div class="container">

		<div class="jumbotron">
			<form class="form-horizontal" method="POST">
				<input type="hidden" name="idfiche" value="${fiche.idfiche}">
				<input type="hidden" name="iduser" value="${user.iduser}"> <input
					type="hidden" name="etatName" value="${fiche.etatPrim.etat}">
				<p>

					Date de création :
					<fmt:formatDate pattern="dd/MM/yyyy" value="${fiche.dateCreation}" />
					</br> Libellé : ${fiche.titre} </br> Niveau de danger :
					${fiche.dangerPrim.nom}

		
<div class="container" style="width: 300px; height: 200px;" id="carteAlerte"></div>

					<c:if test="${!etatPlus}">
						<c:if test="${!empty listeUser}">
							<div class="form-group">
								<label for="iduserHisto" class="col-sm-2 control-label">Fiche
									a attribuer à : </label>
								<div class="col-sm-10 selectContainer">
									<select name="iduserHisto" class="form-control">
										<c:forEach items="${listeUser}" var="user">
											<option value="${user.iduser}">${user.nom}</option>
										</c:forEach>
									</select>
								</div>
							</div>
						</c:if>
					</c:if>
					<input type="hidden" name="iduserHisto" value="0">
				</p>

				<div class="panel-group" id="accordion" role="tablist"
					aria-multiselectable="true">
					<c:forEach items="${fiche.descriptionPrims}" var="listeDescrip">
						<div class="panel panel-default">
							<div class="panel-heading" role="tab" id="headingOne">
								<h4 class="panel-title">
									<a data-toggle="collapse" data-parent="#accordion"
										href="#collapse${listeDescrip.iddescription}"
										aria-expanded="true" aria-controls="collapseOne"> Rapport
										${listeDescrip.userPrim.rolePrim.nom}</a>
								</h4>
							</div>
							<div id="collapse${listeDescrip.iddescription}"
								class="panel-collapse collapse" role="tabpanel"
								aria-labelledby="headingOne">
								<div class="panel-body">${listeDescrip.description}</div>
							</div>
						</div>
					</c:forEach>


					<div class="panel panel-default">
						<div class="panel-heading" role="tab" id="headingThree">
							<h4 class="panel-title">
								<a class="collapsed" data-toggle="collapse"
									data-parent="#accordion" href="#collapseThree"
									aria-expanded="false" aria-controls="collapseThree">
									Remplir votre rapport </a>
							</h4>
						</div>
						<div id="collapseThree" class="panel-collapse collapse"
							role="tabpanel" aria-labelledby="headingThree">
							<div class="panel-body">

								<textarea required="required" class="form-control" rows="5"
									id="comment" name="rapportRemplie"></textarea>

								
							</div>
						</div>
					</div>

				</div>
				<c:if test="${!etatPlus}">
								<input class="btn btn-info" type="submit" value="Envoyer"
										formaction="/primaveraServeur/envoieFiche">
								</c:if>
				<c:if test="${cloture}">
					<input class="btn btn-info" onclick="var ok=confirm('Cloturer la fiche? Aucune modificiations ne sera alors possible!');return ok;" type="submit" value="cloturer"
						formaction="/primaveraServeur/clotureFiche">
				</c:if>
				
					
			</form>
			<form class="form-horizontal" method="POST">
			<input
					type="hidden" name="etatName" value="${fiche.etatPrim.etat}">
					<input type="hidden" name="iduser" value="${user.iduser}">
			<input class="btn btn-default" type="submit" value="Retour"
					formaction="/primaveraServeur/histo">
			</form>
		
		</div>
	</div>
	<nav class="navbar navbar-default navbar-fixed-bottom">
		<div class="container"></div>
	</nav>
	<script>
		$(document).ready(function() {
			$("#topbar-container").dropdown();
		});
		$("body").bind("click", function(e) {
			$('.dropdown-toggle, .dop').parent("span").removeClass("open");
		});
		$(".dropdown-toggle, .dop").click(function(e) {
			var $li = $(this).parent("span").toggleClass('open');
			return false;
		});
	</script>
</body>
</html>