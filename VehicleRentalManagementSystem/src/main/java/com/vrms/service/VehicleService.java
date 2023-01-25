package com.vrms.service;

import java.util.List;

import com.vrms.dto.VehicleDTO;
import com.vrms.exception.NoVehicleFoundException;

public interface VehicleService {

	public VehicleDTO addVehicle(VehicleDTO vehicleDto)throws NoVehicleFoundException;
	public List<VehicleDTO> getAllVehicles() throws NoVehicleFoundException;
	public VehicleDTO updateVehicle(VehicleDTO v, int id) throws NoVehicleFoundException;
}
