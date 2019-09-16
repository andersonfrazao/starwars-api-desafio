package com.starwars.response;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ResponsePeople {
	
	private String name;
	private String birth_year;
	private List<String> films;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirth_year() {
		return birth_year;
	}
	public void setBirth_year(String birth_year) {
		this.birth_year = birth_year;
	}
	public List<String> getFilms() {
		return films;
	}
	public void setFilms(List<String> films) {
		this.films = films;
	}
	

}
