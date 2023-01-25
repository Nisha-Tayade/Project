package com.vrms.dao;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.vrms.entity.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {

	  @Query("Select b from Booking b JOIN b.customer c where c.customerId = :customerId") 
	  List<Booking> viewAllBookingByCustId(@Param("customerId")int customerId);
	  
	  @Query("Select b from Booking b where b.bookingDate = :bookingDate")
	  List<Booking> viewAllBookingByDate(@Param("bookingDate")LocalDate bookingDate);
	  
	  @Query("Select b from Booking b JOIN b.vehicle v where v.vehicleId = :vehicleId") 
	  List<Booking> viewAllBookingByVehicleId(@Param("vehicleId")int vehicleId);	 
}