package com.starwars.response;

import java.util.List;

import org.springframework.stereotype.Component;

import com.starwars.model.People;

@Component
public class ResponseHuman {
	
	
	private Double media;
	
	
	private List<People> listPeople;
	
	

	public Double getMedia() {
		return media;
	}

	public void setMedia(Double media) {
		this.media = media;
	}
	
	public List<People> getListPeople() {
		return listPeople;
	}

	public void setListPeople(List<People> listPeople) {
		this.listPeople = listPeople;
	}


	
	
	

}
