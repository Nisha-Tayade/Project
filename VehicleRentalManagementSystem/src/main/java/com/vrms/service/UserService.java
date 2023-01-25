package com.vrms.service;

import com.vrms.dto.UserDTO;
import com.vrms.exception.NoUserFoundException;

public interface UserService {
	public UserDTO addUser(UserDTO userDto);
	public UserDTO removeUser(int userId)throws NoUserFoundException;
}
