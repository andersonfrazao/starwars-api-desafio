package com.starwars.model;

import java.util.List;

public class People {
	
	
	private String name;
	private String height;
	private String mass;
	private String hair_color;
	private String skin_color;
	private String eye_color;
	private String birth_year;
	private String gender;
	private String homeworld;
	private String created;
	private String edited;
	private String url;
	private Integer amount_films;
	
	private List films;
	private List species;
	private List vehicles;
	private List starships;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getMass() {
		return mass;
	}
	public void setMass(String mass) {
		this.mass = mass;
	}
	public String getHair_color() {
		return hair_color;
	}
	public void setHair_color(String hair_color) {
		this.hair_color = hair_color;
	}
	public String getSkin_color() {
		return skin_color;
	}
	public void setSkin_color(String skin_color) {
		this.skin_color = skin_color;
	}
	public String getEye_color() {
		return eye_color;
	}
	public void setEye_color(String eye_color) {
		this.eye_color = eye_color;
	}
	public String getBirth_year() {
		return birth_year;
	}
	public void setBirth_year(String birth_year) {
		this.birth_year = birth_year;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getHomeworld() {
		return homeworld;
	}
	public void setHomeworld(String homeworld) {
		this.homeworld = homeworld;
	}
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	public String getEdited() {
		return edited;
	}
	public void setEdited(String edited) {
		this.edited = edited;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getAmount_films() {
		return amount_films;
	}
	public void setAmount_films(Integer amount_films) {
		this.amount_films = amount_films;
	}
	public List getFilms() {
		return films;
	}
	public void setFilms(List films) {
		this.films = films;
	}
	public List getSpecies() {
		return species;
	}
	public void setSpecies(List species) {
		this.species = species;
	}
	public List getVehicles() {
		return vehicles;
	}
	public void setVehicles(List vehicles) {
		this.vehicles = vehicles;
	}
	public List getStarships() {
		return starships;
	}
	public void setStarships(List starships) {
		this.starships = starships;
	}
	
	
	

}
