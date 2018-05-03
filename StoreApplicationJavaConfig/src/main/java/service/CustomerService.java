package service;

import model.Customer;

public interface CustomerService {

	//public int addCustomer(int customerId, String customerName,String customerAddress ,String paymentMode);

	public int removeCustomer(int goodsId);

	public int updateCustomer(int customerId, String customerName);

	public int addCustomer(Customer customer);
	
}
