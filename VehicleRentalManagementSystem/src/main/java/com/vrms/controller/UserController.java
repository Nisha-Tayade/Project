package com.vrms.controller;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vrms.dto.UserDTO;
import com.vrms.exception.NoUserFoundException;
import com.vrms.service.UserService;

@RestController
@RequestMapping
public class UserController {
	@Autowired
	private UserService service;

	@PostMapping
	public ResponseEntity<UserDTO> addUser(@Valid @RequestBody UserDTO userDto){
		return new ResponseEntity<>(service.addUser(userDto), HttpStatus.CREATED);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<UserDTO> removeUser(@PathVariable("id")int id) throws NoUserFoundException{
		return new ResponseEntity<>(service.removeUser(id), HttpStatus.OK);
	}
}
