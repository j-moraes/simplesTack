package br.com.cit.resteasy.account;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.cit.resteasy.bean.LoginDTO;
import br.com.cit.resteasy.service.UserService;

@Component
@Path("/account")
public class LoginFacade {

	@Autowired
	private UserService userService;

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/login")
	public Response login(LoginDTO loginDTO) {
		loginDTO = userService.login(loginDTO.getEmail(), loginDTO.getSenha());
		final NewCookie loginCookie = new NewCookie(new Cookie("loggedIn", "true", "/", null));
		final NewCookie emailCookie = new NewCookie(new Cookie("email", loginDTO.getEmail(), "/", null));
		return Response.status(Status.OK).cookie(loginCookie).cookie(emailCookie).build();
	}

}
