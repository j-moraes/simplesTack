package br.com.cit.resteasy.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cit.resteasy.bean.User;
import br.com.cit.resteasy.dao.UserDao;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	public void create(User user) {
		if (StringUtils.isBlank(user.getEmail())) {
			throw new IllegalArgumentException("Campo e-mail obrigatório");
		}
		if (StringUtils.isBlank(user.getNome())) {
			throw new IllegalArgumentException("Campo nome obrigatório");
		}
		if (StringUtils.isBlank(user.getSobrenome())) {
			throw new IllegalArgumentException("Campo sobrenome obrigatório");
		}
		if (StringUtils.isBlank(user.getSenha())) {
			throw new IllegalArgumentException("Campo senha obrigatório");
		}
		if (StringUtils.isBlank(user.getPais())) {
			throw new IllegalArgumentException("Campo país obrigatório");
		}
		if (StringUtils.isBlank(user.getCidade())) {
			throw new IllegalArgumentException("Campo cidade obrigatório");
		}
		if (StringUtils.isBlank(user.getEstado())) {
			throw new IllegalArgumentException("Campo estado obrigatório");
		}
		final User existingUser = userDao.findById(user.getEmail());
		if (existingUser != null) {
			throw new IllegalArgumentException("Já existe um usuário cadastrado com esse e-mail");
		}
		userDao.create(user);
	}

}
