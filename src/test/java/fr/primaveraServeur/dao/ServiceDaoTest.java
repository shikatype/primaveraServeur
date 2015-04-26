package fr.primaveraServeur.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.primaveraServeur.model.ServicePrim;

public class ServiceDaoTest {

	private static ClassPathXmlApplicationContext context;
	private static ServiceDao serviceDao;
	private static String serviceName="Service Test";
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context =new ClassPathXmlApplicationContext("spring/application-config.xml");
		serviceDao= (ServiceDao) context.getBean("serviceDao");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}
	
	@Test
	public void testSave(){
		ServicePrim service =new ServicePrim(serviceName);
		serviceDao.save(service);
		assertNotNull(service.getIdservice());
	}	
	
	@Test
	public void testFindAll() {
		List<ServicePrim> listService=serviceDao.findAll();
		assertNotNull(listService);
		assertTrue(listService.size() > 0);
		System.out.println("testFindAll: "+listService);
	}
	
	@Test
	public void testFindById(){
		//recupération du service de la base avec name
		ServicePrim service=serviceDao.findByName(serviceName);
		assertNotNull(service);
		int idservice=service.getIdservice();
		//recuperation du service de la base avec id
		service=serviceDao.findById(idservice);
		assertNotNull(service);
		System.out.println("testFindById: "+service);
	}
	
	@Test
	public void testFindByName(){
		ServicePrim service=serviceDao.findByName(serviceName);
		assertNotNull(service);
		System.out.println("testFindByName: "+service);
	}

	@Test
	public void testDelete(){
		//recupération du service de la base
		ServicePrim service=serviceDao.findByName(serviceName);
		assertNotNull(service);
		//suppression du service dans la base
		serviceDao.delete(service);
	}
	
}
