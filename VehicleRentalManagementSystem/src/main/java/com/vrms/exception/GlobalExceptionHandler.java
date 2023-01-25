package com.vrms.exception;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;

import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@RequestMapping("/VehicleRentalApp")
public class GlobalExceptionHandler {
	@ResponseBody
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ExceptionHandler(value = { NoCustomerFoundException.class })
	public ErrorInfo handleCustomerExcp(NoCustomerFoundException ex, HttpServletRequest req) {
		
		String uri = req.getRequestURL().toString();
		return new ErrorInfo(uri, ex.getMessage(), LocalDateTime.now().toString());

	}

	@ResponseBody
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ExceptionHandler(value = { NoAdminFoundException.class })
	public ErrorInfo handleAdminExcp(NoAdminFoundException ex, HttpServletRequest req) {

		String uri = req.getRequestURL().toString();
		return new ErrorInfo(uri, ex.getMessage(), LocalDateTime.now().toString());

	}

	@ResponseBody
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ExceptionHandler(value = { NoBookingFoundException.class })
	public ErrorInfo handleBookingExcp(NoBookingFoundException ex, HttpServletRequest req) {

		String uri = req.getRequestURL().toString();
		return new ErrorInfo(uri, ex.getMessage(), LocalDateTime.now().toString());

	}

	@ResponseBody
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ExceptionHandler(value = { NoDriverFoundException.class })
	public ErrorInfo handleDriverExcp(NoDriverFoundException ex, HttpServletRequest req) {

		String uri = req.getRequestURL().toString();
		return new ErrorInfo(uri, ex.getMessage(), LocalDateTime.now().toString());

	}

	@ResponseBody
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ExceptionHandler(value = { NoPaymentFoundException.class })
	public ErrorInfo handlePaymentExcp(NoPaymentFoundException ex, HttpServletRequest req) {

		String uri = req.getRequestURL().toString();
		return new ErrorInfo(uri, ex.getMessage(), LocalDateTime.now().toString());

	}

	@ResponseBody
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ExceptionHandler(value = { NoVehicleFoundException.class })
	public ErrorInfo handleVehicleExcp(NoVehicleFoundException ex, HttpServletRequest req) {
		String msg = "Vehicles not found.";
		String uri = req.getRequestURL().toString();
		return new ErrorInfo(uri, msg, LocalDateTime.now().toString());

	}

	@ResponseStatus(value = HttpStatus.BAD_REQUEST)

	@ResponseBody

	@ExceptionHandler(value = { MethodArgumentNotValidException.class })

	public ErrorInfo handleValidationError(MethodArgumentNotValidException ex, HttpServletRequest req) {

		String msg = "validation failed";

		FieldError error = ex.getFieldError();

		if (error != null)

			msg = error.getDefaultMessage();

		return new ErrorInfo(req.getRequestURI(), msg, LocalDateTime.now().toString());

	}

	@ResponseBody
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value = { Exception.class })
	public ErrorInfo handleGeneric(Exception ex, HttpServletRequest req) {

		String uri = req.getRequestURL().toString();
		return new ErrorInfo(uri, ex.getMessage(), LocalDateTime.now().toString());

	}

}