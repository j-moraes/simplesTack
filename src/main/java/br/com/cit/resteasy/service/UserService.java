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
			throw new IllegalArgumentException("Campo e-mail obrigat�rio");
		}
		if (StringUtils.isBlank(user.getNome())) {
			throw new IllegalArgumentException("Campo nome obrigat�rio");
		}
		if (StringUtils.isBlank(user.getSobrenome())) {
			throw new IllegalArgumentException("Campo sobrenome obrigat�rio");
		}
		if (StringUtils.isBlank(user.getSenha())) {
			throw new IllegalArgumentException("Campo senha obrigat�rio");
		}
		if (StringUtils.isBlank(user.getPais())) {
			throw new IllegalArgumentException("Campo pa�s obrigat�rio");
		}
		if (StringUtils.isBlank(user.getCidade())) {
			throw new IllegalArgumentException("Campo cidade obrigat�rio");
		}
		if (StringUtils.isBlank(user.getEstado())) {
			throw new IllegalArgumentException("Campo estado obrigat�rio");
		}
		final User existingUser = userDao.findById(user.getEmail());
		if (existingUser != null) {
			throw new IllegalArgumentException("J� existe um usu�rio cadastrado com esse e-mail");
		}
		userDao.create(user);
	}

}
