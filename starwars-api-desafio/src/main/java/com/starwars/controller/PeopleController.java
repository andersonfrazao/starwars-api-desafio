package com.starwars.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.starwars.client.PeopleClient;
import com.starwars.helper.ObjectComparator;
import com.starwars.model.People;
import com.starwars.response.ResponseHuman;
import com.starwars.response.ResponsePeople;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class PeopleController  {
	
	static final String URL_STARWARS_PEOPLE_HEADER ="https://swapi.co/api/people";
	static final String URL_STARWARS_PEOPLE 	   ="https://swapi.co/api/people/";
	
	@Autowired
	PeopleClient peopleClient;
	
	@ApiOperation(value = "Lista todas as Pessoas", notes = "Lista todas as Pessoas", response = People.class, responseContainer = "List" )
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Pessoas Listadas com sucesso"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
		    @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
		    @ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	
	@GetMapping("/starwars/people/")
	@ResponseBody
	public List<People> getAllStarWarsPeople() throws JsonProcessingException {
		
		System.out.println(">>>>>>");
		
		List allPeople = peopleClient.getAll();
		/*
		 * List<People> list = new ArrayList<People>(allPeople);
		 * list.sort(Comparator.comparing(People::getAmount_films).reversed());
		 */
		
		Collections.sort(allPeople, new ObjectComparator().reversed());
		
		 //ObjectMapper obj = new ObjectMapper();
		// String all=  obj.writeValueAsString(allPeople);
		

		
		return allPeople;
	}
	
	@ApiOperation(value = "Consulta de Pessoa pelo ID e os filmes que participou ", notes = "Consulta de Pessoa pelo ID e os filmes que participou", response = ResponsePeople.class, responseContainer = "Object" )
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Pessoa consultada com sucesso"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
		    @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
		    @ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping("/starwars/people/{id}")
	@ResponseBody
	public ResponsePeople getOne(@PathVariable Long id) throws JsonProcessingException {
	
		System.out.println(">>>>FIND ONE>>>>");
		ResponsePeople people = peopleClient.getOne(id);
		
		/*
		 * ObjectMapper obj = new ObjectMapper(); String p =
		 * obj.writeValueAsString(people);
		 */
		
		return people;
	}
	
	@ApiOperation(value = "Lista de todos o Humanos com a media de peso ", notes = "Lista de todos o Humanos com a media de peso", response = ResponseHuman.class, responseContainer = "List" )
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Humanos listados com sucesso"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
		    @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
		    @ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping("/starwars/people/human")
	@ResponseBody
	public ResponseHuman getHuman() throws JsonProcessingException {
	
		System.out.println(">>>>FIND HUMAN>>>>");
		ResponseHuman responseHuman = peopleClient.getHuman();
		
		/*
		 * ObjectMapper obj = new ObjectMapper(); String p =
		 * obj.writeValueAsString(people);
		 */
		
		return responseHuman;
	}
	
}
