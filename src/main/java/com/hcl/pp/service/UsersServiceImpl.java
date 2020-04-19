package com.hcl.pp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.hcl.pp.dao.PetsRepository;
import com.hcl.pp.dao.UsersRepository;
import com.hcl.pp.model.Pet;
import com.hcl.pp.model.User;

@Service
public class UsersServiceImpl implements UsersService {

	@Autowired
	UsersRepository userRepository;
	
	@Autowired
	PetsServiceImpl petService;
	
	@Autowired
	PetsRepository petRepository;
	
	@Override
	public List<User> listUsers() {
		return userRepository.findAll();
	}

	@Override
	public User findByUserId(long id) {
		Optional<User> user = userRepository.findById(id);
		User theUser = null;
		if(user.isPresent())
			theUser = user.get();
		return theUser;
	}

	@Override
	public User findByUserName(String userName) {
		User user = null;
		try {
			user = userRepository.findByUsername(userName);
			if(user != null)
				return user;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public String addUser(User user) {
		String message = "";
		try {
			User user1 = userRepository.findByUsername(user.getUsername());
			if(user1 != null)
				message = "This user already exist";
			else {
				BCryptPasswordEncoder encode = new BCryptPasswordEncoder();
				user.setPassword(encode.encode(user.getPassword()));
				userRepository.save(user);
				message = "Successfully added new user";
			}
		}
		catch(Exception e) {
			message  = "Error while saving the user.";
			e.printStackTrace();
		}
		return message;
		
	}

	@Override
	public void updateUser(User user) {

		User currentUser = userRepository.findByUsername(user.getUsername());
		
		if(currentUser != null) {
			currentUser.setUsername(user.getUsername());
			currentUser.setPassword(user.getPassword());
			userRepository.save(currentUser);
		}
		
	}

	@Override
	public List<Pet> getMyPets(long id) {
		List<Pet> pets = null;
		try {
			pets = petRepository.findByOwnerId(id);
			//pets = allPets.stream().filter(pet -> id == pet.getOwner().getUserId()).collect(Collectors.toList());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return pets;
	}

	@Override
	public void deleteUserById(long id) {
		userRepository.deleteByUserId(id);
	}

	@Override
	public void deleteUserByName(String name) {
		userRepository.deleteByUsername(name);
	}

	@Override
	public String buyPet(long petid, long ownerid) {
		String message = "";
		try {
			Pet pet = petService.petByid(petid);
			
			pet.setOwner(userRepository.findByUserId(ownerid));
			
			petRepository.save(pet);
			
			message = "Successfully buyed";
		}
		catch(Exception e) {
			message = "Causing problem while buying the pet";
			e.printStackTrace();
		}
		
		return message;
	}

}
