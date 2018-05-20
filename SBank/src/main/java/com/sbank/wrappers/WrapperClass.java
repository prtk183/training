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

  public Long bankId;
  
	public Long getBankId() {
    return bankId;
  }
  public void setBankId(Long bankId) {
    this.bankId = bankId;
  }
  
  public Customer customer;
	
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
