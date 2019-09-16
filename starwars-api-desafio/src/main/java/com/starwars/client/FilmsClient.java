package com.starwars.client;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.starwars.helper.AbstractClient;
import com.starwars.model.Film;

@Component
public class FilmsClient extends AbstractClient {
	
	
	
	public Film getFilm(String uri) {
		
		RestTemplate restTemplate = new RestTemplate();
		
		ResponseEntity<Film> respFilm =
				restTemplate.exchange(uri,  HttpMethod.GET,
						geraHeader(), Film.class);
		
		
		Film film  = respFilm.getBody();
		
		return film;
	}

}
