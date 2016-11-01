package br.com.cit.resteasy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cit.resteasy.bean.LoginDTO;
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

	public LoginDTO login(String email, String senha) {
		final LoginDTO loginDTO = userDao.findByEmail(email);

		if (!senha.equals(loginDTO.getSenha())) {
			throw new IllegalArgumentException("Usuário e/ou senha inválidos");
		}
		return loginDTO;
	}

	public User findById(String email) {
		return userDao.findById(email);
	}

	public LoginDTO findByEmail(String email) {
		return userDao.findByEmail(email);
	}

}
