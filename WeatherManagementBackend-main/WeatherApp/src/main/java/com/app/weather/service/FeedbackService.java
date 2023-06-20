package com.app.weather.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.Feedback;
import com.app.repo.FeedbackRepository;


@Service
public class FeedbackService {
	@Autowired
	private FeedbackRepository feed;

	public List<Feedback> listAll() {
		return feed.findAll();
	}
	public void save(Feedback feedback) {
		feed.save(feedback);
	}
}


