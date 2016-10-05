package br.com.cit.resteasy.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cit.resteasy.bean.OpeanWeatherResponse;
import br.com.cit.resteasy.dao.WeatherDao;
import br.com.cit.resteasy.dao.generic.RestClient;

@Service
public class WeatherService {

	@Autowired
	private WeatherDao weatherDao;

	@Autowired
	private RestClient restClient;

	public OpeanWeatherResponse obtainCorrentWeather(String city, String country, String language) {

		OpeanWeatherResponse resp = weatherDao.findById(city, country);

		if (resp != null) {
			return resp;
		}

		final Map<String, Object> queryParams = new HashMap<String, Object>();
		queryParams.put("q", city + "," + country);
		queryParams.put("lang", language);
		queryParams.put("units", "metric");

		queryParams.put("APPID", "fc4750874b77b91594759f539d615435");

		resp = restClient.doGet("http://api.openweathermap.org/data/2.5/weather", queryParams,
				OpeanWeatherResponse.class);
		if (resp != null) {
			weatherDao.create(city, country, resp);
		}
		return resp;
	}
}
