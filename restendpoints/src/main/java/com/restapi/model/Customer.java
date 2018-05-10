package com.restapi.model;

public class Customer {


	int customerId;
	String customerName;
	String customerAddress;
	String paymentMode;
	
	
	Customer()
	{
		
	}
	
	public Customer(int id, String custName, String custAdd, String payMode)
	{
		customerId=id;
		customerName=custName;
		customerAddress=custAdd;
		paymentMode=payMode;
	}

	
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	
}
