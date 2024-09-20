package com.jsp.jst_ticket_booking_spring_boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.jst_ticket_booking_spring_boot.dto.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	Customer findByEmail(String email);
}
