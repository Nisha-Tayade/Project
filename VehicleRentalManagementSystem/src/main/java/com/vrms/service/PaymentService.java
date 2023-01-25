package com.vrms.service;

import java.util.List;
import com.vrms.dto.PaymentDTO;
import com.vrms.exception.NoPaymentFoundException;

public interface PaymentService {

	public PaymentDTO addPayment(PaymentDTO payment);
	public PaymentDTO cancelPayment(int id) throws NoPaymentFoundException;
	public List<PaymentDTO> viewPayment() throws NoPaymentFoundException;
	public PaymentDTO viewAllPayments(int id) throws NoPaymentFoundException;
	
}
