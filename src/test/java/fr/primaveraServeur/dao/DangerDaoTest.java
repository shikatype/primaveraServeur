package fr.primaveraServeur.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.primaveraServeur.model.DangerPrim;

public class DangerDaoTest {

	private static ClassPathXmlApplicationContext context;
	private static DangerDao dangerDao;
	private static String dangerName="TestDanger4";
	private static Integer niveauDeDanger=4;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context =new ClassPathXmlApplicationContext("spring/application-config.xml");
		dangerDao= (DangerDao) context.getBean("dangerDao");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}
	
	@Test
	public void testSave(){
		DangerPrim danger =new DangerPrim(niveauDeDanger,dangerName);
		dangerDao.save(danger);
		assertNotNull(danger.getIddanger());
	}	
	
	@Test
	public void testFindAll() {
		List<DangerPrim> listDanger=dangerDao.findAll();
		assertNotNull(listDanger);
		assertTrue(listDanger.size() > 0);
		System.out.println("testFindAll: "+listDanger);
	}
	
	@Test
	public void testFindById(){
		//recupération du danger de la base avec name
		DangerPrim danger=dangerDao.findByName(dangerName);
		assertNotNull(danger);
		int iddanger=danger.getIddanger();
		//recuperation du danger de la base avec id
		danger=dangerDao.findById(iddanger);
		assertNotNull(danger);
		System.out.println("testFindById: "+danger);
	}
	
	@Test
	public void testFindByName(){
		DangerPrim danger=dangerDao.findByName(dangerName);
		assertNotNull(danger);
		System.out.println("testFindByName: "+danger);
	}
	
	@Test
	public void testFindByNiveauDanger(){
		DangerPrim danger=dangerDao.findByNiveauDanger(2);
		assertNotNull(danger);
		System.out.println("testFindByName: "+danger);
	}

	@Test
	public void testDelete(){
		//recupération du danger de la base
		DangerPrim danger=dangerDao.findByName(dangerName);
		assertNotNull(danger);
		//suppression du danger dans la base
		dangerDao.delete(danger);
	}
	
}
