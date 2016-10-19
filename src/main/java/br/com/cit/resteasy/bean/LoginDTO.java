package br.com.cit.resteasy.bean;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

public class LoginDTO {

	@Pattern(regexp = "\\b[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}\\b", message = "E-mail inválido")
	private String email;

	@Length(min = 3, max = 50, message = "Campo senha precisa ter entre 6 e 50 caracteres")
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-zA-Z])([a-zA-Z0-9]+)$", message = "Campo senha deve ter ao menos 1 letra e 1 número")
	private String senha;

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the senha
	 */
	public String getSenha() {
		return senha;
	}

	/**
	 * @param senha
	 *            the senha to set
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}

}
