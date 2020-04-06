package com.hcl.pp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.pp.model.User;

@Repository
public interface UsersRepository extends JpaRepository<User, Long> {

	public User findByUsername(String username);
	
	public User findByUserId(long id);
	
	public void deleteByUserId(long id);
	
	public void deleteByUsername(String name);
	
}
