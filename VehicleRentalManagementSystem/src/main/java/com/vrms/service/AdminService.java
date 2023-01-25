package com.vrms.service;

import java.util.List;

import com.vrms.dto.AdminDTO;
import com.vrms.exception.NoAdminFoundException;
import com.vrms.exception.NoAdminRoleFoundException;
import com.vrms.exception.NoUserFoundException;

public interface AdminService {
	public AdminDTO createAdmin(AdminDTO adminDto) throws NoUserFoundException, NoAdminRoleFoundException;

	List<AdminDTO> findAllAdmins();

	public AdminDTO findAdminById(int id) throws NoAdminFoundException;

	public AdminDTO updateAdmin(int id, AdminDTO adminDto) throws NoAdminFoundException, NoAdminRoleFoundException;

	public AdminDTO deleteAdmin(int id) throws NoAdminFoundException;
}
