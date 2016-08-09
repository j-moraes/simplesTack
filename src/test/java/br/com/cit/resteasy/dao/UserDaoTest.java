package br.com.cit.resteasy.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.cit.resteasy.bean.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/applicationContext.xml")
public class UserDaoTest {

	@Autowired
	private UserDao userDao;

	@Test
	public void teste() throws JsonGenerationException, JsonMappingException, IOException {
		final User user = new User();
		user.setEmail("teste@teste.com");
		user.setNome("teste");
		user.setSenha("123456");
		userDao.create(user);
		User userFound = userDao.findById("teste@teste.com");
		assertNotNull(userFound);
		assertEquals("teste@teste.com", userFound.getEmail());
		assertEquals("teste", userFound.getNome());
		assertEquals("123456", userFound.getSenha());
		userFound = userDao.findById("xpto@xpto");
		assertNull(userFound);
	}
}
