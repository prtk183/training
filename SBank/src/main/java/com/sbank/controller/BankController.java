/**
 * 
 */
package com.sbank.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.sbank.exception.HandleException;
import com.sbank.model.Bank;
import com.sbank.service.BankServiceImpl;

/**
 * @author trainee
 *
 */
@Controller
public class BankController {

	
	
	@Autowired
	BankServiceImpl bankServiceImpl;
	
	/*
	*creating a bank, 
	*/
	@PostMapping("/createbank")
	public ResponseEntity<Bank> callCreateBank( @RequestBody  BigDecimal amount) throws HandleException
	{
		System.out.println(amount);
		
		Bank bank= new Bank(amount);
		
		Bank bank1 =  bankServiceImpl.createBank(bank);
		
		return new ResponseEntity<Bank>(bank1, HttpStatus.OK);
		
		
	}
	
	/*
	 * showing bank details
	 */
	@GetMapping("/getbankdetails")
	public ResponseEntity<List<Bank>> getBankDetails() throws HandleException
	{
		List<Bank> bankslist = new ArrayList<Bank>(); 
		
		bankslist = bankServiceImpl.getBankDetails();
		
		return new ResponseEntity<List<Bank>>(bankslist, HttpStatus.OK);
	}
	
	
	
}
