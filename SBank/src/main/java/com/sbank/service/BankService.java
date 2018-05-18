/**
 * 
 */
package com.sbank.service;

import java.util.List;

import com.sbank.exception.HandleException;
import com.sbank.model.Bank;

/**
 * @author trainee
 *
 */
public interface BankService  {

	
  Bank createBank(Bank bank) throws HandleException ;
	
	List<Bank> getBankDetails( ) throws HandleException;
}
