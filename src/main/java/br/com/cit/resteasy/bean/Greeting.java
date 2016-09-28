package br.com.cit.resteasy.bean;

public class Greeting {
	private String userName;
	private String correntWeather;
	private String message;

	public Greeting() {

	}

	public Greeting(String userName, String correntWeather, String message) {
		this.userName = userName;
		this.correntWeather = correntWeather;
		this.message = message;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName
	 *            the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the correntWeather
	 */
	public String getCorrentWeather() {
		return correntWeather;
	}

	/**
	 * @param correntWeather
	 *            the correntWeather to set
	 */
	public void setCorrentWeather(String correntWeather) {
		this.correntWeather = correntWeather;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

}
