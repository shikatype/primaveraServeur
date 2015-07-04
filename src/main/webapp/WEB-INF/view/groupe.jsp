<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page import="java.util.*"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html >
<html>

<head>
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/css/bootstrap.min.css'/>" />

<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/css/dataTables.bootstrap.css'/>" />
<script type="text/javascript"
	src="<c:url value='/resources/js/jquery-2.1.3.min.js'/>"></script>
<script type="text/javascript"
	src="<c:url value='/resources/js/jquery-ui.js'/>"></script>
<script type="text/javascript"
	src="<c:url value='/resources/js/jquery.dataTables.min.js'/>"></script>
<script type="text/javascript"
	src="<c:url value='/resources/js/dataTables.bootstrap.js'/>"></script>
<script type="text/javascript"
	src="<c:url value='/resources/js/bootstrap.js'/>"></script>
<script type="text/javascript"
	src="<c:url value='/resources/js/bootstrap.min.js'/>"></script>

<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Détails de l'alerte</title>
</head>
<script>
$(document).ready(function() {
	$('#example').DataTable({
			"language":{
    	        "lengthMenu": "Afficher _MENU_ résultats par page",
    	        "zeroRecords": "Aucun résultat!",
    	        "info": "page _PAGE_ sur _PAGES_",
    	        "infoEmpty": "Aucun résultat!",
    	        "infoFiltered": "",
    	        "search": "Recherche :"
    	    			},
	"orderFixed": [ 0, 'desc' ],
	"scrollY":        "200px",
    "scrollCollapse": true,
    "paging":         false
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
				<h1>Groupe d'alertes</h1>
			</div>
		</div>
	</div>


	<div class="container">
		
		<div class="jumbotron">
			<form class="form-horizontal" method="POST">
				<input type="hidden" name="iduser" value="${user.iduser}"> <input
					type="hidden" name="etatName" value="${etatName}">
				<p>
				<p>
					Date de création :
					<fmt:formatDate pattern="dd/MM/yyyy" value="${groupe.dateCreation}" />
					</br> Libellé : ${groupe.titre} </br> Description :${groupe.description}

					<c:if test="${etatPlus}">
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


				<div class="table-responsive">

					<table id="example" class="table table-striped table-bordered">
						<thead>
							<tr class="default">

								<th>Date</th>
								<th>Description</th>
								<th>Niveau de danger</th>
								<th>Etat</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${listeFiche}" var="liste">

								<tr class="default">

									<td><fmt:formatDate pattern="dd/MM/yyyy"
											value="${liste.dateCreation}" /></td>
									<td><c:out value="${liste.titre}" /></td>
									<td><c:out value="${liste.dangerPrim.nom}" /></td>
									<td>
										<form method="POST">
											<input type="hidden" name="iduser"
												value="${user.iduser}"> <input type="hidden"
												name="idfiche" value="${liste.idfiche}"> <input
												type="hidden" name="idGroupe" value="${groupe.idgroupe}">
											<input type="submit" class="btn btn-info" value="Détails"
												formaction="/primaveraServeur/ficheGroupe">
										</form>
									</td>

								</tr>
							</c:forEach>
							<input class="btn btn-primary" type="submit" value="carte"
								formaction="/primaveraServeur/mapGroupe">
					</table>
					</tbody>
					<c:if test="${envoie}">
						<input class="btn btn-primary" type="submit" value="Envoyer"
							formaction="/primaveraServeur/envoieGroupe">
					</c:if>
					<c:if test="${cloture}">
						<input class="btn btn-primary" type="submit" value="cloturer"
							formaction="/primaveraServeur/clotureGroupe">
					</c:if>
					<input class="btn btn-primary" type="submit" value="retour"
						formaction="/primaveraServeur/histo">
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