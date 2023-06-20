package com.app.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Weather;
import com.app.repo.WeatherRepository;
import com.app.weather.service.WeatherService;




@RestController
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:4200")
public class WeatherController {
	@Autowired
	private WeatherRepository repo;
	
	@Autowired
	private WeatherService service;
	@GetMapping("/weatherr")
	public ResponseEntity<List<Weather>> getWeatherByName(@RequestParam String city){
		return new ResponseEntity<List<Weather>>(repo.findByCity(city), HttpStatus.OK);
	}
	

	@GetMapping("/today")
	public String getWeather() {
		return "Today is cool";
	}
	
	

	/*@GetMapping("/weatherr")
	public List<Weather> list() {
		return service.listAll();
	}*/
	
	@GetMapping("/weatherr/{city}")
	public ResponseEntity<Weather> get(@PathVariable String city){
		try {
			Weather weather = service.get(city);
			return new ResponseEntity<Weather>(weather, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Weather>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/weatherr")
	public void add(@RequestBody Weather weather) {
		service.save(weather);
	}

	@PutMapping("/weatherr/{city}")
	public ResponseEntity<?> update(@RequestBody Weather weather, @PathVariable String city) {
		try {
			Weather existweather = service.get(city);
			service.save(weather);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/weatherr/{city}")
	public void delete(@PathVariable String city) {
		service.delete(city);
	}
}
	

