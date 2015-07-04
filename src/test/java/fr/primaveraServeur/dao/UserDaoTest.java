package fr.primaveraServeur.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.primaveraServeur.model.RolePrim;
import fr.primaveraServeur.model.UserPrim;

public class UserDaoTest {

	private static ClassPathXmlApplicationContext context;
	private static UserDao UserDao;
	private static String adresseMail="addresseMail";
	private static String motDePasse="motDePasse";
	private static RoleDao roleDao;
	private static String roleName="role test4";
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context =new ClassPathXmlApplicationContext("spring/application-config.xml");
		UserDao= (UserDao) context.getBean("userDao");
		roleDao= (RoleDao) context.getBean("roleDao");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}
	
	@Test
	public void testSave(){
		RolePrim role=roleDao.findByName(roleName);
		UserPrim user =new UserPrim(adresseMail, motDePasse);
		user.setRolePrim(role);
		UserDao.save(user);
		assertNotNull(user.getIduser());
	}	
	
	@Test
	public void testFindAll() {
		List<UserPrim> listUser=UserDao.findAll();
		assertNotNull(listUser);
		assertTrue(listUser.size() > 0);
		System.out.println("testFindAll: "+listUser);
	}
	
	@Test
	public void testFindById(){
		//recupération du user de la base avec name
		UserPrim user=UserDao.findByMail(adresseMail);
		assertNotNull(user);
		int idUser=user.getIduser();
		//recuperation du user de la base avec id
		user=UserDao.findById(idUser);
		assertNotNull(user);
		System.out.println("testFindById: "+user);
	}
	
	@Test
	public void testFindByMail(){
		UserPrim user=UserDao.findByMail(adresseMail);
		assertNotNull(user);
		System.out.println("testFindByMail: "+user);
	}
	
	@Test
	public void testFindByRole(){
		RolePrim role=roleDao.findByName("role test2");
		List<UserPrim> listUser=UserDao.findByRole(role);
		assertNotNull(listUser);
		assertTrue(listUser.size() > 0);
		System.out.println("testFindByRole: "+listUser);
	}

	@Test
	public void testDelete(){
		//recupération du user de la base
		UserPrim user=UserDao.findByMail(adresseMail);
		assertNotNull(user);
		//suppression du user dans la base
		UserDao.delete(user);
	}
	
}
