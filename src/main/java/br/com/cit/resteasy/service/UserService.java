package br.com.cit.resteasy.service;

import org.apache.commons.lang3.StringUtils;
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
			throw new BusinessException("J� existe um usu�rio cadastrado com esse e-mail");
		}
		userDao.create(user);
	}

	public User login(String email, String senha) {
		if (StringUtils.isBlank(email)) {
			throw new IllegalArgumentException("Campo e-mail obrigat�rio");
		}

		if (StringUtils.isBlank(senha)) {
			throw new IllegalArgumentException("Campo senha obrigat�rio");
		}

		final User user = userDao.findById(email);
		if (!senha.equals(user.getSenha())) {
			throw new IllegalArgumentException("Usu�rio e/ou senha inv�lido(s)");
		}

		return user;
	}

	public User findById(String email) {
		return userDao.findById(email);
	}
}
