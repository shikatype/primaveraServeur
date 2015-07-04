package fr.primaveraServeur.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.primaveraServeur.model.EtatPrim;
import fr.primaveraServeur.model.RolePrim;

public class EtatDaoTest {

	private static ClassPathXmlApplicationContext context;
	private static EtatDao etatDao;
	private static String etatName="EtatTest";
	private static RoleDao roleDao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context =new ClassPathXmlApplicationContext("spring/application-config.xml");
		etatDao= (EtatDao) context.getBean("etatDao");
		roleDao= (RoleDao) context.getBean("roleDao");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}
	
	@Test
	public void testSave(){
		RolePrim role=roleDao.findByName("role test1");
		EtatPrim etat =new EtatPrim(etatName,true,true);
		etat.addRole(role);
		role=roleDao.findByName("role test2");
		etat.addRole(role);
		etatDao.save(etat);
		assertNotNull(etat.getIdetat());
	}	
	
	@Test
	public void testFindAll() {
		List<EtatPrim> listEtat=etatDao.findAll();
		assertNotNull(listEtat);
		assertTrue(listEtat.size() > 0);
		System.out.println("testFindAll: "+listEtat);
	}
	
	@Test
	public void testFindById(){
		//recupération du etat de la base avec name
		EtatPrim etat=etatDao.findByName(etatName);
		assertNotNull(etat);
		int idetat=etat.getIdetat();
		//recuperation du etat de la base avec id
		etat=etatDao.findById(idetat);
		assertNotNull(etat);
		System.out.println("testFindById: "+etat);
	}
	
	@Test
	public void testFindByName(){
		EtatPrim etat=etatDao.findByName(etatName);
		assertNotNull(etat);
		System.out.println("testFindByName: "+etat);
	}

	@Test
	public void testDelete(){
		//recupération du etat de la base
		EtatPrim etat=etatDao.findByName(etatName);
		assertNotNull(etat);
		//suppression du etat dans la base
		etatDao.delete(etat);
	}
	
}
