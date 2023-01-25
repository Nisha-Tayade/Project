package com.vrms.serviceimpl;

import java.util.List;

import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vrms.dao.VehicleRepository;

import com.vrms.dto.VehicleDTO;
import com.vrms.entity.Vehicle;
import com.vrms.exception.NoVehicleFoundException;
import com.vrms.service.VehicleService;

@Service
public class VehicleServiceImpl implements VehicleService{
	
	@Autowired
	private VehicleRepository vehicleRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public VehicleDTO addVehicle(VehicleDTO vehicleDto) throws NoVehicleFoundException {
		Vehicle vehicle = modelMapper.map(vehicleDto,Vehicle.class); 
		vehicleRepo.save(vehicle);
		return vehicleDto;
	}

	@Override
	public List<VehicleDTO> getAllVehicles() throws NoVehicleFoundException {
		return vehicleRepo.findAll().stream().map(vehicle -> modelMapper.map(vehicle, VehicleDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public VehicleDTO updateVehicle(VehicleDTO v, int id) throws NoVehicleFoundException {
		Optional<Vehicle> vehiToUpdate = vehicleRepo.findById(id);
		
		if(vehiToUpdate.isPresent()) {
			vehiToUpdate.get().setVehicleId(v.getVehicleId());
			vehiToUpdate.get().setCapacity(v.getCapacity());
			vehiToUpdate.get().setCategory(v.getCategory());
			vehiToUpdate.get().setChargesPerKM(v.getChargesPerKM());
			vehiToUpdate.get().setDescription(v.getDescription());
			vehiToUpdate.get().setFixedCharges(v.getFixedCharges());
			vehiToUpdate.get().setLocation(v.getLocation());
			vehiToUpdate.get().setType(v.getType());
			vehiToUpdate.get().setVehicleNumber(v.getVehicleNumber());
			vehicleRepo.save(vehiToUpdate.get());
			return v;
		}
		else {
			throw new NoVehicleFoundException("Vehicle not found");
		}
	}

}
