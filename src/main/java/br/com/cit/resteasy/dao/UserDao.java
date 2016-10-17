package br.com.cit.resteasy.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.cit.resteasy.bean.LoginDTO;
import br.com.cit.resteasy.bean.User;
import br.com.cit.resteasy.dao.generic.RedisFacade;

@Repository
public class UserDao {
	@Autowired
	private RedisFacade redisFacade;

	public void create(User user) {
		redisFacade.set("USER:" + user.getEmail(), user);
	}

	public void createAccountUser(LoginDTO loginDTO) {
		redisFacade.set("LOGINDTO:" + loginDTO.getEmail(), loginDTO);
	}

	public User findById(String email) {
		return redisFacade.get("USER:" + email, User.class);
	}

	public LoginDTO findByEmail(String email) {
		return redisFacade.get("LOGINDTO:" + email, LoginDTO.class);
	}
}
