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
	src="<c:url value='/resources/js/jquery.placepicker.min.js'/>"></script>
<script type="text/javascript"
	src="<c:url value='/resources/js/bootstrap.js'/>"></script>
<script type="text/javascript"
	src="<c:url value='/resources/js/bootstrap.min.js'/>"></script>
<script type="text/javascript"
	src="http://maps.googleapis.com/maps/api/js?libraries=places&sensor=false"></script>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Création d'une alerte</title>
</head>
<script>
	$(document).ready(function() {

		$(".placepicker").each(function() {

			// find map-element
			var target = this;
			var $collapse = $(this).parents('.form-group').next('.collapse');
			var $map = $collapse.find('.placepicker-map');

			// init placepicker
			var placepicker = $(this).placepicker({
				map : $map.get(0)
			}).data('placepicker');

			// reload map after collapse in
			$collapse.on('show.bs.collapse', function() {

				window.setTimeout(function() {
					placepicker.resizeMap();
					placepicker.reloadMap();
					if (!$(target).prop('value')) {
						placepicker.geoLocation();
					}

				}, 0);

			});

		});

	});
</script>
<body class="container-fluid" style="text-align: center">
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
				<h1>Création d'une alerte</h1>
			</div>
		</div>
	</div>

	<div class="container">
		<c:if test="${!empty message}">
			<div class="alert alert-dismissible alert-success">
				<button type="button" class="close" data-dismiss="alert">×</button>
				<h4>${message}</h4>
				<p>Vous pouvez désormais créer une autre alerte ou vous
					déconnecter!</p>
			</div>
		</c:if>

		<div class="jumbotron">
			<form class="form-horizontal" action="/primaveraServeur/"
				method="POST">
				<div class="form-group ">
					<input type="hidden" name="iduser" value="${user.iduser}">
					<label id="iduser" name="iduser" class="col-md-7 col-md-offset-0 control-label">
						Identifiant : ${user.iduser}</label>
					</div>
					<div class="form-group ">
					<input type="hidden" name="iduser" value="${user.iduser}">
					<label id="iduser" name="iduser" class="col-md-7 control-label">
						Date : <fmt:formatDate pattern="dd/MM/yyyy" 
            value="<%=new java.util.Date()%>" /></label>
					</div>
					
				<div class="form-group">
					<div class="input-group col-md-7 col-md-offset-3 selectContainer">
						<span class="input-group-btn">
							<button data-toggle="collapse" href="#collapseOne"
								class="btn btn-default">
								<i class="glyphicon glyphicon-globe"></i>
							</button>
						</span> <input required="required" name="adresse" id="adresse"
							class="placepicker form-control" />
					</div>
				</div>
				<div id="collapseOne" class="collapse col-md-7 col-md-offset-3">
					<div style="width: 300px; height: 150px"
						class="placepicker-map thumbnail"></div>
				</div>
				<div class="form-group centered">
					
					<div class="col-md-7 col-md-offset-3 selectContainer">
						<select required="required" name="danger" class="form-control">
						<option value="0" selected="selected">Selectionner le niveau de danger</option>
						
							<c:forEach items="${listeDanger}" var="danger">
								<option value="${danger.iddanger}"}>${danger.nom}</option>
							</c:forEach>
						</select>
					</div>
				</div>

				<input type="hidden" name="iduserHisto" value="0">
				<c:if test="${!empty listeUser}">
					<div class="form-group centered">
						<label for="iduserHisto" class="col-sm-2 control-label">Fiche
							a attribuer à : </label>
						<div class="col-md-4 col-md-offset-4">
							<select name="iduserHisto" class="form-control">
								<c:forEach items="${listeUser}" var="user">
									<option value="${user.iduser}"}>${user.nom}</option>
								</c:forEach>
							</select>
						</div>
					</div>
				</c:if>

				<div class="form-group centered">
					<div class="col-md-7 col-md-offset-3">
						<input required="required" type="text" class="form-control"
							id="titre" name="titre" placeholder="Titre de l'alerte" />
					</div>
				</div>
				<div class="form-group">
					<label for="comment">Description</label>

					<textarea required="required" class="form-control" rows="5"
						id="comment" name="description"></textarea>
				</div>
				<div class="form-group">

					<input type="submit" class="btn btn-info"
						formaction="sauvegardeFiche"></input>
					<button type="reset" class="btn btn-default">Annuler</button>

				</div>

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