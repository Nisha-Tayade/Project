package com.vrms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vrms.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	}
