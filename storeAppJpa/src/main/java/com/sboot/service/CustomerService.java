package com.sboot.service;

import java.util.List;

import com.sboot.model.Customer;

public interface CustomerService {

	public List<Customer> viewAllCustomer();
	
	public String addCustomer(Customer cust);
	
	public void removeCustomer(int cid);
	
	public void updateCustomer(Customer cust);
	
}
