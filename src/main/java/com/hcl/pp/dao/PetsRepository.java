package com.hcl.pp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hcl.pp.model.Pet;

@Repository
public interface PetsRepository extends JpaRepository<Pet, Long> {

	@Query(value = "SELECT * FROM Pets p WHERE p.PET_OWNERID = :ownerid", nativeQuery = true)
	public List<Pet> findByOwnerId(@Param("ownerid") Long ownerid);
	
}
