package com.vrms.controllertest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.vrms.controller.UserController;
import com.vrms.dto.UserDTO;
import com.vrms.exception.NoUserFoundException;
import com.vrms.service.UserService;


@ExtendWith(MockitoExtension.class)
class UserControllerTest {
	
	@Mock
	private UserService userService;

	@InjectMocks
	private UserController userController;

	private UserDTO user;
	private List<UserDTO> userList;
	@BeforeEach
	private void initEach() {
		user = new UserDTO();
		user.setUserId(2);
		user.setPassword("String@12");
		user.setRole("Customer");
		

		userList = new ArrayList<>();
		userList.add(user);
	}
	@Test
	void addUserTest() throws NoUserFoundException {
		Mockito.when(userService.addUser(user)).thenReturn(user);
		ResponseEntity<UserDTO> response = userController.addUser(user);
		System.out.println(response.getStatusCode());
		assertEquals(HttpStatus.CREATED, response.getStatusCode());
	}
	@Test
	void removeUserTest() throws NoUserFoundException {
		
			when(userService.removeUser(10)).thenReturn(user);
			ResponseEntity<UserDTO> response = userController.removeUser(10);
			assertEquals(HttpStatus.OK, response.getStatusCode());
		
	}

}
