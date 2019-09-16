package com.starwars.controller;

import org.springframework.web.client.RestTemplate;

public class TestCallRestSpring {

	public static void main(String[] args) {
		final String uri = "https://swapi.co/api/people/";
	     
	    RestTemplate restTemplate = new RestTemplate();
	     
	    String result = restTemplate.getForObject(uri, String.class);
		/*
		 * HttpHeaders headers = new HttpHeaders();
		 * headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		 * HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		 * 
		 * ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET,
		 * entity, String.class);
		 */
	     
	    System.out.println(result);

	}

}
