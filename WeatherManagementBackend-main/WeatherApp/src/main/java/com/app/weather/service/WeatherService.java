package com.app.weather.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.Weather;
import com.app.repo.WeatherRepository;

@Service
public class WeatherService {

	@Autowired
	private WeatherRepository repo;

	public List<Weather> listAll() {
		return repo.findAll();
	}

	public void save(Weather weather) {
		repo.save(weather);
	}

	public Weather get(String city) {
		return repo.findById(city).get();
	}

	public void delete(String city) {
		repo.deleteById(city);
	}
}
