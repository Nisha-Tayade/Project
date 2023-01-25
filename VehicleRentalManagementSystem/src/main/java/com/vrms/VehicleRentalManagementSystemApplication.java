package com.vrms;

import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class VehicleRentalManagementSystemApplication {
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
	private static final Logger LOG = LogManager.getLogger(VehicleRentalManagementSystemApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(VehicleRentalManagementSystemApplication.class, args);
		LOG.info("Vehicle Rental app started.");		
	}
}
