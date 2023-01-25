package com.vrms.controllertest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

 
import com.vrms.controller.PaymentController;
import com.vrms.dto.CustomerDTO;
import com.vrms.dto.PaymentDTO;
import com.vrms.exception.NoAdminRoleFoundException;
import com.vrms.exception.NoCustomerFoundException;
import com.vrms.exception.NoPaymentFoundException;
import com.vrms.exception.NoUserFoundException;
 
import com.vrms.service.PaymentService;

@ExtendWith(MockitoExtension.class)
class PaymentControllerTest {
	@Mock
	private PaymentService payService;

	@InjectMocks
	private PaymentController payController;
	
	private PaymentDTO payDto;
	private List<PaymentDTO> payList;
	
	@BeforeEach
	private void initEach() {
		payDto = new PaymentDTO();
		payDto.setPaymentId(12);
		payDto.setPaymentDate(LocalDate.now());
		payDto.setPaymentMode("cash");
		payDto.setPaymentStatus("Done");
		payDto.setBookingId(12);
		
		payList = new ArrayList<>();
		payList.add(payDto);
		
	}
	@Test
	void addPaymentTest() throws NoAdminRoleFoundException, NoPaymentFoundException {
		Mockito.when(payService.addPayment(payDto)).thenReturn(payDto);
		ResponseEntity<PaymentDTO> response = payController.addPayment(payDto);
		System.out.println(response.getStatusCode());
		assertEquals(HttpStatus.CREATED, response.getStatusCode());
	}
	@Test
	void cancelPaymentTest() throws NoPaymentFoundException {
	
			when(payService.cancelPayment(1)).thenReturn(payDto);
			ResponseEntity<PaymentDTO> response = payController.delete(1);
			assertEquals(HttpStatus.OK, response.getStatusCode());	
		}
	@Test
	void ViewPaymentById() throws NoPaymentFoundException {
		
			when(payService.viewAllPayments(10)).thenReturn(payDto).thenAnswer(i -> payService.viewAllPayments(10));
			assertEquals(payDto, payService.viewAllPayments(10));	
	}
	@Test
	void ViewPayment() throws NoPaymentFoundException {
		Mockito.when(payService.viewPayment()).thenReturn(payList);
		assertEquals(payService.viewPayment(), payList);
		
	}
}
