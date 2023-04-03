/**
 * @author: Rupendra
 * @Purpose: 
 * @CreateOn: 01-Apr-2023
 * @Package: com.sma.calculator.api
 */
package com.sma.calculator.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sma.calculator.model.MetroTicket;
import com.sma.calculator.services.FareCalculator;

/**
 * 
 *
 */
@RestController
public class MetroFareController {

	@Autowired
	FareCalculator calculator;
	
	/*
	 * 
	 */
	@PostMapping(value= "/calculate", consumes = MediaType.TEXT_PLAIN_VALUE)
	public MetroTicket calculateFare(@RequestBody String ticket){
		System.out.println(ticket);
		MetroTicket newTicket = calculator.Calculate(ticket);
		
		return newTicket;
		
		
	}
	
	/*
	 * 
	 */
	@GetMapping("/hello")
	public String hello(){
		return "hello";
		
		
	}
	
	
	@GetMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}
}
