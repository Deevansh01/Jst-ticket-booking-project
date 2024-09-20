package com.jsp.jst_ticket_booking_spring_boot.customerController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.jst_ticket_booking_spring_boot.ResponseStructure.ResponseStructure;
import com.jsp.jst_ticket_booking_spring_boot.dto.Customer;
import com.jsp.jst_ticket_booking_spring_boot.service.CustomerService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "/customer")
@AllArgsConstructor
public class CustomerController {
	private CustomerService customerService;
	
	@PostMapping(value="/register")
	public ResponseStructure<Customer> saveCustomerService(@RequestBody Customer customer)
	{
		return customerService.saveCustomerService(customer);
	}
	
	@GetMapping(value="/login/{email}/{password}")
	public ResponseStructure<Customer> loginCustomerWithEmailAndPassword(@PathVariable String email, String password)
	{
		return customerService.loginCustomerWithEmailAndPassword(email, password);
	}

}
