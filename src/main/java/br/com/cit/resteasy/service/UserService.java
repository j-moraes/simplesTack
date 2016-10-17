package br.com.cit.resteasy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cit.resteasy.bean.User;
import br.com.cit.resteasy.dao.UserDao;
import br.com.cit.resteasy.exceptions.BusinessException;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	public void create(User user) {
		final User existingUser = userDao.findById(user.getEmail());
		if (existingUser != null) {
			throw new BusinessException("Já existe um usuário cadastrado com esse e-mail");
		}
		userDao.create(user);
	}

	public User findById(String email) {
		return userDao.findById(email);
	}
}
