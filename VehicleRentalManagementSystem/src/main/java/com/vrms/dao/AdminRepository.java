package com.vrms.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vrms.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer>{

}
