package com.vrms.serviceimpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vrms.dao.BookingRepository;
import com.vrms.dto.BookingDTO;
import com.vrms.entity.Booking;
import com.vrms.exception.NoBookingFoundException;
import com.vrms.service.BookingService;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	private BookingRepository bookingRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public BookingDTO addBooking(BookingDTO bookingDto) {
		Booking booking = modelMapper.map(bookingDto, Booking.class);
		bookingRepo.save(booking);
		return bookingDto;
	}

	@Override
	public List<BookingDTO> getAllBooking() throws NoBookingFoundException{
		return bookingRepo.findAll().stream().map(booking -> modelMapper.map(booking, BookingDTO.class))
				.collect(Collectors.toList());	
	}
	
	@Override
	public BookingDTO cancelBooking(int id) throws NoBookingFoundException {
		Optional<Booking> bookingToDel = bookingRepo.findById(id);
		if(bookingToDel.isPresent())
			bookingRepo.delete(bookingToDel.get());
		else
			throw new NoBookingFoundException("Customer not found");

		return modelMapper.map(bookingToDel, BookingDTO.class);

	}

	@Override
	public BookingDTO viewBooking(int id) throws NoBookingFoundException {
		Optional<Booking> book = bookingRepo.findById(id);
		if (book.isPresent())
			return modelMapper.map(book.get(), BookingDTO.class);
		else
			throw new NoBookingFoundException("Booking not found");

	}

	@Override
	public BookingDTO updateBooking(BookingDTO b, int id) throws NoBookingFoundException {

		Optional<Booking> bookUpdate = bookingRepo.findById(id);

		if (bookUpdate.isPresent()) {
			bookUpdate.get().setBookingId(b.getBookingId());
			bookUpdate.get().setBookingDate(b.getBookingDate());
			bookUpdate.get().setBookedTillDate(b.getBookedTillDate());
			//bookUpdate.get().setBookingDescription(b.getBookingDescription());
			bookUpdate.get().setTotalCost(b.getTotalCost());
			bookUpdate.get().setDistance(b.getDistance());
			bookingRepo.save(bookUpdate.get());
			return b;

		} else {
			throw new NoBookingFoundException("Booking not found");
		}
	}

	@Override
	public List<Booking> viewAllBooking(int id) {
		return bookingRepo.viewAllBookingByCustId( id);
	}

	@Override
	public List<Booking> viewAllBookingByDate(LocalDate bookingDate) {
		return bookingRepo.viewAllBookingByDate(bookingDate);
	}

	@Override
	public List<Booking> viewAllBookingByVehicleId(int vehicleId) {
		return bookingRepo.viewAllBookingByVehicleId(vehicleId);
	}

	
}

