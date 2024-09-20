package com.jsp.jst_ticket_booking_spring_boot.dao.impl;

import org.springframework.stereotype.Repository;

import com.jsp.jst_ticket_booking_spring_boot.dao.CustomerDao;
import com.jsp.jst_ticket_booking_spring_boot.dto.Customer;
import com.jsp.jst_ticket_booking_spring_boot.repository.CustomerRepository;

import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class CustomerDaoImpl implements CustomerDao{
	
	private CustomerRepository customerRespository;
	
	@Override
	public Customer saveCustomerDao(Customer customer) {
		return customerRespository.save(customer);
	}
	@Override
	public Customer findCustomerByEmailDao(String email) {
		return customerRespository.findByEmail(email);
	}
}
