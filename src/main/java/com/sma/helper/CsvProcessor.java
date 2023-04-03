/**
 * @author: Rupendra
 * @Purpose: 
 * @CreateOn: 02-Apr-2023
 * @Package: com.sma.helper
 */
package com.sma.helper;

import com.sma.calculator.model.MetroTicket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



/**
 * @author Rupendra
 *
 */
@Component
public class CsvProcessor {

	@Autowired
	private DateTimeHelper dateTimeHelper;
	/*
	 * returns Model mapping with the CSV string
	 */
	public MetroTicket csvToTicket(String csv) {
		//String csv = "Green, Green, 2021-03-24T07:58:30";
		String[] values = csv.split(",");
		MetroTicket ticket = new MetroTicket();
		ticket.setFromLine(values[0].trim());
		ticket.setToLine(values[1].trim());
		ticket.setStartTime(values[2].trim());
		ticket.setDayOfWeek(dateTimeHelper.getDayOfWeek(ticket.getStartTime()));
		
		return ticket;
	}
}
