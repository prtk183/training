package repository;

import model.Customer;

public interface CustomerDAO {

	/*addCustomer
	 * */
	public int addCustomer(Customer e);
	
	/*
	 * updating name of customer
	 * */
	public int updateCustomer(int customerID, String name);
	
	/*
	 * 
	 * remove customer by id
	 * */
	public int removeCustomer(int id);

}
