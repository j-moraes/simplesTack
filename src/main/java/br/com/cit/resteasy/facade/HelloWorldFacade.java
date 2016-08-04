package br.com.cit.resteasy.facade;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.stereotype.Component;

import br.com.cit.resteasy.bean.HelloBean;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Component
@Path("/hello")
public class HelloWorldFacade {
	private final JedisPool pool = new JedisPool(new JedisPoolConfig(), "localhost");

	private Integer countRedis() {
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
			final Object value = jedis.get("count");
			Integer count = 0;
			if (value != null) {
				count = Integer.parseInt(value.toString());
			}
			count++;
			jedis.set("count", count.toString());
			return count;
		} finally {
			if (jedis != null) {
				jedis.close();
			}
		}
	}

	@GET
	@Produces("application/json")
	@Path("/world")
	public HelloBean teste() {
		final HelloBean bean = new HelloBean();
		bean.setText("Hello World! Count: " + countRedis());
		return bean;
	}
}
