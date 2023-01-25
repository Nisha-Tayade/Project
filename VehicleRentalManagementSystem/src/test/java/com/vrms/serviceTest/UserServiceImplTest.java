package com.vrms.serviceTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.vrms.dao.UserRepository;
import com.vrms.dto.UserDTO;
import com.vrms.exception.NoUserFoundException;
import com.vrms.service.UserService;
import com.vrms.serviceimpl.UserServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {
	@Mock
	private UserRepository userRepo;

	@InjectMocks
	private UserService userService;
	
	private List<UserDTO> userList;
	private UserDTO user;
	
	@BeforeEach
	void setUp() throws Exception {
		user = new UserDTO();
		user.setUserId(12);
		user.setPassword("test123");
		user.setRole("Customer");
		
		userList = new ArrayList<>();
		userList.add(user);

	}
	@Test
	void addUserTest() {
		when(userService.addUser(user)).thenReturn(user);
		assertEquals(user, userService.addUser(user));
		System.out.println("DOne");
	}
	@Test
	void removeUserTest() throws NoUserFoundException{
		userList.clear();
		UserDTO isDeleted = userService.removeUser(10);
		verify(userRepo, times(1)).deleteById(12);
		assertEquals(user, isDeleted);
	}
}
