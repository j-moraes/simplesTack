package br.com.cit.resteasy.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.cit.resteasy.bean.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/applicationContext.xml")
public class UserServiceTest {

	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	@Test
	public void validateEmail() {
		expectedException.expect(IllegalArgumentException.class);
		expectedException.expectMessage("Campo e-mail obrigatório");
		final User user = new User();
		user.setEmail("test@test.com");
		UserService userService = new UserService();
		userService.create(user);
		assertNotNull(user.getEmail());
	}

}
