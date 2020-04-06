package com.hcl.pp.home;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.pp.model.Pet;
import com.hcl.pp.service.PetsService;

@RestController
@RequestMapping("/pets")
public class PetsHomeController {
	
	@Autowired
	PetsService petsService;
	
	@RequestMapping("/getAllPets")
	public List<Pet> home() {
		List<Pet> pets = petsService.getAllPets();
		return pets;
	}
	
	@RequestMapping("/{petid}")
	public Pet getPetById(@PathVariable int petid) {
		Pet thePet = petsService.petByid(petid);
		return thePet;
	}

	@PostMapping("/addPet")
	public String addPet(@RequestBody Pet pet) {
		return petsService.savePet(pet);
	}
	
}
