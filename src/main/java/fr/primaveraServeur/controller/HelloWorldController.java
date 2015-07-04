package fr.primaveraServeur.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import fr.primaveraServeur.model.UserPrim;
import fr.primaveraServeur.service.GestionActionService;
import fr.primaveraServeur.service.GestionOptionService;

@Controller
public class HelloWorldController {

	@Autowired
	private GestionActionService gestionActionService;
	@Autowired
	private GestionOptionService gestionOptionService;

	@RequestMapping("/test")
	public String helloWorld() {
		return "test";
	}
	
	@RequestMapping(value = "/test1", method = RequestMethod.POST)
	public ModelAndView helloWorld1(@RequestParam MultipartFile photo) {
		ModelAndView model = new ModelAndView("test");
        if (!photo.isEmpty()) {
            try {
            	File file=new File("/Users/sanatgaran/Desktop/primaveraServeur/src/main/webapp/images", "mouahahah.jpg");
            	
                byte[] bytes = photo.getBytes();
                BufferedOutputStream stream =
                        new BufferedOutputStream(new FileOutputStream(file));
                System.out.println("file " );
                stream.write(bytes);
                stream.close();
                model.addObject("photo", file.getPath());
                System.out.println( "You successfully uploaded " + photo + "!");
            } catch (Exception e) {
            	System.out.println(  "You failed to upload " + photo + " => " + e.getMessage());
            }
        } else {
            System.out.println( "You failed to upload " + photo + " because the file was empty.");
        }
        return model;
	}
	

	@RequestMapping("/test3")
	public String helloWorld2() {
		return "creationUtilisateur";
	}
	
	@RequestMapping("/test4")
	public String helloWorld3() {
		return "detailsAlerteBtp";
	}

	@RequestMapping("/test5")
	public String helloWorld4() {
		return "detailsAlerteInspecteur";
	}
	
	@RequestMapping("/test6")
	public String helloWorld5() {
		return "detailsAlerteMairie";
	}

	@RequestMapping("/test7")
	public String helloWorld6() {
		return "index";
	}
	
	@RequestMapping("/test8")
	public String helloWorld7() {
		return "inspecteurDebut.jsp";
	}

	@RequestMapping("/test9")
	public String helloWorld13() {
		return "mairie-alerte";
	}
	
	@RequestMapping("/test10")
	public String helloWorld8() {
		return "mairieDebut";
	}

	@RequestMapping("/test11")
	public String helloWorld9() {
		return "map-alerte";
	}
	
	@RequestMapping("/test12")
	public String helloWorld10() {
		return "showMessage";
	}

	@RequestMapping("/test13")
	public String helloWorld11() {
		return "welcome-riverains";
	}

	@RequestMapping(value = "/teste", method = RequestMethod.POST)
	public ModelAndView Accueil(@RequestParam String identifiant, @RequestParam String password){
		ModelAndView model = new ModelAndView();
		UserPrim user = gestionActionService.connexion(identifiant, password);
		if(user != null)
		{
			model = new ModelAndView("coco");
			model.addObject("prenom", user);
			model.addObject("attente", gestionOptionService.cloture(user.getIduser()));
		}
		else
		{
			model = new ModelAndView("index");
			model.addObject("echec", "Connexion échouée, veuillez vérifier votre identifiant/password");
		}
		return model;
	}

}