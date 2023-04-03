/**
 * @author: Rupendra
 * @Purpose: 
 * @CreateOn: 01-Apr-2023
 * @Package: com.sma.calculator.model
 */
package com.sma.calculator.model;

import javax.annotation.PostConstruct;
import java.util.Random;
/**
 * @author Rupendra
 *
 */

public class MetroTicket {
	private String fromLine;
	private String toLine;
    private String startTime;
    private String dayOfWeek;
    private double weekMaxFare ;
    private double dayMaxFare;
    private double weekTotalFare ;
    private double dayTotalFare;
    private double fare;
    

    
    //Getter and Setter(s)
	public String getFromLine() {
		return fromLine;
	}
	public void setFromLine(String fromLine) {
		this.fromLine = fromLine;
	}
	public String getToLine() {
		return toLine;
	}
	public void setToLine(String toLine) {
		this.toLine = toLine;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getDayOfWeek() {
		return dayOfWeek;
	}
	public void setDayOfWeek(String dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}
	public double getWeekMaxFare() {
		return weekMaxFare;
	}
	public void setWeekMaxFare(double weekMaxFare) {
		this.weekMaxFare = weekMaxFare;
	}
	public double getDayMaxFare() {
		return dayMaxFare;
	}
	public void setDayMaxFare(double dayMaxFare) {
		this.dayMaxFare = dayMaxFare;
	}
	public double getFare() {
		return fare;
	}
	public void setFare(double fare) {
		this.fare = fare;
	}
	
	public double getWeekTotalFare() {
		return weekTotalFare;
	}
	public void setWeekTotalFare(double weekTotalFare) {
		this.weekTotalFare = weekTotalFare;
	}
	public double getDayTotalFare() {
		return dayTotalFare;
	}
	public void setDayTotalFare(double dayTotalFare) {
		this.dayTotalFare = dayTotalFare;
	}
	
	
	//TODO: move this to configuration or database
	/*
	 * Set max fare
	 */
	@PostConstruct
    public void init() {
		
		//Setup WeekMaxFare and DayMaxFare based on the startLine and toLine
		switch (fromLine + "_" + toLine) {
	    case "Green_Green":
	    	dayMaxFare = 8;
	        weekMaxFare = 55;
	        break;
	    case "Red_Red":
	    	dayMaxFare = 12;
	        weekMaxFare = 70;
	        break;
	    case "Green_Red":
	    case "Red_Green":
	    	dayMaxFare = 15;
	        weekMaxFare = 90;
	        break;
	    default:
	        // Handle the case where fromLine and toLine are not Green or Red
	        break;
		}
		
		
		//TODO: Save the User journey records in Database using a unique identifier like CardNumber and
		// Get these valued calculated from database / cache on each journey and fare calculation
		//Setup random dayTotalFare and weekTotalFare
		this.dayTotalFare = Math.random() * (this.dayMaxFare - 1) + 1;
		
		this.weekTotalFare = Math.random() * (this.weekTotalFare - 1) + 1;

    }
	
}