package com.vrms.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vrms.dto.CustomerDTO;
import com.vrms.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	
	
	@Query("Select c from Customer c where c.address = :address")
	List<CustomerDTO> viewAllCustomersByLocation(@Param("address")String address);

}
