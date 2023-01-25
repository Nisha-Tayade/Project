package com.vrms.dto;

import java.time.LocalDate;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

public class PaymentDTO {
	
	@NotNull
	@Size(min=3, max=10, message="Please enter valid User ID.")
	private int paymentId;
	
	@NotBlank
	private String paymentMode;
	
	@NotBlank
	@PastOrPresent
	private LocalDate paymentDate;
	
	@NotNull
	private int bookingId;
	
	@NotBlank
	private String paymentStatus;

	public PaymentDTO() {}

	public PaymentDTO(@NotNull @Size(min = 3, max = 10, message = "Please enter valid User ID.") int paymentId,
			@NotBlank String paymentMode, @NotBlank @PastOrPresent LocalDate paymentDate, @NotNull int bookingId,
			@NotBlank String paymentStatus) {
		super();
		this.paymentId = paymentId;
		this.paymentMode = paymentMode;
		this.paymentDate = paymentDate;
		this.bookingId = bookingId;
		this.paymentStatus = paymentStatus;
	}

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public LocalDate getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
}
