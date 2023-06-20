package com.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.model.Weather;
@Repository
public interface WeatherRepository extends JpaRepository<Weather, String>{
	List<Weather> findByCity(String city);

}
