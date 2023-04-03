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
 * API for fare calculator
 *
 */
@RestController
public class MetroFareController {

	@Autowired
	FareCalculator calculator;
	
	/*
	 * Method to calculate fare for a journey
	 * returns the Journey object (MetroTicket) with journey fare
	 */
	@PostMapping(value= "/calculate", consumes = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<?> calculateFare(@RequestBody String ticket){
	    try {
	        MetroTicket newTicket = calculator.calculate(ticket);
	        return ResponseEntity.ok(newTicket);
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error calculating fare: " + e.getMessage());
	    }
	}
	
	
	
	/*
	 * Test api
	 */
	@GetMapping("/")
	public String index() {
		return "api test!";
	}
}
