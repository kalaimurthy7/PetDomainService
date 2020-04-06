package com.hcl.pp.home;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.pp.model.Pet;
import com.hcl.pp.model.User;
import com.hcl.pp.service.UsersServiceImpl;

@RestController
@RequestMapping("/users")
public class UsersHomeController {

	@Autowired
	UsersServiceImpl userService;
	
	@RequestMapping("/getAllUsers")
	public List<User> home(){
		return userService.listUsers();
	}
	
	@RequestMapping("/{byValue}")
	public User byValue(@PathVariable String byValue) {
		return userService.findByUserName(byValue);
	}
	
	@PostMapping(value = "/addUser")
	public String addUser(@RequestBody User user) {
		return userService.addUser(user);
	}
	
	@PostMapping("/updateUser")
	public String updateUser(@RequestBody User user) {
		userService.updateUser(user);
		return "success";
	}
	
	@RequestMapping("/myPets/{ownerid}")
	public List<Pet> myPets(@PathVariable long ownerid){
		return userService.getMyPets(ownerid);
	}
	
	@PutMapping("/buyPet/{petId}/{ownerid}")
	public String buyPet(@PathVariable long petId, @PathVariable long ownerid) {
		return userService.buyPet(petId,ownerid);		
	}
}
