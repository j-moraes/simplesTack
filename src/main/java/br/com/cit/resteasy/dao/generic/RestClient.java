package br.com.cit.resteasy.dao.generic;

import java.util.Map;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

@Component
public class RestClient {

	public <T> T doGet(String url, Map<String, Object> queryParams, Class<T> clazz) {
		final Client client = ClientBuilder.newBuilder().build();
		WebTarget target = client.target(url);
		if (queryParams != null) {
			for (final String key : queryParams.keySet()) {
				target = target.queryParam(key, queryParams.get(key));
			}
		}
		final Response response = target.request().get();
		final T resp = response.readEntity(clazz);
		response.close();
		return resp;
	}
}
