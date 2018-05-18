/**
 * 
 */
package com.sbank.service;

import java.util.List;

import com.sbank.exception.HandleException;
import com.sbank.model.Customer;

/**
 * @author trainee
 *
 */
public interface CustomerService {

	
	
  Customer createCustomer(Customer customer) throws HandleException;
	
	List<Customer> getCustomerdetails() throws HandleException;
	
	Customer getCustomer(Long customerId) throws HandleException;
}
