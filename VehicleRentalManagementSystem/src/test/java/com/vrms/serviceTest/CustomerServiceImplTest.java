package com.vrms.serviceTest;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.vrms.dao.CustomerRepository;
import com.vrms.dto.CustomerDTO;
import com.vrms.entity.Customer;
import com.vrms.exception.NoAdminRoleFoundException;
import com.vrms.exception.NoCustomerFoundException;
import com.vrms.exception.NoUserFoundException;
import com.vrms.serviceimpl.CustomerServiceImpl;

@ExtendWith(MockitoExtension.class)
class CustomerServiceImplTest {

	@Mock
	private CustomerRepository custRepo;

	@InjectMocks
	private CustomerServiceImpl custService;

	private List<CustomerDTO> custList;
	private CustomerDTO cus;

	@BeforeEach
	private void initEach() {
		cus = new CustomerDTO();
		cus.setCustomerId(10);
		cus.setFirstName("Rakesh");
		cus.setFirstName("Sharma");
		cus.setMobileNumber(9807623451L);
		cus.setAddress("Delhi");

		custList = new ArrayList<>();
		custList.add(cus);
	}
	
	@Test
	void addCustomerTest() throws NoAdminRoleFoundException, NoUserFoundException {
		Mockito.when(custService.addCustomer(cus)).thenReturn(cus);
		assertEquals(custService.addCustomer(cus), cus);
		verify(custRepo, Mockito.times(1)).save(any(Customer.class));
	}
	
	@Test
	void deleteCustomerTest() throws NoCustomerFoundException {
		verify(custRepo, times(1)).deleteById(10);
		System.out.println("Done");
	}
}
