package com.jsp.jst_ticket_booking_spring_boot.service;

import com.jsp.jst_ticket_booking_spring_boot.ResponseStructure.ResponseStructure;
import com.jsp.jst_ticket_booking_spring_boot.dto.Customer;

public interface CustomerService {
	
	ResponseStructure<Customer> saveCustomerService(Customer customer);
	ResponseStructure<Customer> loginCustomerWithEmailAndPassword(String email, String password);
}
