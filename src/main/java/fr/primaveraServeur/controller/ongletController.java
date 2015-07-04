package fr.primaveraServeur.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.GeocodingResult;

import fr.primaveraServeur.model.EtatPrim;
import fr.primaveraServeur.model.FichePrim;
import fr.primaveraServeur.model.RolePrim;
import fr.primaveraServeur.model.UserPrim;
import fr.primaveraServeur.service.GestionActionService;
import fr.primaveraServeur.service.GestionHistoriqueService;
import fr.primaveraServeur.service.GestionOptionService;

@Controller
public class ongletController {

	@Autowired
	private GestionActionService gestionActionService;
	@Autowired
	private GestionOptionService gestionOptionService;
	@Autowired
	private GestionHistoriqueService gestionHistoriqueService;


	//partie creation de fiche



	@RequestMapping(value = "/creationFiche", method = RequestMethod.POST)
	public ModelAndView creationFiche(@RequestParam Integer iduser) {
		UserPrim user = gestionActionService.recupUser(iduser);
		return initialisePageCreation(user);
	}

	@RequestMapping(value = "/sauvegardeFiche", produces = "application/json", method = RequestMethod.POST)
	public ModelAndView ajoutFiche(@RequestParam Integer iduser, @RequestParam Integer iduserHisto, @RequestParam String adresse, @RequestParam String titre, @RequestParam String description, @RequestParam Integer danger){
		
		UserPrim user = gestionActionService.recupUser(iduser);
		ModelAndView model = initialisePageCreation(user);
		if(danger==0){
			model.addObject("message", "veuillez selectionner un niveau de danger");
			return model;		
		}
		if(titre.equals("")&description.equals("")){
			model.addObject("message", "veuillez remplir tous les champs");
			return model;	
		}
		
		Double lat = (double) 0;
		Double lng = (double) 0;
		GeoApiContext context = new GeoApiContext().setApiKey("AIzaSyDL3IsJHEK88W3p3Qh1jKhNcQ2351GNzZg");
		
		try {
			GeocodingResult[] results =  GeocodingApi.geocode(context, adresse
					).await();
			lat = results[0].geometry.location.lat;
			lng = results[0].geometry.location.lng;
		} catch (Exception e) {
			e.printStackTrace();
			model.addObject("message", "une erreur c'est produite lors de la localisation");
			//TODO retirer le commentaire sur le return !!!!!
			return model;
		}
		

		gestionActionService.creationFiche(titre, lng.toString(), lat.toString(), description, iduser, iduserHisto, danger);
		model.addObject("message", "Votre alerte est désormais prise en compte.");

		return model;	
	}


	@RequestMapping(value = "/creationUser", method = RequestMethod.POST)
	public ModelAndView creationUser(@RequestParam Integer iduser) {
		UserPrim user = gestionActionService.recupUser(iduser);
		return initialisePageCreationUser(user,0);
	}
	
	@RequestMapping(value = "/recupAllFiche", method = RequestMethod.POST)
	public ModelAndView recupAllFiche(@RequestParam Integer iduser) {
		UserPrim user = gestionActionService.recupUser(iduser);
		return initialisePageRecupAllFiche(user);
	}
	
	@RequestMapping(value = "/sauvegardeUser", produces = "application/json", method = RequestMethod.POST)
	public ModelAndView ajoutFiche(@RequestParam Integer iduser, @RequestParam String nom, @RequestParam String prenom,
			@RequestParam String affiliation, @RequestParam String email, @RequestParam String mdp, @RequestParam Integer role){
		
		UserPrim user = gestionActionService.recupUser(iduser);
		if(email.equals("")& mdp.equals("")){
			return initialisePageCreationUser(user,1);
		}
		else if(gestionActionService.userExisting(email)){
			return initialisePageCreationUser(user,2);
		}
		else{
			gestionActionService.creationUser(nom, prenom, affiliation, email, mdp, role);
			return initialisePageCreationUser(user,3);
		}
	}
	
	private ModelAndView initialisePageCreation(UserPrim user){
		ModelAndView model = new ModelAndView();
		if(user != null)
		{
			RolePrim role = user.getRolePrim();
			model = new ModelAndView("nouvelle-fiche");
			model.addObject("user", user);
			model.addObject("role", role);
			model.addObject("historique",role.getEtatPrims());
			model.addObject("creation",gestionOptionService.serviceCreationFiche(user.getIduser()));
			model.addObject("creationUser",gestionOptionService.serviceCreationUser(user.getIduser()));
			model.addObject("recupAllFiche",gestionOptionService.serviceRecupAllFiche(user.getIduser()));
			model.addObject("listeDanger",gestionOptionService.listDanger());
			model.addObject("listeUser",gestionOptionService.affectation(1000));
		}
		else
		{
			model = new ModelAndView("index");
			model.addObject("echec", "Connexion échouée, veuillez vérifier votre identifiant/password");
		}
		return model;
	}
	
	private ModelAndView initialisePageCreationUser(UserPrim user,Integer error){
		ModelAndView model = new ModelAndView();
		if(user != null)
		{
			RolePrim role = user.getRolePrim();
			model = new ModelAndView("creationUtilisateur");
			model.addObject("user", user);
			model.addObject("role", role);
			model.addObject("historique",role.getEtatPrims());
			model.addObject("creation",gestionOptionService.serviceCreationFiche(user.getIduser()));
			model.addObject("creationUser",gestionOptionService.serviceCreationUser(user.getIduser()));
			model.addObject("recupAllFiche",gestionOptionService.serviceRecupAllFiche(user.getIduser()));
			model.addObject("listeRole",gestionOptionService.listRole());
			switch(error){
			case 1: model.addObject("errorMessage","les champs email et mot de passe doivent être remplie");
			break;
			case 2: model.addObject("errorMessage","email déjà existant");
			break;
			case 3:model.addObject("errorMessage","l'utilisateur est bien enregistrer");
			break;
			default: ;
			}
		}
		else
		{
			model = new ModelAndView("index");
			model.addObject("echec", "Connexion échouée, veuillez vérifier votre identifiant/password");
		}
		return model;
	}
	
	
	//partie historique Fiche

	@RequestMapping(value = "/histo", method = RequestMethod.POST)
	public ModelAndView ListeFiche(@RequestParam Integer iduser, @RequestParam String etatName){
		UserPrim user = gestionActionService.recupUser(iduser);
		EtatPrim etat = gestionActionService.recupEtatAvecNom(etatName);
		if(etat.isGroupe()){
			return initialisePageHistoriqueGroupe(user,etat);
		}
		else return initialisePageHistoriqueFiche(user,etat);
	}
	
	private ModelAndView initialisePageHistoriqueFiche(UserPrim user, EtatPrim etat){
		ModelAndView model = new ModelAndView();
		EtatPrim etatplus = gestionActionService.recupEtatPlusAvecId(etat.getIdetat());
		if(user != null)
		{
			RolePrim role = user.getRolePrim();
			model = new ModelAndView("historiqueFiche");
			model.addObject("user", user);
			model.addObject("role", role);
			model.addObject("creation",gestionOptionService.serviceCreationFiche(user.getIduser()));
			model.addObject("creationUser",gestionOptionService.serviceCreationUser(user.getIduser()));
			model.addObject("recupAllFiche",gestionOptionService.serviceRecupAllFiche(user.getIduser()));
			model.addObject("historique",role.getEtatPrims());
			model.addObject("etat", etat.getEtat());
			model.addObject("etatPlus", etatplus.isGroupe());
			List<FichePrim> listFiche=gestionHistoriqueService.recupListFiche(etat, user);
			model.addObject("listeFiche",listFiche);
		}
		else
		{
			model = new ModelAndView("index");
			model.addObject("echec", "Connexion échouée, veuillez vérifier votre identifiant/password");
		}
		return model;
	}
	
	private ModelAndView initialisePageHistoriqueGroupe(UserPrim user, EtatPrim etat){

		ModelAndView model = new ModelAndView();
		EtatPrim etatplus = gestionActionService.recupEtatPlusAvecId(etat.getIdetat());
		if(user != null)
		{
			RolePrim role = user.getRolePrim();
			model = new ModelAndView("historiqueGroupe");
			model.addObject("user", user);
			model.addObject("role", role);
			model.addObject("creation",gestionOptionService.serviceCreationFiche(user.getIduser()));
			model.addObject("creationUser",gestionOptionService.serviceCreationUser(user.getIduser()));
			model.addObject("recupAllFiche",gestionOptionService.serviceRecupAllFiche(user.getIduser()));
			model.addObject("creationGroupe",gestionOptionService.serviceCreationGroupe(user.getIduser()));
			model.addObject("historique",role.getEtatPrims());
			model.addObject("etat", etat.getEtat());
			model.addObject("etatPlus", etatplus.isGroupe());
			model.addObject("listeGroupe",gestionHistoriqueService.recupListGroupeParEtat(etat, user));
		}
		else
		{
			model = new ModelAndView("index");
			model.addObject("echec", "Connexion échouée, veuillez vérifier votre identifiant/password");
		}
		return model;
	}
	
	private ModelAndView initialisePageRecupAllFiche(UserPrim user){
		ModelAndView model = new ModelAndView();
		if(user != null)
		{
			RolePrim role = user.getRolePrim();
			model = new ModelAndView("historiqueAllFiche");
			model.addObject("user", user);
			model.addObject("role", role);
			model.addObject("creation",gestionOptionService.serviceCreationFiche(user.getIduser()));
			model.addObject("creationUser",gestionOptionService.serviceCreationUser(user.getIduser()));
			model.addObject("recupAllFiche",gestionOptionService.serviceRecupAllFiche(user.getIduser()));
			model.addObject("historique",role.getEtatPrims());
			List<FichePrim> listFiche=gestionOptionService.listAllFiche();
			model.addObject("listeFiche",listFiche);
		}
		else
		{
			model = new ModelAndView("index");
			model.addObject("echec", "Connexion échouée, veuillez vérifier votre identifiant/password");
		}
		return model;
	}

}

