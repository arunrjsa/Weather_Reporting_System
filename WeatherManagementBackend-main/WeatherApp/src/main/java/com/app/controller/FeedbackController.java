package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Feedback;
import com.app.weather.service.FeedbackService;




@RestController
@RequestMapping("/feedback")
@CrossOrigin(origins="http://localhost:4200")
public class FeedbackController {
	
	@Autowired
	private FeedbackService serve;

	@GetMapping("/demo")
	public String getWeather() {
		return "Nice app";
	}
	
	@GetMapping("/all")
	public List<Feedback> list() {
		return serve.listAll();
	}
	
	@PostMapping("/all")
	public void add(@RequestBody Feedback feedback) {
		serve.save(feedback);
	}

}
