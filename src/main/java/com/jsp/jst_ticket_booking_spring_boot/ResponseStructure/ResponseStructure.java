package com.jsp.jst_ticket_booking_spring_boot.ResponseStructure;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class ResponseStructure<T> {
	
	private int statusCode;
	private String message;
	private T data;
	

}
