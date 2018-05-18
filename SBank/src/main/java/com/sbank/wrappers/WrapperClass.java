/**
 * 
 */
package com.sbank.wrappers;

import java.math.BigDecimal;

import com.sbank.model.Bank;
import com.sbank.model.Customer;

/**
 * @author trainee
 *
 */
public class WrapperClass {

  public BigDecimal bankId;
  
	public BigDecimal getBankId() {
    return bankId;
  }
  public void setBankId(BigDecimal bankId) {
    this.bankId = bankId;
  }
  
  public Customer customer;
	/**
	 * @return the bank
	 */
	public BigDecimal getBank() {
		return bankId;
	}
	/**
	 * @param bank the bank to set
	 */
	public void setBank(BigDecimal bankId) {
		this.bankId = bankId;
	}
	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}
	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
	
}
