package com.jsp.jst_ticket_booking_spring_boot.service.impl;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.jsp.jst_ticket_booking_spring_boot.ResponseStructure.ResponseStructure;
import com.jsp.jst_ticket_booking_spring_boot.dao.CustomerDao;
import com.jsp.jst_ticket_booking_spring_boot.dto.Customer;

import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomerServiceImpl {
	
	private CustomerDao customerDao;
	private ResponseStructure<Customer> responseStructure;
	private HttpSession httpSession;
	
	
	public ResponseStructure<Customer> saveCustomerService(Customer customer)
	{
		Customer customer1=customerDao.saveCustomerDao(customer);
		
		if(customer1!=null) {
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setMessage("!!...Customer is Registered...!!");
			customer1.setPassword("**************************");
			responseStructure.setData(customer1);
			return responseStructure;
		}else {
			responseStructure.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
			responseStructure.setMessage("!!...Customer is not Registered...Please Check Your Code!!");
			customer1.setPassword("**************************");
			responseStructure.setData(customer1);
			return responseStructure;
		}
	}
	
	public ResponseStructure<Customer> loginCustomerWithEmailAndPasswordService(String email,String password)
	{
		Customer customer=customerDao.findCustomerByEmailDao(email);
		if(customer!=null) {
			
			if(customer.getPassword().equals(password)) {
				
				httpSession.setAttribute("customerSession", email);
				httpSession.setMaxInactiveInterval(300);
				responseStructure.setStatusCode(HttpStatus.CONTINUE.value());
				responseStructure.setMessage("login successgo ahead");
				customer.setPassword("*******************************");
				responseStructure.setData(customer);
				
				return responseStructure;
			}else {
				responseStructure.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
				responseStructure.setMessage("Login Failed.....Because password is wrong..!!");
				customer.setPassword("**************************");
				responseStructure.setData(customer);
				return responseStructure;
				
			}
		}else {
			
			responseStructure.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
			responseStructure.setMessage("login failed.....Because email is wrong..!!");
			responseStructure.setData(customer);
			return responseStructure; 
		}
	}
	

}
