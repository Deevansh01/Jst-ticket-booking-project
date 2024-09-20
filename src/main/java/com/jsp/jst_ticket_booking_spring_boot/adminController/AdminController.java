package com.jsp.jst_ticket_booking_spring_boot.adminController;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient.ResponseSpec;

import com.jsp.jst_ticket_booking_spring_boot.ResponseStructure.ResponseStructure;
import com.jsp.jst_ticket_booking_spring_boot.dto.Admin;
import com.jsp.jst_ticket_booking_spring_boot.service.AdminService;

@RestController
//@RequestMapping(value = "/admin")
public class AdminController {
	@Autowired
	private AdminService adminService;
	
	@Autowired
	ResponseStructure<Admin> responseStructure;
	
	@GetMapping(value = "fetchAdminByEmail/{email}")
	public Admin findByEmailController(@PathVariable String email)
	{
		return adminService.findByEmailService(email);
	}
	
	//public ResponseStructure<Admin> saveAdminController(Admin admin){
	//}
	
	
	
}
