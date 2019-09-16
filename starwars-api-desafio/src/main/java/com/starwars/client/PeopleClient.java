package com.starwars.client;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.starwars.helper.AbstractClient;
import com.starwars.model.Film;
import com.starwars.model.People;
import com.starwars.model.PeopleHeader;
import com.starwars.response.ResponseHuman;
import com.starwars.response.ResponsePeople;

@Component
public class PeopleClient  extends AbstractClient{
	
	static final String URL_STARWARS_PEOPLE_HEADER ="https://swapi.co/api/people";
	static final String URL_STARWARS_PEOPLE 	   ="https://swapi.co/api/people/";
	
	@Autowired
	ResponseHuman responseHuman;
	@Autowired
	ResponsePeople responsePeople;
		
	@Autowired		
	FilmsClient filmsClient;		
	
	public List<People> getAll(){
		
		RestTemplate restTemplate = new RestTemplate();



		ResponseEntity<PeopleHeader> response =
				restTemplate.exchange(URL_STARWARS_PEOPLE_HEADER,  HttpMethod.GET,
						geraHeader(), PeopleHeader.class);

		PeopleHeader result = response.getBody();

		//System.out.println(result);
		
		
		List<People> peopleList = new ArrayList<People>();
		for (int i = 1; i <= result.getCount() ; i++) {
			String urlItem = URL_STARWARS_PEOPLE;
			try {
			 urlItem += +i+"/";
			//People people = new People();
			
			restTemplate = new RestTemplate();
			
			System.out.println("url "+i+": "+ urlItem);
			ResponseEntity<People> resp =
					restTemplate.exchange(urlItem,  HttpMethod.GET,
							geraHeader(), People.class);
			
			
			People people  =resp.getBody();
			people.setAmount_films(people.getFilms().size());
			peopleList.add(people);
			}catch (Exception e) {
				System.out.println("url fora do ar! ");
				System.out.println("url: " +urlItem);
			}
			
		}
		
		return peopleList;
		
	}
	
	public ResponsePeople getOne(Long id) {
		
		String urlPeople = URL_STARWARS_PEOPLE +id+"/";
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<People> resp =
				restTemplate.exchange(urlPeople,  HttpMethod.GET,
						geraHeader(), People.class);
		
		
		People people  =resp.getBody();
		
		List<String> nameFilms = new ArrayList<String>();
		for( Object o : people.getFilms()) {
			String urlFilm = (String)o;
			Film film = filmsClient.getFilm(urlFilm);
			nameFilms.add(film.getTitle());
		}
		
		responsePeople.setName(people.getName());
		responsePeople.setBirth_year(people.getBirth_year());
		responsePeople.setFilms(nameFilms);
		
		
		
		return responsePeople;
		
	}
	
	public ResponseHuman getHuman(){
		
		List<People> all = this.getAll();
		
		double height = 0;
		int count = 1;
		List<People> allHuman = new ArrayList<>();
		for (People people : all) {
			System.out.println(people.getName()+": "+people.getGender());
			if(!"n/a".equals(people.getGender()) && !"none".equals(people.getGender())) {
				allHuman.add(people);
				if(!"unknown".equals(people.getHeight())){
					height += Double.valueOf(people.getHeight()).doubleValue();
					count++;
				}
				
				
			}
		}
		
		System.out.println(height);
		System.out.println(count);
		
		double media = height /count;
		
		responseHuman.setListPeople(allHuman);
		responseHuman.setMedia(media);
		
		return responseHuman;
	}
	
	

}
