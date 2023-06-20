package com.app.weather.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
	@Autowired
    private JavaMailSender mailsender;

    public void sendSimpleEmail(String toEmail, String body, String subject) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom("forecastweather@800gmail.com");
        msg.setTo(toEmail);
        msg.setText(body);
        msg.setSubject(subject);
        mailsender.send(msg);
    }
    }


