package com.vrms.service;

import java.util.List;

import com.vrms.dto.CustomerDTO;
import com.vrms.exception.NoAdminRoleFoundException;
import com.vrms.exception.NoCustomerFoundException;
import com.vrms.exception.NoUserFoundException;

public interface CustomerService {
	
	public CustomerDTO addCustomer(CustomerDTO customerDto)throws NoAdminRoleFoundException, NoUserFoundException;
	public CustomerDTO removeCustomer(int id)throws NoCustomerFoundException;
	public CustomerDTO getCustomerById(int id) throws NoCustomerFoundException;
	public CustomerDTO updateCustomer(CustomerDTO c, int id) throws NoCustomerFoundException;
	public List<CustomerDTO> getAllCustomer() throws NoCustomerFoundException;
	public List<CustomerDTO> viewAllCustomersByLocation(String location)throws NoCustomerFoundException;

}
