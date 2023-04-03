/**
 * @author: Rupendra
 * @Purpose: 
 * @CreateOn: 02-Apr-2023
 * @Package: com.sma.helper
 */
package com.sma.helper;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import org.springframework.stereotype.Component;

/**
 * @author: Rupendra
 * Helper class for DAteTime operations
 */
@Component
public class DateTimeHelper {

	/*
	 * returns DayOfWeek
	 */
	public String getDayOfWeek(String dateString) throws DateTimeParseException {
	    try {
	        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
	        LocalDateTime dateTime = LocalDateTime.parse(dateString, formatter);
	        DayOfWeek dayOfWeek = dateTime.getDayOfWeek();
	        return dayOfWeek.toString();
	    } catch (DateTimeParseException ex) {
	        throw new DateTimeParseException("Invalid date format", dateString, 0, ex);
	    }
	}

}
