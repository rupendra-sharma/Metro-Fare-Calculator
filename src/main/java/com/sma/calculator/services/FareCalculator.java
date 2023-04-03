/**
 * @author: Rupendra
 * @Purpose: 
 * @CreateOn: 02-Apr-2023
 * @Package: com.sma.calculator.services
 */
package com.sma.calculator.services;

import com.sma.calculator.model.MetroTicket;

/**
 * 
 *
 */
public interface FareCalculator {
	MetroTicket calculate(String ticket) throws Exception;
}
