package com.vrms.serviceimpl;

import java.util.List;

import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vrms.dao.PaymentRepository;
import com.vrms.dto.PaymentDTO;
import com.vrms.entity.Payment;
import com.vrms.exception.NoPaymentFoundException;
import com.vrms.service.PaymentService;
@Service
public class PaymentServiceImpl implements PaymentService{

	@Autowired
	private PaymentRepository paymentRepo;

	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public PaymentDTO addPayment(PaymentDTO paymentDto) {
		Payment payment = modelMapper.map(paymentDto,Payment.class); 
		paymentRepo.save(payment);
		return paymentDto;
	}

	@Override
	public PaymentDTO cancelPayment(int id) throws NoPaymentFoundException {
		Optional<Payment> paymentToDel = paymentRepo.findById(id);
		if(paymentToDel.isPresent())
			paymentRepo.delete(paymentToDel.get());
		else
			throw new NoPaymentFoundException("Payment not found");

		return modelMapper.map(paymentToDel, PaymentDTO.class);
	}

	@Override
	public List<PaymentDTO> viewPayment() throws NoPaymentFoundException {

		return paymentRepo.findAll().stream().map(payment -> modelMapper.map(payment, PaymentDTO.class)).collect(Collectors.toList());
	}

	@Override
	public PaymentDTO viewAllPayments(int id) throws NoPaymentFoundException {
				Optional<Payment> paymentlist =paymentRepo.findById(id);
		if(paymentlist.isPresent())
			return  modelMapper.map(paymentlist.get(),PaymentDTO.class);
		else throw new NoPaymentFoundException("No Such Payment found.");
	}
	
}
