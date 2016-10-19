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
			throw new BusinessException("Já existe um usuário cadastrado com esse e-mail");
		}
		userDao.create(user);
	}

	public User login(String email, String senha) {
		if (StringUtils.isBlank(email)) {
			throw new IllegalArgumentException("Campo e-mail obrigatório");
		}

		if (StringUtils.isBlank(senha)) {
			throw new IllegalArgumentException("Campo senha obrigatório");
		}

		final User user = userDao.findById(email);
		if (!senha.equals(user.getSenha())) {
			throw new IllegalArgumentException("Usuário e/ou senha inválido(s)");
		}

		return user;
	}

	public User findById(String email) {
		return userDao.findById(email);
	}
}
