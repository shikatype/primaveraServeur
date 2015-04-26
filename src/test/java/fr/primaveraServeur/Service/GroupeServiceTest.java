package fr.primaveraServeur.Service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.primaveraServeur.model.GroupePrim;
import fr.primaveraServeur.service.GroupeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/application-config.xml"})
public class GroupeServiceTest {

	@Autowired
	GroupeService groupeService;
	
	@Test
	public void testCreationGroupeDeFiche() {
		List<Integer> listIdFiche=new ArrayList<Integer>();
		listIdFiche.add(5);
		listIdFiche.add(6);
		listIdFiche.add(7);
		groupeService.creationGroupeDeFiche("titre", "description", new Date(), 4, 2, 5, listIdFiche);
	}

	@Test
	public void testRecupGroupeAssigne() {
		List<GroupePrim> listGroupe=groupeService.recupListGroupeAssigne(6);
		assertNotNull(listGroupe);
		assertTrue(listGroupe.size() > 0);
		System.out.println("recupGroupeAssigneTest : "+listGroupe);
	}

	@Test
	public void testRecupGroupeParEtat() {
		List<GroupePrim> listGroupe=groupeService.recupListGroupeParEtat("EtatTest2");
		assertNotNull(listGroupe);
		assertTrue(listGroupe.size() > 0);
		System.out.println("recupGroupeParEtatTest : "+listGroupe);
	}

}
