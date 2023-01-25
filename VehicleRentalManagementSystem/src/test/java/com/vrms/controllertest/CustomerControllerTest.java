package com.vrms.controllertest;



import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;

import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.vrms.controller.CustomerController;
import com.vrms.dao.CustomerRepository;
import com.vrms.dto.CustomerDTO;
import com.vrms.entity.Customer;
import com.vrms.exception.NoAdminRoleFoundException;
import com.vrms.exception.NoCustomerFoundException;
import com.vrms.exception.NoUserFoundException;
import com.vrms.service.CustomerService;
import com.vrms.serviceimpl.CustomerServiceImpl;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(CustomerController.class)
class CustomerControllerTest {

	@MockBean
	private CustomerService custService;

	@InjectMocks
	private CustomerController custController;

	private CustomerDTO cus;
	private List<CustomerDTO> custList;

	@BeforeEach
	private void initEach() {
		cus = new CustomerDTO();
		cus.setCustomerId(51);
		cus.setFirstName("Rakesh");
		cus.setLastName("Sharma");
		cus.setMobileNumber(9807623451L);
		cus.setAddress("Delhi");

		custList = new ArrayList<>();
		custList.add(cus);
	}

	@Test
	void addCustomerTest() throws NoAdminRoleFoundException, NoUserFoundException {
		Mockito.when(custService.addCustomer(cus)).thenReturn(cus);
		ResponseEntity<CustomerDTO> response = custController.add(cus);
		System.out.println(response.getStatusCode());
		assertEquals(HttpStatus.CREATED, response.getStatusCode());
	}

	@Test
	void testDeleteCustomer() throws NoCustomerFoundException {
		
			when(custService.removeCustomer(51)).thenReturn(cus);
			ResponseEntity<CustomerDTO> response = custController.delete(51);
			assertEquals(HttpStatus.OK, response.getStatusCode());
		
	}

	@Test
	void updateCustomerTest() throws NoCustomerFoundException {
		cus.setFirstName("Karan");
		cus.setLastName(null);

		Mockito.when(custService.getCustomerById(10)).thenReturn(cus);
		Mockito.when(custService.updateCustomer(cus, 10)).thenReturn(cus);
		Assertions.assertEquals(cus, custService.updateCustomer(cus, 10));

	}

	@Test
	void findAllCustomerTest() throws NoCustomerFoundException {
		Mockito.when(custService.getAllCustomer()).thenReturn(custList);
		assertEquals(custService.getAllCustomer(), custList);
	}

	@Test
	void testFindCustomerById() throws NoCustomerFoundException{
		
			when(custService.getCustomerById(10)).thenReturn(cus).thenAnswer(i -> custService.getCustomerById(10));
			assertEquals(cus, custService.getCustomerById(10));	
	}
}

