package com.vrms.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vrms.dto.PaymentDTO;
import com.vrms.exception.NoPaymentFoundException;
import com.vrms.service.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController {
	@Autowired
	private PaymentService paymentService;

	@PostMapping
	public ResponseEntity<PaymentDTO> addPayment(@Valid @RequestBody PaymentDTO payment) {
		return new ResponseEntity<>(paymentService.addPayment(payment), HttpStatus.CREATED);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<PaymentDTO> delete(@PathVariable int id) throws NoPaymentFoundException {
		return new ResponseEntity<>(paymentService.cancelPayment(id), HttpStatus.OK);

	}
	
	@GetMapping
	public ResponseEntity<List<PaymentDTO>> getAll() throws NoPaymentFoundException {
		return new ResponseEntity<>(paymentService.viewPayment(), HttpStatus.OK);

	}
	@GetMapping("/{id}")
	public ResponseEntity<PaymentDTO> getById(@PathVariable int id) throws NoPaymentFoundException {
		return new ResponseEntity<>(paymentService.viewAllPayments(id), HttpStatus.FOUND);

	}
}