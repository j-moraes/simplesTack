package br.com.cit.resteasy.dao.generic;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Component;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.util.SafeEncoder;

@Component
public class RedisFacade {
	private final JedisPool pool = new JedisPool(new JedisPoolConfig(), "localhost");

	public void set(String key, Object object) {
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
			final ObjectMapper mapper = new ObjectMapper();
			jedis.set(SafeEncoder.encode(key), SafeEncoder.encode(mapper.writeValueAsString(object)));
		} catch (final Exception e) {
			e.printStackTrace();
		} finally {
			if (jedis != null) {
				jedis.close();
			}
		}
	}

	public <T> T get(String key, Class<T> clazz) {
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
			final Object value = jedis.get(key);
			if (value != null) {
				final ObjectMapper mapper = new ObjectMapper();
				final T result = mapper.readValue(value.toString(), clazz);
				return result;
			}
		} catch (final Exception e) {
			e.printStackTrace();
		} finally {
			if (jedis != null) {
				jedis.close();
			}
		}
		return null;
	}
}
