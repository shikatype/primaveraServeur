package fr.primaveraServeur.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.primaveraServeur.model.EtatPrim;
import fr.primaveraServeur.model.FichePrim;
import fr.primaveraServeur.model.GroupePrim;
import fr.primaveraServeur.model.UserPrim;

public class GroupeDaoTest {

	private static ClassPathXmlApplicationContext context;
	private static GroupeDao groupeDao;
	private static UserDao userDao;
	private static EtatDao etatDao;
	private static FicheDao ficheDao;
	private static int idEtat=1;
	private static int idUser=6;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context =new ClassPathXmlApplicationContext("spring/application-config.xml");
		groupeDao= (GroupeDao) context.getBean("groupeDao");
		userDao= (UserDao) context.getBean("userDao");
		etatDao= (EtatDao) context.getBean("etatDao");
		ficheDao= (FicheDao) context.getBean("ficheDao");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}
	
	@Test
	public void testSave(){
		EtatPrim etat = etatDao.findById(idEtat);
		UserPrim user= userDao.findById(idUser);
		Set<FichePrim> listFiche=new HashSet<FichePrim>();
		listFiche.add(ficheDao.findById(5));
		listFiche.add(ficheDao.findById(6));
		listFiche.add(ficheDao.findById(7));
		listFiche.add(ficheDao.findById(9));
		GroupePrim groupe =new GroupePrim(new Date(), "descriptionTest", "TitreTest", etat, user);
		groupe.setFichePrims(listFiche);
		groupeDao.save(groupe);
		assertNotNull(groupe.getIdgroupe());
	}	
	
	@Test
	public void testFindAll() {
		List<GroupePrim> listGroupe=groupeDao.findAll();
		assertNotNull(listGroupe);
		assertTrue(listGroupe.size() > 0);
		System.out.println("testFindAll: "+listGroupe);
	}
	
	@Test
	public void testFindById(){
		GroupePrim groupe=groupeDao.findById(2);
		assertNotNull(groupe);
		System.out.println("testFindById: "+groupe);
	}
	
	@Test
	public void testFindAllByUser(){
		UserPrim user=userDao.findById(idUser);
		List<GroupePrim> listGroupeByUser=groupeDao.findAllByUserHisto(user);
		assertNotNull(listGroupeByUser);
		assertTrue(listGroupeByUser.size() > 0);
		System.out.println("testFindAllByUser: "+listGroupeByUser);
	}
	
	@Test
	public void testFindAllByEtat(){
		EtatPrim etat=etatDao.findById(idEtat);
		List<GroupePrim> listGroupeByEtat=groupeDao.findAllByEtat(etat);
		assertNotNull(listGroupeByEtat);
		assertTrue(listGroupeByEtat.size() > 0);
		System.out.println("testFindAllByEtat: "+listGroupeByEtat);
	}
	
}
