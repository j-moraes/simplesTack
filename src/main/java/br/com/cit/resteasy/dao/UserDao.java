package br.com.cit.resteasy.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.cit.resteasy.bean.User;
import br.com.cit.resteasy.dao.generic.RedisFacade;

@Repository
public class UserDao {
	@Autowired
	private RedisFacade redisFacade;

	public void create(User user) {
		redisFacade.set("USER:" + user.getEmail(), user);
	}

	public User findById(String email) {
		return redisFacade.get("USER:" + email, User.class);
	}

}
