/**
 * @author: Rupendra
 * @Purpose: 
 * @CreateOn: 02-Apr-2023
 * @Package: com.sma.calculator.services
 */
package com.sma.calculator.services;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sma.calculator.model.MetroTicket;
import com.sma.helper.CsvProcessor;

/**
 * 
 *
 */
@Service
public class FareCalculatorImpl implements FareCalculator {
	@Autowired
    private KieContainer kieContainer;
	private CsvProcessor csvProcessor;
	
	
	/*
	 * returns: MetroTicket model generated from the input CSV and with fare
	 */
	@Override
	public MetroTicket Calculate(String csv) {
		
		//Create ticket model
		MetroTicket ticket = csvProcessor.csvToTicket(csv);
		
		//Process rules to identify the fare
		KieSession kieSession = kieContainer.newKieSession();
        kieSession.insert(ticket);
        kieSession.fireAllRules();
        kieSession.dispose();
        return ticket;
	}
	
	

}
