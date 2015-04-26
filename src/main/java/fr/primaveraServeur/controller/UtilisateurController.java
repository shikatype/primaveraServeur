package fr.primaveraServeur.controller;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.primaveraServeur.model.UserPrim;
import fr.primaveraServeur.service.UserService;

@Controller
@RequestMapping(value = "/")
public class UtilisateurController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/api/utilisateur/authentication", method = RequestMethod.GET)
	public @ResponseBody String Authentication(@RequestParam(required = true, value = "email") String email,
			@RequestParam(required = true, value = "password") String password,
			ModelMap model)
			throws JSONException {
		
		UserPrim user = userService.connection(email, password);
		JSONObject utilisateurJSON = new JSONObject();
		
		if(user != null )
		{
			utilisateurJSON.put("user", user);
		}
		return utilisateurJSON.toString();
	}
	
//	@RequestMapping(value = "/api/utilisateur/modificationPosition", method = RequestMethod.GET)
//	public @ResponseBody void modificationPosition(@RequestParam(required = true, value = "mail") String mail,@RequestParam(required = true, value = "longitude") String longitude,
//			@RequestParam(required = true, value = "latitude") String latitude,
//			ModelMap model){
//		
//		Utilisateur utilisateur = utilisateurI.getUtilisateurByMail(mail);
//		System.out.println(longitude+" "+latitude);
//		utilisateur.setLongitude(longitude);
//		utilisateur.setLatitude(latitude);
//		utilisateurI.sauvegarderUtilisateur(utilisateur);
//		
//	}
	
//	@RequestMapping(value = "/api/utilisateur/authenticationFB", method = RequestMethod.GET)
//	public @ResponseBody void AuthenticationFB(@RequestParam(required = true, value = "nom") String nom,
//			@RequestParam(required = true, value = "prenom") String prenom,
//			@RequestParam(required = true, value = "age") String age,
//			ModelMap model)
//			throws JSONException {
//		Utilisateur utilisateur = new Utilisateur();
//		utilisateur.setNom(nom);
//		utilisateur.setPrenom(prenom);
//		utilisateur.setAge(age);
//		utilisateur.setMail(nom + prenom + "@facebook.com");
//		
//		utilisateurI.creerUtilisateur(utilisateur);
//		
//		
//	}
}
