package com.vrms.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vrms.dto.AdminDTO;
import com.vrms.dto.BookingDTO;
import com.vrms.dto.CustomerDTO;
import com.vrms.dto.VehicleDTO;
import com.vrms.exception.NoAdminFoundException;
import com.vrms.exception.NoAdminRoleFoundException;
import com.vrms.exception.NoBookingFoundException;
import com.vrms.exception.NoCustomerFoundException;
import com.vrms.exception.NoUserFoundException;
import com.vrms.exception.NoVehicleFoundException;
import com.vrms.service.AdminService;
import com.vrms.service.BookingService;
import com.vrms.service.CustomerService;
import com.vrms.service.VehicleService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private CustomerService custService;
	
	@Autowired
	private BookingService bookService;
	
	@Autowired
	private VehicleService vehicleService;
	
	@PostMapping
	public ResponseEntity<AdminDTO> createAdmin(@Valid @RequestBody AdminDTO adminDto)
			throws NoAdminRoleFoundException, NoUserFoundException {
		return new ResponseEntity<>(adminService.createAdmin(adminDto), HttpStatus.CREATED);
	}
	
	@PostMapping("/addvehicle")
	public ResponseEntity<VehicleDTO> addVehicle(@Valid @RequestBody VehicleDTO vehicleDto) throws NoVehicleFoundException {
			return new ResponseEntity<>(vehicleService.addVehicle(vehicleDto), HttpStatus.CREATED);
	}
	
	@PutMapping("/updatevehicles/{id}")
	public ResponseEntity<VehicleDTO> updateVehicles(@Valid @RequestBody VehicleDTO vehicleDto, @PathVariable int id) throws NoVehicleFoundException {
		return new ResponseEntity<>(vehicleService.updateVehicle(vehicleDto, id), HttpStatus.OK);
	}
	
	@GetMapping("/vehiclesviewall")
	public ResponseEntity<List<VehicleDTO>> viewAllVehicles() throws NoVehicleFoundException{
		return new ResponseEntity<>(vehicleService.getAllVehicles(), HttpStatus.OK);
	}
	
	@GetMapping("/customerviewall")
	public ResponseEntity<List<CustomerDTO>> viewAllCustomer() throws NoCustomerFoundException{
		return new ResponseEntity<>(custService.getAllCustomer(), HttpStatus.OK);
	}

	@GetMapping("/bookings")
	public ResponseEntity<List<BookingDTO>> viewAllBooking() throws NoBookingFoundException{
		return new ResponseEntity<>(bookService.getAllBooking(), HttpStatus.OK);
	}

	
	@GetMapping
	public ResponseEntity<List<AdminDTO>> getAllAdmins() {
		return new ResponseEntity<>(adminService.findAllAdmins(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<AdminDTO> getById(@PathVariable int id) throws NoAdminFoundException {
		return new ResponseEntity<>(adminService.findAdminById(id), HttpStatus.FOUND);
	}

	@PutMapping("/{id}")
	public ResponseEntity<AdminDTO> updateAdmin(@Valid @RequestBody AdminDTO adminDto, @PathVariable int id)
			throws NoAdminRoleFoundException, NoAdminFoundException {
		return new ResponseEntity<>(adminService.updateAdmin(id, adminDto), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<AdminDTO> deleteAdmin(@PathVariable int id) throws NoAdminFoundException {
		return new ResponseEntity<>(adminService.deleteAdmin(id), HttpStatus.OK);
	}
}
