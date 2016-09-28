package br.com.cit.resteasy.service;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.cit.resteasy.bean.Greeting;
import br.com.cit.resteasy.bean.OpeanWeatherResponse;
import br.com.cit.resteasy.bean.User;

@Component
@Path("/home")
public class WeatherFacade {

	@Autowired
	private UserService userService;

	@Autowired
	private WeatherService weatherService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response home(@CookieParam(value = "loggedIn") boolean loggedIn, @CookieParam(value = "id") String email) {
		if (!loggedIn || StringUtils.isBlank(email)) {
			final Map<String, String> result = new HashMap<String, String>();
			result.put("Erro", "Usuário não está logado.");
			return Response.status(Status.UNAUTHORIZED).entity(result).build();
		}
		final User user = userService.findById(email);

		if (user == null) {
			final Map<String, String> result = new HashMap<String, String>();
			result.put("Erro", "Usuário não está logado");
			return Response.status(Status.UNAUTHORIZED).entity(result).build();
		}

		final OpeanWeatherResponse response = weatherService.obtainCorrentWeather(user.getCidade(), user.getPais(),
				"pt");

		final Greeting greeting = new Greeting(user.getNome(), response.getWeathers().get(0).getDescription(),
				"Olá " + user.getNome() + "! Atualmente a previsão diz: "
						+ response.getWeathers().get(0).getDescription() + " com temperatura de "
						+ response.getForecast().getTemp() + "º.");

		return Response.status(Status.OK).entity(greeting).build();
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public WeatherService getWeatherService() {
		return weatherService;
	}

	public void setWeatherService(WeatherService weatherService) {
		this.weatherService = weatherService;
	}
}
