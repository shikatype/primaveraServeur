package fr.primaveraServeur.Service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.primaveraServeur.model.FichePrim;
import fr.primaveraServeur.service.FicheService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/application-config.xml"})
public class FicheServiceTest {

	@Autowired
	FicheService ficheService;

	@Test
	public void recupFicheParEtatTest() {
		List<FichePrim> listFiche=ficheService.recupListFicheParEtat("EtatTest2");
		assertNotNull(listFiche);
		assertTrue(listFiche.size() > 0);
		System.out.println("recupFicheParEtatTest : "+listFiche);
	}

	@Test
	public void recupFicheAssigneTest() {
		List<FichePrim> listFiche=ficheService.recupListFicheAssigne(6);
		assertNotNull(listFiche);
		assertTrue(listFiche.size() > 0);
		System.out.println("recupFicheAssigneTest : "+listFiche);
	}
	
	@Test
	public void creationFicheTest() {
		ficheService.creationFiche("titreServiceTest", "longitudeServiceTest", "latitudeServiceTest", new Date(), "txtDescriptionServiceTest", 4, 5, 2, 1);
	}
}
