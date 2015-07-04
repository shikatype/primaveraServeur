package fr.primaveraServeur.configuration;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.primaveraServeur.model.EtatPrim;
import fr.primaveraServeur.model.RolePrim;
import fr.primaveraServeur.model.ServicePrim;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/application-config.xml"})
public class configurationTest {

	@Test
	public void test() {
		//list des services (deja existant)
		ServicePrim service1=new ServicePrim("creation de fiche");
		service1.setIdservice(1001);
		ServicePrim service2=new ServicePrim("creation de groupe");
		service2.setIdservice(1002);
		ServicePrim service3=new ServicePrim("récuperation de ficheou groupe par etat");
		service3.setIdservice(1003);
		ServicePrim service4=new ServicePrim("récuperation de fiche groupe par user");
		service4.setIdservice(1004);
		ServicePrim service5=new ServicePrim("affecter a un user");
		service5.setIdservice(1005);

		//creation d'etat
		EtatPrim etat1=new EtatPrim("nouvelle fiche", false,true);
		etat1.setIdetat(1001);
		EtatPrim etat2=new EtatPrim("mission inspecteur", true,true);
		etat2.setIdetat(1002);
		EtatPrim etat3=new EtatPrim("rapport inspecteur", true,false);
		etat3.setIdetat(1003);
		EtatPrim etat4=new EtatPrim("chantier", true,true);
		etat4.setIdetat(1004);
		EtatPrim etat5=new EtatPrim("rapport de chef de chantier", true,false);
		etat5.setIdetat(1005);
		EtatPrim etat6=new EtatPrim("cloture", true,true);
		etat6.setIdetat(1006);
		//list d'etat
		ArrayList<EtatPrim> listEtat=new ArrayList<EtatPrim>();
		listEtat.add(etat1);
		listEtat.add(etat2);
		listEtat.add(etat3);
		listEtat.add(etat4);
		listEtat.add(etat5);
		listEtat.add(etat6);

		//creation des roles
		RolePrim role1=new RolePrim("user");
		role1.setIdrole(1001);
		RolePrim role2=new RolePrim("mairie");
		role2.setIdrole(1002);
		RolePrim role3=new RolePrim("inspecteur");
		role3.setIdrole(1003);
		RolePrim role4=new RolePrim("chef de chantier");
		role4.setIdrole(1004);
		RolePrim role5=new RolePrim("admin mairie");
		role5.setIdrole(1005);
		//list d'etat
		ArrayList<RolePrim> listRole=new ArrayList<RolePrim>();
		listRole.add(role1);
		listRole.add(role2);
		listRole.add(role3);
		listRole.add(role4);
		listRole.add(role5);

		//insertion des roles dans les etats
		etat1.addRole(role2);
		etat1.addRole(role5);
		etat2.addRole(role3);
		etat3.addRole(role2);
		etat3.addRole(role5);
		etat4.addRole(role4);
		etat5.addRole(role2);
		etat5.addRole(role5);
		etat6.addRole(role5);

		//choix de recuperation
		role2.addService(service3);
		role3.addService(service4);
		role4.addService(service4);
		role5.addService(service3);
		
		/**
		 * pour savoir si l'utilisateur l'affect a un role ou pas( voir l'etat +1 et voir si il a recuperation par user ou role)
		 * pour savoir si on recupere un groupe de fiche ou une fiche(on voit l'etat de ce qu'on veut prendre si c'est true on recupere un groupe sinon fiche)
		 * pour savoir si on recupere par userHisto ou par etat(on regard si le role contient le service "récuperation de fiche groupe par user")
		 */

	}

}
