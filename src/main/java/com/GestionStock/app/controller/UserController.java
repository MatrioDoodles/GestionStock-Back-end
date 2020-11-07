package com.GestionStock.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.GestionStock.app.model.User;
import com.GestionStock.app.service.UserService;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/GetAllUsers")
	public List<User> GetAllUsers()
	{
		return userService.allUser();
	}
	
	@PostMapping("/addUser")
	public User addUser(@RequestBody User user) {
		
		return userService.addUser(user);
	}
	@PostMapping("/ModUser")
	public User ModUser(@RequestBody User user) {
		
		return userService.updateUser(user);
	}
	@GetMapping("/{id}")
	public User GetUserByid(@PathVariable long id) {
		return userService.findUserById(id);
	}
	@GetMapping("/searchUserByUsername/{username}")  
	public User getUserByUsername(@PathVariable("username") String username){  
	return userService.findUserByUsername(username);  
	}
	@PostMapping("/GetAllUsersT")
	public List<User> GetUserByTenantId(@RequestBody User tenant) {
		return userService.getUsersByTenantId(tenant);
	}

	@DeleteMapping("/DelUser")
	public void DelAscenseur(@RequestBody User user) {
		
		userService.deleteUser(user);
			//return "Utilisateur Supprimé";
	}

	
	

}
