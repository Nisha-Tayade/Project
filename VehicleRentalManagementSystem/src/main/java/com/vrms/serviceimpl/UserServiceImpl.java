package com.vrms.serviceimpl;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vrms.dao.UserRepository;
import com.vrms.dto.UserDTO;
import com.vrms.entity.User;
import com.vrms.exception.NoUserFoundException;
import com.vrms.service.UserService;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public UserDTO addUser(UserDTO userDto) {
		User user = modelMapper.map(userDto, User.class);
		return modelMapper.map(userRepo.save(user),UserDTO.class);
	}

	@Override
	public UserDTO removeUser(int userId) throws NoUserFoundException {
		Optional<User> userToDel = userRepo.findById(userId);
		if(userToDel.isPresent()) 
			userRepo.delete(userToDel.get());	
		else
			throw new NoUserFoundException("No user with this id");
		return modelMapper.map(userToDel.get(), UserDTO.class);
	}
}
