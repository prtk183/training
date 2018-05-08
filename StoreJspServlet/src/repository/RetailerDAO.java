/**
 * 
 */
package repository;

import java.util.List;

import model.Customer;
import model.Goods;
import model.Retailer;
import model.Supplier;



public interface RetailerDAO {

	
	int addRetailer(String name, String address);
	
public  List<Goods> viewGoods();

public List<Customer> getAllCustomer();

public List<Supplier> getAllSupplier();

public List<Retailer> getAllRetailer();


public List<Customer>  viewCustomer(int customerId);

public  List<Supplier>  viewSupplier(int supplierId);
	
	
}
