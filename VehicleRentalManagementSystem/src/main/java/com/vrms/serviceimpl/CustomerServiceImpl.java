package com.vrms.serviceimpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vrms.dao.CustomerRepository;
import com.vrms.dao.UserRepository;
import com.vrms.dto.CustomerDTO;
import com.vrms.entity.Customer;
import com.vrms.entity.User;
import com.vrms.exception.NoAdminRoleFoundException;
import com.vrms.exception.NoCustomerFoundException;
import com.vrms.exception.NoUserFoundException;
import com.vrms.service.CustomerService;
@Service
public class CustomerServiceImpl implements CustomerService{

	private static final String NO_USER_FOUND = "User ID not found.";	
	private static final String CUSTOMER_ROLE_REQUIRED = "Customer role is required.";
	
	@Autowired
	private CustomerRepository customerRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserRepository uRepo;
	
	@Override
	public CustomerDTO addCustomer(CustomerDTO customerDto) throws NoAdminRoleFoundException, NoUserFoundException{
		Optional<User> find = uRepo.findById(customerDto.getCustomerId());
		if (find.isPresent()) {
	        if (find.get().checkCustomer()) {
	            Customer cust = modelMapper.map(customerDto, Customer.class);
	            customerRepo.save(cust);
	            return customerDto;
	        } else {
	            throw new NoAdminRoleFoundException(CUSTOMER_ROLE_REQUIRED);
	        } 
	     }else {
	        throw new NoUserFoundException(NO_USER_FOUND);
	    }

	}
	
	@Override
	public List<CustomerDTO> getAllCustomer() throws NoCustomerFoundException{
		return customerRepo.findAll().stream().map(cust -> modelMapper.map(cust, CustomerDTO.class)).collect(Collectors.toList());
		
		
	}
	
	@Override
	public CustomerDTO getCustomerById(int id) throws NoCustomerFoundException {
		Optional<Customer> cust = customerRepo.findById(id);
		if (cust.isPresent())
			return modelMapper.map(cust.get(), CustomerDTO.class);

		throw new NoCustomerFoundException("Customer not found");
	}
	
	@Override
	public CustomerDTO updateCustomer(CustomerDTO c, int id) throws NoCustomerFoundException {
		Optional<Customer> custToUpdate = customerRepo.findById(id);
		if(custToUpdate.isPresent()) {
			custToUpdate.get().setCustomerId(c.getCustomerId());
			custToUpdate.get().setFirstName(c.getFirstName());
			custToUpdate.get().setLastName(c.getLastName());
			custToUpdate.get().setMobileNumber(c.getMobileNumber());
			custToUpdate.get().setEmailId(c.getEmailId());
			custToUpdate.get().setAddress(c.getAddress());
			
			customerRepo.save(custToUpdate.get());
			return c;
		}
		else {
			throw new NoCustomerFoundException("Customer not found");
		}
		
	}

	@Override
	public CustomerDTO removeCustomer(int id) throws NoCustomerFoundException{
		Optional<Customer> custToDel = customerRepo.findById(id);
		if(custToDel.isPresent())
			customerRepo.delete(custToDel.get());
		else
			throw new NoCustomerFoundException("Customer not found");

		return modelMapper.map(custToDel, CustomerDTO.class);
	}
	

	@Override
	public List<CustomerDTO> viewAllCustomersByLocation(String location) throws NoCustomerFoundException{
		return customerRepo.viewAllCustomersByLocation(location);
	}
}
