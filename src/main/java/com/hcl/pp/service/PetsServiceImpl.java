package com.hcl.pp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.pp.dao.PetsRepository;
import com.hcl.pp.model.Pet;

@Service
public class PetsServiceImpl implements PetsService {
	
	@Autowired
	PetsRepository petsRepository;
	
	@Autowired
	public PetsServiceImpl(PetsRepository petsRepository) {
		this.petsRepository = petsRepository;
	}

	@Override
	public List<Pet> getAllPets() {
		List<Pet> allpets = petsRepository.findAll();
		return allpets;
	}

	@Override
	public Pet petByid(long id) {
		Optional<Pet> result = petsRepository.findById(id);
		Pet thePet = null;
		if(result.isPresent()) {
			thePet = result.get();
		}
		return thePet;
	}

	@Override
	public String savePet(Pet pet) {
		String message = "";
		try {
			Pet thePet = petsRepository.save(pet);
			if(thePet != null)
				message = "Pet saved successfully";
			else
				message = "Pet not saved";
		}
		catch(Exception e) {
			message = "There is some issue while saving the pet";
			e.printStackTrace();
		}
		return message;
	}

	@Override
	public void updatePetById(Pet thePet) {
		Optional<Pet> currentPet = petsRepository.findById(thePet.getId());
		Pet pet = currentPet.get();
		if(pet != null) {
			pet.setName(thePet.getName());
			pet.setAge(thePet.getAge());
			pet.setPlace(thePet.getPlace());
			pet.getOwner().setUserId(1);
			petsRepository.save(pet);
		}
	}

	@Override
	public void deletePetById(long id) {
		petsRepository.deleteById(id);
	}

}
