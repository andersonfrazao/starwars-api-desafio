package com.starwars.client;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.starwars.model.User;

@Component
public class UsersClient {
	
	
	public String convertUser2Json() {
		
		User user = new User();
		User user1 = new User();
		List<User> users = new ArrayList<User>();
		
		user.setName("Lucas");
		user.setCountry("Brazil");
		user1.setName("Jackie");
		user1.setCountry("China");
		
		users.add(user);
		users.add(user1);
		
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(users);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
				
		
	}
	
	
	
	

}
