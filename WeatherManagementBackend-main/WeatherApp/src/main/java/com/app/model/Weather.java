package com.app.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="weatherdata")

public class Weather {
	@Id
	private String city;
	private String temperature;
	private String humidity;
	private String pressure;
	private String sunrise;
	private String sunset;
	private String geocoords;
	@Override
	public int hashCode() {
		return Objects.hash(city, geocoords, humidity, pressure, sunrise, sunset, temperature);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Weather other = (Weather) obj;
		return Objects.equals(city, other.city) && Objects.equals(geocoords, other.geocoords)
				&& Objects.equals(humidity, other.humidity) && Objects.equals(pressure, other.pressure)
				&& Objects.equals(sunrise, other.sunrise) && Objects.equals(sunset, other.sunset)
				&& Objects.equals(temperature, other.temperature);
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getTemperature() {
		return temperature;
	}
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}
	public String getHumidity() {
		return humidity;
	}
	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}
	public String getPressure() {
		return pressure;
	}
	public void setPressure(String pressure) {
		this.pressure = pressure;
	}
	public String getSunrise() {
		return sunrise;
	}
	public void setSunrise(String sunrise) {
		this.sunrise = sunrise;
	}
	public String getSunset() {
		return sunset;
	}
	public void setSunset(String sunset) {
		this.sunset = sunset;
	}
	public String getGeocoords() {
		return geocoords;
	}
	public void setGeocoords(String geocoords) {
		this.geocoords = geocoords;
	}

}
