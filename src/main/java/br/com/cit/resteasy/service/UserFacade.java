package br.com.cit.resteasy.service;


import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
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

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/create")
	public Response create(@Valid User user) {
		userService.create(user);
		return Response.status(Status.OK).entity(user).build();

	}
}
