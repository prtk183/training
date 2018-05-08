package service;

import java.util.List;
import java.util.function.Supplier;

import model.Customer;
import model.Goods;
import model.Retailer;

public interface RetailerService {

	public List<Goods> getAllGoods();
	
	public List<Customer> getAllCustomer();

	public List<model.Supplier> getAllSupplier();

	public List<Retailer> getAllRetailer();

	
	public void viewCustomer(int id);
	
	public void viewSupplier(int id);
	
	public int addRetailer(String name, String add);
}
