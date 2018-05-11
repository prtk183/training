package com.sboot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {

	@Id
	Integer customerId;
	
	String customerName;
	String customerAddress;
	String paymentMode;
	
	Boolean operation;
	
	
	

	Customer()
	{
		
	}
	
	public Customer(Integer  id, String name, String address, String payMode, Boolean oper)
	{
		customerId=id;
		customerName=name;
		customerAddress=address;
		paymentMode=payMode;
		operation=oper;
	}
	
	public Integer  getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer  customerId) {
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
	
	public Boolean getOperation() {
		return operation;
	}

	public void setOperation(Boolean operation) {
		this.operation = operation;
	}
}
