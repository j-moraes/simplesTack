package br.com.cit.resteasy.bean;

import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import br.com.cit.resteasy.bean.OpeanWeatherResponse.WeatherBean.ForecastBean;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OpeanWeatherResponse {

	@JsonProperty(value = "weather")
	private List<WeatherBean> weathers;

	@JsonProperty(value = "main")
	private ForecastBean forecast;

	/**
	 * @return the weathers
	 */
	public List<WeatherBean> getWeathers() {
		return weathers;
	}

	/**
	 * @param weathers
	 *            the weathers to set
	 */
	public void setWeathers(List<WeatherBean> weathers) {
		this.weathers = weathers;
	}

	/**
	 * @return the forecast
	 */
	public ForecastBean getForecast() {
		return forecast;
	}

	/**
	 * @param forecast
	 *            the forecast to set
	 */
	public void setForecast(ForecastBean forecast) {
		this.forecast = forecast;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class WeatherBean {

		private Long id;
		private String description;

		/**
		 * @return the id
		 */
		public Long getId() {
			return id;
		}

		/**
		 * @param id
		 *            the id to set
		 */
		public void setId(Long id) {
			this.id = id;
		}

		/**
		 * @return the description
		 */
		public String getDescription() {
			return description;
		}

		/**
		 * @param description
		 *            the description to set
		 */
		public void setDescription(String description) {
			this.description = description;
		}

		@JsonIgnoreProperties(ignoreUnknown = true)
		public static class ForecastBean {
			private Double temp;

			/**
			 * @return the temp
			 */
			public Double getTemp() {
				return temp;
			}

			/**
			 * @param temp
			 *            the temp to set
			 */
			public void setTemp(Double temp) {
				this.temp = temp;
			}

		}
	}
}
