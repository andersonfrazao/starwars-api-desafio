package com.starwars.model;

import org.apache.tomcat.util.json.JSONParser;
import org.springframework.boot.json.GsonJsonParser;

import com.fasterxml.jackson.databind.ObjectMapper;

public class User {
	
	private String name;
	private String country;
	private String cpf;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String toJSON() {
		
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(this);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	

}
