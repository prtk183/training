package model;

import java.util.List;


public class Customer {

	private int customerId;
	private String customerName;
	private String customerAddress;
	private String paymentMode;


	public Customer(int customerId, String customerName, String customerAddress, String paymentMode) {
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.paymentMode = paymentMode;
	}

	public Customer(String customerName) {
		this.customerId = customerId;
		this.customerName = customerName;

	}

	public Customer() {

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
