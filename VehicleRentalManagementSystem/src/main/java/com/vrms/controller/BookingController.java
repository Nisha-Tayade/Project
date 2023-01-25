package com.vrms.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vrms.dto.BookingDTO;
import com.vrms.entity.Booking;
import com.vrms.exception.NoBookingFoundException;
import com.vrms.service.BookingService;

@RestController
@RequestMapping("/booking")
public class BookingController {
	@Autowired
	private BookingService bookingService;

	@PostMapping
	public ResponseEntity<BookingDTO> add(@Valid @RequestBody BookingDTO bookingDto) {
			return new ResponseEntity<>(bookingService.addBooking(bookingDto), HttpStatus.CREATED);
	}

	@GetMapping()
	public ResponseEntity<List<BookingDTO>> getAll() throws NoBookingFoundException {
		return new ResponseEntity<>(bookingService.getAllBooking(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<BookingDTO> getById(@PathVariable int id)throws NoBookingFoundException { 
		return new ResponseEntity<>(bookingService.viewBooking(id), HttpStatus.FOUND);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<BookingDTO> cancel(@PathVariable int id)throws NoBookingFoundException {
		return new ResponseEntity<>(bookingService.cancelBooking(id), HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<BookingDTO> update(@Valid@RequestBody BookingDTO bookingDto, @PathVariable int id)throws NoBookingFoundException {
		return new ResponseEntity<>(bookingService.updateBooking(bookingDto, id), HttpStatus.FOUND);
	}

	@GetMapping("/viewall/{id}")
	public ResponseEntity<List<Booking>> getBookingByCustId(@PathVariable int id){
		return new ResponseEntity<>(bookingService.viewAllBooking(id), HttpStatus.FOUND);
	}
	
	@GetMapping("/viewall/{bookingDate}")
	public ResponseEntity<List<Booking>> getBookingByDate(@PathVariable LocalDate bookingDate){
		return new ResponseEntity<>(bookingService.viewAllBookingByDate(bookingDate), HttpStatus.FOUND);
	}
	
	@GetMapping("/viewall/{vehicleId}")
	public ResponseEntity<List<Booking>> getBookingByVehicleId(@PathVariable int vehicleId){
		return new ResponseEntity<>(bookingService.viewAllBookingByVehicleId(vehicleId), HttpStatus.FOUND);
	}
}

