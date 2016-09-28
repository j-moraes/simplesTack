package br.com.cit.resteasy.service;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cit.resteasy.bean.OpeanWeatherResponse;
import br.com.cit.resteasy.dao.WeatherDao;

@Service
public class WeatherService {

	@Autowired
	private WeatherDao weatherDao;

	public OpeanWeatherResponse obtainCorrentWeather(String city, String country, String language) {

		OpeanWeatherResponse resp = weatherDao.findById(city, country);

		if (resp != null) {
			return resp;
		}

		final Client client = ClientBuilder.newBuilder().build();

		final WebTarget target = client.target("http://api.openweathermap.org/data/2.5/weather")
				.queryParam("q", city + "," + country).queryParam("lang", language).queryParam("units", "metric")
				.queryParam("APPID", "fc4750874b77b91594759f539d615435");

		final Response response = target.request().get();
		resp = response.readEntity(OpeanWeatherResponse.class);
		response.close();

		if (resp != null) {
			weatherDao.create(city, country, resp);
		}
		return resp;
	}
}
