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
import com.vrms.dto.CustomerDTO;
import com.vrms.exception.NoAdminRoleFoundException;
import com.vrms.exception.NoCustomerFoundException;
import com.vrms.exception.NoUserFoundException;
import com.vrms.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private CustomerService custService;

	@PostMapping
	public ResponseEntity<CustomerDTO> add(@Valid @RequestBody CustomerDTO custDto) throws NoAdminRoleFoundException, NoUserFoundException {
		return new ResponseEntity<>(custService.addCustomer(custDto), HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<CustomerDTO> getById(@PathVariable int id) throws NoCustomerFoundException {
		return new ResponseEntity<>(custService.getCustomerById(id), HttpStatus.FOUND);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<CustomerDTO> delete(@PathVariable int id) throws NoCustomerFoundException {
		return new ResponseEntity<>(custService.removeCustomer(id), HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<CustomerDTO> update(@Valid @RequestBody CustomerDTO customerDto, @PathVariable int id) throws NoCustomerFoundException {
		return new ResponseEntity<>(custService.updateCustomer(customerDto, id), HttpStatus.OK);
	}

	@GetMapping()
	public ResponseEntity<List<CustomerDTO>> getAll() throws NoCustomerFoundException {
		return new ResponseEntity<>(custService.getAllCustomer(), HttpStatus.OK);
	}

	@PutMapping("/locatecustomer/{location}")
	public ResponseEntity<List<CustomerDTO>> findCustomerByLocation(@PathVariable String location) throws NoCustomerFoundException {
		return new ResponseEntity<>(custService.viewAllCustomersByLocation(location), HttpStatus.OK);
	}

}