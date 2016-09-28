package br.com.cit.resteasy.service;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.cit.resteasy.bean.OpeanWeatherResponse;

public class WeatherServiceTest {

	@Test
	public void obtainCorrentWeatherTest() {
		final WeatherService service = new WeatherService();
		final OpeanWeatherResponse resp = service.obtainCorrentWeather("Campinas", "br", "pt");
		assertNotNull(resp.getForecast());
		assertNotNull(resp.getForecast().getTemp());
		assertNotNull(resp.getWeathers().get(0).getDescription());
	}
}
