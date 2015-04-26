package fr.primaveraServeur.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.primaveraServeur.model.FichePrim;
import fr.primaveraServeur.model.PhotoPrim;

public class PhotoDaoTest {

	private static ClassPathXmlApplicationContext context;
	private static PhotoDao photoDao;
	private static String lien="LienPhoto Test1";
	private static FicheDao ficheDao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context =new ClassPathXmlApplicationContext("spring/application-config.xml");
		photoDao= (PhotoDao) context.getBean("photoDao");
		ficheDao= (FicheDao) context.getBean("ficheDao");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}
	
	@Test
	public void testFindAll() {
		List<PhotoPrim> listPhoto=photoDao.findAll();
		assertNotNull(listPhoto);
		assertTrue(listPhoto.size() > 0);
		System.out.println("testFindAll: "+listPhoto);
	}
	
	@Test
	public void testFindAllByFiche() {
		//TODO a faire
		FichePrim fiche=ficheDao.findById(4);
		List<PhotoPrim> listPhoto=photoDao.findAllByFiche(fiche);
		assertNotNull(listPhoto);
		assertTrue(listPhoto.size() >= 0);
		System.out.println("testFindAllByFiche: "+listPhoto);
	}
	
	@Test
	public void testFindById(){
		//recupération du photo de la base avec name
		PhotoPrim photo=photoDao.findByName(lien);
		assertNotNull(photo);
		int idphoto=photo.getIdphoto();
		//recuperation du photo de la base avec id
		photo=photoDao.findById(idphoto);
		assertNotNull(photo);
		System.out.println("testFindById: "+photo);
	}
	
	@Test
	public void testFindByName(){
		PhotoPrim photo=photoDao.findByName(lien);
		assertNotNull(photo);
		System.out.println("testFindByName: "+photo);
	}
	
}
