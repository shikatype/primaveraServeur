package fr.primaveraServeur.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.primaveraServeur.model.RolePrim;
import fr.primaveraServeur.model.UserPrim;
import fr.primaveraServeur.service.GestionActionService;
import fr.primaveraServeur.service.GestionOptionService;

@Controller
public class connexionController {

	@Autowired
	private GestionActionService gestionActionService;
	@Autowired
	private GestionOptionService gestionOptionService;

	@RequestMapping("/bienvenue")
	public String helloWorld() {
		return "index";
	}
	
	@RequestMapping(value = "/accueil", method = RequestMethod.POST)
	public ModelAndView Accueil(@RequestParam String identifiant, @RequestParam String password){
		ModelAndView model = new ModelAndView();
		UserPrim user = gestionActionService.connexion(identifiant, password);
		if(user != null)
		{
			RolePrim role = user.getRolePrim();
			model = new ModelAndView("accueil");
			model.addObject("user", user);
			model.addObject("role", role);
			model.addObject("historique",role.getEtatPrims());
			model.addObject("creation",gestionOptionService.serviceCreationFiche(user.getIduser()));
			model.addObject("creationUser",gestionOptionService.serviceCreationUser(user.getIduser()));
			model.addObject("recupAllFiche",gestionOptionService.serviceRecupAllFiche(user.getIduser()));
		}
		else
		{
			model = new ModelAndView("index");
			model.addObject("echec", "Connexion échouée, veuillez vérifier votre identifiant/password");
		}
		return model;
	}

}

