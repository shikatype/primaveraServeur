package fr.primaveraServeur.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.primaveraServeur.model.DescriptionPrim;
import fr.primaveraServeur.model.EtatPrim;
import fr.primaveraServeur.model.FichePrim;
import fr.primaveraServeur.model.GroupePrim;
import fr.primaveraServeur.model.RolePrim;
import fr.primaveraServeur.model.UserPrim;
import fr.primaveraServeur.service.GestionActionService;
import fr.primaveraServeur.service.GestionHistoriqueService;
import fr.primaveraServeur.service.GestionOptionService;

@Controller
public class actionController {

	@Autowired
	private GestionActionService gestionActionService;
	@Autowired
	private GestionOptionService gestionOptionService;
	@Autowired
	private GestionHistoriqueService gestionHistoriqueService;

	@RequestMapping(value = "/fiche", method = RequestMethod.POST)
	public ModelAndView afficheFiche(@RequestParam Integer iduser,@RequestParam Integer idfiche) {
		UserPrim user = gestionActionService.recupUser(iduser);
		return initialisePageFiche(user,idfiche,false);
	}

	/**
	 * si la remarque est obligatoire et pas remplie alors on le renvois sur la page avec un message d'erreur
	 * si la remaque est obligatoire et remplie, on envoie en base
	 * si la remaque est pas obligatoire on envoie en base
	 * @param iduser
	 * @param iduserHisto
	 * @param idfiche
	 * @param rapportRemplie
	 * @return
	 */
	@RequestMapping(value = "/envoieFiche", method = RequestMethod.POST)
	public ModelAndView envoieFiche(@RequestParam Integer iduser, @RequestParam Integer iduserHisto,@RequestParam Integer idfiche,@RequestParam String rapportRemplie) {
		UserPrim user = gestionActionService.recupUser(iduser);
		UserPrim userHisto = gestionActionService.recupUser(iduserHisto);
		FichePrim fiche= gestionActionService.recupFiche(idfiche);
		EtatPrim etat=fiche.getEtatPrim();
		if(fiche.getEtatPrim().isRemObligatoire()&rapportRemplie.equals("")){
			return initialisePageFiche(user,idfiche,true);
		}
		else if(!fiche.getEtatPrim().isRemObligatoire()&rapportRemplie.equals("")){
			
			fiche.setUserHisto(userHisto);
			gestionActionService.envoyerFiche(fiche);

			return initialisePageHistoriqueFiche(user,etat);
		}
		DescriptionPrim description= new DescriptionPrim(new Date(), rapportRemplie, user);
		fiche.addDescriptionPrim(description);
		fiche.setUserHisto(userHisto);
		gestionActionService.envoyerFiche(fiche);

		return initialisePageHistoriqueFiche(user,etat);
	}

	@RequestMapping(value = "/clotureFiche", method = RequestMethod.POST)
	public ModelAndView clotureFiche(@RequestParam Integer iduser,@RequestParam Integer idfiche,@RequestParam String rapportRemplie) {
		UserPrim user = gestionActionService.recupUser(iduser);
		FichePrim fiche= gestionActionService.recupFiche(idfiche);
		EtatPrim etat=fiche.getEtatPrim();
		if(rapportRemplie.equals("")){
			return initialisePageFiche(user,idfiche,true);
		}
		DescriptionPrim description= new DescriptionPrim(new Date(), rapportRemplie, user);
		fiche.addDescriptionPrim(description);
		gestionActionService.envoyerFiche(fiche);

		gestionActionService.cloturationFiche(fiche);

		return initialisePageHistoriqueFiche(user,etat);
	}

	@RequestMapping(value = "/ficheAudit", method = RequestMethod.POST)
	public ModelAndView afficheFicheAudit(@RequestParam Integer iduser,@RequestParam Integer idfiche) {
		UserPrim user = gestionActionService.recupUser(iduser);
		return initialisePageFicheAudit(user,idfiche);
	}

	@RequestMapping(value = "/creationGroupe", method = RequestMethod.POST)
	public ModelAndView creationGroupe(@RequestParam Integer iduser,@RequestParam String etatName) {
		UserPrim user = gestionActionService.recupUser(iduser);
		EtatPrim etat = gestionActionService.recupEtatAvecNom(etatName);
		return initialisePageCreationGroupe(user,etat,0);
	}

	@RequestMapping(value = "/sauvegardeGroupe", method = RequestMethod.POST)
	public ModelAndView envoieGroupe(@RequestParam Integer iduser, @RequestParam Integer iduserHisto,
			@RequestParam Integer[] listidfiche,@RequestParam String description,@RequestParam String titre,@RequestParam String etatName) {

		UserPrim user = gestionActionService.recupUser(iduser);
		EtatPrim etat = gestionActionService.recupEtatAvecNom(etatName);
		if(titre.equals("")&description.equals("")){
			return initialisePageCreationGroupe(user,etat,2);
		}
		else if(listidfiche.length!=1){
			List<Integer> list=new ArrayList<Integer>();
			for(Integer id:listidfiche){
				if(id!=0){
					list.add(id);
				}
			}
			gestionActionService.creationGroupeDeFiche(titre, description, iduser, etat.getIdetat(), iduserHisto, list);
			return initialisePageHistoriqueFiche(user, etat);
		}
		else {

			return initialisePageCreationGroupe(user,etat,1);
		}
	}

	@RequestMapping(value = "/groupe", method = RequestMethod.POST)
	public ModelAndView afficheGroupe(@RequestParam Integer iduser,@RequestParam Integer idGroupe) {
		UserPrim user = gestionActionService.recupUser(iduser);
		return initialisePageGroupe(user,idGroupe);
	}

	@RequestMapping(value = "/envoieGroupe", method = RequestMethod.POST)
	public ModelAndView envoieGroupe(@RequestParam Integer iduser, @RequestParam Integer iduserHisto,@RequestParam Integer idGroupe) {
		UserPrim user = gestionActionService.recupUser(iduser);
		UserPrim userHisto = gestionActionService.recupUser(iduserHisto);
		GroupePrim groupe= gestionActionService.recupGroupe(idGroupe);
		EtatPrim etat=groupe.getEtatPrim();
		groupe.setUserHisto(userHisto);
		gestionActionService.envoyerGroupe(groupe);

		return initialisePageHistoriqueGroupe(user,etat);
	}

	@RequestMapping(value = "/clotureGroupe", method = RequestMethod.POST)
	public ModelAndView clotureGroupe(@RequestParam Integer iduser,@RequestParam Integer idGroupe) {
		UserPrim user = gestionActionService.recupUser(iduser);

		GroupePrim groupe= gestionActionService.recupGroupe(idGroupe);
		EtatPrim etat=groupe.getEtatPrim();

		gestionActionService.cloturationGroupe(groupe);

		return initialisePageHistoriqueGroupe(user,etat);
	}

	@RequestMapping(value = "/ficheGroupe", method = RequestMethod.POST)
	public ModelAndView afficheFicheGroupe(@RequestParam Integer iduser,@RequestParam Integer idfiche,@RequestParam Integer idGroupe) {
		UserPrim user = gestionActionService.recupUser(iduser);
		return initialisePageFicheGroupe(user,idfiche,idGroupe,false);
	}

	
	/**
	 * si la remarque est obligatoire et pas remplie alors on le renvois sur la page avec un message d'erreur
	 * si la remaque est obligatoire et remplie, on envoie en base
	 * si la remaque est pas obligatoire on envoie en base
	 * @param iduser
	 * @param idfiche
	 * @param rapportRemplie
	 * @param idGroupe
	 * @return
	 */
	@RequestMapping(value = "/envoieFicheGroupe", method = RequestMethod.POST)
	public ModelAndView envoieFicheGroupe(@RequestParam Integer iduser,@RequestParam Integer idfiche,@RequestParam String rapportRemplie,@RequestParam Integer idGroupe) {
		UserPrim user = gestionActionService.recupUser(iduser);
		FichePrim fiche= gestionActionService.recupFiche(idfiche);
		if(fiche.getEtatPrim().isRemObligatoire()&rapportRemplie.equals("")){
			return initialisePageFicheGroupe(user,idfiche,idGroupe,true);
		}
		else if(!fiche.getEtatPrim().isRemObligatoire()&rapportRemplie.equals("")){
			
			fiche.setRempli(true);
			gestionActionService.sauvegardeFiche(fiche);
			return initialisePageFicheGroupe(user,idfiche,idGroupe,false);
		}
		DescriptionPrim description= new DescriptionPrim(new Date(), rapportRemplie, user);
		fiche.addDescriptionPrim(description);
		fiche.setRempli(true);
		gestionActionService.sauvegardeFiche(fiche);
		return initialisePageFicheGroupe(user,idfiche,idGroupe,false);
	}

	@RequestMapping(value = "/mapFiche", method = RequestMethod.POST)
	public ModelAndView mapFiche(@RequestParam Integer iduser,@RequestParam String etatName) {
		UserPrim user = gestionActionService.recupUser(iduser);
		EtatPrim etat = gestionActionService.recupEtatAvecNom(etatName);
		return initialisePageMapFiche(user,etat);
	}

	@RequestMapping(value = "/mapGroupe", method = RequestMethod.POST)
	public ModelAndView mapGroupeFiche(@RequestParam Integer iduser,@RequestParam String etatName,@RequestParam Integer idGroupe) {
		UserPrim user = gestionActionService.recupUser(iduser);
		EtatPrim etat = gestionActionService.recupEtatAvecNom(etatName);
		GroupePrim groupe = gestionActionService.recupGroupe(idGroupe);
		return initialisePageMapGroupe(user,etat,groupe);
	}

	private ModelAndView initialisePageCreationGroupe(UserPrim user, EtatPrim etat,Integer erreur){
		ModelAndView model = new ModelAndView();
		EtatPrim etatplus = gestionActionService.recupEtatPlusAvecId(etat.getIdetat());
		if(user != null)
		{
			RolePrim role = user.getRolePrim();
			model = new ModelAndView("creationGroupeFiche");
			model.addObject("user", user);
			model.addObject("role", role);
			model.addObject("creation",gestionOptionService.serviceCreationFiche(user.getIduser()));
			model.addObject("creationUser",gestionOptionService.serviceCreationUser(user.getIduser()));
			model.addObject("recupAllFiche",gestionOptionService.serviceRecupAllFiche(user.getIduser()));
			model.addObject("historique",role.getEtatPrims());
			model.addObject("etat", etat.getEtat());
			model.addObject("etatPlus", etatplus.isGroupe());
			model.addObject("listeUser",gestionOptionService.affectation(etat.getIdetat()));
			List<FichePrim> listFiche=gestionHistoriqueService.recupListFiche(etat, user);
			model.addObject("listeFiche",listFiche);
			switch(erreur){
			case 1 : model.addObject("errorMessage","veuillez selectionner des fiches");
			break;
			case 2 : model.addObject("errorMessage","veuillez remplir tous les champs");;
			break;
			default : ;
			}
		}
		else
		{
			model = new ModelAndView("index");
			model.addObject("echec", "Connexion échouée, veuillez vérifier votre identifiant/password");
		}
		return model;
	}

	private ModelAndView initialisePageFiche(UserPrim user,Integer idfiche,boolean erreur){
		ModelAndView model = new ModelAndView();
		FichePrim fiche =gestionActionService.recupFiche(idfiche);
		EtatPrim etatplus = gestionActionService.recupEtatPlusAvecId(fiche.getEtatPrim().getIdetat());
		if(user != null)
		{
			RolePrim role = user.getRolePrim();
			model = new ModelAndView("fiche");
			model.addObject("user", user);
			model.addObject("role", role);
			model.addObject("historique",role.getEtatPrims());
			model.addObject("creation",gestionOptionService.serviceCreationFiche(user.getIduser()));
			model.addObject("creationUser",gestionOptionService.serviceCreationUser(user.getIduser()));
			model.addObject("recupAllFiche",gestionOptionService.serviceRecupAllFiche(user.getIduser()));
			model.addObject("fiche", fiche);
			model.addObject("listeUser",gestionOptionService.affectation(fiche.getEtatPrim().getIdetat()));
			model.addObject("etatPlus", etatplus.isGroupe());
			model.addObject("cloture",gestionOptionService.cloture(user.getIduser()));
			if(erreur){
				model.addObject("errorMessage","veuillez remplir le rapport");
			}
		}
		else
		{
			model = new ModelAndView("index");
			model.addObject("echec", "Connexion échouée, veuillez vérifier votre identifiant/password");
		}
		return model;
	}

	private ModelAndView initialisePageFicheAudit(UserPrim user,Integer idfiche){
		ModelAndView model = new ModelAndView();
		FichePrim fiche =gestionActionService.recupFiche(idfiche);
		if(user != null)
		{
			RolePrim role = user.getRolePrim();
			model = new ModelAndView("ficheAudit");
			model.addObject("user", user);
			model.addObject("role", role);
			model.addObject("historique",role.getEtatPrims());
			model.addObject("creation",gestionOptionService.serviceCreationFiche(user.getIduser()));
			model.addObject("creationUser",gestionOptionService.serviceCreationUser(user.getIduser()));
			model.addObject("recupAllFiche",gestionOptionService.serviceRecupAllFiche(user.getIduser()));
			model.addObject("fiche", fiche);
		}
		else
		{
			model = new ModelAndView("index");
			model.addObject("echec", "Connexion échouée, veuillez vérifier votre identifiant/password");
		}
		return model;
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

	private ModelAndView initialisePageMapFiche(UserPrim user, EtatPrim etat){
		ModelAndView model = new ModelAndView();
		if(user != null)
		{
			RolePrim role = user.getRolePrim();
			model = new ModelAndView("map-alerte");
			model.addObject("user", user);
			model.addObject("role", role);
			model.addObject("creation",gestionOptionService.serviceCreationFiche(user.getIduser()));
			model.addObject("creationUser",gestionOptionService.serviceCreationUser(user.getIduser()));
			model.addObject("recupAllFiche",gestionOptionService.serviceRecupAllFiche(user.getIduser()));
			model.addObject("historique",role.getEtatPrims());
			model.addObject("etat", etat.getEtat());
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

	private ModelAndView initialisePageGroupe(UserPrim user,Integer idgroupe){
		ModelAndView model = new ModelAndView();
		GroupePrim groupe =gestionActionService.recupGroupe(idgroupe);
		EtatPrim etatplus = gestionActionService.recupEtatPlusAvecId(groupe.getEtatPrim().getIdetat());
		if(user != null)
		{
			RolePrim role = user.getRolePrim();
			model = new ModelAndView("groupe");
			model.addObject("user", user);
			model.addObject("role", role);
			model.addObject("historique",role.getEtatPrims());
			model.addObject("creation",gestionOptionService.serviceCreationFiche(user.getIduser()));
			model.addObject("creationUser",gestionOptionService.serviceCreationUser(user.getIduser()));
			model.addObject("recupAllFiche",gestionOptionService.serviceRecupAllFiche(user.getIduser()));
			model.addObject("groupe", groupe);
			model.addObject("etatName", groupe.getEtatPrim().getEtat());
			model.addObject("listeUser",gestionOptionService.affectation(groupe.getEtatPrim().getIdetat()));
			model.addObject("etatPlus", etatplus.isGroupe());
			Set<FichePrim> listFiche=groupe.getFichePrims();
			model.addObject("listeFiche",listFiche);
			boolean envoie=true;
			for(FichePrim fiche: listFiche){
				if(!fiche.isRempli()){
					envoie=false;
				}
			}
			model.addObject("envoie",envoie);
			model.addObject("cloture",gestionOptionService.cloture(user.getIduser()));
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

	private ModelAndView initialisePageMapGroupe(UserPrim user, EtatPrim etat, GroupePrim groupe){
		ModelAndView model = new ModelAndView();
		if(user != null)
		{
			RolePrim role = user.getRolePrim();
			model = new ModelAndView("map-alerte");
			model.addObject("user", user);
			model.addObject("role", role);
			model.addObject("creation",gestionOptionService.serviceCreationFiche(user.getIduser()));
			model.addObject("creationUser",gestionOptionService.serviceCreationUser(user.getIduser()));
			model.addObject("recupAllFiche",gestionOptionService.serviceRecupAllFiche(user.getIduser()));
			model.addObject("historique",role.getEtatPrims());
			model.addObject("etat", etat.getEtat());
			Set<FichePrim> listFiche=groupe.getFichePrims();
			model.addObject("listeFiche",listFiche);
		}
		else
		{
			model = new ModelAndView("index");
			model.addObject("echec", "Connexion échouée, veuillez vérifier votre identifiant/password");
		}
		return model;
	}

	private ModelAndView initialisePageFicheGroupe(UserPrim user,Integer idfiche,Integer idgroupe,boolean erreur){
		ModelAndView model = new ModelAndView();
		FichePrim fiche =gestionActionService.recupFiche(idfiche);
		if(user != null)
		{
			RolePrim role = user.getRolePrim();
			model = new ModelAndView("ficheGroupe");
			model.addObject("user", user);
			model.addObject("role", role);
			model.addObject("historique",role.getEtatPrims());
			model.addObject("creation",gestionOptionService.serviceCreationFiche(user.getIduser()));
			model.addObject("creationUser",gestionOptionService.serviceCreationUser(user.getIduser()));
			model.addObject("recupAllFiche",gestionOptionService.serviceRecupAllFiche(user.getIduser()));
			model.addObject("fiche", fiche);
			model.addObject("idgroupe", idgroupe);
			if(erreur){
				System.out.println("ici");
				model.addObject("errorMessage","veuillez remplir le rapport");
			}

		}
		else
		{
			model = new ModelAndView("index");
			model.addObject("echec", "Connexion échouée, veuillez vérifier votre identifiant/password");
		}
		return model;
	}
}