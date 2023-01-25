package com.vrms.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vrms.entity.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer>{

}
