package com.vrms.service;
import java.time.LocalDate;
import java.util.List;

import com.vrms.dto.BookingDTO;
import com.vrms.entity.Booking;
import com.vrms.exception.NoBookingFoundException;

public interface BookingService {
	public BookingDTO addBooking (BookingDTO bookingDto);
	public  BookingDTO cancelBooking(int id) throws NoBookingFoundException;
	public BookingDTO updateBooking(BookingDTO b, int id) throws NoBookingFoundException;
	public List<BookingDTO> getAllBooking() throws NoBookingFoundException;
	public BookingDTO viewBooking(int id) throws NoBookingFoundException;
	public List<Booking> viewAllBooking(int id);
	public List<Booking> viewAllBookingByDate(LocalDate bookingDate);
	public List<Booking> viewAllBookingByVehicleId(int vehicleId);
}