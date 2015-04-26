package fr.primaveraServeur.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.primaveraServeur.model.RolePrim;
import fr.primaveraServeur.model.ServicePrim;

public class RoleDaoTest {

	private static ClassPathXmlApplicationContext context;
	private static RoleDao roleDao;
	private static String roleName="role test11";
	private static ServiceDao serviceDao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context =new ClassPathXmlApplicationContext("spring/application-config.xml");
		roleDao= (RoleDao) context.getBean("roleDao");
		serviceDao= (ServiceDao) context.getBean("serviceDao");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}
	
	@Test
	public void testSave(){
		ServicePrim service=serviceDao.findByName("Service Test1");
		RolePrim role =new RolePrim(roleName);
		role.addService(service);
		service=serviceDao.findByName("Service Test2");
		role.addService(service);
		roleDao.save(role);
		assertNotNull(role.getIdrole());
	}	
	
	@Test
	public void testFindAll() {
		List<RolePrim> listRole=roleDao.findAll();
		assertNotNull(listRole);
		assertTrue(listRole.size() > 0);
		System.out.println("testFindAll: "+listRole);
	}
	
	@Test
	public void testFindById(){
		//recupération du role de la base avec name
		RolePrim role=roleDao.findByName(roleName);
		assertNotNull(role);
		int idrole=role.getIdrole();
		//recuperation du role de la base avec id
		role=roleDao.findById(idrole);
		assertNotNull(role);
		System.out.println("testFindById: "+role);
	}
	
	@Test
	public void testFindByName(){
		RolePrim role=roleDao.findByName(roleName);
		assertNotNull(role);
		System.out.println("testFindByName: "+role);
	}

	@Test
	public void testDelete(){
		//recupération du role de la base
		RolePrim role=roleDao.findByName(roleName);
		assertNotNull(role);
		//suppression du role dans la base
		roleDao.delete(role);
	}
	
}
