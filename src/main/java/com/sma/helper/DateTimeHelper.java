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
	public String getDayOfWeek(String dateString) {
		DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        LocalDateTime dateTime = LocalDateTime.parse(dateString, formatter);
        DayOfWeek dayOfWeek = dateTime.getDayOfWeek();
        return dayOfWeek.toString();
	}
}
