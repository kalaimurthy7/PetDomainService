package com.hcl.pp.service;

import java.util.List;

import com.hcl.pp.model.Pet;

public interface PetsService {

	public List<Pet> getAllPets();
	
	public Pet petByid(long id);
	
	public String savePet(Pet pet);
	
	public void updatePetById(Pet pet);
	
	public void deletePetById(long id);
	
}
