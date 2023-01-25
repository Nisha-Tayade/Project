package com.vrms.dto;

import java.time.LocalDate;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

public class BookingDTO {
	
	//@JsonProperty(access = Access.READ_ONLY)
	private int bookingId;
	
	@Autowired
	private int customerId;
	
	@Autowired
	private int vehicleId;
	
	@NotNull
	@FutureOrPresent
	private LocalDate bookingDate;
	
	@NotNull
	@FutureOrPresent
	private LocalDate bookedTillDate;
	
	@JsonProperty(access = Access.READ_ONLY)
	private String bookingDescription;
	
	@NotNull
	private double totalCost;
	
	@NotNull
	private double distance;

	public BookingDTO() {}

	public BookingDTO(int bookingId, int customerId, int vehicleId, @NotNull @FutureOrPresent LocalDate bookingDate,
			@NotNull @FutureOrPresent LocalDate bookedTillDate, @NotNull double totalCost, @NotNull double distance) {
		super();
		this.bookingId = bookingId;
		this.customerId = customerId;
		this.vehicleId = vehicleId;
		this.bookingDate = bookingDate;
		this.bookedTillDate = bookedTillDate;
		this.totalCost = totalCost;
		this.distance = distance;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public LocalDate getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}

	public LocalDate getBookedTillDate() {
		return bookedTillDate;
	}

	public void setBookedTillDate(LocalDate bookedTillDate) {
		this.bookedTillDate = bookedTillDate;
	}

	public String getBookingDescription() {
		return bookingDescription;
	}

	public void setBookingDescription(String bookingDescription) {
		this.bookingDescription = bookingDescription;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}
	
	
}
