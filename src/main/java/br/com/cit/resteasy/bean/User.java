package br.com.cit.resteasy.bean;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class User {

	@NotEmpty(message = "Campo nome é obrigatório")
	@Length(min = 3, max = 50, message = "Campo nome precisa ter entre 3 e 50 caracteres")
	private String nome;

	@NotEmpty(message = "Campo sobrenome é obrigatório")
	@Length(min = 3, max = 50, message = "Campo sobrenome precisa ter entre 3 e 50 caracteres")
	private String sobrenome;

	@Pattern(regexp = "\\b[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}\\b", message = "E-mail inválido")
	private String email;

	@Length(min = 3, max = 50, message = "Campo senha precisa ter entre 6 e 50 caracteres")
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-zA-Z])([a-zA-Z0-9]+)$", message = "Campo senha deve ter ao menos 1 letra e 1 número")
	private String senha;

	@NotEmpty(message = "Campo país é obrigatório")
	@Length(min = 2, max = 2, message = "O campo país tem que ser uma sigla de 2 caracteres")
	private String pais;

	@NotEmpty(message = "Campo estado é obrigatório")
	@Length(min = 2, max = 2, message = "O campo estado tem que ser uma sigla de 2 caracteres")
	private String estado;

	@NotEmpty(message = "Campo cidade é obrigatório")
	private String cidade;

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome
	 *            the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the sobrenome
	 */
	public String getSobrenome() {
		return sobrenome;
	}

	/**
	 * @param sobrenome
	 *            the sobrenome to set
	 */
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

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

	/**
	 * @return the pais
	 */
	public String getPais() {
		return pais;
	}

	/**
	 * @param pais
	 *            the pais to set
	 */
	public void setPais(String pais) {
		this.pais = pais;
	}

	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estado
	 *            the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * @return the cidade
	 */
	public String getCidade() {
		return cidade;
	}

	/**
	 * @param cidade
	 *            the cidade to set
	 */
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

}
