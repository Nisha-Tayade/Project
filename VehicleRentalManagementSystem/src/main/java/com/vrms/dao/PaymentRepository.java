package com.vrms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vrms.entity.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer>{
	

}
