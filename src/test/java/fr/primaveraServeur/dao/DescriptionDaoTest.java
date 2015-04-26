package fr.primaveraServeur.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.primaveraServeur.model.DescriptionPrim;
import fr.primaveraServeur.model.FichePrim;
import fr.primaveraServeur.model.UserPrim;

public class DescriptionDaoTest {

	private static ClassPathXmlApplicationContext context;
	private static DescriptionDao descriptionDao;
	private static FicheDao ficheDao;
	private static UserDao userDao;
	private static Integer idDescription=1;
	private static Integer idFiche=5;
	private static String mailUser="addresseMail2";
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context =new ClassPathXmlApplicationContext("spring/application-config.xml");
		descriptionDao= (DescriptionDao) context.getBean("descriptionDao");
		ficheDao= (FicheDao) context.getBean("ficheDao");
		userDao= (UserDao) context.getBean("userDao");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}
	
	@Test
	public void testFindAll() {
		List<DescriptionPrim> listDescription=descriptionDao.findAll();
		assertNotNull(listDescription);
		assertTrue(listDescription.size() > 0);
		System.out.println("testFindAll: "+listDescription);
	}
	
	@Test
	public void testFindById(){
		DescriptionPrim description=descriptionDao.findById(idDescription);
		assertNotNull(description);
		System.out.println("testFindById: "+description);
	}
	
	@Test
	public void testFindAllByFiche(){
		FichePrim fiche=ficheDao.findById(idFiche);
		List<DescriptionPrim> listDescriptionByFiche=descriptionDao.findAllByFiche(fiche);
		assertNotNull(listDescriptionByFiche);
		assertTrue(listDescriptionByFiche.size() > 0);
		System.out.println("testFindAllByFiche: "+listDescriptionByFiche);
	}
	
	@Test
	public void testFindAllByUser(){
		UserPrim user=userDao.findByMail(mailUser);
		List<DescriptionPrim> listDescriptionByEtat=descriptionDao.findAllByUser(user);
		assertNotNull(listDescriptionByEtat);
		assertTrue(listDescriptionByEtat.size() > 0);
		System.out.println("testFindAllByEtat: "+listDescriptionByEtat);
	}
	
}
