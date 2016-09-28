package br.com.cit.resteasy.service;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.cit.resteasy.bean.User;

@Component
@Path("/user")
public class UserFacade {

	@Autowired
	private UserService userService;

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/login")
	public Response login(User user) {
		try {
			user = userService.login(user.getEmail(), user.getSenha());
			final NewCookie loginCookie = new NewCookie(new Cookie("loggedIn", "true", "/", null));
			final NewCookie idCookie = new NewCookie(new Cookie("id", user.getEmail(), "/", null));
			return Response.status(Status.OK).cookie(loginCookie).cookie(idCookie).build();
		} catch (final IllegalArgumentException arg) {
			final Map<String, String> result = new HashMap<String, String>();
			result.put("erro", arg.getMessage());
			final NewCookie loginCookie = new NewCookie(new Cookie("loggedIn", "false", "/", null));
			final NewCookie idCookie = new NewCookie(new Cookie("id", null, "/", null));
			return Response.status(Status.BAD_REQUEST).cookie(loginCookie).cookie(idCookie).entity(result).build();
		}
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/create")
	public Response create(User user) {
		try {
			userService.create(user);
			return Response.status(Status.OK).entity(user).build();
		} catch (final IllegalArgumentException arg) {
			final Map<String, String> result = new HashMap<String, String>();
			result.put("erro", arg.getMessage());
			return Response.status(Status.BAD_REQUEST).entity(result).build();
		}
	}
}
