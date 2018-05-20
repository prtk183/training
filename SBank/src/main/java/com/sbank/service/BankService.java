/**
 * 
 */
package com.sbank.service;

import java.math.BigDecimal;
import java.util.List;

import com.sbank.exception.HandleException;
import com.sbank.model.Bank;

/**
 * @author trainee
 *
 */
public interface BankService  {

	/**/
  /**
   * @param bank
   * @return bank
   * @throws HandleException
   */
  Bank createBank(Bank bank) throws HandleException ;
  

	/**
	 * @return list of banks
	 * @throws HandleException
	 */
	List<Bank> getBankDetails( ) throws HandleException;

	/**
	 * @param bankId
	 * @return bank
	 * @throws HandleException
	 */
	Bank getBank(Long bankId) throws HandleException;
	/**/
	/**
	 * @param bank
	 * @throws HandleException
	 */
	void updateBank(Bank bank) throws HandleException;
}
