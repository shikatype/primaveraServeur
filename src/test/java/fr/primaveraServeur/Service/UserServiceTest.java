package fr.primaveraServeur.Service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.primaveraServeur.model.UserPrim;
import fr.primaveraServeur.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/application-config.xml"})
public class UserServiceTest {

	@Autowired
	UserService userService;
	
	@Test
	public void testConnection() {
		UserPrim user=userService.connection("addresseMail3", "motDePasse3");
		assertNotNull(user);
		assertEquals(user.getAddresseMail(),"addresseMail3");
		assertEquals(user.getMdp(), "motDePasse3");
		
	}

}
