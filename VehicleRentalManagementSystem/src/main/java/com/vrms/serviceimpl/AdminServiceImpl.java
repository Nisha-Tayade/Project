package com.vrms.serviceimpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vrms.dao.AdminRepository;
import com.vrms.dao.UserRepository;
import com.vrms.dto.AdminDTO;
import com.vrms.entity.Admin;
import com.vrms.entity.User;
import com.vrms.exception.NoAdminFoundException;
import com.vrms.exception.NoAdminRoleFoundException;
import com.vrms.exception.NoUserFoundException;
import com.vrms.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService{

	static Logger LOG = LogManager.getLogger(AdminServiceImpl.class);
	private static final String NO_ADMIN_FOUND = "Admin ID not found.";
	private static final String NO_USER_FOUND = "User ID not found.";
	private static final String ADMIN_ROLE_REQD = "Admin role is required.";

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private AdminRepository aRepo;

	@Autowired
	private UserRepository uRepo;
	
	@Override
	public AdminDTO createAdmin(AdminDTO adminDto) throws NoUserFoundException, NoAdminRoleFoundException {
		
		Optional<User> find = uRepo.findById(adminDto.getAdminId());
		if (find.isPresent()) {
			if (find.get().checkAdmin()) {
				Admin admin = modelMapper.map(adminDto, Admin.class);
				LOG.info("Saving admin");
				aRepo.save(admin);
				LOG.info("Saved. Returning admin");
				return adminDto;
			} else {
				throw new NoAdminRoleFoundException(ADMIN_ROLE_REQD);
			}
		} else {
			throw new NoUserFoundException(NO_USER_FOUND);
		}
	
	}

	@Override
	public List<AdminDTO> findAllAdmins() {
		LOG.info("Returning all admins");
		return aRepo.findAll().stream().map(adm -> modelMapper.map(adm, AdminDTO.class)).collect(Collectors.toList());
	}

	@Override
	public AdminDTO findAdminById(int id) throws NoAdminFoundException {
		Optional<Admin> adm = aRepo.findById(id);
		if (adm.isPresent()) {
			LOG.info("Returning admin using id");
			return modelMapper.map(adm.get(), AdminDTO.class);
		} else {
			throw new NoAdminFoundException(NO_ADMIN_FOUND);
		}
	}

	@Override
	public AdminDTO updateAdmin(int id, AdminDTO adminDto) throws NoAdminFoundException, NoAdminRoleFoundException {
		Optional<Admin> admUpdate = aRepo.findById(id);
		Admin admin = modelMapper.map(adminDto, Admin.class);
		if (admUpdate.isPresent()) {
			LOG.info("Admin present. Updating...");
			admUpdate.get().setAdminId(admin.getAdminId());
			admUpdate.get().setUsername(admin.getUsername());
			admUpdate.get().setPassword(admin.getPassword());
			LOG.info("Saving...");
			aRepo.save(admUpdate.get());
			LOG.info("Saved. Returning admin");
			return adminDto;
		} else {
			throw new NoAdminFoundException(NO_ADMIN_FOUND);
		}
	}

	@Override
	public AdminDTO deleteAdmin(int id) throws NoAdminFoundException {
		Optional<Admin> admDel = aRepo.findById(id);
		if (admDel.isPresent())
			aRepo.delete(admDel.get());
		else
			throw new NoAdminFoundException(NO_ADMIN_FOUND);
		return modelMapper.map(admDel.get(), AdminDTO.class);
	}

}
