package com.spring.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	@Query(value = "SELECT MAX(userId) as userId from User u")
	String getNullUserId();

	@Query(value = "SELECT MAX(userId) as userId from User u")
	int getMaxUserId();

}
