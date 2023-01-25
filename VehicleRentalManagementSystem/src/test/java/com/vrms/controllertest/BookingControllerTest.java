package com.vrms.controllertest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.OngoingStubbing;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.vrms.controller.BookingController;
import com.vrms.controller.CustomerController;
import com.vrms.dto.BookingDTO;
import com.vrms.dto.CustomerDTO;
import com.vrms.dto.DriverDTO;
import com.vrms.dto.VehicleDTO;
import com.vrms.entity.Booking;
import com.vrms.exception.NoAdminRoleFoundException;
import com.vrms.exception.NoBookingFoundException;
import com.vrms.exception.NoCustomerFoundException;
import com.vrms.service.BookingService;

@ExtendWith(MockitoExtension.class)
class BookingControllerTest {

	@Mock
	private BookingService bookService;

	@Mock
	private ModelMapper mapper;

	@InjectMocks
	private BookingController bookController;

	private CustomerDTO cus;
	private List<CustomerDTO> custList;

	private BookingDTO bookDto;
	private List<BookingDTO> bookList;

	@BeforeEach
	private void initEach() {
		cus = new CustomerDTO();
		cus.setCustomerId(10);
		cus.setFirstName("Rakesh");
		cus.setLastName("Sharma");
		cus.setMobileNumber(9807623451L);
		cus.setAddress("Delhi");
		DriverDTO driver = new DriverDTO();
		driver.setDriverId(200);
		driver.setFirstName("Ram");
		driver.setLastName("L");
		driver.setContactNumber(9874321679L);
		driver.setEmail("ram@gmail.com");
		driver.setAddress("Sangli");
		driver.setChargesPerDay(800);

		driver.setLicenseNo("RL209834");

		VehicleDTO vehicle = new VehicleDTO();
		vehicle.setVehicleId(987);
		vehicle.setVehicleNumber("MH98XZ1209");
		vehicle.setType("Car");
		vehicle.setCategory("AC");
		vehicle.setDescription("this is vehicle");
		vehicle.setLocation("Pune");
		vehicle.setCapacity("6 seater");
		vehicle.setChargesPerKM(20);
		vehicle.setFixedCharges(3000);
		vehicle.setDriverDto(driver);

		bookDto = new BookingDTO();
		bookDto.setBookingId(23);
		bookDto.setBookingDescription("NEW BOOKING");
		bookDto.setBookingDate(LocalDate.now());
		bookDto.setBookedTillDate(LocalDate.MAX);

		Booking book = mapper.map(bookDto, Booking.class);
		bookList = new ArrayList<>();
		bookList.add(bookDto);
	}

	@Test
	void addBooking() throws NoAdminRoleFoundException, NoBookingFoundException {
		when(bookService.addBooking(bookDto)).thenReturn(bookDto);
		ResponseEntity<BookingDTO> response = bookController.add(bookDto);
		System.out.println(response.getStatusCode());
		assertEquals(HttpStatus.CREATED, response.getStatusCode());
	}

	@Test
	void cancelBookingTest() throws NoBookingFoundException {
			when(bookService.cancelBooking(1)).thenReturn(bookDto);
			ResponseEntity<BookingDTO> response = bookController.cancel(1);
			assertEquals(HttpStatus.OK, response.getStatusCode());
	}

	@Test
	void updateBookingTest() throws NoBookingFoundException {

		Mockito.when(bookService.updateBooking(bookDto, 10)).thenReturn(bookDto);
		Mockito.when(bookService.updateBooking(bookDto, 10)).thenReturn(bookDto);
		Assertions.assertEquals(bookDto, bookService.updateBooking(bookDto, 10));

	}
}
