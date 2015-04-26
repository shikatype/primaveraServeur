package fr.primaveraServeur.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.primaveraServeur.model.DangerPrim;
import fr.primaveraServeur.model.DescriptionPrim;
import fr.primaveraServeur.model.EtatPrim;
import fr.primaveraServeur.model.FichePrim;
import fr.primaveraServeur.model.PhotoPrim;
import fr.primaveraServeur.model.UserPrim;

public class FicheDaoTest {

	private static ClassPathXmlApplicationContext context;
	private static FicheDao ficheDao;
	private static UserDao userDao;
	private static EtatDao etatDao;
	private static DangerDao dangerDao;
	private static Integer idUser=4;
	private static Integer idetat=2;
	private static Integer idDanger=1;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context =new ClassPathXmlApplicationContext("spring/application-config.xml");
		ficheDao= (FicheDao) context.getBean("ficheDao");
		userDao= (UserDao) context.getBean("userDao");
		etatDao= (EtatDao) context.getBean("etatDao");
		dangerDao= (DangerDao) context.getBean("dangerDao");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}
	
	@Test
	public void testSave(){
		
		UserPrim userCreateur=userDao.findById(idUser);
		EtatPrim etat=etatDao.findById(idetat);
		DangerPrim danger=dangerDao.findById(idDanger);
		
		FichePrim fiche =new FichePrim(new Date(), "latitude Test2", "longitude Test2", "titre Test2", etat, userCreateur, danger);

		DescriptionPrim description=new DescriptionPrim(new Date(), "Description Test5tt", userCreateur);
		fiche.addDescriptionPrim(description);
		DescriptionPrim description1=new DescriptionPrim(new Date(), "Description Test6", userCreateur);
		fiche.addDescriptionPrim(description1);
		DescriptionPrim description2=new DescriptionPrim(new Date(), "Description Test7", userCreateur);
		fiche.addDescriptionPrim(description2);
		DescriptionPrim description3=new DescriptionPrim(new Date(), "Description Test8", userCreateur);
		fiche.addDescriptionPrim(description3);
		

		PhotoPrim photo=new PhotoPrim("LienPhoto Test16");
		fiche.addPhotoPrim(photo);
		PhotoPrim photo1=new PhotoPrim("LienPhoto Test17");
		fiche.addPhotoPrim(photo1);
		PhotoPrim photo2=new PhotoPrim("LienPhoto Test18");
		fiche.addPhotoPrim(photo2);
		
		ficheDao.save(fiche);
		assertNotNull(fiche.getIdfiche());
	}	
	
	@Test
	public void testFindAll() {
		List<FichePrim> listFiche=ficheDao.findAll();
		assertNotNull(listFiche);
		assertTrue(listFiche.size() > 0);
		System.out.println("testFindAll: "+listFiche);
	}
	
	@Test
	public void testFindById(){
		FichePrim fiche=ficheDao.findById(1);
		assertNotNull(fiche);
		System.out.println("testFindById: "+fiche);
	}
	
	@Test
	public void testFindAllByUser(){
		UserPrim user=userDao.findById(idUser);
		List<FichePrim> listFicheByUser=ficheDao.findAllByUserHisto(user);
		assertNotNull(listFicheByUser);
		assertTrue(listFicheByUser.size() >= 0);
		System.out.println("testFindAllByUser: "+listFicheByUser);
	}
	
	@Test
	public void testFindAllByEtat(){
		EtatPrim etat=etatDao.findById(idetat);
		List<FichePrim> listFicheByEtat=ficheDao.findAllByEtat(etat);
		assertNotNull(listFicheByEtat);
		assertTrue(listFicheByEtat.size() > 0);
		System.out.println("testFindAllByEtat: "+listFicheByEtat);
	}
	
	@Test
	public void testFindAllByDanger(){
		DangerPrim danger=dangerDao.findById(idDanger);
		List<FichePrim> listFicheByEtat=ficheDao.findAllByDanger(danger);
		assertNotNull(listFicheByEtat);
		assertTrue(listFicheByEtat.size() > 0);
		System.out.println("testFindAllByEtat: "+listFicheByEtat);
	}
	
}
