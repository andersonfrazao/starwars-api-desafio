package com.starwars.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.starwars.client.UsersClient;
import com.starwars.model.People;
import com.starwars.model.Usuario;
import com.starwars.repository.UserRepository;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/*@SpringBootApplication
@EnableAutoConfiguration*/

@RestController
public class UserController {
	
	@Autowired
	UsersClient usersBusiness;
	
	@Autowired
	private UserRepository userRepository;
	
	/*
	 * public static void main(String[] args) {
	 * SpringApplication.run(UserController.class, args);
	 * 
	 * }
	 */
	 
	
	@RequestMapping("/users")
	@ResponseBody
	public String getUsers() {
		 return usersBusiness.convertUser2Json(); 
		/*
		 * return "{\"users\":[{\"name\":\"Lucas\", \"country\":\"Brazil\"}," +
		 * "{\"name\":\"Jackie\",\"country\":\"China\"}]}";
		 */
	}
	
	
	@ApiOperation(value = "Lista todas os Usuarios do Banco", notes = "Lista todos os usuaruis do Banco", response = People.class, responseContainer = "List" )
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Pessoas Listadas com sucesso"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
		    @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
		    @ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@RequestMapping(path="/usuario")
	@ResponseBody
	public Iterable<Usuario> getAll(){
	
		return userRepository.findAll();
	}
	

}
