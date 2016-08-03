package br.com.cit.resteasy.facade;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.stereotype.Component;

import br.com.cit.resteasy.bean.HelloBean;

@Component
@Path("/hello")
public class HelloWorldFacade {

	@GET
	@Produces("application/json")
	@Path("/world")
	public HelloBean teste() {
		final HelloBean bean = new HelloBean();
		bean.setText("Hello World!");
		return bean;
	}
}
