package br.com.cit.resteasy.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.cit.resteasy.bean.OpeanWeatherResponse;
import br.com.cit.resteasy.dao.generic.RedisFacade;

@Repository
public class WeatherDao {

	@Autowired
	private RedisFacade redisFacade;

	public void create(String city, String country, OpeanWeatherResponse weather) {
		redisFacade.set(country + ":" + city, weather, 300);
	}

	public OpeanWeatherResponse findById(String city, String country) {
		return redisFacade.get(country + ":" + city, OpeanWeatherResponse.class);
	}
}
