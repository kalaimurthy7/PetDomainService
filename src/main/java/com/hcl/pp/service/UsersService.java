package com.hcl.pp.service;

import java.util.List;

import com.hcl.pp.model.Pet;
import com.hcl.pp.model.User;

public interface UsersService {
	
	public List<User> listUsers();
	
	public User findByUserId(long id);
	
	public User findByUserName(String userName);
	
	public String addUser(User user);
	
	public void updateUser(User user);
	
	public List<Pet> getMyPets(long id);
	
	public void deleteUserById(long id);
	
	public void deleteUserByName(String name);
	
	public String buyPet(long petid, long ownerid);

}
